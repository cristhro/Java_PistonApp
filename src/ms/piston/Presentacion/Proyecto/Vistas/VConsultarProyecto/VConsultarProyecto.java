package ms.piston.Presentacion.Proyecto.Vistas.VConsultarProyecto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Negocio.Proyecto.Fecha;
import ms.piston.Negocio.Proyecto.Proyecto;
import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Factura.VFactura.imp.ModeloTabla;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Miguel
 * @generated 
 *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VConsultarProyecto extends JFrame {
	private static JFrame ventana;
	private TProyecto tp;

	private Set<JPanel> jPanel;
	private Set<JLabel> jLabel;
	private Set<JTextField> jTextField;
	private Set<JButton> jButton;
	private JPanel panelIzquierda;
	private JPanel panelDerecha;
	
	private LabelText nombre;
	private LabelText jefe;
	private LabelText duracion;
	private LabelText activo;
	private LabelText id;

	/*panel lista*/
	private JScrollPane jScrollPane;
	private JTable jTable;
	private panelLista lista;
	private ModeloTabla modelo;
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public VConsultarProyecto(TProyecto tp) {
		super("Consultar Proyecto");
		this.tp = tp;
		
		ventana = this;
	}
	private JPanel panelPrincipal;
	public void initGUI() {
		
		panelPrincipal= new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		
			panelIzquierda = new JPanel();
			panelDerecha = new JPanel();
			lista = new panelLista();
			modelo = new ModeloTabla();
			
			panelLabels label = new panelLabels();
			panelbotones botones = new panelbotones();
			
			panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
			panelIzquierda.setBorder(BorderFactory.createTitledBorder("Datos del proyecto"));
			panelIzquierda.add(label,BorderLayout.CENTER);
			panelIzquierda.add(botones, BorderLayout.SOUTH);
	
			actualizar(tp);
			panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
			panelDerecha.setBorder(BorderFactory.createTitledBorder("Lista de empleados"));
			panelDerecha.add(lista);
			
			panelPrincipal.add(panelIzquierda, BorderLayout.WEST);
			panelPrincipal.add(panelDerecha, BorderLayout.EAST);
			ventana.setIconImage	(icon.getImage());
			
		ventana.setContentPane(panelPrincipal);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}

	private class panelLabels extends JPanel {
		public panelLabels() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			setId(new LabelText("Id"));
			setNombre(new LabelText("Nombre"));
			setJefe(new LabelText("Jefe"));
			setDuracion(new LabelText("Duracion"));
			setActivo(new LabelText("Activo"));

			getId().text.setText(String.valueOf(tp.getId()));
			getNombre().text.setText(tp.getNombre());
			getDuracion().text
					.setText(String.valueOf(tp.getDuracionEmpleados()));
			getJefe().text.setText(String.valueOf(tp.getJefe()));
			if (tp.getActivo())
				getActivo().text.setText("Si");
			else
				getActivo().text.setText("No");
			getJefe().text.setEditable(false);
			getNombre().text.setEditable(false);
			getId().text.setEditable(false);
			getActivo().text.setEditable(false);
			getDuracion().text.setEditable(false);

			add(getId());
			add(getNombre());
			add(getJefe());
			add(getActivo());
			add(getDuracion());
		}
	}

	public class LabelText extends JPanel {
		private JTextField text;

		public LabelText(String mensaje) {
			setLayout(new FlowLayout());
			JLabel label = new JLabel(mensaje);
			label.setPreferredSize(new Dimension(70, 15));

			text = new JTextField(16);
			add(label);
			add(text);
		}

		public String getText() {
			if (text.getText().isEmpty())
				return "";
			else
				return text.getText();
		}
	}

	private class panelbotones extends JPanel {

		public panelbotones() {
			JButton aceptar = new JButton("Aceptar");
			aceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}

			});
			add(aceptar);

		}
	}

	private class panelLista extends JPanel {
		
		
		public panelLista() {
			jTable = new JTable();
	        modelo = new ModeloTabla();
	        jScrollPane = new JScrollPane(jTable);
	        String[] columnas = { "Id Proyecto","Id Empleado" , "Fecha inicio","Fecha fin"};
	        
	        modelo.setColumnIdentifiers(columnas);
	        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        jTable.setFillsViewportHeight(true); 
	        jTable.setModel(modelo);
	        this.setVisible(true);
	        jTable.setVisible(true);		
	        jScrollPane.setPreferredSize(new Dimension(600, 200));
	        jScrollPane.setVisible(true);
			add(jScrollPane);
		
		}
	}
	
	public void actualizar(TProyecto tp) {
		// begin-user-code
		if(tp == null)
		{
			JOptionPane.showMessageDialog(null, "Se produjo un error", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			ventana.remove(lista);
			lista = new panelLista();
			
			List<TFecha> ltf = tp.getFechas();
			
			for (TFecha f: ltf) {
				 modelo.addRow( new Object[] {f.getIdProyecto(), f.getIdEmpleado(), f.getFechaInicio().toGMTString(),f.getFechaFin().toGMTString()});
			}
			
			ventana.add(lista,BorderLayout.CENTER);
			ventana.revalidate();
		}
		// end-user-code
	}
	public final static JFrame getFrame() {
		return ventana;
	}

	public LabelText getId() {
		return id;
	}

	public void setId(LabelText id) {
		this.id = id;
	}

	public LabelText getNombre() {
		return nombre;
	}

	public void setNombre(LabelText nombre) {
		this.nombre = nombre;
	}

	public LabelText getJefe() {
		return jefe;
	}

	public void setJefe(LabelText jefe) {
		this.jefe = jefe;
	}

	public LabelText getDuracion() {
		return duracion;
	}

	public void setDuracion(LabelText duracion) {
		this.duracion = duracion;
	}

	public LabelText getActivo() {
		return activo;
	}

	public void setActivo(LabelText activo) {
		this.activo = activo;
	}
}