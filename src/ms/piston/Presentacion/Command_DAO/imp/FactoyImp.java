/**
 * 
 */
package ms.piston.Presentacion.Command_DAO.imp;

import ms.piston.Presentacion.Cliente.VAnadirCliente.VAnadirCliente;
import ms.piston.Presentacion.Cliente.VConsultarCliente.VConsultarCliente;
import ms.piston.Presentacion.Cliente.VModificarCliente.VModificarCliente;
import ms.piston.Presentacion.Command_DAO.FactoryCommand;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Command_DAO.CommandCliente.AnadirClienteEmpresa;
import ms.piston.Presentacion.Command_DAO.CommandCliente.AnadirClienteParticular;
import ms.piston.Presentacion.Command_DAO.CommandCliente.EliminarCliente;
import ms.piston.Presentacion.Command_DAO.CommandCliente.ModifcarCliente;
import ms.piston.Presentacion.Command_DAO.CommandCliente.MostrarCliente;
import ms.piston.Presentacion.Command_DAO.CommandCliente.MostrarClientes;
import ms.piston.Presentacion.Command_DAO.CommandFactura.AltaCesta;
import ms.piston.Presentacion.Command_DAO.CommandFactura.ConsultarFacturas;
import ms.piston.Presentacion.Command_DAO.CommandFactura.EmitirFactura;
import ms.piston.Presentacion.Command_DAO.CommandFactura.QuitarProductoCesta;
import ms.piston.Presentacion.Command_DAO.CommandProducto.ConsultarProducto;
import ms.piston.Presentacion.Command_DAO.CommandProducto.ConsultarProductos;
import ms.piston.Presentacion.Command_DAO.CommandProducto.EliminarProducto;
import ms.piston.Presentacion.Command_DAO.CommandProducto.ModificarProducto;
import ms.piston.Presentacion.Producto.VAnadirProducto.VAnadirProducto;
import ms.piston.Presentacion.Producto.VConsultarProducto.VConsultarProducto;
import ms.piston.Presentacion.Producto.VModificarProducto.VModificarProducto;
import ms.piston.Presentacion.Factura.VAltaCesta.VAltaCesta;
import ms.piston.Presentacion.Factura.VAltaCesta.VAltaCestaCliente;
import ms.piston.Presentacion.Factura.VConsultarFactura.VConsultarFactura;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoyImp extends FactoryCommand {
	
	/** 
	 * (sin Javadoc)
	 * @see FactoryCommand#generarCommand()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public command generarCommand(Integer evento) {
		command com = null;
		
		switch(evento){
			case 0 ://crear ventana anadir cliente
			{
				com = new VAnadirCliente();	
				break;
			}
			case 1://crear ventana modificar cliente
			{
				com = new VModificarCliente();
				break;
			}
			case 2://ejecutar eliminar cliente
			{
				com = new EliminarCliente();
				break;
			}
			case 3://ejecutar anadir cliente empresa
			{
				com = new AnadirClienteEmpresa();
				break;
			}
			case 4://ejecutar anadir cliente particular
			{
				com = new AnadirClienteParticular();
				break;
			}
			case 5://ejecutar consultar clientes
			{
				com = new MostrarClientes();
				break;
			}
			case 6://ejecutar consultar cliente para modificar
			{
				com = new MostrarCliente();
				break;
			}
			case 7://ejecutar modificar clientes
			{
				com = new ModifcarCliente();
				break;
			}
			case 8://ejecutar new ventana consultar cliente
			{
				com = new VConsultarCliente();
				break;
			}
			case 9://ejecutar consultar cliente para consultarle
			{
				com = new MostrarCliente();
				break;
			}
			case 10://crear ventana a�adirProducto
			{
				com = new VAnadirProducto();
				break;
			}
			case 11://crear ventana modificarProducto
			{
				com = new VModificarProducto();
				break;
			}
			case 12://ejecutar eliminarProducto
			{
				com = new EliminarProducto();
				break;
			}
			case 13://ejecutar anadir producto
			{
				com = new ms.piston.Presentacion.Command_DAO.CommandProducto.AnadirProducto();
				break;
			}
			case 14://ejecutar consultar clientes
			{
				com = new ConsultarProductos();
				break;
			}
			case 15://ejecutar consultar producto para modificar
			{
				com = new ConsultarProducto();
				break;
			}
			case 16://ejecutar modificar producto
			{
				com = new ModificarProducto();
				break;
			}
			case 17://ejecutar consultar producto
			{
				com = new ConsultarProducto();
				break;
			}
			case 18://crear ventana consultar producto
			{
				com = new VConsultarProducto();
				break;
			}
			case 19://crear ventana seleccion cliente alta cesta
			{
				com = new VAltaCestaCliente();
				break;
			}
			case 20://leer clientes para ventana seleccion cliente alta cesta
			{
				com = new MostrarClientes();
				break;
			}
			case 21://ejecutar alta cesta
			{
				com = new AltaCesta();
				break;
			}
			
			case 22 ://crear ventana alta cesta
			{
				com = new VAltaCesta();	
				break;
			}
			case 23://ejecutar anadir producto alta cesta
			{
				com = new ms.piston.Presentacion.Command_DAO.CommandFactura.AnadirProducto();
				break;
			}
			case 24 ://quitar producto alta cesta
			{
				com = new QuitarProductoCesta();
				break;
			}
			case 25 ://emitir factura
			{
				com = new EmitirFactura();	
				break;
			}
			case 26 ://consultar facturas
			{
				com = new ConsultarFacturas();
				break;
			}
			case 27 ://consultar Factura
			{
				com = new VConsultarFactura();
				break;
			}
			
		}
		return com;

		// end-user-code
	}
}