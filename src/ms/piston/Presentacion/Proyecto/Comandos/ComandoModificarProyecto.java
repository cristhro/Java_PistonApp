/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.VModificarProyecto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoModificarProyecto implements Command {

	@Override
	public TContexto ejecuta(Object datos) throws Exception {
		FactoriaSA.obtenerInstancia().generarServicioProyecto().modificarProyecto((TProyecto )datos);
		datos = FactoriaSA.obtenerInstancia().generarServicioProyecto().consultarProyectos();
		TContexto contexto = new TContexto("modificar proyecto", datos);	
		return contexto;
	}
}