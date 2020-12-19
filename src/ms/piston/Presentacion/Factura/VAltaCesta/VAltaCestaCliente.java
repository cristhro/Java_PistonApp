package ms.piston.Presentacion.Factura.VAltaCesta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;









import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Cliente.VCliente.imp.ModeloTabla;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Factura.VAltaCesta.imp.ActionListenerImp;


public class VAltaCestaCliente extends JFrame implements command {
	private static JFrame ventana;
	public static JFrame getVentana() {
		return ventana;
	}
	public static void setVentana(JFrame ventana) {
		VAltaCestaCliente.ventana = ventana;
	}
	public JTable jTable;
	public ModeloTabla modelo;
	public JScrollPane jScrollPane;
	private panelLista lista;
	private JPanel jPanel;
	public VAltaCestaCliente() throws HeadlessException {
		super("Selecciona Cliente");
		ventana = this;
		
	}
	private void initGUI() {
		jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(900,400));
		jPanel.setLayout(new BorderLayout());
		ImageIcon appIcon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		ventana.setIconImage(appIcon.getImage());
		lista = new panelLista();
		panelBotones botones = new panelBotones();
		jPanel.add(botones,BorderLayout.SOUTH);
		jPanel.add(lista,BorderLayout.CENTER);
		ventana.setContentPane(jPanel);
		ventana.setVisible(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		
	}
	private class panelLista extends JPanel {
		
		
		public panelLista() {
			jTable = new JTable();
	        modelo = new ModeloTabla();
	        jScrollPane = new JScrollPane(jTable);
	        String[] columnas = { "Id","Nombre" , "Apellidos","NIF","Direccion","Telefono","Mail"};
	        
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
			JButton aceptar = new JButton("aceptar");
			JButton cancelar = new JButton("cancelar");
			setLayout(new FlowLayout());
			ActionListenerImp action = new ActionListenerImp();
			aceptar.addActionListener(action);
			cancelar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}
				
			});
			aceptar.setActionCommand("1");
			
			add(aceptar);
			
			
			}
	}
	public static JFrame getJFrame() {
		
		return ventana;
	}
	public JTable getjTable() {
		
		return jTable;
	}
	public ModeloTabla getModelo() {
	
		return modelo;
	}
	public void actualizar(Object Datos) {
		// begin-user-code
		if(Datos == null)
		{
			JOptionPane.showMessageDialog(null, "Se produjo un error", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			jPanel.remove(lista);
		lista = new panelLista();
			TCliente cl;
			Iterator<TCliente> it = ((Collection<TCliente>) Datos).iterator();
			 while(it.hasNext()) {
				 cl = it.next();
				 if(cl.getActivo()==true)
					 modelo.addRow( new Object[] {cl.getId(), cl.getNombre(), cl.getApellidos(), cl.getNif(),cl.getDireccion(),cl.getTelefono(),cl.getEmail()}); 
			 }
			 jPanel.add(lista,BorderLayout.CENTER);
			 jPanel.revalidate();
		}
		// end-user-code
	}
	@Override
	public Object ejecuta(Integer Orden, Object Datos) {
		initGUI();
		Controlador.ObtenerInstancia().accion(20, Datos);
		return null;
	}

}
