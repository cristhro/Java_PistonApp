package ms.piston.Negocio.Empleado;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import ms.piston.Negocio.Departamentos.Departamento;
import ms.piston.Negocio.Proyecto.Fecha;

@Entity
@NamedQueries({
		@NamedQuery(name = "Empleado.findByid", query = "select obj from Empleado obj where obj.id = :id"),
		@NamedQuery(name = "Empleado.findByDepartamento", query = "select obj from Empleado obj where obj.departamento = :departamento"),
		@NamedQuery(name = "Empleado.findByactivo", query = "select obj from Empleado obj where obj.activo = :activo"),
		@NamedQuery(name = "Empleado.findBynif", query = "select obj from Empleado obj where obj.nif = :nif"),
		@NamedQuery(name = "Empleado.findBynombre", query = "select obj from Empleado obj where obj.nombre = :nombre"),
		@NamedQuery(name = "Empleado.findByapellidos", query = "select obj from Empleado obj where obj.apellidos = :apellidos"),
		@NamedQuery(name = "Empleado.findBytelefono", query = "select obj from Empleado obj where obj.telefono = :telefono"),
		@NamedQuery(name = "Empleado.findBydireccion", query = "select obj from Empleado obj where obj.direccion = :direccion"),
		@NamedQuery(name = "Empleado.findByemail", query = "select obj from Empleado obj where obj.email = :email"),
		@NamedQuery(name = "Empleado.findBysalario", query = "select obj from Empleado obj where obj.salario = :salario"),
		@NamedQuery(name = "Empleado.findAll", query = "select obj from Empleado obj") })
public abstract class Empleado implements Serializable {

	private static final long serialVersionUID = 0;

	public Empleado() {
	}

	@Id
	@GeneratedValue
	private int id;

	@Version
	private Long version;

	@ManyToOne
	private Departamento departamento;

	private Boolean activo;

	private String nif;

	private String nombre;

	private String apellidos;

	private int telefono;

	private String direccion;

	private String email;

	@OneToMany(mappedBy = "empleado")
	private Set<Fecha> fecha;

	protected Float salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract Float getSalario();

	public void setSalario(Float salario) {
		this.salario = salario;
	}

}