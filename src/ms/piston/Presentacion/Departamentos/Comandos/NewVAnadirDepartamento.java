/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Comandos;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Departamentos.Vistas.VAnadirDepartamentos.VAnadirDepartamento;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class NewVAnadirDepartamento implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#ejecuta(Object entrada)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TContexto ejecuta(Object entrada) {
		VAnadirDepartamento v = new VAnadirDepartamento();
		TContexto contexto = new TContexto("Init VaddDepartamento", v);
		
		return contexto;
	}
}