package ms.piston.Negocio.Proyecto;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import ms.piston.Negocio.Empleado.Empleado;

public class TFecha {
	@Override
	public String toString() {
		return "TFecha [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idPro=" + idPro + ", idEmp=" + idEmp
				+ "]";
	}
	private Date fechaInicio;
	private Date fechaFin;
	private Integer idPro;
	private Integer idEmp;
	
	/* Constructor */
	public TFecha() {}
	public TFecha(Date fechaInicio, Date fechaFin, Integer idPro, Integer idEmp) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idPro = idPro;
		this.idEmp = idEmp;
	}
	
	public TFecha(Date fechaInicio, Date fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	/* Setters y Getters */
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
	public Integer getIdProyecto() {
		return idPro;
	}
	public void setIdProyecto(Integer idProyecto) {
		this.idPro= idProyecto;
	}
	public Integer getIdEmpleado() {
		return idEmp;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmp= idEmpleado;
	}
}
