package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.TContexto;

public class ModificarEmpleado implements Command {
    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        FactoriaSA.obtenerInstancia().generarServicioEmpleado().modificarEmpleado((TEmpleado) entrada);
        return new TContexto("modifica empleado", true);
    }
}
