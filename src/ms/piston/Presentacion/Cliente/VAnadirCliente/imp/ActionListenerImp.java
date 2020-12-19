/**
 * 
 */
package ms.piston.Presentacion.Cliente.VAnadirCliente.imp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Negocio.Cliente.imp.TClienteEmpresa;
import ms.piston.Negocio.Cliente.imp.TClienteParticular;
import ms.piston.Presentacion.Cliente.VAnadirCliente.VAnadirCliente;
import ms.piston.Presentacion.Controlador_DAO.Controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ActionListenerImp implements ActionListener {
	/** 
	 * (sin Javadoc)
	 * @see ActionListener#actionPerformed(ActionEvent arg0)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actionPerformed(ActionEvent arg0) {
		// begin-user-code
			VAnadirCliente v = (VAnadirCliente) VAnadirCliente.getFrame();
	    	TCliente cliente;
			int telefono;
			String nif =  v.getLabel1().getText();
			String nombre =  v.getLabel2().getText();
			String apellidos = v.getLabel3().getText();
			try{
				telefono = Integer.parseInt(v.getLabel4().getText());
				String direccion =v. getLabel5().getText();
				String email = v.getLabel6().getText();
				
				String postal = v.getLabel7().getText();
				
				String empresa = v.getLabel8().getText();
				
				if(nif == "" || nombre == "" || apellidos == ""  || direccion == "" || email== "" || postal == "" && empresa == ""){
					JOptionPane.showMessageDialog(null, "No has introducido todos los datos necesarios", "ERROR", JOptionPane.ERROR_MESSAGE);		
				}
				
				else if(empresa != "")
				{
					cliente = new TClienteEmpresa();
					cliente.setNombre(nombre);
					cliente.setApellidos(apellidos);
					cliente.setNif(nif);
					cliente.setDireccion(direccion);
					cliente.setTelefono(telefono);
					cliente.setEmail(email);
					((TClienteEmpresa) cliente).setEmpresa(empresa);
					cliente.setActivo(false);
					Controlador.ObtenerInstancia().accion(3 , cliente);
					v.dispose();
					
				}
				else
				{
					cliente = new TClienteParticular();
					cliente.setNombre(nombre);
					cliente.setApellidos(apellidos);
					cliente.setNif(nif);
					cliente.setDireccion(direccion);
					cliente.setTelefono(telefono);
					cliente.setEmail(email);
					cliente.setActivo(false);
					((TClienteParticular) cliente).setCodigoPostal(Integer.parseInt(postal));
					Controlador.ObtenerInstancia().accion(4 , cliente);
					v.dispose();
					
				}
				
			}
			catch(NumberFormatException e1){
				JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
	 

		// end-user-code
	}
}