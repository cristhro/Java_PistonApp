/**
 * 
 */
package ms.piston.Integracion.FactoriaDAO.imp;

import ms.piston.Integracion.FactoriaDAO.FactoriaDAO;
import ms.piston.Integracion.Cliente.DAOCliente;
import ms.piston.Integracion.Cliente.imp.DAOClienteImp;
import ms.piston.Integracion.Factura.DAOFactura;
import ms.piston.Integracion.Factura.imp.DAOFacturaImp;
import ms.piston.Integracion.Producto.DAOProducto;
import ms.piston.Integracion.Producto.imp.DAOProductoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOImp extends FactoriaDAO {
	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#generarDAOCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente generarDAOCliente() {
		// begin-user-code
		return new DAOClienteImp();
		// end-user-code
	}


	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#generarDAOFactura()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOFactura generarDAOFactura() {
		// begin-user-code
		return new DAOFacturaImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#generarDAOProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOProducto generarDAOProducto() {
		// begin-user-code
		return new DAOProductoImp();
		// end-user-code
	}
}