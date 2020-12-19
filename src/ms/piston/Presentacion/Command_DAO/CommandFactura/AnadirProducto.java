/**
 * 
 */
package ms.piston.Presentacion.Command_DAO.CommandFactura;

import java.util.Collection;
import java.util.Iterator;

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
	 * @see command#ejecuta(Integer Orden)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object ejecuta(Integer Orden, Object Datos)  {
		
		// begin-user-code
		Iterator<Integer> it = ((Collection<Integer>) Datos).iterator();
			Integer id = it.next();
			Integer cantidad = it.next();
		FactoriaSA.obtenerInstancia().generarSAFactura().AnadirProductoCesta(id,cantidad);
		return Datos;
		// end-user-code
	}
}