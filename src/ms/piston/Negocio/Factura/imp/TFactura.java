/**
 * 
 */
package ms.piston.Negocio.Factura.imp;

import java.util.HashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TFactura {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int ID;
	
	private int id_cliente;

	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private java.util.Date Fecha;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private HashMap<Integer, TLineaProducto> LineasDeProducto;
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	

	
	public java.util.Date getFecha() {
		return Fecha;
	}

	public void setFecha(java.util.Date fecha2) {
		Fecha = fecha2;
	}

	public HashMap<Integer, TLineaProducto> getLineasDeProducto() {
		return LineasDeProducto;
	}

	public void setLineasDeProducto(
			HashMap<Integer, TLineaProducto> lineasDeProducto) {
		LineasDeProducto = lineasDeProducto;
	}
	@Override
	public String toString() {
		return "TFactura [ID=" + ID + ", Fecha=" + Fecha
				+ ", LineasDeProducto=" + LineasDeProducto + "]";
	}

}