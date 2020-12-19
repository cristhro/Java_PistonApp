/**
 * 
 */
package ms.piston.Presentacion.Empleado.Vistas.altaEmpleado;

import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.imp.EscuchadorAltaEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.componentes.LabelText;
import ms.piston.Presentacion.Main;

import javax.swing.*;
import java.awt.*;

public class VAltaEmpleado extends JFrame {
    private JPanel panelPrincipal;

    private JPanel datosPersonales;
    public LabelText nif;
    public LabelText nombre;
    public LabelText apellidos;

    private JPanel datosContacto;
    public LabelText telefono;
    public LabelText direccion;
    public LabelText email;

    private JPanel datosEmpresa;
    public LabelText departamento;
    public LabelText salario;
    public JComboBox<String> tipo;
    public JCheckBox ayudaTransporte;
    public LabelText cocheEmpresa;

    private JPanel panelBotones;
    private JButton insertar;
    private JButton cancelar;

    private TEmpleado empleado;

    private EscuchadorAltaEmpleado escuchador;

    public VAltaEmpleado() {
        super("Alta empleado");

        this.panelPrincipal = new JPanel();
        this.escuchador = new EscuchadorAltaEmpleado(this);

        this.datosPersonales = new JPanel();
        this.nombre = new LabelText("Nombre");
        this.apellidos = new LabelText("Apellidos");
        this.nif = new LabelText("NIF");

        this.datosContacto = new JPanel();
        this.telefono = new LabelText("Telefono");
        this.direccion = new LabelText("Direccion");
        this.email = new LabelText("Email");

        this.datosEmpresa = new JPanel();
        this.departamento = new LabelText("Departamento");
        this.salario = new LabelText("Salario");
        this.tipo = new JComboBox();
        this.ayudaTransporte = new JCheckBox("Ayuda transporte");
        this.cocheEmpresa = new LabelText("Coche de Empresa");

        this.panelBotones = new JPanel();
        this.insertar = new JButton("Insertar");
        this.cancelar = new JButton("Cancelar");

        configGUI();
        initGUI();
    }

    private void configGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        datosPersonales.setLayout(new BoxLayout(datosPersonales, BoxLayout.Y_AXIS));
        datosPersonales.setBorder(BorderFactory.createTitledBorder("Datos personales"));
        datosContacto.setLayout(new BoxLayout(datosContacto, BoxLayout.Y_AXIS));
        datosContacto.setBorder(BorderFactory.createTitledBorder("Datos contacto"));
        datosEmpresa.setLayout(new BoxLayout(datosEmpresa, BoxLayout.Y_AXIS));
        datosEmpresa.setBorder(BorderFactory.createTitledBorder("Datos empresa"));
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ayudaTransporte.setEnabled(false);
        cocheEmpresa.setEditable(false);
        tipo.addItem("Seleccionar");
        tipo.addItem("Jefe");
        tipo.addItem("Empleado");
        tipo.addActionListener(escuchador);
        tipo.setActionCommand("tipo");

        datosPersonales.add(nombre);
        datosPersonales.add(apellidos);
        datosPersonales.add(nif);
        datosContacto.add(telefono);
        datosContacto.add(direccion);
        datosContacto.add(email);
        datosEmpresa.add(departamento);
        datosEmpresa.add(salario);
        datosEmpresa.add(tipo);
        datosEmpresa.add(ayudaTransporte);
        datosEmpresa.add(cocheEmpresa);

        insertar.addActionListener(escuchador);
        insertar.setActionCommand("insertar");
        cancelar.addActionListener(escuchador);
        cancelar.setActionCommand("cancelar");
        panelBotones.add(insertar);
        panelBotones.add(cancelar);

        panelPrincipal.add(datosPersonales);
        panelPrincipal.add(datosContacto);
        panelPrincipal.add(datosEmpresa);
        panelPrincipal.add(panelBotones);
        this.add(panelPrincipal);

        ImageIcon icon = new ImageIcon(Main.class.getResource("/img/Logo.png"));
        this.setIconImage(icon.getImage());
        this.setContentPane(panelPrincipal);
    }

    private void initGUI() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}