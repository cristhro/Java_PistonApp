/**
 * 
 */
package ms.piston.Integracion.Querys;

import ms.piston.Integracion.Querys.imp.FactoriaQueryImp;
import ms.piston.Integracion.Querys.imp.QueryCliente;
import ms.piston.Integracion.Querys.imp.QueryFactura;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaQuery {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaQuery factoria;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaQuery obtenerInstancia() {
		if(factoria == null) {
			factoria = new FactoriaQueryImp();
		}
		
		return factoria;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract QueryCliente generarQueryCliente();
	public abstract QueryFactura generarQueryFactura();
}