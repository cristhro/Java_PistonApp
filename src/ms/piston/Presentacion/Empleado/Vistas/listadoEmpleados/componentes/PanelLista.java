package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.componentes;

import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp.EscuchadorListadoEmpleados;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp.EscuchadorRaton;

import javax.swing.*;
import java.awt.*;

public class PanelLista extends JPanel {
    private JTable tabla;
    private MyModel modelo;
    private JScrollPane scrollPanel;
    private String[] columnas;
    private VListadoEmpleados ventana;

    public PanelLista(String[] columnas, VListadoEmpleados ventana) {
        this.ventana = ventana;
        this.columnas = columnas;
        this.tabla = new JTable();
        this.scrollPanel = new JScrollPane(this.tabla);
        this.modelo = new MyModel();

        configPane();
        showPane();
    }

    private void configPane() {
        tabla.addMouseListener(new EscuchadorRaton(ventana));
        modelo.setColumnIdentifiers(columnas);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(800, 250));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);
        tabla.setModel(modelo);
        this.add(scrollPanel);
    }

    private void showPane() {
        tabla.setVisible(true);
        scrollPanel.setVisible(true);
        this.setVisible(true);
    }

    public void addRow(Object[] data) {
        this.modelo.addRow(data);
    }

    public Object getValueAtSelectedRow(int col) {
        return tabla.getValueAt(tabla.getSelectedRow(), col);
    }

    public int getSelectedRow() {
        return tabla.getSelectedRow();
    }
}
