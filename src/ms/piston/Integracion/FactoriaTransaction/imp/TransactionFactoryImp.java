/**
 * 
 */
package ms.piston.Integracion.FactoriaTransaction.imp;

import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.FactoriaTransaction.TransactionFactory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryImp extends TransactionFactory {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction generarTransaction() {
		// begin-user-code
		return new TransactionMySQL();
		// end-user-code
	}
	
}