package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;

public class NewVDelEmpleado implements Command{

	@Override
	public TContexto ejecuta(Object entrada) throws Exception {
		TContexto tc = new TContexto("init VDelEmpleado", entrada);
		
		return tc;
	}

}
