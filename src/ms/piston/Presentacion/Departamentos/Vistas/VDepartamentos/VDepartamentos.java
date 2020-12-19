/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos;



import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Cliente.VCliente.imp.ModeloTabla;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.imp.ActionListenerImp;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.imp.EscuchadorRaton;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VDepartamentos extends JPanel {
	public VDepartamentos() {
		super();
		ventana = this;
		initGUI();
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Set<JButton> jButton;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private JScrollPane jScrollPane;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private JTable jTable;

	private panelLista lista;
	private ModeloTabla modelo;
	private static JPanel ventana;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
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
			TDepartamento dep;
			Iterator<TDepartamento> it = ((Collection<TDepartamento>) Datos).iterator();
			 while(it.hasNext()) {
				 dep = it.next();
				 if(dep.getActivo()==true && dep.getJefe() != -1 )
					 modelo.addRow( new Object[] {dep.getID(), dep.getNombre(), dep.getJefe()}); 
				 else if(dep.getActivo()==true && dep.getJefe() == -1){
					 modelo.addRow( new Object[] {dep.getID(), dep.getNombre(), "NULL"}); 
				 }
					 
					 
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
	public void initGUI() {
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
		        jTable.addMouseListener(new EscuchadorRaton((VDepartamentos) ventana));
		        String[] columnas = { "Id","Nombre" , "Jefe"};
		        
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
				JButton anadir = new JButton("Crear Departamento");
				JButton modificar = new JButton("Modificar Departamento");
				JButton eliminar = new JButton("Eliminar Departamento");
				JButton consultar = new JButton("Consultar Departamento");
				JButton nomina = new JButton("Calcular Nomina Departamento");
				ImageIcon trashIcon = new ImageIcon(Main.class.getResource("/img/trash.png"));
				eliminar.setIcon(trashIcon);
				ImageIcon updateIcon = new ImageIcon(Main.class.getResource("/img/update.gif"));
				modificar.setIcon(updateIcon);
				ImageIcon nuevoIcon = new ImageIcon(Main.class.getResource("/img/add.png"));
				anadir.setIcon(nuevoIcon);
				ImageIcon consIcon = new ImageIcon(Main.class.getResource("/img/Buscar.png"));
				consultar.setIcon(consIcon);
				ImageIcon nominaIcon = new ImageIcon(Main.class.getResource("/img/calcu.png"));
				nomina.setIcon(nominaIcon);
				setLayout(new FlowLayout());
				ActionListenerImp action = new ActionListenerImp();
				anadir.addActionListener(action);
				modificar.addActionListener(action);
				eliminar.addActionListener(action);
				consultar.addActionListener(action);
				nomina.addActionListener(action);
				anadir.setActionCommand("add");
				modificar.setActionCommand("mod");
				eliminar.setActionCommand("sup");
				consultar.setActionCommand("cons");
				nomina.setActionCommand("nomina");
				
				add(anadir);
				add(modificar);
				add(eliminar);
				add(consultar);
				add(nomina);
				
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