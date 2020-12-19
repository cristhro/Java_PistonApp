/**
 * 
 */
package ms.piston.Negocio.Departamentos;


import java.util.Collection;

import ms.piston.Negocio.Empleado.TEmpleado;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class TDepartamento {
	private Integer ID;
	
	private boolean Activo;
	
	private String Nombre;
	
	private Integer Jefe;
	
	private Collection<TEmpleado> ListaEmpleados;

	public String getNombre() {
		
		return Nombre;
	}

	public Collection<TEmpleado> getListaEmpleados() {
		return ListaEmpleados;
	}

	public void setListaEmpleados(Collection<TEmpleado> listaEmpleados) {
		ListaEmpleados = listaEmpleados;
	}
	public int getJefe() {

		if(Jefe != null)
			return Jefe;
			else
			return -1;
		
	}
	public int getID() {
		return ID;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public void setJefe(int jefe) {
		this.Jefe = jefe;
	}

	public boolean getActivo() {
		return Activo;
	}

	public void setActivo(boolean activo) {
		Activo = activo;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	

	

	
}