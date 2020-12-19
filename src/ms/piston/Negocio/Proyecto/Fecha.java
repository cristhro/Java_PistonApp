package ms.piston.Negocio.Proyecto;

/**
 * 
 */

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.NamedQuery;

import ms.piston.Negocio.Empleado.Empleado;

import java.util.Date;

import javax.persistence.NamedQueries;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Version;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author pc
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Fecha.findByid", query = "select obj from Fecha obj where obj.id = :id"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Fecha.findByfechaInicio", query = "select obj from Fecha obj where obj.fechaInicio = :fechaInicio"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Fecha.findByfechaFin", query = "select obj from Fecha obj where obj.fechaFin = :fechaFin"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Fecha.findByproyecto", query = "select obj from Fecha obj where obj.proyecto = :proyecto"),
		@NamedQuery(name = "ModeloJPA.Negocio.Proyecto.Fecha.findByempleado", query = "select obj from Fecha obj where obj.empleado = :empleado") })
public class Fecha implements Serializable {

	@Override
	public String toString() {
		return "Fecha [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", proyecto=" + proyecto
				+ ", empleado=" + empleado + "]";
	}

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
	public Fecha() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@EmbeddedId
	private FechaId id;
	
	@Version
	private Long version;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Date fechaInicio;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Date fechaFin;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@MapsId @ManyToOne
	private Proyecto proyecto;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@MapsId @ManyToOne
	private Empleado empleado;
	
	
	public FechaId getId() {
		return id;
	}
	public void setId(FechaId id) {
		this.id = id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}