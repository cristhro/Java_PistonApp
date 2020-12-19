/**
 * 
 */
package ms.piston.Presentacion.Producto.VModificarProducto.imp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ms.piston.Negocio.Producto.TProducto;
import ms.piston.Presentacion.Producto.VModificarProducto.VModificarProducto;
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
		VModificarProducto v = (VModificarProducto) VModificarProducto.getFrame();
		
		TProducto producto;
		int ano = -1, nplazas = -1 , npuertas = -1, stock = -1;
		float precio;
		String marca =  v.getLabel1().getText();
		String modelo =  v.getLabel2().getText();
		ano = Integer.parseInt(v.getLabel3().getText());
		try{
			precio = Float.parseFloat(v.getLabel4().getText());
			nplazas = Integer.parseInt(v. getLabel5().getText());
			npuertas = Integer.parseInt(v.getLabel6().getText());
			
			String combustible = v.getLabel7().getText();
			
			stock = Integer.parseInt(v.getLabel8().getText());
			
			if(marca == "" || modelo == "" || ano == -1  || precio == -1 || nplazas== -1 || npuertas == -1 || combustible == "" || stock == -1)
			{
				JOptionPane.showMessageDialog(null, "No has introducido todos los datos necesarios", "ERROR", JOptionPane.ERROR_MESSAGE);		
			}
			else
			{
				producto = new TProducto();
				producto.setMarca(marca);
				producto.setModelo(modelo);
				producto.setAno(ano);
				producto.setPrecio(precio);
				producto.setNplazas(nplazas);
				producto.setNpuertas(npuertas);
				producto.setCombustible(combustible);
				producto.setStock(stock);
				producto.setId(Integer.parseInt(v.getLabel0().getText()));
				Controlador.ObtenerInstancia().accion(16 , producto);
				v.dispose();
				
			}
			
		}
		catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}