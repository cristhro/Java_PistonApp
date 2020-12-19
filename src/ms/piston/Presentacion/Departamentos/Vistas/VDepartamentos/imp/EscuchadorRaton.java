package ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.imp;

import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EscuchadorRaton extends MouseAdapter {
    private VDepartamentos ventana;

    public EscuchadorRaton(VDepartamentos ventana) {
        this.ventana = ventana;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JTable tabla = (JTable) e.getSource();
        Point p = e.getPoint();
        int row = tabla.rowAtPoint(p);
        if (e.getClickCount() == 2) {
				int ID = (int) (ventana.getModelo().getValueAt(row,0));
				Controller.ObtenerInstancia().accion("new VConsDepartamento", null);
				Controller.ObtenerInstancia().accion("Consultar Departamento", ID);
        }
    }
}
