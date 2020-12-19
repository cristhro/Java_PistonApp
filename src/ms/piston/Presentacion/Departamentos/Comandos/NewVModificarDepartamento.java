/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VModificarDepartamentos.VModificarDepartamento;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class NewVModificarDepartamento implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#ejecuta(Object entrada)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TContexto ejecuta(Object entrada) {
		VModificarDepartamento v = new VModificarDepartamento();
		TContexto contexto = new TContexto("Init VModificarDepartamento", v);
		
		return contexto;
	}
}