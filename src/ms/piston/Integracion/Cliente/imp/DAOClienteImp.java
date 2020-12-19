/**
 * 
 */
package ms.piston.Integracion.Cliente.imp;

import ms.piston.Integracion.Almacendeldominio.TransactionManager;
import ms.piston.Integracion.Cliente.DAOCliente;
import ms.piston.Integracion.FactoriaTransaction.Transaction;
import ms.piston.Negocio.Cliente.SACliente;
import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Negocio.Cliente.imp.TClienteEmpresa;
import ms.piston.Negocio.Cliente.imp.TClienteParticular;
import ms.piston.Negocio.FactoriaSA.FactoriaSA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteImp implements DAOCliente {
	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#anadirCliente(TCliente e)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirCliente(TCliente e) {
		
		Integer id = -1;
	
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();	
		
		String  sql ="INSERT INTO clientes (activo,nif,nombre,apellidos,direccion,telefono,email) VALUES (" +
		
				"'" + 1 + "'," +
				"'" + e.getNif() + "'," +
				"'" + e.getNombre() + "',"+
				"'" + e.getApellidos() + "'," +
				"'" + e.getDireccion() + "'," +
					+ e.getTelefono() + "," +
				"'" + e.getEmail() + "' )";
			statement.execute(sql);
		
		// Obtenemos el id del nuevo cliente
		id = ((TCliente) readByNif(e.getNif())).getId();
		
		// es Cliente Empresa
		if(e instanceof TClienteEmpresa){
			sql = "insert into clientes_empresa (id, empresa) VALUES (" + id + ", '" + ((TClienteEmpresa) e).getEmpresa()+ "')";
			statement.execute(sql);
		}
		// es Cliente Particular
		if(e instanceof TClienteParticular){
			sql = "insert into clientes_particular (id, codigo_postal) VALUES ( " + id + ", " + ((TClienteParticular) e).getCodigoPostal()+ ")";
			statement.execute(sql);
		}
		   
		} catch (SQLException e2) 
		{
			e2.printStackTrace();
		}
		
		
		return id ;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#modificarCliente(TCliente tc)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean modificarCliente(TCliente tc) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();
		
		
		String  sql = "UPDATE clientes SET " + 
			"nif = '" + tc.getNif() + "'," +
			"nombre = '" + tc.getNombre() + "'," +
			"apellidos = '" + tc.getApellidos() + "'," +
			"direccion = '" + tc.getDireccion() + "'," +
			"telefono = " + tc.getTelefono() + "," +
			"email = '" + tc.getEmail() + "' " +
			" WHERE id = " + tc.getId() ;
		
		statement.executeUpdate(sql);
		
		if(tc instanceof TClienteEmpresa){
			sql ="UPDATE clientes_empresa SET " +
					"empresa = '" + ((TClienteEmpresa) tc).getEmpresa() +
					"' WHERE id = " + tc.getId() ;
		statement.executeUpdate(sql);
		}
		// es Cliente Particular
		if(tc instanceof TClienteParticular){
			sql ="UPDATE clientes_particular SET " +
					"codigoPostal = " + ((TClienteParticular) tc).getCodigoPostal() +
					"WHERE id = " + tc.getId() ;
			statement.executeUpdate(sql);
		}
		
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
			
		
		return true;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#bajaCliente(Integer id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean bajaCliente(Integer id) {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();
		
		String  sql = "UPDATE  clientes SET activo = 0 where id = " + id + "";
		
		statement.execute(sql);
		
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}

	
	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#consultarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection consultarClientes() {
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();

        TCliente cliente = new TCliente();
        
        ArrayList<Object> clientes = new ArrayList<Object>();
        
        try {
        	java.sql.Statement statement = connection.createStatement();
        	java.sql.Statement statement1 = connection.createStatement();
        	java.sql.Statement statement2 = connection.createStatement();
        	
        	String query = "SELECT * FROM clientes";
            ResultSet rs = statement.executeQuery(query);
           
            
            while(rs.next()) {
            		
            	//guardamos los datos del cliente
            	 String nif = rs.getString("nif");
            	 clientes.add(readByNif(nif));
    	           
            }
        } catch (SQLException e) {
           System.err.println(e);
        } 
		return clientes;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#readByNif(Integer nif)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("null")
	public Object readByNif(String nif) {
		
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		 TCliente cliente =  new TCliente();
	        
		 try {
			 
	        	java.sql.Statement statement = connection.createStatement();
	        		
	        	 String query = "SELECT * FROM clientes WHERE nif= '" + nif + "'";
	        	
	        	
	            ResultSet rs = statement.executeQuery(query);
	         
	            if(!rs.next()) {
	                return null;
	            }
	          
	           cliente.setId(rs.getInt("id"));
	            
	           Boolean activo = false;
	          
	           if(rs.getInt("activo") == 1) activo = true;
	       
	           cliente.setActivo(activo);   
	           cliente.setNif(rs.getString("nif"));   
	           cliente.setNombre(rs.getString("nombre"));   
	           cliente.setApellidos(rs.getString("apellidos")); 
	           cliente.setTelefono(rs.getInt("telefono"));  
	           cliente.setDireccion(rs.getString("direccion"));   
	           cliente.setEmail(rs.getString("email"));
	            
	           
	           // buscamos en la Tabla cliente Particular
	           query = "SELECT * FROM clientes_particular WHERE id= " + cliente.getId() + "";
	           rs = statement.executeQuery(query);
	         
	           if(rs.next()) {
	        	   TClienteParticular cp = new TClienteParticular();
	        	   cp.setActivo(cliente.getActivo());
	        	   cp.setApellidos(cliente.getApellidos());
	        	   cp.setDireccion(cliente.getDireccion());
	        	   cp.setEmail(cliente.getEmail());
	        	   cp.setId(cliente.getId());
	        	   cp.setNif(cliente.getNif());
	        	   cp.setNombre(cliente.getNombre());
	        	   cp.setTelefono(cliente.getTelefono());
	               cp.setCodigoPostal(rs.getInt("codigo_postal"));
	               return cp;
	           }
	            // buscamos en la Tabla cliente empresa
	            query = "SELECT * FROM clientes_empresa WHERE id= " + cliente.getId() + "";
	            rs = statement.executeQuery(query);
	            	
	            if(rs.next()) {
	            	TClienteEmpresa ce = new TClienteEmpresa();
		        	   ce.setActivo(cliente.getActivo());
		        	   ce.setApellidos(cliente.getApellidos());
		        	   ce.setDireccion(cliente.getDireccion());
		        	   ce.setEmail(cliente.getEmail());
		        	   ce.setId(cliente.getId());
		        	   ce.setNif(cliente.getNif());
		        	   ce.setNombre(cliente.getNombre());
		        	   ce.setTelefono(cliente.getTelefono());
		        	   ce.setEmpresa(rs.getString("empresa"));
	            	return ce;
	            }
	            	
	            
	           
	        } 
	        catch (SQLException e) {
	            System.err.println(e);
	        }
	        return cliente;
	}
	
	public Boolean activarCliente(int id){
		
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
		try 
		{
		java.sql.Statement statement = connection.createStatement();
		
		
		String  sql = "UPDATE clientes SET " + 
			"activo = " + 1 + " " +
			" WHERE id = " + id ;
		
		statement.executeUpdate(sql);
		
		}catch (SQLException e) {
            System.err.println(e);
        }
		
		return true;
	}
	@Override
	public boolean readByID(Integer idCliente) {
	
		Transaction transaction = TransactionManager.obtenerInstancia().getTransaction(Thread.currentThread());
		
		Connection connection = transaction.getResource();
		
	     boolean ok = true;   
		 try {
			 
	        	java.sql.Statement statement = connection.createStatement();
	        		
	        	 String query = "SELECT * FROM clientes WHERE id= " + idCliente + "";
	        	
	        	
	            ResultSet rs = statement.executeQuery(query);
	         
	            if(!rs.next()) {
	                ok = false;
	            }
		    } 
	        catch (SQLException e) {
	            System.err.println(e);
	        }
	        return ok;
	}
	public static void main(String[] args) {
	
		SACliente saC = FactoriaSA.obtenerInstancia().generarSACLiente();
		
		
		
	/*Collection<Object> c =saC.ConsultarClientes();
		while (c.iterator().hasNext()) {
			System.out.println(c.getClass().toString());
			c.iterator().next();
		}*/
	
	System.out.println(saC.ConsultarClientes().toString());
	
	}
		


}
