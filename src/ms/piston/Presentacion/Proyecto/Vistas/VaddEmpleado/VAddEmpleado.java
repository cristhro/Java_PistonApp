/**
 * 
 */
package ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

import ms.piston.Negocio.Proyecto.TFecha;
import ms.piston.Presentacion.Main;
import ms.piston.Presentacion.Proyecto.Vistas.VaddEmpleado.imp.ActionListenerImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Miguel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class VAddEmpleado extends JFrame {
		
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	  private JPanel panelPrincipal;
	  private JPanel panelFinicio;
	  private JPanel panelFfin;
	  private JPanel panelIds;
	  private panelbotones panelBotones;
	  
	  private JCalendarCombo calendarInicio;
	  private JCalendarCombo calendarFin; 

	  private JButton aceptar;
	  private JButton cancelar;
	  
	  private LabelText idPro;
	  private LabelText idEmp;
	  private TFecha tFecha;
	  
	  
	public VAddEmpleado(int idPro2){
		 super("Añadir empleado");
		 
		 	ventana = this;
	        panelPrincipal = new JPanel();
	        panelFfin = new JPanel();
	        panelFinicio = new JPanel();
	        panelIds = new JPanel();
	        panelBotones =new panelbotones();
	        
	        calendarInicio = new JCalendarCombo();
	        calendarInicio.addDateListener(new DateListener() {
	        	public void dateChanged(DateEvent arg0) {
	        		tFecha.setFechaInicio(calendarInicio.getDate());
	        	}
	        });
	        calendarFin = new JCalendarCombo();
	        calendarFin.addDateListener(new DateListener() {
	        	
				@Override
				public void dateChanged(DateEvent arg0) {
					// TODO Auto-generated method stub
					tFecha.setFechaFin(calendarFin.getDate());
				}
	        });

	        idPro = new LabelText("Id proyecto: ");
	        idEmp = new LabelText("Id empleado");
	        idPro.textField.setText(String.valueOf(idPro2));
	        tFecha = new TFecha(calendarInicio.getDate(),calendarFin.getDate());
		 
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
        //panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelFfin.setBorder(BorderFactory.createTitledBorder("Fecha fin"));
        panelFinicio.setBorder(BorderFactory.createTitledBorder("Fecha inicio"));
        
        panelFfin.add(calendarFin);
        panelFinicio.add(calendarInicio);
        
        panelIds.add(idEmp);
        panelIds.add(idPro);
        
        panelPrincipal.add(panelFfin,  BorderLayout.EAST);
        panelPrincipal.add(panelFinicio, BorderLayout.WEST);
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
    public TFecha getTFecha(){
    
    	try {
    		tFecha.setIdEmpleado(Integer.parseInt(idEmp.getText()));
        	tFecha.setIdProyecto(Integer.parseInt(idPro.getText()));
    	}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Hay datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
    	return tFecha;
    }
}