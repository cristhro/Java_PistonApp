package ms.piston.Presentacion.Proyecto.Vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ms.piston.Negocio.Proyecto.Proyecto;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Factura.VFactura.imp.ModeloTabla;

public class VProyecto extends JPanel{


	public VProyecto() {
		super();
		ventana = this;
		initGUI();
	}
	private Set<JButton> jButton;
	private JScrollPane jScrollPane;
	private JTable jTable;

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
			TProyecto tp;
			Iterator<TProyecto> it = ((Collection<TProyecto>) Datos).iterator();
			 while(it.hasNext()) {
				 tp = it.next();
				 if(tp.getActivo() == true)
					 modelo.addRow( new Object[] {tp.getId(), tp.getNombre(), tp.getJefe(), tp.getDuracionEmpleados()}); 
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
		lista = new panelLista();
		panelBotones botones = new panelBotones();
	
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
		        String[] columnas = { "Id","Nombre" , "Jefe","Duracion"};
		        
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
				JButton anadir = new JButton("Crear Proyecto");
				JButton modificar = new JButton("Modificar Proyecto");
				JButton eliminar = new JButton("Baja Proyecto");
				JButton consultar = new JButton("Consultar Proyecto");
				JButton addEmp = new JButton("Añadir Empleado");
				JButton delEmp = new JButton("Quitar Empleado");
				
				ImageIcon trashIcon = new ImageIcon(Main.class.getResource("/img/trash.png"));
				eliminar.setIcon(trashIcon);
				ImageIcon updateIcon = new ImageIcon(Main.class.getResource("/img/update.gif"));
				modificar.setIcon(updateIcon);
				ImageIcon nuevoIcon = new ImageIcon(Main.class.getResource("/img/add.png"));
				anadir.setIcon(nuevoIcon);
				ImageIcon consIcon = new ImageIcon(Main.class.getResource("/img/Buscar.png"));
				consultar.setIcon(consIcon);
				ImageIcon delEmpIcon = new ImageIcon(Main.class.getResource("/img/delEmpFromPro.png"));
				delEmp.setIcon(delEmpIcon);
				ImageIcon addEmpIcon = new ImageIcon(Main.class.getResource("/img/addEmpToPro.png"));
				addEmp.setIcon(addEmpIcon);
				setLayout(new FlowLayout());
				
				jButton.add(anadir);
				jButton.add(modificar);
				jButton.add(eliminar);
				jButton.add(consultar);
				jButton.add(addEmp);
				jButton.add(delEmp);
				
				ActionListenerImp action = new ActionListenerImp();
				anadir.addActionListener(action);
				modificar.addActionListener(action);
				eliminar.addActionListener(action);
				consultar.addActionListener(action);
				addEmp.addActionListener(action);
				delEmp.addActionListener(action);
				
				anadir.setActionCommand("crear");
				modificar.setActionCommand("modificar");
				eliminar.setActionCommand("borrar");
				consultar.setActionCommand("consultar");
				addEmp.setActionCommand("addEmp");
				delEmp.setActionCommand("delEmp");
				
				add(anadir);
				add(modificar);
				add(eliminar);
				add(consultar);
				add(addEmp);
				add(delEmp);
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
