/**
 * 
 */
package ms.piston.Integracion.Almacendeldominio.imp;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.FactoriaTransaction.imp.TransactionMySQL;

import java.util.concurrent.ConcurrentHashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap concurrentHashMap;
	
	public TransactionManagerImp() {
		super();
		concurrentHashMap = new ConcurrentHashMap<Thread, Transaction>();
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#nuevaTransaccion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void nuevaTransaccion(Thread thread) {
		// begin-user-code
		Transaction trans = new TransactionMySQL();
		this.concurrentHashMap.put(thread, trans);
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#getTransaction()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction getTransaction(Thread thread) {
		// begin-user-code
		return (Transaction) this.concurrentHashMap.get(thread);
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#eliminaTransaction()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void eliminaTransaction(Thread thread) {
		// begin-user-code
		concurrentHashMap.remove(thread);
		// end-user-code
	}
}