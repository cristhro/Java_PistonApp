package ms.piston.Negocio.Departamentos.imp;


import ms.piston.Negocio.Departamentos.Departamento;
import ms.piston.Negocio.Departamentos.ServicioDepartamento;
import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Negocio.Empleado.Empleado;
import ms.piston.Negocio.Empleado.Jefe;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoConEmpleado;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoExistente;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoExiste;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoModificable;
import ms.piston.Presentacion.Departamentos.Excepciones.EmpleadoNoJefe;
import ms.piston.Presentacion.Departamentos.Excepciones.JefeNoExiste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ServicioDepartamentoImp implements ServicioDepartamento {

	public boolean CrearDepartamento(TDepartamento departamento) throws DepartamentoExistente, EmpleadoNoJefe, JefeNoExiste {
		boolean alta = false;
		Departamento dep = new Departamento();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query query = em.createNamedQuery("Departamento.findBynombre");
		query.setParameter("nombre", departamento.getNombre());
		List<Departamento> lista = (List<Departamento>) query.getResultList();

		if(lista.isEmpty()){
			dep.setNombre(departamento.getNombre());
			dep.setActivo(true);
			if(departamento.getJefe() != -1){
				Empleado emp = em.find(Empleado.class, departamento.getJefe(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if(emp != null){
					if(emp instanceof Jefe)
						dep.setJefe(departamento.getJefe());
					else{
						et.rollback();
						em.close();
						throw new EmpleadoNoJefe("El empleado " + emp.getNombre() +" " + emp.getApellidos()+ " no es un jefe");
					}
				}
				else{
					throw new JefeNoExiste("El jefe no existe");
				}
			}
			try{

				em.persist(dep);
				et.commit();
				alta = true;

			} catch(Exception e){

				et.rollback();
				alta = false;

			} finally{

				em.close();

			}

		} else{

			boolean parar = false;
			Iterator<Departamento> it = lista.iterator();

			while(it.hasNext() && !parar){
				if(it.next().getNombre().equals(departamento.getNombre()))
					parar = true;
			}

			if(parar){
				dep.setActivo(true);
				dep.setNombre(departamento.getNombre());
				dep.setJefe(departamento.getJefe());
				try{

					em.persist(dep);
					et.commit();
					alta = true;

				} catch(Exception e){

					et.rollback();
					alta = false;

				} finally{

					em.close();

				}
			}

		}

		return alta;
	}
	
	public float CalcularNominaDepartamento(int ID) {
		float result = 0;
		Empleado empleado;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Departamento dep = em.find(Departamento.class, ID);
		Query query = em.createNamedQuery("Empleado.findByDepartamento");
		query.setParameter("departamento", dep);
		query.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		List<Empleado> lista = (List<Empleado>) query.getResultList();
		
		Iterator<Empleado> it = lista.iterator();
		while (it.hasNext()) {
			empleado = it.next();
			if (empleado.getActivo()) {
				result += empleado.getSalario();
			}
		}

		return result;
	}

	public boolean ModificarDepartamento(TDepartamento departamento) throws DepartamentoNoModificable, EmpleadoNoJefe, JefeNoExiste {
		boolean mod = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();


		int ID = departamento.getID();
		Departamento dep = em.find(Departamento.class, ID);
		String nombreAntiguo = dep.getNombre();

		if (dep != null){
			List<Departamento> lista = new ArrayList<Departamento>() ;
			if(!nombreAntiguo.equals(departamento.getNombre())){
				Query query = em.createNamedQuery("Departamento.findBynombre");
				query.setParameter("nombre", departamento.getNombre());
				lista = (List<Departamento>) query.getResultList();
			}
			if(departamento.getJefe() != -1){
				Empleado emp = em.find(Empleado.class, departamento.getJefe(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if(emp != null){
					if(emp instanceof Jefe)
						dep.setJefe(departamento.getJefe());
					else{
						et.rollback();
						em.close();
						throw new EmpleadoNoJefe("El empleado " + emp.getNombre() +" " + emp.getApellidos()+ " no es un jefe");
					}
				}
				else{
					throw new JefeNoExiste("El jefe no existe");
				}
			}
			if(lista.isEmpty()){
				try{
					dep.setNombre(departamento.getNombre());
					et.commit();
					mod = true;

				} catch(Exception e){

					et.rollback();
					mod = false;

				} finally{

					em.close();

				}
			} else{
				et.rollback();
				em.close();
				throw new DepartamentoNoModificable("El Departamento " + nombreAntiguo +" no puede ser modificado");
			}
		}	


		return mod;
	}

	public boolean BorrarDepartamento(int ID) throws DepartamentoNoExiste, DepartamentoConEmpleado{

		boolean baja = false;
		boolean desactivados = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Departamento dep = em.find(Departamento.class, ID, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		Query query = em.createNamedQuery("Empleado.findByDepartamento");
		query.setParameter("departamento", dep);
		query.setLockMode(LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		List<Empleado> lista = (List<Empleado>) query.getResultList();
		Iterator it = lista.iterator();
		
		while(it.hasNext() && desactivados){
			Empleado auxEmp = (Empleado) it.next();
			
			if(auxEmp.getActivo() == true)
				desactivados = false;
			
		}
		
		if(lista.isEmpty() || desactivados){
			if (dep != null) {

				try{
					dep.setActivo(false);
					et.commit();
					baja = true;

				} catch(Exception e){

					et.rollback();
					baja = false;

				} finally{

					em.close();

				}


			}
			else{
				et.rollback();
				em.close();
				throw new DepartamentoNoExiste("El Departamento " + ID +" no existe");
			}
		}
		else
		{
			et.rollback();
			em.close();
			throw new DepartamentoConEmpleado("El Departamento " + dep.getNombre() +" tiene empleados asignados, imposible de borrar");
		}


		return baja;

	}

	public TDepartamento ConsultarDepartamento(int ID) {
		TDepartamento departamento =  new TDepartamento();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query query = em.createNamedQuery("Departamento.findByid");
		query.setParameter("id", ID);
		Departamento dep = (Departamento) query.getSingleResult();
		
		Query query2 = em.createNamedQuery("Empleado.findByDepartamento");
		query2.setParameter("departamento", dep);		
		List<Empleado> lista = (List<Empleado>) query2.getResultList();
		Iterator it = lista.iterator();
		List<TEmpleado> listaEmp = new ArrayList<TEmpleado>();
		while(it.hasNext()){
			Empleado emp = (Empleado) it.next();
			TEmpleado Temp = new TEmpleado();
			Temp.setActivo(emp.getActivo());
			Temp.setApellidos(emp.getApellidos());
			Temp.setDireccion(emp.getDireccion());
			Temp.setEmail(emp.getEmail());
			Temp.setId(emp.getId());
			Temp.setNif(emp.getNif());
			Temp.setNombre(emp.getNombre());
			Temp.setSalario(emp.getSalario());
			Temp.setTelefono(emp.getTelefono());
			listaEmp.add(Temp);
		}

		departamento.setNombre(dep.getNombre());
		departamento.setJefe(dep.getJefe());
		departamento.setID(dep.getID());
		departamento.setActivo(dep.getActivo());
		departamento.setListaEmpleados(listaEmp);

		em.close();

		return departamento;
	}

	public Collection<TDepartamento> ConsultarDepartamentos() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		List<TDepartamento> departamentos =  new ArrayList<TDepartamento>();
		Query query = em.createNamedQuery("Departamento.findAll");
		for (Object dep : query.getResultList()) {
			TDepartamento departamento = new TDepartamento();
			departamento.setID(((Departamento) dep).getID());
			departamento.setActivo(((Departamento) dep).getActivo());
			departamento.setNombre(((Departamento) dep).getNombre());
			if(((Departamento) dep).getJefe() != -1)
				departamento.setJefe(((Departamento) dep).getJefe());


			departamentos.add(departamento);
		}
		et.commit();
		em.close();

		return departamentos;
	}

} 