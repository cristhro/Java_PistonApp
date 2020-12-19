/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Comandos;


import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ConsultarDepartamento implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#ejecuta(Object entrada)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public TContexto ejecuta(Object entrada) {
		Object datos = FactoriaSA.obtenerInstancia().generarServicioDepartamento().ConsultarDepartamento((int) entrada);
		TContexto contexto = new TContexto("consultar departamento", datos);
		return contexto;
	}
}