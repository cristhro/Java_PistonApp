/**
 * 
 */
package ms.piston.Negocio.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class TProyecto {
	@Override
	public String toString() {
		return "TProyecto [activo=" + activo + ", nombre=" + nombre + ", jefe=" + jefe + ", duracionEmpleados="
				+ duracionEmpleados + ", id=" + id + ", Fechas=" + Fechas.toString() + "]";
	}
	private Boolean activo;
	private String nombre;
	private Integer jefe;
	private Integer duracionEmpleados;
	private Integer id;
	
	private List<TFecha> Fechas;
	
	public List<TFecha> getFechas() {
		return Fechas;
	}
	public void setFechas(List<TFecha> fechas) {
		Fechas = fechas;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}