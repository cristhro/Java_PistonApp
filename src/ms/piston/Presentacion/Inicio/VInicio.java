/**
 * 
 */
package ms.piston.Presentacion.Inicio;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.VListadoEmpleados;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Cliente.VCliente.Vcliente;
import ms.piston.Presentacion.Departamentos.Vistas.VDepartamentos.VDepartamentos;
import ms.piston.Presentacion.Factura.VFactura.VFactura;
import ms.piston.Presentacion.Producto.VProducto.VProducto;
import ms.piston.Presentacion.Proyecto.Vistas.VProyecto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VInicio extends JFrame {
	public VInicio() {
		super("Piston");
	
		initGUI();
	}
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTabbedPane jTabbedPane;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private  JPanel jPanel;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Vcliente cliente;
	private VProducto producto;
	private VFactura factura;
	private VDepartamentos departamento;
	private VListadoEmpleados empleado;
	private VProyecto proyecto;
	
	private void initGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		jTabbedPane = new JTabbedPane();
		jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(900,400));
		jPanel.setLayout(new BorderLayout());
		ImageIcon appIcon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		this.setIconImage(appIcon.getImage());
		JLabel imagen= new JLabel("");
		JLabel bienvenido= new JLabel("          Bienvenido a Piston             ");
		bienvenido.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		imagen.setIcon(new ImageIcon(Main.class.getResource("/img/Piston.gif")));
		LabelNombres autor = new LabelNombres();
		jPanel.add(imagen, BorderLayout.CENTER);
		jPanel.add(bienvenido,BorderLayout.WEST);
		jPanel.add(autor,BorderLayout.EAST);
		this.setVisible(false);
		
		// end-user-code
	}
	private class LabelNombres extends JPanel{
		public LabelNombres(){
			setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			JLabel espacio1= new JLabel("							");
			JLabel espacio2= new JLabel("							");
			JLabel espacio3= new JLabel("							");
			JLabel autores= new JLabel("          Autores:             ");
			JLabel pablo1= new JLabel("          Pablo Márquez             ");
			JLabel pablo2= new JLabel("          Pablo Martín             ");
			JLabel sergio= new JLabel("          Sergio Pino            ");
			JLabel miguel= new JLabel("          Miguel Franco             ");
			JLabel cristhian= new JLabel("          Cristhian Rodríguez             ");
			JLabel jaime= new JLabel("          Jaime Tamames             ");
			autores.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			miguel.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			pablo1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			pablo2.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			sergio.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			cristhian.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			jaime.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			espacio1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			espacio2.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			espacio3.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
			add(espacio1);
			add(espacio2);
			add(espacio3);
			add(autores);
			add(miguel);
			add(pablo1);
			add(pablo2);
			add(sergio);
			add(cristhian);
			add(jaime);
			
		}
	}

	public void anadirTabs()
	{
		jTabbedPane.addTab("Inicio", jPanel);
		jTabbedPane.addTab("Cliente", cliente);
		jTabbedPane.addTab("Productos", producto);
		jTabbedPane.addTab("Facturas", factura);
		jTabbedPane.addTab("Departamentos", departamento);
		jTabbedPane.addTab("Proyectos", proyecto);
		jTabbedPane.addTab("Empleados", empleado);
		jTabbedPane.setPreferredSize(new Dimension(1150,400));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(jTabbedPane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	public void actualizar(Object ventana) {
		if(ventana instanceof Vcliente){
			cliente = (Vcliente) ventana;
		}
		else if(ventana instanceof VProducto){
			producto = (VProducto) ventana;
		}
		else if(ventana instanceof VFactura){
			factura = (VFactura) ventana;
		}
		else if(ventana instanceof VDepartamentos){
			departamento = (VDepartamentos) ventana;
		}
		else if(ventana instanceof VProyecto){
			proyecto = (VProyecto) ventana;
		}
		else if(ventana instanceof VListadoEmpleados){
			empleado = (VListadoEmpleados) ventana;
		}
	}

	
}