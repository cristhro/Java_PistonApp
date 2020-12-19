/**
 * 
 */
package ms.piston.Presentacion.Factura.VAltaCesta;

import javax.swing.JFrame;

import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Factura.VAltaCesta.imp.ActionListenerImp;
import ms.piston.Presentacion.Producto.VProducto.imp.ModeloTabla;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VAltaCesta extends JFrame implements command {
	public VAltaCesta() throws HeadlessException {
		super("Alta cesta");
		
		ventana = this;
	}
	private LabelText labelIdCliente;
	
	private LabelText label1;
	private LabelText label2;

	public JTable jTable;

	public ModeloTabla modelo;

	public JScrollPane jScrollPane;

	public panelLista lista;
	private static JFrame ventana;
	
	public static JFrame getVentana() {
		return ventana;
	}
	public static void setVentana(JFrame ventana) {
		VAltaCesta.ventana = ventana;
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
			panelLabels label = new panelLabels();
			lista = new panelLista(); 
			panelbotones botones = new panelbotones();
			add(label,BorderLayout.NORTH);
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
	private class panelLabels extends JPanel {
		public panelLabels(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		setLabelIdCliente(new LabelText("Id Cliente"));
		setLabel1(new LabelText("Id Producto"));
		setLabel2(new LabelText("Cantidad"));
		getLabelIdCliente().text.setEditable(false);
		add(getLabelIdCliente());
		add(getLabel1());
		add(getLabel2());
	
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
			JButton anadir = new JButton("Anadir producto");
			JButton quitar = new JButton("Quitar producto");
			JButton emitir = new JButton("Emitir factura");
			JButton cancelar = new JButton("Cancelar");
			ActionListener action = new ActionListenerImp();
			anadir.addActionListener(action);
			quitar.addActionListener(action);
			emitir.addActionListener(action);
			cancelar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}
				
			});
			anadir.setActionCommand("2");
			quitar.setActionCommand("3");
			emitir.setActionCommand("4");
			add(anadir);
			add(quitar);
			add(emitir);
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
		getLabelIdCliente().text.setText(String.valueOf(Datos));
		return Datos;
	
		// end-user-code
	}
	public LabelText getLabelIdCliente() {
		return labelIdCliente;
	}

	public void setLabelIdCliente(LabelText labelIdCliente) {
		this.labelIdCliente = labelIdCliente;
	}
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
	public void actualizar() {
		 modelo.addRow( new Object[] {getLabelIdCliente().getText(), getLabel1().getText(),getLabel2().getText()});
	}
	public JTable getjTable() {
		return jTable;
	}
	public ModeloTabla getModelo() {
		return modelo;
	}
	public void quitar() {
		jTable.remove(jTable.getSelectedRow());
		
	}

	
}