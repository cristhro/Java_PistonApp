package ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado.imp;

/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado.VAddEmpleado;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ActionListenerImp implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		VAddEmpleado v = (VAddEmpleado) VAddEmpleado.getFrame();
		TFecha tf = v.getTFecha();
		Controller.ObtenerInstancia().accion("ComandoAddEmpleado", tf);
		v.dispose();
	}
}