/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;

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
		String action = arg0.getActionCommand();
		VDepartamentos ventana = (VDepartamentos) VDepartamentos.getPanel();
    	JTable tabla = ventana.getjTable();
	    switch (action) {
	    case "add":
	    	Controller.ObtenerInstancia().accion("new VAddDepartamento", null);
	    	break;
	    case "mod":
	    	if(tabla.getSelectedRow() != -1){
				int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controller.ObtenerInstancia().accion("new VModDepartamento", null);
				Controller.ObtenerInstancia().accion("Consultar Departamento", ID);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun departamento", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	break;
	    case "sup":
	    	if(tabla.getSelectedRow() != -1){
				int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controller.ObtenerInstancia().accion("borrar Departamento", ID);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun departamento", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	break;
	    case "cons":
	    	if(tabla.getSelectedRow() != -1){
				int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controller.ObtenerInstancia().accion("new VConsDepartamento", null);
				Controller.ObtenerInstancia().accion("Consultar Departamento", ID);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun departamento", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	break;
	    case "nomina":
	    	if(tabla.getSelectedRow() != -1){
				int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controller.ObtenerInstancia().accion("Calcular Nomina", ID);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun departamento", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	break;
	    }
	}
}