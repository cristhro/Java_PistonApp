/**
 * 
 */
package ms.piston.Presentacion.Factura.VConsultarFactura;

import javax.swing.JFrame;

import ms.piston.Negocio.Factura.imp.TFactura;
import ms.piston.Negocio.Factura.imp.TLineaProducto;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Cliente.VCliente.imp.ModeloTabla;
import ms.piston.Presentacion.Command_DAO.command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VConsultarFactura extends JFrame implements command {
	private static JFrame ventana;
	public VConsultarFactura() throws HeadlessException {
		super("Consultar Factura");
		ventana = this;
		
	}
	
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
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<JButton> jButton;

	/** 
	 * (sin Javadoc)
	 * @return 
	 * @see command#ejecuta(Integer Orden)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	JPanelPrincipal panel;
	private JTable jTable;
	private panelLista lista;
	private ModeloTabla modelo;
	private JScrollPane jScrollPane;
	private JTextField jTextField;
	
	private LabelText label1;
	private LabelText label2;
	
	public LabelText getLabel1() {
		return label1;
	}

	public void setLabel1(LabelText label1) {
		this.label1 = label1;
	}

	public LabelText getLabel2() {
		return label2;
	}

	public void setLabel2(LabelText label2) {
		this.label2 = label2;
	}
	
	public Object ejecuta(Integer Orden, Object Datos)  {
		return Datos;
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
	
	private void initGUI() {
		panel = new JPanelPrincipal();
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		ventana.setIconImage(icon.getImage());
		ventana.setContentPane(panel);
		ventana.setResizable(false);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public void actualizar(Object Datos){
		
		TFactura factura = (TFactura) Datos;
		
		getLabel1().text.setText(String.valueOf(factura.getID()));
		getLabel2().text.setText(String.valueOf(factura.getFecha()));
		
		HashMap<Integer, TLineaProducto> lineaProducto = factura.getLineasDeProducto();
		
		for (Integer key : lineaProducto.keySet()){
			
			TLineaProducto tlineaProducto = lineaProducto.get(key);
			
			modelo.addRow( new Object[] {key, tlineaProducto.getCantidad(), tlineaProducto.getPrecio()}); 
		 }
		 ventana.add(lista,BorderLayout.CENTER);
		 panel.revalidate();
	}
	
	private class panelLista extends JPanel {
		
		
		public panelLista() {
			jTable = new JTable();
	        modelo = new ModeloTabla();
	        jScrollPane = new JScrollPane(jTable);
	        String[] columnas = { "ID_Producto", "Cantidad" , "Precio"};
	        
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

	private class JPanelPrincipal extends JPanel {
		public JPanelPrincipal(){
			setLayout(new BorderLayout());
			panelLabels label = new panelLabels();
			
			panelbotones botones = new panelbotones();
			add(label,BorderLayout.CENTER);
			add(botones,BorderLayout.SOUTH);
		}
	}
	
	private class panelLabels extends JPanel {
		public panelLabels(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		setLabel1(new LabelText("ID"));
		setLabel2(new LabelText("Fecha"));
		
		add(getLabel1());
		add(getLabel2());
		
		getLabel1().text.setEditable(false);
    	getLabel2().text.setEditable(false);
		
		}
	}
	
		public class LabelText extends JPanel {
			private JTextField text;
			public LabelText(String mensaje){
			setLayout(new FlowLayout());
			JLabel label = new JLabel(mensaje);
			label.setPreferredSize(new Dimension(70,15));
			
			text = new JTextField(16);
			add(label);
			add(text);
			}
			public String getText(){
				if(text.getText().isEmpty())
					return "";
				else
					return text.getText();
			}
		}
	
	private class panelbotones extends JPanel {
		
		public panelbotones(){
			JButton aceptar = new JButton("Aceptar");
			
			aceptar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}
				
			});
			add(aceptar);
		
}
}
public final static JFrame getFrame() {
return ventana;
}		
	
}