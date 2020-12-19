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
@NamedQuery(name = "Jefe.findBycocheEmpresa", query = "select obj from Jefe obj where obj.cocheEmpresa = :cocheEmpresa")
public class Jefe extends Empleado implements Serializable {
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
	public Jefe() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String cocheEmpresa;

	public String getCocheEmpresa() {
		return cocheEmpresa;
	}

	public void setCocheEmpresa(String cocheEmpresa) {
		this.cocheEmpresa = cocheEmpresa;
	}

	@Override
	public Float getSalario() {
		return (float) (this.salario * 1.5);
	}

	
}