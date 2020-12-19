/**
 * 
 */
package ms.piston.Negocio.Producto.imp;

import java.util.Collection;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.FactoriaDAO.FactoriaDAO;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Producto.DAOProducto;
import ms.piston.Negocio.Producto.SAProducto;
import ms.piston.Negocio.Producto.TProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAProductoImp implements SAProducto {
	/** 
	 * (sin Javadoc)
	 * @see SAProducto#anadirProducto(TProducto TProducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirProducto(TProducto TProducto) {
		
		Integer id = null;  //valor de retorno
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		TProducto producto2 =  daoProducto.readByMarcaModeloAnoPrecioPlazasCombustibleS(TProducto) ; 
		
		if(producto2 == null){
			
			id = daoProducto.anadirProducto(TProducto);
			System.out.println("id" +id);
			transaction.commit();
			
		}else
		{
			
			transaction.rollback();
			
		}
		
		return id;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#modificarProdructo(TProducto TProducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean modificarProdructo(TProducto TProducto) {
		Boolean complete = false;  //valor de retorno
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		TProducto producto2 =  daoProducto.readByID(TProducto.getId());
		
		
		if(producto2  != null){		//  existe
	
			complete = daoProducto.modificarProducto(TProducto);
			
			transaction.commit();
		
		}else						// no existe
		{ 		
			transaction.rollback();
		}
		
		return complete;
		
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#eliminarProducto(Integer Id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean eliminarProducto(Integer Id) {
		Boolean complete = false;

		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		TProducto producto2 =  daoProducto.readByID(Id) ; //daoProducto;	//TODO poner operacion leer un producto mediante un parametro
		
		if(producto2 != null){ // !=
			
			complete = daoProducto.eliminarProducto(Id);
			
			transaction.commit();
			
		}else
		{
			
			transaction.rollback();
			
		}
		
		return complete;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#consultarProducto(Integer Id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto consultarProducto(Integer Id) {
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		return daoProducto.readByID(Id);
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#consultarProductos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public Collection<TProducto> consultarProductos() {
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		return daoProducto.consultarProductos();
	}
}