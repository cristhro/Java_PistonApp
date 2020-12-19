/**
 * 
 */
package ms.piston.Integracion.FactoriaTransaction.imp;

import ms.piston.Integracion.FactoriaTransaction.Transaction;

import java.sql.*;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionMySQL implements Transaction {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Connection connection;

	/** 
	 * (sin Javadoc)
	 * @see Transaction#start()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {

		String url = "jdbc:mysql://qul790.pino.es/qul790";
		//String url = "jdbc:mysql://localhost/piston";
		String user = "qul790";
		String pass = "Pis07ton";
	
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		
			connection = DriverManager.getConnection(url,user,pass);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#commit()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		// begin-user-code
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#rollback()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() {
		// begin-user-code
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#getResource()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getResource() {
		// begin-user-code
		return connection;
		// end-user-code
	}
}