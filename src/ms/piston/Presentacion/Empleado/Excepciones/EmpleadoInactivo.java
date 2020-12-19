package ms.piston.Presentacion.Empleado.Excepciones;

public class EmpleadoInactivo extends Exception {
	
	public EmpleadoInactivo(String msg) {
		super(msg);
	}
}