package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.TContexto;

public class BajaEmpleado implements Command {
    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        FactoriaSA.obtenerInstancia().generarServicioEmpleado().bajaEmpleado((Integer) entrada);
        return new TContexto("baja empleado", true);
    }
}
