package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoExiste;
import ms.piston.Presentacion.Empleado.Excepciones.EmpleadoExistente;
import ms.piston.Presentacion.TContexto;

public class AltaEmpleado implements Command {

    @Override
    public TContexto ejecuta(Object entrada) throws EmpleadoExistente, DepartamentoNoExiste {
        Object data = FactoriaSA.obtenerInstancia().generarServicioEmpleado().altaEmpleado((TEmpleado) entrada);
        return new TContexto("alta Empleado", data);
    }
}
