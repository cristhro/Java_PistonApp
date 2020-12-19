/**
 * 
 */
package ms.piston.Presentacion.Command_DAO.CommandProducto;

import ms.piston.Negocio.Producto.TProducto;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command_DAO.command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class AnadirProducto implements command {
	/** 
	 * (sin Javadoc)
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object ejecuta(Integer Orden, Object Datos)  {
		// begin-user-code
		Datos = FactoriaSA.obtenerInstancia().generarSAProducto().anadirProducto((TProducto) Datos);
		return Datos;

		// end-user-code
	}
}