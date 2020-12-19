package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;
import ms.piston.Presentacion.Proyecto.Vistas.VProyecto;

public class NewVProyecto implements Command {

	@Override
	public TContexto ejecuta(Object entrada) {
		TContexto contexto = new TContexto ("add tab proyecto", null);
		return contexto;
	}

}
