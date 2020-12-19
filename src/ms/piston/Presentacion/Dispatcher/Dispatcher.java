package ms.piston.Presentacion.Dispatcher;

import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Dispatcher.imp.DispatcherImp;

public abstract class Dispatcher {

    private static DispatcherImp dispatcher;

    public static DispatcherImp ObtenerInstancia() {

        if (dispatcher == null) {
            dispatcher = new DispatcherImp();
        }
        return dispatcher;
    }

    public abstract void despacha(TContexto contexto);
    
}