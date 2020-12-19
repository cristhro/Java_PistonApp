/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Vistas.VModificarDepartamentos.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VModificarDepartamentos.VModificarDepartamento;


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
		VModificarDepartamento ventana = (VModificarDepartamento) VModificarDepartamento.getFrame();
		int id = ventana.getID();
    	TDepartamento dep = new TDepartamento();
    	
    	try{
    		if(ventana.getJefe().getText() != "")
    			dep.setJefe(Integer.parseInt(ventana.getJefe().getText()));
    		dep.setNombre(ventana.getNombre().getText());
    		dep.setID(id);
    		Controller.ObtenerInstancia().accion("modificar departamento", dep);
    		ventana.dispose();
    		
    	}
    	catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}