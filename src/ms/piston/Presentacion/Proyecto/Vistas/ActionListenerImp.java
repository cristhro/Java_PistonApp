package ms.piston.Presentacion.Proyecto.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Cliente.VCliente.Vcliente;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;
import ms.piston.Presentacion.Proyecto.Vistas.VConsultarProyecto.VConsultarProyecto;

public class ActionListenerImp implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		VProyecto ventana = (VProyecto) VProyecto.getPanel();
    	JTable tabla = ventana.getjTable();
	    switch (action) {
	    	case "crear":
	    		Controller.ObtenerInstancia().accion("new VCrearProyecto", null);
	    		break;
	    	case "modificar":
	    		VProyecto p = (VProyecto) VProyecto.getPanel();
		    	if(tabla.getSelectedRow() != -1){
		    		TProyecto tp = new TProyecto();
					int id = (int) (p.getModelo().getValueAt(tabla.getSelectedRow(), 0));
					String nombre = (String) p.getModelo().getValueAt(tabla.getSelectedRow(), 1);
					int jefe = (int) (p.getModelo().getValueAt(tabla.getSelectedRow(), 2));
					int duracion = (int) (p.getModelo().getValueAt(tabla.getSelectedRow(), 3));
					tp.setNombre(nombre);
					tp.setId(id);
					tp.setJefe(jefe);
					tp.setDuracionEmpleados(duracion);
					tp.setActivo(true);
					Controller.ObtenerInstancia().accion("new VModificarProyecto", tp);
				
		    	}else{
					JOptionPane.showMessageDialog(null, "No has seleccionado ningun proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
	    		break;
	    	case "consultar":
    			if(tabla.getSelectedRow() != -1){
    				int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
    				Controller.ObtenerInstancia().accion("new VConsultarProyecto",ID);
    			}else
    				JOptionPane.showMessageDialog(null, "No has seleccionado ningun proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	    break;
	    	case "borrar":
	    		
	    		if(tabla.getSelectedRow() != -1){
					int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
					Controller.ObtenerInstancia().accion("borrar proyecto", ID);
					}
					else
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		break;
	    	case "addEmp":
	    		if(tabla.getSelectedRow() != -1){
					int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
					Controller.ObtenerInstancia().accion("new VAddEmpleado", ID);
					}
					else
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		break;
	    	case "delEmp":
	    		if(tabla.getSelectedRow() != -1){
					int ID = (int) (ventana.getModelo().getValueAt(tabla.getSelectedRow(), 0));
					Controller.ObtenerInstancia().accion("new VDelEmpleado", ID);
					}
					else
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun proyecto", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		break;
	    }
	}

}