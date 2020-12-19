/**
 * 
 */
package ms.piston.Presentacion.Controlador_DAO.imp;

import ms.piston.Presentacion.Command_DAO.FactoryCommand;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Controlador_DAO.TContexto;
import ms.piston.Presentacion.Dispatcher_DAO.Dispatcher;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImp extends Controlador{

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param evento
	 * @param Datos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	public void accion(Integer evento, Object Datos) {
		// begin-user-code
		command c = FactoryCommand.obtenerinstancia().generarCommand(evento);
		if(c != null)
		{
		Datos = c.ejecuta(evento,Datos);
		}
		TContexto context = new TContexto(evento,Datos);
		Dispatcher.ObtenerInstacia().despacha(context);
		// end-user-code
		
	}
}