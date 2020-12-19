/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoConsultarProyecto implements Command {
	public TContexto ejecuta(Object entrada) throws Exception {
		Object datos = FactoriaSA.obtenerInstancia().generarServicioProyecto().consultarProyecto((int) entrada);
		TContexto contexto = new TContexto("consultar proyecto", datos);
		return contexto;
	}
}