/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoAddEmpleado implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Comando#ejecutar(Object parametro)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		FactoriaSA.obtenerInstancia().generarServicioProyecto().addEmpleado((TFecha )entrada);
		TContexto contexto = new TContexto("add empleado", (TFecha) entrada);	
		return contexto;
	}
}