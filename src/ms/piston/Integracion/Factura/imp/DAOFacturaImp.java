/**
 * 
 */
package ms.piston.Integracion.Factura.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.FactoriaDAO.FactoriaDAO;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Factura.DAOFactura;
import ms.piston.Negocio.Factura.imp.TFactura;
import ms.piston.Negocio.Factura.imp.TLineaProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author cristhian
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOFacturaImp implements DAOFactura {
	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#EmitirFactura(TFactura cesta, Date fecha)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer EmitirFactura(TFactura tFactura) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		Integer idFacturaCreada = 100;
		try {
			java.sql.Statement statement = connection.createStatement();
			
			// insertamos en  factura
			String  sql ="INSERT INTO facturas (fecha,id_cliente) "+
							"VALUES ( '" + " 2015-10-12"+" ', "+ tFactura.getId_cliente()+")";
			statement.execute(sql);
		
					sql = "SELECT * FROM facturas";
				
			ResultSet rs = statement.executeQuery(sql);
				
				while (rs.next()) {
					
					idFacturaCreada = rs.getInt("id");
				}
	        	
				for (Integer key : tFactura.getLineasDeProducto().keySet()) {
					
					sql ="INSERT INTO lineas_producto (id_factura, id_producto, cantidad, precio )"+
					" VALUES ("+ idFacturaCreada + ","+key+"," + 
					tFactura.getLineasDeProducto().get(key).getCantidad()+","+
					tFactura.getLineasDeProducto().get(key).getPrecio()+")"		;
					statement.execute(sql);
				}
		
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}	
		
		
		return idFacturaCreada;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#devolucion(TFactura cesta, Date fecha)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean devolucion(TFactura tfactura, Integer  id_producto) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try {
			Statement statement = connection.createStatement();
			
			String sql = "UPDATE lineas_producto SET "+ 
						"cantidad = " + tfactura.getLineasDeProducto().get(id_producto).getCantidad() + ","	+
						"precio = " + tfactura.getLineasDeProducto().get(id_producto).getPrecio() + " "+
						"WHERE id_factura = "+ tfactura.getID()+ " AND "+"id_producto = "+id_producto;
			statement.executeUpdate(sql);
		
		
		
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
		
		return true;
		
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#readById(Integer idFactura)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TFactura readById(Integer idFactura) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		 TFactura tfactura =  new TFactura();
	        
		 try {
			 
	        	java.sql.Statement statement = connection.createStatement();
	        	// tabla facturas solo cojes fecha
	        	String query = "SELECT * FROM facturas WHERE id= " + idFactura ;
	        	
	        	ResultSet rs = statement.executeQuery(query);
	        	
	        	if(!rs.next()) {
		              return null;
		         }
	        	
	        	tfactura.setID(rs.getInt("id"));										// id Factura, id_ producto, cantidad
	        	tfactura.setFecha(rs.getDate("fecha"));											//1				
	        																					//1
	        	query = "SELECT * FROM lineas_producto where id_factura = "+ tfactura.getID();
	        	ResultSet rsProducto = statement.executeQuery(query);
	        	
	        	// Linea Productos
	        	HashMap<Integer, TLineaProducto> lineaDeProducto = new 	HashMap<Integer, TLineaProducto>();
	        	
	        	while(rsProducto.next()){
	        		
	        		TLineaProducto tlineaProducto = new TLineaProducto();
	        		tlineaProducto.setPrecio(rsProducto.getFloat("precio"));
	        		tlineaProducto.setCantidad(rsProducto.getInt("cantidad"));
	        		
	        		lineaDeProducto.put(rsProducto.getInt("id_producto"), tlineaProducto);
	        	}
	        	
	        	tfactura.setLineasDeProducto(lineaDeProducto);
	        	
	        	
		 } catch (SQLException e) {
	            System.err.println(e);
	        }

	        return tfactura;
	}

	@Override
	public Collection<TFactura> ConsultarFacturas() {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		 TFactura tfactura =  new TFactura();
	     ArrayList<TFactura> ListaFacturas = new   ArrayList<TFactura>();
	     java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM facturas  ";
			ResultSet rsFacturas = statement.executeQuery(query);
			
			
	     while(rsFacturas.next()){
	    	 ListaFacturas.add(readById(rsFacturas.getInt("id")));
	     }
		
		
		
		} catch (SQLException e) {
			// TODO Bloque catch generado autom�ticamente
			e.printStackTrace();
		}
	 	
	        return ListaFacturas;
	}
	public static void main(String[] args) {
		
		//SACliente saC = FactoriaSA.obtenerInstancia().generarSACLiente();
		//SAFactura saFactura = FactoriaSA.obtenerInstancia().generarSAFactura();
		//System.out.println(saFactura.EmitirFactura().toString());
		
		TransactionManager.obtenerInstancia().nuevaTransaccion(Thread.currentThread());
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		transaction.start();
		
		DAOFactura daoFactura = FactoriaDAO.obtenerInstancia().generarDAOFactura();
		
		HashMap<Integer, TLineaProducto> lineaDeProducto = new HashMap<Integer, TLineaProducto>();
		
		@SuppressWarnings("deprecation")
		TFactura tFactura = new TFactura();
		tFactura.setId_cliente(5);
		
		System.out.println(daoFactura.EmitirFactura(tFactura));
		
		transaction.commit();
		//TFactura tFactura = daoFactura.readById(1);
		
		
		
		//HashMap<Integer, TLineaProducto>
		//daoFactura.EmitirFactura(lineaDeProducto, fecha)
		
	}
		
}