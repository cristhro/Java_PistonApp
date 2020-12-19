/**
 * 
 */
package ms.piston.Negocio.Proyecto;

import java.util.Collection;
import java.util.List;

import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoExistente;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoInactivo;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoNoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.FechaExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.FechaNoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.JefeAsignado;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoExistente;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoInactivo;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoNoExistente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public interface ServicioProyecto {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param tp
	 * @return
	 * @throws ProyectoExistente 
	 * @throws EmpleadoExistente 
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Integer crearProyecto(TProyecto tp) throws ProyectoExistente, EmpleadoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param tp
	 * @param mod
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void modificarProyecto(TProyecto tp)throws ProyectoNoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void bajaProyecto(Integer id)throws ProyectoNoExistente;;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idEmp
	 * @param idPro
	 * @throws FechaExistente 
	 * @throws ProyectoInactivo 
	 * @throws EmpleadoInactivo 
	 * @throws JefeAsignado 
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void addEmpleado(TFecha tf)throws ProyectoNoExistente,EmpleadoNoExistente, FechaExistente, ProyectoInactivo, EmpleadoInactivo, JefeAsignado;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idEmp
	 * @throws FechaNoExistente 
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void quitarEmpleado(TFecha tf)throws ProyectoNoExistente,EmpleadoNoExistente, FechaNoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TProyecto consultarProyecto(Integer id)throws ProyectoNoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @throws ProyectoNoExistente 
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Collection<TProyecto> consultarProyectos() throws ProyectoNoExistente;

	
}