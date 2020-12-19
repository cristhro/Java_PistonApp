package ms.piston.Presentacion.Controller.imp;


import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Command.Command;
import ms.piston.Presentacion.Command.FactoryCommand;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Dispatcher.Dispatcher;

public class ControladorImp extends Controller {
	public void accion(String evento, Object Datos) {
		TContexto contexto = new TContexto();
		Command c =  FactoryCommand.obtenerinstancia().generarCommand(evento);

		if(c != null)
		{
			try{
				contexto = (TContexto) c.ejecuta(Datos);
			}
			catch(Exception e){
				contexto.setEvento("exception");
				contexto.setDatos(e.getMessage());
			}
			finally{
				Dispatcher.ObtenerInstancia().despacha(contexto);
			}
		}
	}
}