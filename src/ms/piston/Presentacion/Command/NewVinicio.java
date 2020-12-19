package ms.piston.Presentacion.Command;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Inicio.VInicio;

public class NewVinicio implements Command {

	@Override
	public TContexto ejecuta(Object entrada) {
		return new TContexto("add tabs", new VInicio());
	}

}
