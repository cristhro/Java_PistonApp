/**
 * 
 */
package ms.piston.Presentacion.Empleado.Comandos;

import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Departamentos.Vistas.VAnadirDepartamentos.VAnadirDepartamento;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.VAltaEmpleado;
import ms.piston.Presentacion.TContexto;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class NewVAltaEmpleado implements Command {
    @Override
    public TContexto ejecuta(Object entrada) throws Exception {
        VAltaEmpleado view = null;
        TContexto contexto = new TContexto("Init VAltaEmpleado", view);

        return contexto;
    }
}