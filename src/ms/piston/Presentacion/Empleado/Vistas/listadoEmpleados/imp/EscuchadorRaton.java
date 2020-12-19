package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp;

import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EscuchadorRaton extends MouseAdapter {
    private VListadoEmpleados ventana;

    public EscuchadorRaton(VListadoEmpleados ventana) {
        this.ventana = ventana;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JTable tabla = (JTable) e.getSource();
        Point p = e.getPoint();
        int row = tabla.rowAtPoint(p);
        if (e.getClickCount() == 2) {
            Controller.ObtenerInstancia().accion("consulta empleado", ventana.getEmpleado());
        }
    }
}
