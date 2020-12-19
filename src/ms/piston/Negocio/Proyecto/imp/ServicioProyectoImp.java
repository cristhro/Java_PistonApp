/**
 * 
 */
package ms.piston.Negocio.Proyecto.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ms.piston.Negocio.Empleado.Empleado;
import ms.piston.Negocio.Empleado.Jefe;
import ms.piston.Negocio.Proyecto.Fecha;
import ms.piston.Negocio.Proyecto.FechaId;
import ms.piston.Negocio.Proyecto.Proyecto;
import ms.piston.Negocio.Proyecto.ServicioProyecto;
import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoExistente;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoInactivo;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoNoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.FechaExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.FechaNoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.JefeAsignado;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoInactivo;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoNoExistente;

public class ServicioProyectoImp implements ServicioProyecto {

	public Integer crearProyecto(TProyecto tp) throws ProyectoExistente,
	EmpleadoExistente {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		TypedQuery<Proyecto> query = em.createQuery(
				"select obj from Proyecto obj where obj.nombre = :nombre",
				Proyecto.class);
		query.setParameter("nombre", tp.getNombre());

		List<Proyecto> listaProyectos = query.getResultList();
		Proyecto pro = new Proyecto();
		Empleado jefe = em.find(Empleado.class, tp.getJefe(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);

		if ((listaProyectos.size() == 0) && (jefe != null)) {
			if (jefe instanceof Jefe) {
				pro.setActivo(true);
				pro.setNombre(tp.getNombre());
				pro.setJefe(tp.getJefe());
				pro.setDuracionEmpleados(tp.getDuracionEmpleados());

				try {
					em.persist(pro);
					em.flush();
					et.commit();
				} catch (Exception e) {
					et.rollback();
				}
			} else {
				throw new EmpleadoExistente("El empleado con id: "
						+ tp.getJefe() + " no es jefe");
			}
		} else {
		
			
			et.rollback();
			if ((listaProyectos.size() != 0))
				throw new ProyectoExistente("El proyecto con nombre: "
						+ tp.getNombre() + " ya existe.");
			else if (jefe == null)
				throw new EmpleadoExistente("El empleado jefe con id: "
						+ tp.getJefe() + " no existe.");
		}
		em.close();
		return pro.getId();
	}

	public void modificarProyecto(TProyecto tp) throws ProyectoNoExistente {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		int id = tp.getId();
		Proyecto pro = (Proyecto) em.find(Proyecto.class, id);

		if (pro != null) {
			try {
				pro.setActivo(tp.getActivo());
				pro.setDuracionEmpleados(tp.getDuracionEmpleados());
				pro.setNombre(tp.getNombre());
				pro.setJefe(tp.getJefe());
				et.commit();

			} catch (Exception e) {

				et.rollback();

			} finally {

				em.close();

			}

		} else {
			et.rollback();
			em.close();
			throw new ProyectoNoExistente("El proyecto " + id + " no existe");
		}

	}

	public void bajaProyecto(Integer id) throws ProyectoNoExistente {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Proyecto pro = em.find(Proyecto.class, id);
		TypedQuery<Fecha> query = em.createQuery(
				"select obj from Fecha obj where obj.proyecto = :proyecto", Fecha.class);
		query.setParameter("proyecto", pro);
		List<Fecha> lProAsignado = query.getResultList();

		if (lProAsignado.isEmpty()) {
			try {
				pro.setActivo(false);
				et.commit();
			} catch (Exception e) {

				et.rollback();

			} finally {
				em.close();
			}
		} else {
			et.rollback();
			em.close();
			throw new ProyectoNoExistente("El proyecto con id: " + id + " tiene asignados empleados");
		}

	}

	public void addEmpleado(TFecha tf) throws ProyectoNoExistente,
	EmpleadoNoExistente, FechaExistente, ProyectoInactivo,
	EmpleadoInactivo, JefeAsignado {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		FechaId fechaId = new FechaId();
		fechaId.setEmpleado(tf.getIdEmpleado());
		fechaId.setProyecto(tf.getIdProyecto());

		TypedQuery<Fecha> query = em.createQuery(
				"select obj from Fecha obj where obj.id = :id", Fecha.class);
		query.setParameter("id", fechaId);

		List<Fecha> listaFechas = query.getResultList();

		if (listaFechas.isEmpty()) {

			Fecha EntityFecha = new Fecha();
			Empleado empleado = em.find(Empleado.class, tf.getIdEmpleado(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Proyecto proyecto = em.find(Proyecto.class, tf.getIdProyecto(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			
			if (empleado != null) {
				if (empleado.getActivo()) {
					if (proyecto != null) {
						if (proyecto.getActivo()) {
							if (empleado.getId() != proyecto.getJefe()) {
								if(tf.getFechaInicio().compareTo(tf.getFechaFin()) < 0) {								
									EntityFecha.setEmpleado(empleado);
									EntityFecha.setProyecto(proyecto);
									EntityFecha.setFechaInicio(tf.getFechaInicio());
									EntityFecha.setFechaFin(tf.getFechaFin());
									try {
										em.persist(EntityFecha);
										em.flush();
										et.commit();
									} catch (Exception e) {
										et.rollback();
									}
								}else {
									et.rollback();
									em.close();
									throw new JefeAsignado("La Fecha de inicio no puede ser mayor que la Fecha Fin");
								}
							}else {
								et.rollback();
								em.close();
								throw new JefeAsignado(" El jefe con id: "
										+ tf.getIdProyecto() + " ya esta asignado.");
							}
							
						} else {
							et.rollback();
							em.close();
							throw new ProyectoInactivo("El proyecto con id: "
									+ tf.getIdProyecto() + " esta inactivo.");
						}
					} else {
						et.rollback();
						em.close();
						throw new ProyectoNoExistente("El proyecto con id: "
								+ tf.getIdProyecto() + " no existe.");
					}
				} else {
					et.rollback();
					em.close();
					throw new EmpleadoInactivo("El empleado con id: "
							+ tf.getIdEmpleado() + " esta inactivo.");
				}
			} else {
				et.rollback();
				em.close();
				throw new EmpleadoNoExistente("El empleado con id: "
						+ tf.getIdEmpleado() + " no existe.");
			}

		} else {
			em.close();
			throw new FechaExistente("El empleado con id: "
					+ tf.getIdEmpleado()
					+ " ya esta asignado al proyecto con id: "
					+ tf.getIdProyecto());

		}
	}

	public void quitarEmpleado(TFecha tf) throws ProyectoNoExistente,
	EmpleadoNoExistente, FechaNoExistente {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		FechaId fechaId = new FechaId(tf.getIdEmpleado(), tf.getIdProyecto());
		Empleado empleado = em.find(Empleado.class, tf.getIdEmpleado(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		Proyecto proyecto = em.find(Proyecto.class, tf.getIdProyecto(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);

		if (empleado != null) {
			if (proyecto != null) {
				Fecha EntityFecha = em.find(Fecha.class, fechaId);
				if (EntityFecha != null) {
					em.remove(EntityFecha);
					et.commit();
				} else {
					em.close();
					throw new FechaNoExistente("El empleado con id: "
							+ tf.getIdEmpleado()
							+ " no esta asignado al proyecto con id: "
							+ tf.getIdProyecto());
				}

			} else {
				et.rollback();
				em.close();
				throw new ProyectoNoExistente("El proyecto con id: "
						+ tf.getIdProyecto() + " no existe.");
			}
		} else {
			et.rollback();
			em.close();
			throw new EmpleadoNoExistente("El empleado con id: "
					+ tf.getIdEmpleado() + " no existe.");
		}
	}

	@SuppressWarnings("null")
	public TProyecto consultarProyecto(Integer id) throws ProyectoNoExistente {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		TProyecto tp = new TProyecto();

		et.begin();
		Proyecto pro = em.find(Proyecto.class, id);
		TypedQuery<Fecha> query = em.createQuery(
				"select obj from Fecha obj where obj.proyecto = :proyecto", Fecha.class);
		query.setParameter("proyecto", pro);

		List<TFecha> ltf = new ArrayList<TFecha>();
		List<Fecha> listaFechas = query.getResultList();

		for (Fecha f: listaFechas) {
			//	if(f.getEmpleado().getActivo()){
			TFecha tf = new TFecha(f.getFechaInicio(),f.getFechaFin(),f.getProyecto().getId(),f.getEmpleado().getId());
			ltf.add(tf);
			//}
		}
		if (pro != null) {
			tp.setActivo(pro.getActivo());
			tp.setDuracionEmpleados(pro.getDuracionEmpleados());
			tp.setId((Integer) pro.getId());
			tp.setJefe(pro.getJefe());
			tp.setNombre(pro.getNombre());
			tp.setFechas(ltf);
		} else {
			et.rollback();
			throw new ProyectoNoExistente("El proyecto con id: " + id
					+ " no existe.");
		}

		return tp;

	}

	@SuppressWarnings({ "unchecked", "null" })
	public Collection<TProyecto> consultarProyectos() throws ProyectoNoExistente {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PistonJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Query query = em.createQuery("SELECT e FROM Proyecto e");
		List<Proyecto> lp = query.getResultList();
		Collection<TProyecto> lTProyecto = new ArrayList<TProyecto>();;

		for (Proyecto p: lp) {
			lTProyecto.add(consultarProyecto(p.getId()));
		}
		et.commit();
		em.close();
		emf.close();
		return lTProyecto;
	}


}