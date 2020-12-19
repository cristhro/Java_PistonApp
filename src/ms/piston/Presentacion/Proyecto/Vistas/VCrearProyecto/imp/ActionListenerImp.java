/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.VCrearProyecto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ActionListenerImp implements ActionListener {
	/** 
	 * (sin Javadoc)
	 * @see ActionListener#actionPerformed(ActionEvent arg0)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void actionPerformed(ActionEvent arg0) {
		VCrearProyecto ventana = (VCrearProyecto) VCrearProyecto.getFrame();
    	TProyecto pro = new TProyecto();
    	
    	try{
    		pro.setJefe(Integer.parseInt(ventana.getJefe().getText()));
    		pro.setNombre(ventana.getNombre().getText());
    		pro.setDuracionEmpleados(Integer.parseInt(ventana.getDuracion().getText()));
    		Controller.ObtenerInstancia().accion("crear proyecto", pro);
    		Controller.ObtenerInstancia().accion("consultar proyectos", null);
    		ventana.dispose();
    	}
    	catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}