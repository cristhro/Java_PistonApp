/**
 * 
 */
package ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.imp;

import ms.piston.Negocio.Empleado.TEmpJefe;
import ms.piston.Negocio.Empleado.TEmpNormal;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.VAltaEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class EscuchadorAltaEmpleado implements ActionListener {
    private VAltaEmpleado ventana;
    private TEmpleado empleado;

    public EscuchadorAltaEmpleado(VAltaEmpleado ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "insertar":
            	if (ventana.tipo.getSelectedIndex() != 0) {
            		if (((String) ventana.tipo.getSelectedItem()).equalsIgnoreCase("empleado")) {
                        empleado = new TEmpNormal();
                        ((TEmpNormal) empleado).setAyudaTransporte(ventana.ayudaTransporte.isSelected());
                    } else {
                        empleado = new TEmpJefe();
                        ((TEmpJefe) empleado).setCocheEmpresa(ventana.cocheEmpresa.getText());
                    }

                    try {
                        empleado.setActivo(true);
                        empleado.setNombre(ventana.nombre.getText());
                        empleado.setApellidos(ventana.apellidos.getText());
                        empleado.setIdDepartamento(Integer.parseInt(ventana.departamento.getText()));
                        empleado.setDireccion(ventana.direccion.getText());
                        empleado.setNif(ventana.nif.getText());
                        empleado.setEmail(ventana.email.getText());
                        empleado.setSalario(Float.parseFloat(ventana.salario.getText()));
                        empleado.setTelefono(Integer.parseInt(ventana.telefono.getText()));

                        Controller.ObtenerInstancia().accion("alta empleado", empleado);
                        Controller.ObtenerInstancia().accion("actualiza listaEmpleados", null);
                        ventana.dispose();
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Hay datos incorrectos!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
            	} else {
            		JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            	}

                break;
            case "cancelar":
                ventana.dispose();
                break;
            case "tipo":
                if (((String) ventana.tipo.getSelectedItem()).equalsIgnoreCase("empleado")) {
                    ventana.cocheEmpresa.setEditable(false);
                    ventana.ayudaTransporte.setEnabled(true);
                } else if (((String) ventana.tipo.getSelectedItem()).equalsIgnoreCase("jefe")) {
                    ventana.ayudaTransporte.setEnabled(false);
                    ventana.cocheEmpresa.setEditable(true);
                } else {
                    ventana.ayudaTransporte.setEnabled(false);
                    ventana.cocheEmpresa.setEditable(false);
                }

                break;
        }
    }
}