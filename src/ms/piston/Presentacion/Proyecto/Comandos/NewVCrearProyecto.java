package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.VCrearProyecto;

public class NewVCrearProyecto implements Command {

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		TContexto contexto = new TContexto ("init VCrearProyecto", null);
		return contexto;
	}

}
