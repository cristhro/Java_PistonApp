/**
 * 
 */
package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.componentes.PanelLista;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.componentes.PanelBotones;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp.EscuchadorListadoEmpleados;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class VListadoEmpleados extends JPanel {
    private PanelBotones panelBotones;
    private PanelLista panelLista;
    private String[] columnas;
    private EscuchadorListadoEmpleados escuchador;
    private List<TEmpleado> empleados;

    public VListadoEmpleados() {
        super();
        this.escuchador = new EscuchadorListadoEmpleados(this);
        this.panelBotones = new PanelBotones(this.escuchador);
        this.columnas = new String[] {"Id", "NIF", "Nombre", "Apellidos"};
        this.panelLista = new PanelLista(columnas, this);

        initGUI();
    }

    public void initGUI() {
        setLayout(new BorderLayout());
        this.add(panelBotones, BorderLayout.NORTH);
        this.add(panelLista, BorderLayout.CENTER);
    }

    public void actualizar(Object data) {
        this.empleados = (List<TEmpleado>) data;

        if (data == null) {
            JOptionPane.showMessageDialog(null, "Se produjo un error", "Ooops! Algo no fue bien.", JOptionPane.ERROR_MESSAGE);
        } else {
            this.remove(panelLista);
            this.panelLista = new PanelLista(this.columnas, this);

            TEmpleado emp;
            Iterator<TEmpleado> it = empleados.iterator();
            while (it.hasNext()) {
                emp = it.next();

                if (emp.getActivo() == true) {
                    Object[] datosEmpleado = new Object[] {emp.getId(), emp.getNif(), emp.getNombre(), emp.getApellidos()};
                    this.panelLista.addRow(datosEmpleado);
                }
            }

            this.add(panelLista, BorderLayout.CENTER);
            this.revalidate();
        }
    }

    public int getEmpleadoId() {
        return (int) panelLista.getValueAtSelectedRow(0);
    }

    public TEmpleado getEmpleado() {
    	int idEmp = getEmpleadoId();
    	TEmpleado emp = null;
        Iterator<TEmpleado> it = empleados.iterator();
        
        while (it.hasNext()) {
        	emp = it.next();
        	
        	if (emp.getId() == idEmp)
        		break;
        }
    	
        return emp;
    }
}