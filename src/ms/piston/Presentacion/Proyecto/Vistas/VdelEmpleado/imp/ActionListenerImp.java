package ms.piston.Presentacion.Proyecto.Vistas.VdelEmpleado.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.VModificarProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VdelEmpleado.VDelEmpleado;

public class ActionListenerImp implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		VDelEmpleado v = (VDelEmpleado) VDelEmpleado.getFrame();
		TFecha tf = v.getFecha();
		Controller.ObtenerInstancia().accion("quitar empleado" , tf);
		v.dispose();
		
	}

}
