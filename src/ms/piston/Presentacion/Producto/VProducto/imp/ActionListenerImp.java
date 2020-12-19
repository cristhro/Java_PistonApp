/**
 * 
 */
package ms.piston.Presentacion.Producto.VProducto.imp;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Producto.VProducto.VProducto;

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
	    	Controlador.ObtenerInstancia().accion(10, null);
	        break;
	    case 2://modificar
	    	{
	    	VProducto p = (VProducto) VProducto.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				Integer id = (Integer) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(11, id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun producto", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 3://eliminar
	    {
	    	VProducto p = (VProducto) VProducto.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
	    		Integer id = (Integer) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(12, id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun producto", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	        break; 
	    case 4:
	    {
	    	VProducto p = (VProducto) VProducto.getPanel();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
	    		Integer id = (Integer) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(18,id);
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
			
	        break;
	    }
	    default:
	        break;
	    }
			
	}
}