/**
 * 
 */
package ms.piston.Presentacion.Dispatcher_DAO;


import ms.piston.Presentacion.Cliente.VCliente.Vcliente;
import ms.piston.Presentacion.Cliente.VConsultarCliente.VConsultarCliente;
import ms.piston.Presentacion.Cliente.VModificarCliente.VModificarCliente;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Controlador_DAO.TContexto;
import ms.piston.Presentacion.Factura.VAltaCesta.VAltaCestaCliente;
import ms.piston.Presentacion.Factura.VFactura.VFactura;
import ms.piston.Presentacion.Inicio.VInicio;
import ms.piston.Presentacion.Producto.VConsultarProducto.VConsultarProducto;
import ms.piston.Presentacion.Producto.VModificarProducto.VModificarProducto;
import ms.piston.Presentacion.Producto.VProducto.VProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Dispatcher {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	private static Dispatcher Instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Dispatcher ObtenerInstacia() {
		// begin-user-code
		if(Instancia == null)
			Instancia = new Dispatcher();
		return Instancia;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param context 
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private VInicio ini;
	private Vcliente cliente;
	private VProducto prod;
	private VFactura fact;
	public void despacha(TContexto context) {
		Integer evento = context.getEvento();
		Object Datos = context.getDato();
		switch(evento){
		case 0 ://crear ventana anadir cliente
		{	
			break;
		}
		case 1://crear ventana modificar cliente
		{
			break;
		}
		case 2://ejecutar eliminar cliente
		{
			if(Datos == null)
				cliente.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(5, Datos);//lee todos los clientes
			
			break;
		}
		case 3://ejecutar anadir cliente empresa
		{
			if(Datos == null)
				cliente.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(5, Datos);//lee todos los clientes
			
			break;
		}
		case 4://ejecutar anadir cliente particular
		{
			if(Datos == null)
				cliente.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(5, Datos);//lee todos los clientes
			
			break;
		}
		case 5://ejecutar consultar clientes
		{
			cliente.actualizar(Datos);
			break;
		}
		case 6://leer datos cliente para modificar
		{
			VModificarCliente mod = (VModificarCliente) VModificarCliente.getFrame();
			mod.actualizar(Datos);
			break;
		}
		case 7://ejecutar consultar clientes
		{
			if((Boolean)Datos == false){
				Datos = null;
				cliente.actualizar(Datos); //mostrar error
			}
			else
				Controlador.ObtenerInstancia().accion(5, Datos);//lee todos los clientes
			
			break;
		}
		case 9://consulta cliente
		{
			VConsultarCliente cons = (VConsultarCliente) VConsultarCliente.getFrame();
			cons.actualizar(Datos);
			break;
		}
		case 10://crear ventana a�adirProducto
		{
			break;
		}
		case 11://crear ventana modificarProducto
		{
			break;
		}
		case 12://ejecutar eliminarProducto
		{
			if(Datos == null)
				prod.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(14, Datos);//lee todos los clientes
			
			break;
			
		}
		case 13://anadir producto
		{
			if(Datos == null)
				prod.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(14, Datos);//lee todos los clientes
			
			break;
		}
		case 14://consultar productos
		{
			prod.actualizar(Datos);
			break;
		}
		case 15://leer datos producto para modificar
		{
			VModificarProducto mod = (VModificarProducto) VModificarProducto.getFrame();
			mod.actualizar(Datos);
			break;
		}
		case 16://anadir producto
		{
			if(Datos == null)
				prod.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(14, Datos);//lee todos los clientes
			
			break;
		}
		case 17://leer datos producto para consultar
		{
			VConsultarProducto cons = (VConsultarProducto)VConsultarProducto.getFrame();
			cons.actualizar(Datos);
			break;
		}
		case 18:{//crear ventana consultar producto
			break;
		}
		case 19:{//crear ventana seleccion cliente alta cesta
			break;
		}
		case 20:{//leer clientes alta cesta
			VAltaCestaCliente cl = (VAltaCestaCliente)VAltaCestaCliente.getJFrame();
			cl.actualizar(Datos);
			break;
		}
		case 25://emitir factura
		{
			if(Datos == null)
				fact.actualizar(Datos); //mostrar error
			else
				Controlador.ObtenerInstancia().accion(26, Datos);//lee todos las facturas
			
			break;
		}
		case 26://consultar facturas
		{
			fact.actualizar(Datos);
			break;
		}
		case 100: //crear vInicio
		{
			ini = new VInicio();
			Controlador c = Controlador.ObtenerInstancia();
			c.accion(101, null);
			c.accion(102, null);
			c.accion(103, null);
			ini.anadirTabs();
			break;
		}
		case 101: //crear vCliente
		{
			cliente = new Vcliente();
			Controlador.ObtenerInstancia().accion(5, null);//consultar clientes
			((VInicio) Datos).actualizar(cliente);
			break;
		}
		case 102: //crear vProducto
		{
			prod = new VProducto();
			Controlador.ObtenerInstancia().accion(14, null);
			((VInicio) Datos).actualizar(prod);

			break;
		}
		case 103: //crear vFactura
		{
			fact = new VFactura();
			Controlador.ObtenerInstancia().accion(26, null);
			((VInicio) Datos).actualizar(fact);
		
			break;
		}
		// end-user-code
	}
	}
}