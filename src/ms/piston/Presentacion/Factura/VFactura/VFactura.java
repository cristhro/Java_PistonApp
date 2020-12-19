/**
 * 
 */
package ms.piston.Presentacion.Factura.VFactura;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;




import ms.piston.Negocio.Factura.imp.TFactura;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Factura.VFactura.imp.ActionListenerImp;
import ms.piston.Presentacion.Factura.VFactura.imp.ModeloTabla;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VFactura extends JPanel {
	
	public VFactura() {
		super();
		ventana = this;
		initGUI();
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
	private Set<JFrame> jFrame;
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
	private JTable jTable;
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
	private JTextField jTextField;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<JTabbedPane> jTabbedPane;

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
			TFactura fact;
			Iterator<TFactura> it = ((Collection<TFactura>) Datos).iterator();
			 while(it.hasNext()) {
				 fact = it.next();
					 modelo.addRow( new Object[] {fact.getID(), fact.getFecha()}); 
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
		        String[] columnas = { "Id","Fecha"};
		        
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
				JButton altacesta = new JButton("Alta Cesta");
				JButton Devolucion = new JButton("Devolucion");
				JButton consultar = new JButton("Consultar Cesta");

				ImageIcon updateIcon = new ImageIcon(Main.class.getResource("/img/update.gif"));
				Devolucion.setIcon(updateIcon);
				ImageIcon nuevoIcon = new ImageIcon(Main.class.getResource("/img/add.png"));
				altacesta.setIcon(nuevoIcon);
				ImageIcon consIcon = new ImageIcon(Main.class.getResource("/img/Buscar.png"));
				consultar.setIcon(consIcon);
				setLayout(new FlowLayout());
				jButton.add(altacesta);
				jButton.add(Devolucion);
				jButton.add(consultar);
				ActionListenerImp action = new ActionListenerImp();
				altacesta.addActionListener(action);
				Devolucion.addActionListener(action);
				consultar.addActionListener(action);
				altacesta.setActionCommand("1");
				Devolucion.setActionCommand("2");
				consultar.setActionCommand("4");
				
				add(altacesta);
				add(Devolucion);
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