/**
 * 
 */
package ms.piston.Presentacion.Empleado.Vistas.datosEmpleado.imp;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.datosEmpleado.VDatosEmpleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class EscuchadorDatosEmpleado implements ActionListener {

    private VDatosEmpleado ventana;

    public EscuchadorDatosEmpleado(VDatosEmpleado ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cerrar":
                ventana.dispose();
                break;
        }
    }
}