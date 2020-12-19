package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Proyecto.Vistas.VConsultarProyecto.VConsultarProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado.VAddEmpleado;

public class NewVAddEmpleado implements Command {

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		TContexto contexto = new TContexto("init VAddEmpleado", entrada);
		
		return contexto;
	}

}
