/**
 * 
 */
package ms.piston.Negocio.FactoriaSA;

import ms.piston.Negocio.Empleado.ServicioEmp;
import ms.piston.Negocio.FactoriaSA.imp.FactoriaSAImp;
import ms.piston.Negocio.Factura.SAFactura;
import ms.piston.Negocio.Cliente.SACliente;
import ms.piston.Negocio.Departamentos.ServicioDepartamento;
import ms.piston.Negocio.Producto.SAProducto;
import ms.piston.Negocio.Proyecto.ServicioProyecto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaSA factoria;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaSA obtenerInstancia() {
		if(factoria == null) {
			factoria = new FactoriaSAImp();
		}
		
		return factoria;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAFactura generarSAFactura() ;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SACliente generarSACLiente();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAProducto generarSAProducto();

	public abstract ServicioDepartamento generarServicioDepartamento();

	public abstract ServicioProyecto generarServicioProyecto();

	public abstract ServicioEmp generarServicioEmpleado();
}