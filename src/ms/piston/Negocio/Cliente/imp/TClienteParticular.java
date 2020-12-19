/**
 * 
 */
package ms.piston.Negocio.Cliente.imp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TClienteParticular extends TCliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer CodigoPostal;

	public Integer getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "TClienteParticular [CodigoPostal=" + CodigoPostal
				+ ", toString()=" + super.toString() + "]";
	}



}