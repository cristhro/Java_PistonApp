/**
 * 
 */
package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp;

import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class EscuchadorListadoEmpleados implements ActionListener {

    private VListadoEmpleados ventana;

    public EscuchadorListadoEmpleados(VListadoEmpleados ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "alta":
                Controller.ObtenerInstancia().accion("new VAltaEmpleado", null);
                break;
            case "baja":
                if (ventana.getEmpleadoId() != -1) {
                    Controller.ObtenerInstancia().accion("baja empleado", ventana.getEmpleadoId());
                    Controller.ObtenerInstancia().accion("actualiza listaEmpleados", null);
                }
                break;
            case "modificar":
                Controller.ObtenerInstancia().accion("new VModificarEmpleado", ventana.getEmpleado());
                break;
            case "consultar":
                Controller.ObtenerInstancia().accion("consulta empleado", ventana.getEmpleado());
                break;
        }
    }
}