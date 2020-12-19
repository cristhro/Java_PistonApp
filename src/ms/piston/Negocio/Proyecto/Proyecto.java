package ms.piston.Negocio.Proyecto;

/**
 * 
 */

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author pc
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findByid", query = "select obj from Proyecto obj where obj.id = :id"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findByactivo", query = "select obj from Proyecto obj where obj.activo = :activo"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findBynombre", query = "select obj from Proyecto obj where obj.nombre = :nombre"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findByjefe", query = "select obj from Proyecto obj where obj.jefe = :jefe"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findByduracionEmpleados", query = "select obj from Proyecto obj where obj.duracionEmpleados = :duracionEmpleados"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Proyecto.findByfecha", query = "select obj from Proyecto obj where obj.fecha = :fecha") })
public class Proyecto implements Serializable {
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
	public Proyecto() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@Id @GeneratedValue
	private Integer id;
	
	@Version
	private Long version;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Boolean activo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String nombre;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Integer jefe;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Integer duracionEmpleados;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@OneToMany(mappedBy = "proyecto")
	private Set<Fecha> fecha;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getJefe() {
		return jefe;
	}
	public void setJefe(Integer jefe) {
		this.jefe = jefe;
	}
	public Integer getDuracionEmpleados() {
		return duracionEmpleados;
	}
	public void setDuracionEmpleados(Integer duracionEmpleados) {
		this.duracionEmpleados = duracionEmpleados;
	}
	public Set<Fecha> getFecha() {
		return fecha;
	}
	public void setFecha(Set<Fecha> fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", activo=" + activo + ", nombre=" + nombre + ", jefe=" + jefe
				+ ", duracionEmpleados=" + duracionEmpleados + ", fecha=" + fecha + "]";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

}