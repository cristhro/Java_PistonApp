/**
 * 
 */
package ms.piston.Negocio.Empleado;

import java.util.List;

import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoExiste;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoExistente;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoNoExistente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public interface ServicioEmp {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idEmp
	 * @param empleado
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int altaEmpleado(TEmpleado empleado) throws EmpleadoExistente, DepartamentoNoExiste;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void bajaEmpleado(int id) throws EmpleadoNoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @param empleado
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TEmpleado consultaEmpleado(int id) throws EmpleadoNoExistente;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param empleados
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<TEmpleado> consultaEmpleados();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param empleado
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void modificarEmpleado(TEmpleado empleado) throws EmpleadoNoExistente, DepartamentoNoExiste;

}