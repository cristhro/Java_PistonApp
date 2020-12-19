/**
 *
 */
package ms.piston.Presentacion.Dispatcher.imp;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.TContexto;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Departamentos.Vistas.VAnadirDepartamentos.VAnadirDepartamento;
import ms.piston.Presentacion.Departamentos.Vistas.VConsultarDepartamentos.VConsultarDepartamento;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;
import ms.piston.Presentacion.Departamentos.Vistas.VModificarDepartamentos.VModificarDepartamento;
import ms.piston.Presentacion.Dispatcher.Dispatcher;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.VAltaEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.datosEmpleado.VDatosEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;
import ms.piston.Presentacion.Empleado.Vistas.modificarEmpleado.VModificarEmpleado;
import ms.piston.Presentacion.Inicio.VInicio;
import ms.piston.Presentacion.Proyecto.Vistas.VProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VConsultarProyecto.VConsultarProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.VCrearProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.VModificarProyecto;
import ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado.VAddEmpleado;
import ms.piston.Presentacion.Proyecto.Vistas.VdelEmpleado.VDelEmpleado;


public class DispatcherImp extends Dispatcher {

    private VInicio ini;
    private VDepartamentos departamento;
    private VProyecto proyecto;
    private VListadoEmpleados vListadoEmpleados;
    private VModificarDepartamento modDep;
    private VConsultarDepartamento consDep;

    public void despacha(TContexto contexto) {
        String evento = contexto.getEvento();
        Object datos = contexto.getDatos();

        switch (evento) {
            /*
             *
             * #### GENERAL ####
             *
             */
            case "add tabs":
                ini = (VInicio) datos;
                Controlador.ObtenerInstancia().accion(101, datos);
                Controlador.ObtenerInstancia().accion(102, datos); // las 3 ventanas del DAO
                Controlador.ObtenerInstancia().accion(103, datos);
                Controller.ObtenerInstancia().accion("new VDepartamento", null);
                Controller.ObtenerInstancia().accion("new VProyecto", null);
                Controller.ObtenerInstancia().accion("new VEmpleado", null);
                Controller.ObtenerInstancia().accion("actualiza listaEmpleados", null);
                ini.anadirTabs();
                break;
            case "exception":
                JOptionPane.showMessageDialog(null, datos, "Ooops, algo no fue bien...", JOptionPane.ERROR_MESSAGE);
                break;

            /*
             *
             * #### DEPARTAMENTOS ####
             *
             */
            case "add tab departamento":
                departamento = (VDepartamentos) datos;
                Controller.ObtenerInstancia().accion("consultar departamentos", null);
                ini.actualizar(departamento);
                break;
            case "departamento existente":
                JOptionPane.showMessageDialog(null, "Departamento ya existente", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
            case "Init VaddDepartamento":
                ((VAnadirDepartamento) datos).initGUI();
                break;
            case "Init VModificarDepartamento":
            	modDep = (VModificarDepartamento) datos;
            	modDep.initGUI();
                break;
            case "Init VconsDepartamento":
            	consDep = (VConsultarDepartamento) datos;
            	consDep.initGUI();
                break;
            case "consultar departamento":
                if (modDep != null){
                    modDep.actualizar((TDepartamento) datos);
                    modDep = null;
                }
                if (consDep != null){
                    consDep.actualizar((TDepartamento) datos);
                    consDep = null;
                }
                break;
            case "actualizar departamento":
            	Controller.ObtenerInstancia().accion("consultar departamentos", datos);
            	break;
            case "actualizar VDepartamento":
            	departamento.actualizar(datos);
            	break;
            case "calcular nomina":
            	String salida = "La suma de los salarios de los empleados del departamento es de " + datos +" €";
             JOptionPane.showMessageDialog(null, salida, "Nomina del departamento", JOptionPane.INFORMATION_MESSAGE);
            	break;
            	

            /*
             *
             * #### PROYECTOS ####
             *
             */
            case "add tab proyecto":
                proyecto = new VProyecto();
                ini.actualizar(proyecto);
                Controller.ObtenerInstancia().accion("consultar proyectos", null);
                break;
            case "init VCrearProyecto":
            	new VCrearProyecto().initGUI();;
            	break;
            case "init VAddEmpleado":
            	int idPro = (int) datos;
            	new VAddEmpleado(idPro);
            	break;
            case "init VModificarProyecto":
            	new VModificarProyecto(datos).initGUI();;
            	break;
            case "init VConsultarProyecto":
            	TProyecto tp = (TProyecto) datos;
            	new VConsultarProyecto(tp).initGUI();
            	break;	
            case "init VDelEmpleado":
            	int idProyecto = (int) datos;
            	new VDelEmpleado(idProyecto);
            	break;
            case "actualizar proyecto":
            	proyecto.actualizar(datos);
            	break;
            case  "add empleado":
            	TFecha tf = (TFecha)datos;
            	JOptionPane.showMessageDialog(null, "Empleado con id:  "+ tf.getIdEmpleado() + " asignado al " +"Proyecto con id: " + tf.getIdProyecto(), "Asignacion correcta", JOptionPane.INFORMATION_MESSAGE);
            	break;
            case  "crear proyecto":
            	Integer id = (Integer)datos;
            	JOptionPane.showMessageDialog(null, "Proyecto creado con id:  "+ id ,"Creacion correcta", JOptionPane.INFORMATION_MESSAGE);
            	break;
            case "modificar proyecto":
            	proyecto.actualizar(datos);
            	JOptionPane.showMessageDialog(null, "Proyecto modificado con exito.", "Modificacion correcta", JOptionPane.INFORMATION_MESSAGE);
            	break;
            case "del empleado": 
            	TFecha tfe = (TFecha) datos;
            	JOptionPane.showMessageDialog(null, "Empleado  con id: " + tfe.getIdEmpleado()+" eliminado con exito del Proyecto con id: "+ tfe.getIdProyecto(), "Desvinculacion correcta", JOptionPane.INFORMATION_MESSAGE);
            	break;
            /*
             *
             * #### EMPLEADOS ####
             *
             */
            case "add tab empleado":
                vListadoEmpleados = (VListadoEmpleados) datos;
                ini.actualizar(vListadoEmpleados);
                break;
            case "Init VAltaEmpleado":
                new VAltaEmpleado();
                break;
            case "Init VModificarEmpleado":
                TEmpleado empleado = (TEmpleado) datos;
                new VModificarEmpleado(empleado);
                break;
            case "Init VDatosEmpleado":
                TEmpleado empleado1 = (TEmpleado) datos;
                new VDatosEmpleado(empleado1);
                break;
            case "alta Empleado":
                JOptionPane.showMessageDialog(null, "Alta correcta con id: " + datos, "Alta correcta", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "baja empleado":
                JOptionPane.showMessageDialog(null, "Empleado dado de baja.", "Baja correcta", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "consulta empleado":
                TEmpleado empleado2 = (TEmpleado) datos;
                new VDatosEmpleado(empleado2);
                break;
            case "modifica empleado":
                JOptionPane.showMessageDialog(null, "Empleado modificado con exito.", "Modificacion correcta", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "actualiza listaEmpleados":
                vListadoEmpleados.actualizar(datos);
                break;
        }
    }

}