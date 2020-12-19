/**
 * 
 */
package ms.piston.Integracion.Producto.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Integracion.Producto.DAOProducto;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;
import ms.piston.Negocio.Producto.SAProducto;
import ms.piston.Negocio.Producto.TProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOProductoImp implements DAOProducto {
	/** 
	 * (sin Javadoc)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto readByID( int id) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		 TProducto producto =  new TProducto();
	        
		 try {
			 
	        	java.sql.Statement statement = connection.createStatement();
	        		
	        	 String query = "SELECT * FROM productos WHERE id= " + id ;	        	
	        	
	            ResultSet rs = statement.executeQuery(query);
	         
	            if(!rs.next()) {
	                return null;
	            }
	          
	           producto.setId(rs.getInt("id"));
	            
	           Boolean activo = false;
	           if(rs.getInt("activo") == 1) activo = true;
	       
	           producto.setActivo(activo);   
	           producto.setMarca(rs.getString("marca"));   
	           producto.setModelo(rs.getString("modelo"));   
	           producto.setAno(rs.getInt("ano"));
	           producto.setPrecio(rs.getInt("precio"));  
	           producto.setNplazas(rs.getInt("plazas"));   
	           producto.setNpuertas(rs.getInt("puertas"));
	           producto.setCombustible(rs.getString("combustible"));
	           producto.setStock(rs.getInt("stock"));
	           
	        } 
	        catch (SQLException e) {
	            System.err.println(e);
	        }

	        return producto;
	}
	
	public Integer anadirProducto(TProducto tp){
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();	
		
		String  sql = "INSERT INTO productos (activo,marca,modelo,ano,precio,plazas,puertas,combustible,stock) VALUES (" +
				1 + "," +
				"'" + tp.getMarca() + "'," +
				"'" + tp.getModelo() + "'," + 
				tp.getAno() + "," +
				tp.getPrecio() + "," + 
				tp.getNplazas() + "," + 
				tp.getNpuertas() + "," + 
				"'" + tp.getCombustible() + "'," + 
				tp.getStock() + " )";
			statement.execute(sql);
			
		
		} catch (SQLException tp1) 
		{
			tp1.printStackTrace();
		}
		
		return readByMarcaModeloAnoPrecioPlazasCombustibleS(tp).getId();
		
	}
	
	public Boolean modificarProducto(TProducto tproducto){
		

		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();
		
		String  sql = "UPDATE productos SET " + 
			"marca = '" + tproducto.getMarca() + "'," +
			"modelo = '" + tproducto.getModelo() + "'," +
			"ano = " + tproducto.getAno() + "," +
			"precio = " + tproducto.getPrecio() + "," +
			"plazas = " + tproducto.getNplazas() + ", " +
			"puertas = " + tproducto.getNpuertas() + ", " +
			"combustible = '" + tproducto.getCombustible() + "', " +
			"stock = " + tproducto.getStock() + " " +
			" WHERE id = " + tproducto.getId() ;
		
		statement.executeUpdate(sql);
		
		}catch (SQLException tp) 
		{
			tp.printStackTrace();
		}
		
		return true;
		
	}
	
	public Boolean eliminarProducto(Integer id) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();
		
		String  sql = "UPDATE  productos SET activo = 0 where id = " + id + "";
		
		statement.execute(sql);
		
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}

	public Collection<TProducto> consultarProductos() {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		String query = "SELECT * FROM productos";

        TProducto producto = null;
        
        ArrayList<TProducto> productos = new ArrayList<TProducto>();
        
        try {
        	java.sql.Statement statement = connection.createStatement();
          
        	ResultSet rs = statement.executeQuery(query);
           
            if(!rs.isBeforeFirst()) {
                return null;
            }

            while(rs.next()) {
            	producto = new TProducto();
               
            	producto.setId(rs.getInt("id"));
            
	           Boolean activo = false;
	           if(rs.getInt("activo") == 1) activo = true;
	       
	           producto.setActivo(activo);   
	           producto.setMarca(rs.getString("marca"));   
	           producto.setModelo(rs.getString("modelo"));   
	           producto.setAno(rs.getInt("ano"));
	           producto.setPrecio(rs.getInt("precio"));  
	           producto.setNplazas(rs.getInt("plazas"));   
	           producto.setNpuertas(rs.getInt("puertas"));
	           producto.setCombustible(rs.getString("combustible"));
	           producto.setStock(rs.getInt("stock"));
	           productos.add(producto);
            }
        } catch (SQLException e) {
           System.err.println(e);
        } 
		return productos;
	}

	public TProducto readByMarcaModeloAnoPrecioPlazasCombustibleS(TProducto tp) {
		
Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		 TProducto producto =  new TProducto();
	        
		 try {
			 
	        	java.sql.Statement statement = connection.createStatement();

	    		String query = "SELECT * FROM productos WHERE marca = '" + tp.getMarca() +     "' AND " +
	    													"modelo = '" + tp.getModelo() +    "' AND " +
	    													   "ano = "  + tp.getAno() +        " AND " +
	    													"precio = "  + tp.getPrecio() +     " AND " +
	    													"plazas = "  + tp.getNplazas() +    " AND " +
	    											   "combustible = '" + tp.getCombustible()+"'" ;
	          
	    		ResultSet rs = statement.executeQuery(query);
	         
	            if(!rs.next()) {
	                return null;
	            }
	          
	           producto.setId(rs.getInt("id"));
	            
	           Boolean activo2 = false;
	           if(rs.getInt("activo") == 1) activo2 = true;
	       
	           producto.setActivo(activo2);   
	           producto.setMarca(rs.getString("marca"));   
	           producto.setModelo(rs.getString("modelo"));   
	           producto.setAno(rs.getInt("ano"));
	           producto.setPrecio(rs.getInt("precio"));  
	           producto.setNplazas(rs.getInt("plazas"));   
	           producto.setNpuertas(rs.getInt("puertas"));
	           producto.setCombustible(rs.getString("combustible"));
	           producto.setStock(rs.getInt("stock"));
	           
	        } 
	        catch (SQLException e) {
	            System.err.println(e);
	        }

	        return producto;
	}

	
	public static void main(String[] args) {
		
		
		//TproductoParticular c = new TproductoParticular();
		TProducto p = new TProducto();
		p.setId(1);
		p.setActivo(true);
		p.setAno(2016);
		p.setCombustible("NUEVO");
		p.setMarca("BMV");
		p.setModelo("c1");
		p.setNplazas(3);
		p.setPrecio(6000);
		p.setStock(98);
		
		SAProducto saProducto = FactoriaSA.obtenerInstancia().generarSAProducto();
		
		/* ------------PRUEBAS ---------*/
		
		// A�ADIR PRODUCTO
	//	saProducto.a�adirProducto(p);
		
		//MODIFICAR PRODUCTO
	//	saProducto.modificarProdructo(p);
		
		//BAJA PRODUCTO
	//	saProducto.eliminarProducto(1);
		
		//CONSULTAR PRODUCTO
	//	System.out.println(saProducto.consultarProducto(1).toString());

		//CONSULTAR PRODUCTOS
	//	System.out.println(saProducto.consultarProductos().toString());
		//	Integer id = saProducto.a�adirProducto(p);
		

	}




	
}