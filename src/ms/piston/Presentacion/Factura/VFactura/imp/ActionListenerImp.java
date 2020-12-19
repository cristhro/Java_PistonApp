/**
 * 
 */
package ms.piston.Presentacion.Factura.VFactura.imp;

import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Factura.VFactura.VFactura;

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
		// begin-user-code
		int action = Integer.parseInt(arg0.getActionCommand());
	    switch (action) {
	    case 1: //anadir
	    	Controlador.ObtenerInstancia().accion(19 , null);
	        break;
	    case 2://modificar
	    	{
	    	VFactura p = (VFactura) VFactura.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String id = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(51, id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 3://eliminar
	    {
	    	VFactura p = (VFactura) VFactura.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String id = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(52,id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 4://consultar
	    {
	    	VFactura p = (VFactura) VFactura.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				String id = (String) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(58, id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break;
	    default:
	        break;
	    }

		// end-user-code
	}
}