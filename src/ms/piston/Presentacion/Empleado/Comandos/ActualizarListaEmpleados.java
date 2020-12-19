package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.TContexto;

public class ActualizarListaEmpleados implements Command {

    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        Object data = FactoriaSA.obtenerInstancia().generarServicioEmpleado().consultaEmpleados();
        return new TContexto("actualiza listaEmpleados", data);
    }
}
