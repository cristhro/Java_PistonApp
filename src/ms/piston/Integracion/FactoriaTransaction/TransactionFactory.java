/**
 * 
 */
package ms.piston.Integracion.FactoriaTransaction;

import ms.piston.Integracion.FactoriaTransaction.imp.TransactionFactoryImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class TransactionFactory {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static TransactionFactory factoria;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static TransactionFactory obtenerInstancia() {
		// begin-user-code
		if(factoria == null) {
			factoria = new TransactionFactoryImp();
		}
		
		return factoria;
		// end-user-code
	}

}