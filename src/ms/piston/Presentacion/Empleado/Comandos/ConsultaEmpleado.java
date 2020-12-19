package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.TContexto;

public class ConsultaEmpleado implements Command {

    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        return new TContexto("consulta empleado", entrada);
    }
}
