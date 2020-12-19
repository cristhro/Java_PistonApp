/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoQuitarEmpleado implements Command {

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		TFecha tf = (TFecha) entrada;
		FactoriaSA.obtenerInstancia().generarServicioProyecto().quitarEmpleado(tf);
		TContexto tc = new TContexto("del empleado", tf);
		return tc;
	}
}