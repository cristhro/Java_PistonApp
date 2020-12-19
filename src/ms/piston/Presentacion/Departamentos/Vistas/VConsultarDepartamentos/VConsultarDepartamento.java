/**
 * 
 */
package ms.piston.Presentacion.Departamentos.Vistas.VConsultarDepartamentos;


import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ms.piston.Negocio.Departamentos.TDepartamento;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.imp.ModeloTabla;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VConsultarDepartamento extends JFrame {
	private static JFrame ventana;
	public VConsultarDepartamento() {
			super("Consultar Departamento");
			ventana = this;
	}

	private Set<JPanel> jPanel;

	private Set<JLabel> jLabel;
	
	private Set<JTextField> jTextField;

	private Set<JButton> jButton;

	private LabelText nombre;
	private LabelText jefe;
	private LabelText id;
	private LabelText activo;
	private JTable jTable;
	private panelLista lista;
	private ModeloTabla modelo;
	
	public LabelText getId() {
		return id;
	}

	public void setId(LabelText id) {
		this.id = id;
	}

	public LabelText getActivo() {
		return activo;
	}

	public void setActivo(LabelText activo) {
		this.activo = activo;
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

	public void setJefe(LabelText label2) {
		this.jefe = label2;
	}

	public void initGUI() {
		// begin-user-code
		setLayout(new BorderLayout());
		panelLabels label = new panelLabels();
		panelbotones botones = new panelbotones();
		add(label,BorderLayout.NORTH);
		add(botones,BorderLayout.SOUTH);
		lista = new panelLista();
		add(lista,BorderLayout.CENTER);
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		ventana.setIconImage(icon.getImage());
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		

		// end-user-code
	}
	
	private class panelLabels extends JPanel {
		public panelLabels(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		setId(new LabelText("Id"));
		setActivo(new LabelText("Activo"));
		setNombre(new LabelText("Nombre"));
		setJefe(new LabelText("Jefe"));
		add(getId());
		add(getNombre());
		add(getJefe());
		add(getActivo());
	
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

private class panelLista extends JPanel {
	
	
	public panelLista() {
		jTable = new JTable();
        modelo = new ModeloTabla();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        String[] columnas = {"Id", "NIF", "Nombre", "Apellidos", "Nomina"};
        
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
public void actualizar(TDepartamento departamento){
	getNombre().text.setText(departamento.getNombre());
	if(departamento.getJefe() != -1)
		getJefe().text.setText(String.valueOf(departamento.getJefe()));
	getId().text.setText(String.valueOf(departamento.getID()));
	if(departamento.getActivo())
		getActivo().text.setText("Si");
	else
		getActivo().text.setText("No");
	getJefe().text.setEditable(false);
	getNombre().text.setEditable(false);
	getId().text.setEditable(false);
	getActivo().text.setEditable(false);
	
	ventana.remove(lista);
	lista = new panelLista();

    TEmpleado emp;
    List<TEmpleado> empleados = (List<TEmpleado>) departamento.getListaEmpleados();
    Iterator<TEmpleado> it = empleados.iterator();
    while (it.hasNext()) {
        emp = it.next();

        if (emp.getActivo() == true) {
            Object[] datosEmpleado = new Object[] {emp.getId(), emp.getNif(), emp.getNombre(), emp.getApellidos(),emp.getSalario()};
           modelo.addRow(datosEmpleado);
        }
    }

    ventana.add(lista);
    ventana.revalidate();
}
	

public final static JFrame getFrame(){
	return ventana;
}
}