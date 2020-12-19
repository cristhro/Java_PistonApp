/**
 * 
 */
package ms.piston.Integracion.Querys.imp;

import ms.piston.Integracion.Querys.FactoriaQuery;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaQueryImp extends FactoriaQuery {
	/** 
	 * (sin Javadoc)
	 * @see FactoriaQuery#generarQueryCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public QueryCliente generarQueryCliente() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new QueryCliente();
		// end-user-code
	}

	@Override
	public QueryFactura generarQueryFactura() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new QueryFactura();
	}
}