/**
 * 
 */
package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.TContexto;

public class NewVModificarEmpleado implements Command {

    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        return new TContexto("Init VModificarEmpleado", (TEmpleado) entrada);
    }
}