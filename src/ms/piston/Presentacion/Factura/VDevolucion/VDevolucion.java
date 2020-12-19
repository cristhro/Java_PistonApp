/**
 * 
 */
package ms.piston.Presentacion.Factura.VDevolucion;

import javax.swing.JFrame;


import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Producto.VProducto.imp.ModeloTabla;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VDevolucion extends JFrame implements command {
	public VDevolucion() throws HeadlessException {
		super("Devolucion");
		
		ventana = this;
	}

	public JTable jTable;

	public ModeloTabla modelo;

	public JScrollPane jScrollPane;

	public panelLista lista;
	private static JFrame ventana;
	
	public static JFrame getVentana() {
		return ventana;
	}

	public void initGUI() {
		// begin-user-code
		JPanelPrincipal panel = new JPanelPrincipal();
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		ventana.setIconImage(icon.getImage());
		ventana.setContentPane(panel);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		// end-user-code
	}
	private class JPanelPrincipal extends JPanel {
		public JPanelPrincipal(){
			setLayout(new BorderLayout());
			lista = new panelLista(); 
			panelbotones botones = new panelbotones();
			add(lista,BorderLayout.CENTER);
			add(botones,BorderLayout.SOUTH);
		}
	}
private class panelLista extends JPanel {
		
		
		public panelLista() {
			jTable = new JTable();
	        modelo = new ModeloTabla();
	        jScrollPane = new JScrollPane(jTable);
	        
	        String[] columnas = { "Id Cliente","Id Producto","Cantidad"};
	        
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
	
	
	private class panelbotones extends JPanel {
		
		public panelbotones(){
			JButton devolver = new JButton("Devolver producto");
			
			JButton cancelar = new JButton("Cancelar");
			ActionListener action = new ActionListenerImp();
			devolver.addActionListener(action);
			
			cancelar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}
				
			});
			devolver.setActionCommand("1");
			add(devolver);
			add(cancelar);
		
}
}		
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
	private Set<JPanel> jPanel;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<JLabel> jLabel;

	/** 
	 * (sin Javadoc)
	 * @return 
	 * @see command#ejecuta(Integer Orden)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object ejecuta(Integer Orden, Object Datos)  {
		// begin-user-code

		initGUI();

		return Datos;
	
		// end-user-code
	}

	
	public JTable getjTable() {
		return jTable;
	}
	public ModeloTabla getModelo() {
		return modelo;
	}
	
}