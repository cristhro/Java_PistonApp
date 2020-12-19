/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Vistas.VAnadirDepartamentos.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VAnadirDepartamentos.VAnadirDepartamento;

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
		VAnadirDepartamento ventana = (VAnadirDepartamento) VAnadirDepartamento.getFrame();
    	TDepartamento dep = new TDepartamento();
    	String jefe = ventana.getJefe().getText();
    	
    	try{
    		if(jefe != "")
    			dep.setJefe(Integer.parseInt(jefe));
    		else
    			dep.setJefe(-1);
    		dep.setNombre(ventana.getNombre().getText());
    		Controller.ObtenerInstancia().accion("alta Departamento", dep);
    		ventana.dispose();
    	
    	}
    	catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}