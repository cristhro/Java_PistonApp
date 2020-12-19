/**
 * 
 */
package ms.piston.Negocio.Factura.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.Cliente.DAOCliente;
import ms.piston.Integracion.FactoriaDAO.FactoriaDAO;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Factura.DAOFactura;
import ms.piston.Integracion.Producto.DAOProducto;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Factura.SAFactura;
import ms.piston.Negocio.Producto.TProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAFacturaImp implements SAFactura {
	/** 
	 * (sin Javadoc)
	 * @see SAFactura#AltaCesta(Integer idcliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	/* Atributos */
	Integer IdCliente;							
	Date Fecha;
	HashMap<Integer, TLineaProducto> lineaDeProducto ; 	// <idProducto, TlineaProducto>
	
	
	public SAFacturaImp() {
		
		this.lineaDeProducto =  new HashMap<Integer, TLineaProducto>();
	
	}

	public void AltaCesta(Integer idcliente, Date fecha) {
		
		IdCliente = idcliente;
		Fecha = fecha;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#Devolucion(TFactura cesta, Date fecha)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean Devolucion(Integer idFactura, Integer idProducto, Integer cantidad ) {
		
		DAOFactura daoFactura = FactoriaDAO.obtenerInstancia().generarDAOFactura();
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		// buscamos cliente por id
		TFactura tfactura = daoFactura.readById(idFactura);
		TProducto tProducto = daoProducto.readByID(idProducto);
		
		//Exist
		if(tfactura != null){
			
			//obtenemos la lineaDeProducto
			lineaDeProducto = (HashMap<Integer, TLineaProducto>) tfactura.getLineasDeProducto();
			
			// idProducto a devolver  esta en linea de producto de la factura
			if(lineaDeProducto.containsKey(idProducto)){
				
				//productos de la lineade producto suficientes para devolver
				if(lineaDeProducto.get(idProducto).getCantidad() >= cantidad){
				
					//modificamos factura
					// actualiza la cantidad y el precio del producto que hay en la linea de producto
					TLineaProducto tlineaProducto = new TLineaProducto();
					tlineaProducto.setCantidad(lineaDeProducto.get(idProducto).getCantidad() - cantidad);
					tlineaProducto.setPrecio((lineaDeProducto.get(idProducto).getCantidad()- cantidad) * tProducto.getPrecio());
					
					//reducmos la cantidad del producto y el precio
					lineaDeProducto.put(idProducto, tlineaProducto);
					
					
				
					//actualizamos el stock del producto
					tProducto.setStock(tProducto.getStock() + cantidad);
					
					//actualizamos en la base de datos
					daoProducto.modificarProducto(tProducto);
					transaction.commit();
					
					TFactura tFactura2 = new TFactura();
					tFactura2.setID(idFactura);
					tFactura2.setLineasDeProducto(lineaDeProducto);
					daoFactura.devolucion(tFactura2,idProducto);
					transaction.commit();
					//si no quedan productos eliminamos el producto de la factura
					if(lineaDeProducto.get(idProducto).getCantidad() ==  0){
						
						lineaDeProducto.remove(idProducto);
					}
					
					
					
					
				}
			}
		}
			return true;
		
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#AnadirProductoCesta(Integer Id, Integer CantidadProducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */									// id Producto	
	public void AnadirProductoCesta(Integer Id, Integer CantidadProducto) {
		//boolean ok = false;
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		TLineaProducto tlineaProducto =  new TLineaProducto();
		
		if(!lineaDeProducto.isEmpty()){
			
		
			if(lineaDeProducto.containsKey(Id)){
				
				// actualiza la cantidad del producto que hay en la linea de producto
				tlineaProducto.setCantidad(lineaDeProducto.get(Id).getCantidad() + CantidadProducto);
				tlineaProducto.setPrecio(daoProducto.readByID(Id).getPrecio() *(lineaDeProducto.get(Id).getCantidad()));
				lineaDeProducto.put(Id, tlineaProducto);
				
			}
			else{
				tlineaProducto.setCantidad(CantidadProducto);
				tlineaProducto.setPrecio(daoProducto.readByID(Id).getPrecio() *(CantidadProducto));
				lineaDeProducto.put(Id, tlineaProducto);
			}
		}
		else{
			tlineaProducto.setCantidad(CantidadProducto);
			tlineaProducto.setPrecio(daoProducto.readByID(Id).getPrecio() *(CantidadProducto));
			lineaDeProducto.put(Id, tlineaProducto);
		}
		//return lineaDeProducto;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#QuitarProductoCesta(Integer Id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean QuitarProductoCesta(Integer Id) {
		
		if(lineaDeProducto.containsKey(Id)) {
			lineaDeProducto.remove(Id);
			
			return true;
		} 
		else {
			return false;
		}
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#EmitirFactura(TFactura Cesta, Date Fecha)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer EmitirFactura() {
		
		DAOProducto daoProducto = FactoriaDAO.obtenerInstancia().generarDAOProducto();
		
		DAOCliente daoCLiente = FactoriaDAO.obtenerInstancia().generarDAOCliente();
		
		DAOFactura daoFactura = FactoriaDAO.obtenerInstancia().generarDAOFactura();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		// buscamos cliente por id
		boolean existe = daoCLiente.readByID(IdCliente);
	
		Integer id=null;
		//Exist
		if(existe){
			
			
			for (Integer key : lineaDeProducto.keySet()) {
				//hay mas
				TProducto producto =  daoProducto.readByID(key);
				
				//existe
				if(producto != null){
					
					//activo
					if(producto.getActivo()){
						
						//modificamos stock
						
						Integer stock = producto.getStock()- lineaDeProducto.get(key).getCantidad();
						
						if(stock >= 0){
							
							//modificamos stock
							producto.setStock(stock);
							daoProducto.modificarProducto(producto);
							
							//modificamos factura
							TLineaProducto tlp = new TLineaProducto();
							tlp.setCantidad(lineaDeProducto.get(key).getCantidad());
							tlp.setPrecio(lineaDeProducto.get(key).getCantidad()*producto.getPrecio());
							
							lineaDeProducto.put(key, tlp);
							TFactura tFactura = new TFactura();
							tFactura.setFecha(Fecha);
							tFactura.setLineasDeProducto(lineaDeProducto);
							tFactura.setId_cliente(IdCliente);
							id = daoFactura.EmitirFactura(tFactura);
							System.out.println(id);
							transaction.commit();
						}
					}
					
				}
			}
			
		}
		
			
			return id;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#ConsultarFactura(Integer id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TFactura ConsultarFactura(Integer id) {
		DAOFactura daoFactura = FactoriaDAO.obtenerInstancia().generarDAOFactura();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		return daoFactura.readById(id);
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#ConsultarFacturas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TFactura> ConsultarFacturas() {
		
		DAOFactura daoFactura = FactoriaDAO.obtenerInstancia().generarDAOFactura();
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		return daoFactura.ConsultarFacturas();
	}
	
	public static void main(String[] args) {
		
		SAFactura saFactura = FactoriaSA.obtenerInstancia().generarSAFactura();
		
		
		
		
		
		 String date_s = "2011-01-18";

	        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"  
		 	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	        try {
				
	        Date date = dt.parse(date_s);
//			// ALTA CESTA
//	        saFactura.AltaCesta(2, date);
//			//A�ADIR PRODUCTO
//	        saFactura.AnadirProductoCesta(1, 2);
//	        saFactura.AnadirProductoCesta(2,3);
//	        saFactura.AnadirProductoCesta(3, 5);
//	        saFactura.AnadirProductoCesta(4, 4);
//	        saFactura.AnadirProductoCesta(4, 5);
//	        saFactura.AnadirProductoCesta(2, 8);
			//EMITIR FACTURA
//			saFactura.EmitirFactura();
			
			//DEVOLuciON
			saFactura.Devolucion(11, 2, 5);
			
			
	        } catch (ParseException e) {
				// TODO Bloque catch generado autom�ticamente
				e.printStackTrace();
			}
		
	}
}