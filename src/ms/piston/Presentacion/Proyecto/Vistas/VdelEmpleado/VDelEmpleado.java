package ms.piston.Presentacion.Proyecto.Vistas.VdelEmpleado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Proyecto.Vistas.VdelEmpleado.imp.ActionListenerImp;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

public class VDelEmpleado extends JFrame {

	  private static JFrame ventana;
	  private JPanel panelPrincipal;
	  private JPanel panelIds;
	  private panelbotones panelBotones;
	  TFecha tf;

	  private JButton aceptar;
	  private JButton cancelar;
	  
	  private LabelText idPro;
	  private LabelText idEmp;
	  private TFecha tFecha;
	  
	  
	public VDelEmpleado( int idProyecto){
		 super("Quitar empleado");
		 
		 	ventana = this;
	        panelPrincipal = new JPanel();
	        panelIds = new JPanel();
	        panelBotones =new panelbotones();

	        idPro = new LabelText("Id proyecto: ");
	        idPro.textField.setText(String.valueOf(idProyecto));
	        idEmp = new LabelText("Id empleado");
	        
	        tf = new TFecha();
	        tf.setIdProyecto(idProyecto);
	        
		configGUI();
		initGUI();
	}
	private void initGUI() {
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
    private void configGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        panelPrincipal.setLayout(new BorderLayout());
        panelIds.setLayout(new BorderLayout());
        panelIds.add(idEmp, BorderLayout.SOUTH);
        panelIds.add(idPro,BorderLayout.NORTH);
        
        panelPrincipal.add(panelIds,BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        
        ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
        this.setIconImage(icon.getImage());
        this.setContentPane(panelPrincipal);
    }
    public class LabelText extends JPanel {
        private JLabel label;
        private JTextField textField;

        public LabelText(String texto) {
            this.label = new JLabel(texto);
            this.textField = new JTextField(10);

            configPane();
        }

        private void configPane() {
            this.setLayout(new FlowLayout());
            this.label.setPreferredSize(new Dimension(100, 15));
            this.add(label);
            this.add(textField);
        }

        public String getText() {
            if (textField.getText().isEmpty()) {
                return "";
            } else {
                return textField.getText();
            }
        }

        public void setText(String text) {
            this.textField.setText(text);
        }

        public void setEditable(boolean opt) {
            textField.setEditable(opt);
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
    public static Frame getFrame(){
    	return ventana;
    }
    public TFecha getFecha(){
    	tf.setIdEmpleado(Integer.parseInt(idEmp.getText()));
    	tf.setIdProyecto(Integer.parseInt(idPro.getText()));
    	return tf;
    }
}