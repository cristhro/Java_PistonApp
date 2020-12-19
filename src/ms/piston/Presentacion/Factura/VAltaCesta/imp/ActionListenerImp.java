/**
 * 
 */
package ms.piston.Presentacion.Factura.VAltaCesta.imp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Factura.VAltaCesta.VAltaCesta;
import ms.piston.Presentacion.Factura.VAltaCesta.VAltaCestaCliente;

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
	    case 1: //seleccion de cliente
	    {
	    	VAltaCestaCliente p = (VAltaCestaCliente) VAltaCestaCliente.getJFrame();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				Integer id = (Integer) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
				Controlador.ObtenerInstancia().accion(21,id);
				Controlador.ObtenerInstancia().accion(22,id);
				p.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
	        break;
	}
	    case 2://anadir producto
	    	{
	    		VAltaCesta p = (VAltaCesta) VAltaCesta.getVentana();
		    	
					Integer id = Integer.parseInt(p.getLabel1().getText());
					Integer cantidad = Integer.parseInt(p.getLabel2().getText());
					ArrayList<Integer> datos = new ArrayList<Integer>();
					datos.add(id);
					datos.add(cantidad);
					Controlador.ObtenerInstancia().accion(23,datos);
					p.actualizar();
					
		        break;
	    	} 
	    case 3://quitar producto
	    {
	    	VAltaCesta p = (VAltaCesta) VAltaCesta.getVentana();
	    	JTable tabla = p.getjTable();
	    	if(tabla.getSelectedRow() != -1){
				Integer id = (Integer) (p.getModelo().getValueAt(tabla.getSelectedRow(), 3));
				Controlador.ObtenerInstancia().accion(24,id);
				p.quitar();
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	  break; 	
	    }
	      
	    case 4://emitir factura
	    {
	    	VAltaCesta p = (VAltaCesta) VAltaCesta.getVentana();
				Controlador.ObtenerInstancia().accion(25,null);
				p.dispose();
		 break;
	    }
	      
	    default:
	        break;
	    }

		// end-user-code
	}
}