/**
 * 
 */
package ms.piston.Negocio.Cliente.imp;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.Cliente.DAOCliente;
import ms.piston.Integracion.FactoriaDAO.FactoriaDAO;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Querys.FactoriaQuery;
import ms.piston.Negocio.Cliente.SACliente;
import ms.piston.Integracion.Querys.imp.QueryCliente;

import java.sql.Date;
import java.util.Collection;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClienteImp implements SACliente {
	/** 
	 * (sin Javadoc)
	 * @see SACliente#anadirCliente(TCliente cliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirCliente(TCliente cliente) {
		
		Integer id = null;  //valor de retorno
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		TCliente cliente2 = (TCliente) daoCLiente.readByNif(cliente.getNif());
		
		if(cliente2  == null){		//  no existe
			id = daoCLiente.anadirCliente(cliente);
			transaction.commit();
		}else						// existe
		{ 		
			if(cliente2.getActivo()){
				transaction.rollback();
			}
			else{
				daoCLiente.activarCliente(cliente2.getId());
				id = cliente2.getId();
				transaction.commit();
			}
		}
		
		return id;
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#modificarCliente(TCliente e)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean modificarCliente(TCliente e) {
		
		Boolean complete = false;  //valor de retorno
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		TCliente cliente2 =  (TCliente) daoCLiente.readByNif(e.getNif());
		
		if(cliente2  != null){		//  existe
			e.setId(cliente2.getId());
			complete = daoCLiente.modificarCliente(e);
			transaction.commit();
		}else						// no existe
		{ 		
			transaction.rollback();
		}
		
		return complete;
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#ConsultarCliente(String nif)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object ConsultarCliente(String nif) {
		
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		return daoCLiente.readByNif(nif);
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#ConsultarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection ConsultarClientes() {
		
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		return daoCLiente.consultarClientes();
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#QueryCliente(TCliente Par�metro1)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void QueryCliente(Integer IdProducto, Date inicio, Date fin) {
		
		QueryCliente queryCliene =  FactoriaQuery.obtenerInstancia().generarQueryCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		queryCliene.executeQueryCliente(IdProducto, inicio, fin);
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#bajaCliente(Integer nif)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean bajaCliente(String nif) {
		Boolean complete = false;  //valor de retorno
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		transaction.start();
		TCliente cliente2 =  (TCliente) daoCLiente.readByNif(nif);
		if(cliente2  != null){		//  existe
			
			boolean activo = cliente2.getActivo();
			if(activo){
				complete = daoCLiente.bajaCliente(cliente2.getId());
				transaction.commit();
			}
		
		}else						// no existe
		{ 		
			transaction.rollback();
			
		}
		
		return complete;
	}
}