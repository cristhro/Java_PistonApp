/**
 * 
 */
package ms.piston.Integracion.Querys;

import java.sql.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface Query {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param param
	 * @param d
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void executeQueryFactura(Object param, Object d);
	public void executeQueryCliente(Integer idProducto, Date inicio, Date fin);
}