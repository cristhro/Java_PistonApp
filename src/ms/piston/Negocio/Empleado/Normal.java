/**
 * 
 */
package ms.piston.Negocio.Empleado;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.NamedQuery;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQuery(name = "Normal.findByayudaTransporte", query = "select obj from Normal obj where obj.ayudaTransporte = :ayudaTransporte")
public class Normal extends Empleado implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Normal() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Boolean ayudaTransporte;

	public Boolean getAyudaTransporte() {
		return ayudaTransporte;
	}

	public void setAyudaTransporte(Boolean ayudaTransporte) {
		this.ayudaTransporte = ayudaTransporte;
	}

	
	@Override
	public Float getSalario() {
		return (float) (this.salario);
	}

	
}