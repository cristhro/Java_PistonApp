/**
 * 
 */
package ms.piston.Presentacion.Producto.VModificarProducto;

import javax.swing.JFrame;


import ms.piston.Negocio.Producto.TProducto;
import ms.piston.Presentacion.Main;

import ms.piston.Presentacion.Producto.VModificarProducto.imp.ActionListenerImp;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Controlador_DAO.Controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VModificarProducto extends JFrame implements command {
	private static JFrame ventana;
	public VModificarProducto() throws HeadlessException {
		super("Modificar Producto");
		ventana = this;
	}
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
	private Set<JPanel> jPanel;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<JTextField> jTextField;
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
	private void initGUI() {
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

	/** 
	 * (sin Javadoc)
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object ejecuta(Integer Orden, Object Datos)  {
		initGUI();
		Controlador.ObtenerInstancia().accion(15, Datos); //leer producto por id
		
		return Datos;
	}
	
	public void actualizar(Object Datos) {
		// begin-user-code
			TProducto producto = (TProducto) Datos;
			getLabel0().text.setText(String.valueOf(producto.getId()));
			getLabel1().text.setText(producto.getMarca());
			getLabel2().text.setText(producto.getModelo());
			getLabel3().text.setText(String.valueOf(producto.getAno()));
			getLabel4().text.setText(String.valueOf(producto.getPrecio()));
			getLabel5().text.setText(String.valueOf(producto.getNplazas()));
			getLabel6().text.setText(String.valueOf(producto.getNpuertas()));
			getLabel7().text.setText(producto.getCombustible());
			getLabel8().text.setText(String.valueOf(producto.getStock()));
		// end-user-code
	}
	
	private LabelText label0;
	public LabelText getLabel0() {
		return label0;
	}

	public void setLabel0(LabelText label0) {
		this.label0 = label0;
	}
	private LabelText label1;
	private LabelText label2;
	private LabelText label3;
	private LabelText label4;
	private LabelText label5;
	private LabelText label6;
	private LabelText label7;
	private LabelText label8;
	
	
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

	public LabelText getLabel3() {
		return label3;
	}

	public void setLabel3(LabelText label3) {
		this.label3 = label3;
	}

	public LabelText getLabel4() {
		return label4;
	}

	public void setLabel4(LabelText label4) {
		this.label4 = label4;
	}

	public LabelText getLabel5() {
		return label5;
	}

	public void setLabel5(LabelText label5) {
		this.label5 = label5;
	}

	public LabelText getLabel6() {
		return label6;
	}

	public void setLabel6(LabelText label6) {
		this.label6 = label6;
	}

	public LabelText getLabel7() {
		return label7;
	}

	public void setLabel7(LabelText label7) {
		this.label7 = label7;
	}

	public LabelText getLabel8() {
		return label8;
	}

	public void setLabel8(LabelText label8) {
		this.label8 = label8;
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
		setLabel0(new LabelText("ID"));
		setLabel1(new LabelText("Marca"));
		setLabel2(new LabelText("Modelo"));
		setLabel3(new LabelText("A�o"));
		setLabel4(new LabelText("Precio"));
		setLabel5(new LabelText("Plazas"));
		setLabel6(new LabelText("Puertas"));
		setLabel7(new LabelText("Combustible"));
		setLabel8(new LabelText("Stock"));
		label0.text.setEditable(false);
	
		add(getLabel0());
		add(getLabel1());
		add(getLabel2());
		add(getLabel3());
		add(getLabel4());
		add(getLabel5());
		add(getLabel6());
		add(getLabel7());
		add(getLabel8());
		
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
				JButton cancelar = new JButton("Cancelar");
				ActionListener action = new ActionListenerImp();
				aceptar.addActionListener(action);
				cancelar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						ventana.dispose();
					}
					
				});
				add(aceptar);
				add(cancelar);
			
}
}		
	public final static JFrame getFrame(){
		return ventana;
	}

	
}