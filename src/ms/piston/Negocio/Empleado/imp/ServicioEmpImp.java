package ms.piston.Negocio.Empleado.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ms.piston.Negocio.Departamentos.Departamento;
import ms.piston.Negocio.Empleado.Empleado;
import ms.piston.Negocio.Empleado.Jefe;
import ms.piston.Negocio.Empleado.Normal;
import ms.piston.Negocio.Empleado.ServicioEmp;
import ms.piston.Negocio.Empleado.TEmpJefe;
import ms.piston.Negocio.Empleado.TEmpNormal;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoExiste;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoExistente;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoNoExistente;

public class ServicioEmpImp implements ServicioEmp {
	
	public int altaEmpleado(TEmpleado empleado) throws EmpleadoExistente, DepartamentoNoExiste {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Query query = em.createNamedQuery("Empleado.findBynif");
		query.setParameter("nif", empleado.getNif());
		
		Departamento dep = em.find(Departamento.class, empleado.getIdDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		if (dep == null) {
			throw new DepartamentoNoExiste("Debe introducir un departamento existente.");
		}

		List<Empleado> empleados = (List<Empleado>) query.getResultList();
        Empleado emp;

		if (empleados.isEmpty()) {
            if (empleado instanceof TEmpNormal) {
                emp = new Normal();
                ((Normal) emp).setAyudaTransporte(((TEmpNormal) empleado).getAyudaTransporte());
            } else {
                emp = new Jefe();
                ((Jefe) emp).setCocheEmpresa(((TEmpJefe) empleado).getCocheEmpresa());
            }

			emp.setActivo(true);
			emp.setDepartamento(dep);
			emp.setNif(empleado.getNif());
			emp.setNombre(empleado.getNombre());
			emp.setApellidos(empleado.getApellidos());
			emp.setTelefono(empleado.getTelefono());
			emp.setDireccion(empleado.getDireccion());
			emp.setEmail(empleado.getEmail());
			emp.setSalario(empleado.getSalario());
			
			try {
				em.persist(emp);
                em.flush();
				et.commit();
			} catch (Exception e) {
				et.rollback();
			}
		} else {
			et.rollback();
			throw new EmpleadoExistente("El empleado con nif: " + empleado.getNif() + " ya existe.");
		}

        em.close();
        emf.close();

		return emp.getId();
	}

	public void bajaEmpleado(int id) throws EmpleadoNoExistente {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Empleado emp = em.find(Empleado.class, id);
		
		if (emp != null) {
			try {
				et.begin();
				emp.setActivo(false);
				et.commit();
			} catch (Exception e) {
				et.rollback();
			}
		} else {
			throw new EmpleadoNoExistente("El empleado con nif: " + emp.getNif() + " no existe.");
		}

        em.close();
        emf.close();
	}

	public TEmpleado consultaEmpleado(int id) throws EmpleadoNoExistente {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		TEmpleado empleado = null;
		
		et.begin();
		Empleado emp = em.find(Empleado.class, id);
		
		if (emp != null) {
			if (emp instanceof Jefe) {
				empleado = new TEmpJefe();
			} else if (emp instanceof Normal) {
				empleado = new TEmpNormal();
			}
			empleado.setId(((Empleado) emp).getId());
			empleado.setIdDepartamento(((Empleado) emp).getDepartamento().getID());
            empleado.setActivo(((Empleado) emp).getActivo());
			empleado.setNombre(((Empleado) emp).getNombre());
			empleado.setApellidos(((Empleado) emp).getApellidos());
            empleado.setNif(((Empleado) emp).getNif());
            empleado.setTelefono(((Empleado) emp).getTelefono());
            empleado.setDireccion(((Empleado) emp).getDireccion());
            empleado.setEmail(((Empleado) emp).getEmail());
            empleado.setSalario(((Empleado) emp).getSalario());
		}  else {
			et.rollback();
			throw new EmpleadoNoExistente("El empleado con nif: " + empleado.getNif() + " no existe.");
		}
		
		et.commit();
        em.close();
        emf.close();
		
		return empleado;
	}

	public List<TEmpleado> consultaEmpleados() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
        List<TEmpleado> empleados = new ArrayList<TEmpleado>();
		TEmpleado empleado = null;

		et.begin();
		Query query = em.createNamedQuery("Empleado.findAll");
        for (Object emp : query.getResultList()) {
            if (emp instanceof Jefe) {
                empleado = new TEmpJefe();
                ((TEmpJefe) empleado).setCocheEmpresa(((Jefe) emp).getCocheEmpresa());
            } else if (emp instanceof Normal){
                empleado = new TEmpNormal();
                ((TEmpNormal) empleado).setAyudaTransporte(((Normal) emp).getAyudaTransporte());
            }
            empleado.setId(((Empleado) emp).getId());
            empleado.setIdDepartamento(((Empleado) emp).getDepartamento().getID());
            empleado.setActivo(((Empleado) emp).getActivo());
			empleado.setNombre(((Empleado) emp).getNombre());
			empleado.setApellidos(((Empleado) emp).getApellidos());
            empleado.setNif(((Empleado) emp).getNif());
            empleado.setTelefono(((Empleado) emp).getTelefono());
            empleado.setDireccion(((Empleado) emp).getDireccion());
            empleado.setEmail(((Empleado) emp).getEmail());
            empleado.setSalario(((Empleado) emp).getSalario());

            empleados.add(empleado);
        }
        et.commit();
        em.close();
        emf.close();
		
		return empleados;
	}

	public void modificarEmpleado(TEmpleado empleado) throws EmpleadoNoExistente, DepartamentoNoExiste {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Departamento dep = em.find(Departamento.class, empleado.getIdDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		if (dep == null) {
			throw new DepartamentoNoExiste("Debe introducir un departamento existente.");
		}
		
		Empleado emp = em.find(Empleado.class, empleado.getId());

        if (emp != null) {
            try {
                if (empleado instanceof TEmpNormal) {
                    ((Normal) emp).setAyudaTransporte(((TEmpNormal) empleado).getAyudaTransporte());
                } else {
                    ((Jefe) emp).setCocheEmpresa(((TEmpJefe) empleado).getCocheEmpresa());
                }

                emp.setDepartamento(dep);
                emp.setActivo(true);
                emp.setNombre(empleado.getNombre());
                emp.setApellidos(empleado.getApellidos());
                emp.setNif(empleado.getNif());
                emp.setTelefono(empleado.getTelefono());
                emp.setDireccion(empleado.getDireccion());
                emp.setEmail(empleado.getEmail());
                emp.setSalario(empleado.getSalario());

                try {
    				et.commit();
    			} catch (Exception e) {
    				et.rollback();
    			}
            } catch (Exception e) {
            	et.rollback();
                throw new EmpleadoNoExistente("El empleado no existe.");
            }
        }

        em.close();
        emf.close();
	}

}