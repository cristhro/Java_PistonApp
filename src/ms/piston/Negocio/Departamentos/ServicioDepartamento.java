/**
 * 
 */
package ms.piston.Negocio.Departamentos;

import java.util.Collection;

import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoConEmpleado;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoExistente;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoExiste;
import ms.piston.Presentacion.Departamentos.Excepciones.DepartamentoNoModificable;
import ms.piston.Presentacion.Departamentos.Excepciones.EmpleadoNoJefe;
import ms.piston.Presentacion.Departamentos.Excepciones.JefeNoExiste;

public interface ServicioDepartamento {

	boolean CrearDepartamento(TDepartamento departamento) throws DepartamentoExistente, EmpleadoNoJefe, JefeNoExiste;

	public float CalcularNominaDepartamento(int ID);
	
	public boolean ModificarDepartamento(TDepartamento departamento) throws DepartamentoNoModificable, EmpleadoNoJefe, JefeNoExiste;

	public boolean BorrarDepartamento(int ID) throws DepartamentoNoExiste, DepartamentoConEmpleado;

	public TDepartamento ConsultarDepartamento(int ID);

	public Collection ConsultarDepartamentos();
}