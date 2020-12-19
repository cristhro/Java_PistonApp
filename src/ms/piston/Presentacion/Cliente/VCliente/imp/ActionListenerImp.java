/**
 * 
 */
package ms.piston.Presentacion.Cliente.VCliente.imp;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Presentacion.Cliente.VCliente.Vcliente;
import ms.piston.Presentacion.Controlador_DAO.Controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ActionListenerImp implements ActionListener {
	
	/** 
	 * (sin Javadoc)
	 * @see ActionListener#actionPerformed(ActionEvent arg0)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actionPerformed(ActionEvent arg0) {
		int action = Integer.parseInt(arg0.getActionCommand());
	    switch (action) {
	    case 1: //anadir
	    	Controlador.ObtenerInstancia().accion(0 , null);
	        break;
	    case 2://modificar
	    	{
	    	Vcliente p = (Vcliente) Vcliente.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String nif = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 3));
				Controlador.ObtenerInstancia().accion(1,nif);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 3://eliminar
	    {
	    	Vcliente p = (Vcliente) Vcliente.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String nif = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 3));
				Controlador.ObtenerInstancia().accion(2,nif);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 4://consultar
	    {
	    	Vcliente p = (Vcliente) Vcliente.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String nif = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 3));
				Controlador.ObtenerInstancia().accion(8,nif);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break;
	    default:
	        break;
	    }
			
	}


}