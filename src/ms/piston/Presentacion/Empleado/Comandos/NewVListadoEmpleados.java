/**
 * 
 */
package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;
import ms.piston.Presentacion.TContexto;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class NewVListadoEmpleados implements Command {
    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        TContexto contexto = new TContexto("add tab empleado", new VListadoEmpleados());

        return contexto;
    }
}