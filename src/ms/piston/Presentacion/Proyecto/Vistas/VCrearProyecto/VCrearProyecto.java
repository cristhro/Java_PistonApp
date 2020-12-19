/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Proyecto.Vistas.VCrearProyecto.imp.ActionListenerImp;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VCrearProyecto extends JFrame {
	private static JFrame ventana;
	public VCrearProyecto() {
			super("Crear proyecto");
			ventana = this;
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Set<JPanel> jPanel;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Set<JLabel> jLabel;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Set<JTextField> jTextField;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Set<JButton> jButton;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public static JPanel getJPanel() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
	private LabelText nombre;
	private LabelText jefe;
	private LabelText duracion;
	
	public LabelText getDuracion() {
		return duracion;
	}

	public void setDuracion(LabelText duracion) {
		this.duracion = duracion;
	}

	public LabelText getNombre() {
		return nombre;
	}

	public void setNombre(LabelText label1) {
		this.nombre = label1;
	}

	public LabelText getJefe() {
		return jefe;
	}

	/**
	 * @param label2
	 */
	public void setJefe(LabelText label2) {
		this.jefe = label2;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
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
			
			panelbotones botones = new panelbotones();
			add(label,BorderLayout.CENTER);
			add(botones,BorderLayout.SOUTH);
		}
	}
	private class panelLabels extends JPanel {
		public panelLabels(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		setNombre(new LabelText("Nombre"));
		setJefe(new LabelText("Id jefe"));
		setDuracion(new LabelText("Duracion"));
		add(getNombre());
		add(getJefe());
		add(getDuracion());
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

	/** 
	 * (sin Javadoc)
	 * @see command#ejecuta(Integer Orden)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
public Object ejecuta(Integer Orden, Object Datos) {
		// begin-user-code
		initGUI();
		// end-user-code
		return Datos;
	}

public final static JFrame getFrame(){
	return ventana;
}

}