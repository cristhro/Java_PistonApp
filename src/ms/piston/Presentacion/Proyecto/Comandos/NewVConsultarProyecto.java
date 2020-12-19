package ms.piston.Presentacion.Proyecto.Comandos;

import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Departamentos.Vistas.VConsultarDepartamentos.VConsultarDepartamento;
import ms.piston.Presentacion.Proyecto.Vistas.VConsultarProyecto.VConsultarProyecto;

public class NewVConsultarProyecto implements Command {

	@Override
	public TContexto ejecuta(Object datos) throws Exception {
		int id = (int) datos;
		datos =  FactoriaSA.obtenerInstancia().generarServicioProyecto().consultarProyecto(id);
		
		TContexto contexto = new TContexto("init VConsultarProyecto", datos);
		
		return contexto;
	}

}
