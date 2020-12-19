package ms.piston.Negocio.Proyecto;

/**
 * 
 */

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.MapsId;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author pc
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Embeddable
public class FechaId implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	public FechaId(Integer empleado, Integer proyecto) {
		super();
		this.empleado = empleado;
		this.proyecto = proyecto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public FechaId() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	
	private Integer empleado;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	private Integer proyecto;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof FechaId))
			return false;
		FechaId pk = (FechaId) obj;
		if ((empleado == null && pk.empleado != null)
				|| (empleado != null && !empleado.equals(pk.empleado)))
			return false;
		if ((proyecto == null && pk.proyecto != null)
				|| (proyecto != null && !proyecto.equals(pk.proyecto)))
			return false;
		return true;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getProyecto() {
		return proyecto;
	}

	public void setProyecto(Integer proyecto) {
		this.proyecto = proyecto;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int hashCode() {
		int hashcode = 0;
		if (empleado != null) {
			hashcode += empleado.hashCode();
		}
		if (proyecto != null) {
			hashcode += proyecto.hashCode();
		}
		return hashcode;
	}
}