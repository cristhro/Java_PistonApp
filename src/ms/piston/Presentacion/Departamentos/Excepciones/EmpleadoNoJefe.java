package ms.piston.Presentacion.Departamentos.Excepciones;

public class EmpleadoNoJefe extends Exception {
	public EmpleadoNoJefe(String msg) {
		super(msg);
	}
}
