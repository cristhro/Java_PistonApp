package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.componentes;

import javax.swing.table.DefaultTableModel;

public class MyModel extends DefaultTableModel {

    public boolean isCellEditable (int row, int col) {
        return false;
    }
}
