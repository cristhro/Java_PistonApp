package ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.imp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Negocio.Cliente.imp.TClienteEmpresa;
import ms.piston.Negocio.Cliente.imp.TClienteParticular;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Cliente.VModificarCliente.VModificarCliente;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.VModificarProyecto;

public class ActionListenerImpMp implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		VModificarProyecto v = (VModificarProyecto) VModificarProyecto.getFrame();
		TProyecto tp = v.getTProyecto();
		Controller.ObtenerInstancia().accion("modificar proyecto" , tp);
		v.dispose();

	}

}
