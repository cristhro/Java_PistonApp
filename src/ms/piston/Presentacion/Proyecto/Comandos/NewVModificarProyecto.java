package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.VCrearProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.VModificarProyecto;

public class NewVModificarProyecto implements Command{

	
	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		// TODO Auto-generated method stub
			TProyecto tp = (TProyecto) entrada;
			TContexto contexto = new TContexto ("init VModificarProyecto", entrada);
		return contexto;
	}

}
