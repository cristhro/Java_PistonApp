package ms.piston.Presentacion.Command;

import ms.piston.Presentacion.Departamentos.Comandos.AddDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.BorrarDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.CalcularNominaDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.ConsultarDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.ConsultarDepartamentos;
import ms.piston.Presentacion.Departamentos.Comandos.ModificarDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.NewVAnadirDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.NewVConsultarDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.NewVDepartamento;
import ms.piston.Presentacion.Departamentos.Comandos.NewVModificarDepartamento;
import ms.piston.Presentacion.Empleado.Comandos.*;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoAddEmpleado;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoBorrarProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoConsultarProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoConsultarProyectos;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoCrearProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoModificarProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.ComandoQuitarEmpleado;
import ms.piston.Presentacion.Proyecto.Comandos.NewVAddEmpleado;
import ms.piston.Presentacion.Proyecto.Comandos.NewVConsultarProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.NewVCrearProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.NewVDelEmpleado;
import ms.piston.Presentacion.Proyecto.Comandos.NewVModificarProyecto;
import ms.piston.Presentacion.Proyecto.Comandos.NewVProyecto;

public class FactoryCommandImp extends FactoryCommand {


	@Override
    public Command generarCommand(String evento) {
        Command command = null;

        switch (evento) {
            case "crear VInicio":
                command = new NewVinicio();
                break;
                /*
                *
                * #### DEPARTAMENTOS ####
                *
                */
            case "new VDepartamento":
                command = new NewVDepartamento();
                break;
            
            case "new VAddDepartamento":
                command = new NewVAnadirDepartamento();
                break;
            case "new VModDepartamento":
            	command = new NewVModificarDepartamento();
            	break;
            case "new VConsDepartamento":
            	command = new NewVConsultarDepartamento();
            	break;
            case "alta Departamento":
                command = new AddDepartamento();
                break;
            case "modificar departamento":
            	command = new ModificarDepartamento();
                break;
            case "borrar Departamento":
                command = new BorrarDepartamento();
                break;
            case "Consultar Departamento":
            	command = new ConsultarDepartamento();
            	break;
            case "consultar departamentos":
            	command = new ConsultarDepartamentos();
            	break;
            case "Calcular Nomina":
            	command = new CalcularNominaDepartamento();
            	break;
            	/*
                *
                * #### PROYECTOS ####
                *
                */
            	
            case "new VProyecto":
                command = new NewVProyecto();
                break;
            case "new VCrearProyecto":
            	command = new NewVCrearProyecto();
            	break;
            case "new VModificarProyecto":
            	command = new NewVModificarProyecto();
            	break;
            case "new VConsultarProyecto":
            	command = new NewVConsultarProyecto();
            	break;
            case "new VAddEmpleado" :
            	command = new NewVAddEmpleado();
            	break;
            case "new VDelEmpleado":
            	command = new NewVDelEmpleado();
            	break;
            case "crear proyecto":
                command = new ComandoCrearProyecto();
                break;
            case "consultar proyectos":
                command = new ComandoConsultarProyectos();
                break;
            case "borrar proyecto":
            	command = new ComandoBorrarProyecto();
            	break;
            case "consultar proyecto":
                command = new ComandoConsultarProyecto();
                break;
            case "modificar proyecto":
                command = new ComandoModificarProyecto();
                break;
            case "ComandoAddEmpleado":
                command = new ComandoAddEmpleado();
                break;
            case "quitar empleado":
            	command = new ComandoQuitarEmpleado();
            	break;
                /*
                *
                * #### EMPLEADOS ####
                *
                */
                
            case "new VEmpleado":
                command = new NewVListadoEmpleados();
                break;
            case "new VAltaEmpleado":
                command = new NewVAltaEmpleado();
                break;
            case "new VModificarEmpleado":
                command = new NewVModificarEmpleado();
                break;
            case "alta empleado":
                command = new AltaEmpleado();
                break;
            case "baja empleado":
                command = new BajaEmpleado();
                break;
            case "consulta empleado":
            	command = new ConsultaEmpleado();
                break;
            case "modifica empleado":
                command = new ModificarEmpleado();
                break;
            case "actualiza listaEmpleados":
                command = new ActualizarListaEmpleados();
                break;
        }

        return command;
    }

}
