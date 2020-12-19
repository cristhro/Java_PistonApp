/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Proyecto.Excepciones.ProyectoExistente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoCrearProyecto implements Command {

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		
		Object datos = FactoriaSA.obtenerInstancia().generarServicioProyecto().crearProyecto((TProyecto) entrada);
		TContexto contexto = new TContexto("crear proyecto", datos);
		return contexto;
	}
}