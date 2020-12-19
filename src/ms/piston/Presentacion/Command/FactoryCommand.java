/**
 * 
 */
package ms.piston.Presentacion.Command;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class FactoryCommand {
	
	private static FactoryCommand factory;
	
	public static FactoryCommand obtenerinstancia() {
		if(factory == null){
			factory = new FactoryCommandImp();
		}
		return factory;
	}

	public abstract Command generarCommand(String evento);
}