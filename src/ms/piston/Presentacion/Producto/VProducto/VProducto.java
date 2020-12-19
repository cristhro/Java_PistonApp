/**
 * 
 */
package ms.piston.Presentacion.Producto.VProducto;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;


import javax.swing.JTextField;
import javax.swing.JButton;

import ms.piston.Negocio.Producto.TProducto;
import ms.piston.Presentacion.Main;

import ms.piston.Presentacion.Producto.VProducto.imp.ActionListenerImp;
import ms.piston.Presentacion.Producto.VProducto.imp.ModeloTabla;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VProducto extends JPanel {
	
	public VProducto() {
		super();
		ventana = this;
		initGUI();
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JScrollPane jScrollPane;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTable jTable;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<TextField> textField;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTextField jTextField;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<JButton> jButton;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private panelLista lista;
	private ModeloTabla modelo;
	private static JPanel ventana;
	
	public void actualizar(Object Datos) {
		// begin-user-code
		if(Datos == null)
		{
			JOptionPane.showMessageDialog(null, "Se produjo un error", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			ventana.remove(lista);
			lista = new panelLista();
			TProducto pr;
			Iterator<TProducto> it = ((Collection<TProducto>) Datos).iterator();
			 while(it.hasNext()) {
				 pr = it.next();
				 if(pr.getActivo()==true)
					 modelo.addRow( new Object[] {pr.getId(), pr.getMarca(), pr.getModelo(), pr.getAno(), pr.getPrecio(), pr.getNplazas(), pr.getNpuertas(), pr.getCombustible(), pr.getStock()});
			 }
			 ventana.add(lista,BorderLayout.CENTER);
			 ventana.revalidate();
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUI() {
		// begin-user-code
		jButton = new HashSet<JButton>();
		panelBotones botones = new panelBotones();
		lista = new panelLista();
		 setLayout(new BorderLayout());
		 ventana.add(botones,BorderLayout.NORTH);
		 ventana.add(lista,BorderLayout.CENTER);
		// end-user-code
	}
	
	private class panelLista extends JPanel {
		
		
		public panelLista() {
			jTable = new JTable();
	        modelo = new ModeloTabla();
	        jScrollPane = new JScrollPane(jTable);
	        
	        String[] columnas = { "Id", "Marca", "Modelo", "Año", "Precio", "Plazas", "Puertas", "Combustible", "Stock"};
	        
	        modelo.setColumnIdentifiers(columnas);
	        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        jTable.setFillsViewportHeight(true); 
	        jTable.setModel(modelo);
	        this.setVisible(true);
	        jTable.setVisible(true);		
	        jScrollPane.setPreferredSize(new Dimension(800, 250));
	        jScrollPane.setVisible(true);
			add(jScrollPane);
		
		}
 }
	
 private class panelBotones extends JPanel {
		public panelBotones() {
			JButton anadir = new JButton("Añadir Producto");
			JButton modificar = new JButton("Modificar Producto");
			JButton eliminar = new JButton("Eliminar Producto");
			JButton consultar = new JButton("Consultar Producto");
			ImageIcon trashIcon = new ImageIcon(Main.class.getResource("/img/trash.png"));
			eliminar.setIcon(trashIcon);
			ImageIcon updateIcon = new ImageIcon(Main.class.getResource("/img/update.gif"));
			modificar.setIcon(updateIcon);
			ImageIcon nuevoIcon = new ImageIcon(Main.class.getResource("/img/add.png"));
			anadir.setIcon(nuevoIcon);
			ImageIcon consIcon = new ImageIcon(Main.class.getResource("/img/Buscar.png"));
			consultar.setIcon(consIcon);
			setLayout(new FlowLayout());
			jButton.add(anadir);
			jButton.add(modificar);
			jButton.add(eliminar);
			ActionListenerImp action = new ActionListenerImp();
			anadir.addActionListener(action);
			modificar.addActionListener(action);
			eliminar.addActionListener(action);
			consultar.addActionListener(action);
			anadir.setActionCommand("1");
			modificar.setActionCommand("2");
			eliminar.setActionCommand("3");
			consultar.setActionCommand("4");
			add(anadir);
			add(modificar);
			add(eliminar);
			add(consultar);
			
			}
 }
 
 public final static JPanel getPanel(){
		return ventana;
	}

public JTable getjTable() {
	return jTable;
}

public ModeloTabla getModelo() {
	return modelo;
}

public void setModelo(ModeloTabla modelo) {
	this.modelo = modelo;
}

public void setjTable(JTable jTable) {
	this.jTable = jTable;
}
	
}