package ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ms.piston.Negocio.Cliente.imp.TCliente;
import ms.piston.Negocio.Cliente.imp.TClienteEmpresa;
import ms.piston.Negocio.Cliente.imp.TClienteParticular;
import ms.piston.Negocio.Proyecto.TProyecto;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Command_DAO.command;
import ms.piston.Presentacion.Controlador_DAO.Controlador;
import ms.piston.Presentacion.Controller.Controller;
import ms.piston.Presentacion.Proyecto.Vistas.VModificarProyecto.imp.ActionListenerImpMp;

public class VModificarProyecto extends JFrame {
	private static JFrame ventana;
	private TProyecto tp;

	public VModificarProyecto(Object Datos) throws HeadlessException {
		super("Modificar Proyecto");
		this.tp = (TProyecto) Datos;
		ventana = this;
	}

	private LabelText label1;
	private LabelText label2;
	private LabelText label3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

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

	public void initGUI() {
		// begin-user-code
		JPanelPrincipal panel = new JPanelPrincipal();
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
		getLabel1().text.setText(tp.getNombre());
		getLabel2().text.setText(String.valueOf(tp.getJefe()));
		getLabel3().text.setText(String.valueOf(tp.getDuracionEmpleados()));

		ventana.setIconImage(icon.getImage());
		ventana.setContentPane(panel);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		// end-user-code
	}

	private class JPanelPrincipal extends JPanel {
		public JPanelPrincipal() {
			setLayout(new BorderLayout());
			panelLabels label = new panelLabels();
			panelbotones botones = new panelbotones();
			add(label, BorderLayout.CENTER);
			add(botones, BorderLayout.SOUTH);
		}
	}

	private class panelLabels extends JPanel {
		public panelLabels() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			setLabel1(new LabelText("Nombre"));
			setLabel2(new LabelText("Id jefe"));
			setLabel3(new LabelText("Duracion"));

			add(getLabel1());
			add(getLabel2());
			add(getLabel3());

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
			JButton cancelar = new JButton("Cancelar");
			ActionListener action = new ActionListenerImpMp();
			aceptar.addActionListener(action);
			cancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ventana.dispose();
				}

			});
			add(aceptar);
			add(cancelar);

		}
	}

	public final static JFrame getFrame() {
		return ventana;
	}

	public TProyecto getTProyecto() {
		String nombre = getLabel1().getText();
		int idJefe = Integer.parseInt(getLabel2().getText());
		int duracion = Integer.parseInt(getLabel3().getText());
		try {
			if (nombre == "") {
				JOptionPane.showMessageDialog(null,
						"No has introducido todos los datos necesarios",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				tp.setNombre(nombre);
				tp.setJefe(idJefe);
				tp.setDuracionEmpleados(duracion);
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return tp;

	}
}
