/**
 * 
 */
package ms.piston.Integracion.Querys.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Querys.Query;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class QueryCliente implements Query {
	/** 
	 * (sin Javadoc)
	 * @see Query#execute(Object param, Object d)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	/*
	 	OBTIENE UN LISTADO DE CLIENTES QUE HAYAN REALIZADO UNA COMPRA DE X COCHES ENTRE DOS FECHAS
	
	 */					// Id_Producto, Fechas


	@Override
	public void executeQueryCliente(Integer idProducto, Date inicio, Date fin) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		Connection connection = transaction.getResource();
		
		try {
			Statement statement = connection.createStatement();
		
			String sql = "";
			
			
			
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void executeQueryFactura(Object param, Object d) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}
}