/**
 *
 */
package ms.piston.Presentacion.Empleado.Vistas.modificarEmpleado;

import ms.piston.Negocio.Empleado.TEmpJefe;
import ms.piston.Negocio.Empleado.TEmpNormal;
import ms.piston.Negocio.Empleado.TEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.altaEmpleado.imp.EscuchadorAltaEmpleado;
import ms.piston.Presentacion.Empleado.Vistas.modificarEmpleado.componentes.LabelText;
import ms.piston.Presentacion.Empleado.Vistas.modificarEmpleado.imp.EscuchadorModificarEmpleado;
import ms.piston.Presentacion.Main;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("Duplicates")
public class VModificarEmpleado extends JFrame {
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
    private JButton modificar;
    private JButton cancelar;

    private TEmpleado empleado;

    private EscuchadorModificarEmpleado escuchador;

    public VModificarEmpleado(TEmpleado empleado) {
        super("Modificar empleado " + empleado.getNombre() + " " + empleado.getApellidos());

        if (empleado instanceof TEmpJefe) {
            this.empleado = new TEmpJefe();
            this.empleado = empleado;
        } else if (empleado instanceof TEmpNormal){
            this.empleado = new TEmpNormal();
            this.empleado = empleado;
        }
        this.panelPrincipal = new JPanel();
        this.escuchador = new EscuchadorModificarEmpleado(this, empleado.getId());

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
        this.modificar = new JButton("Modificar");
        this.cancelar = new JButton("Cancelar");

        this.empleado = empleado;

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

        nombre.setText(empleado.getNombre());
        apellidos.setText(empleado.getApellidos());
        nif.setText(empleado.getNif());
        telefono.setText(String.valueOf(empleado.getTelefono()));
        direccion.setText(empleado.getDireccion());
        email.setText(empleado.getEmail());
        departamento.setText(String.valueOf(empleado.getIdDepartamento()));
        salario.setText(String.valueOf(empleado.getSalario()));
        if (empleado instanceof TEmpJefe) {
            tipo.setSelectedItem("Jefe");
            cocheEmpresa.setText(((TEmpJefe) empleado).getCocheEmpresa());
        } else if (empleado instanceof TEmpNormal){
            tipo.setSelectedItem("Empleado");
            ayudaTransporte.setSelected(((TEmpNormal) empleado).getAyudaTransporte());
        }

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

        modificar.addActionListener(escuchador);
        modificar.setActionCommand("modificar");
        cancelar.addActionListener(escuchador);
        cancelar.setActionCommand("cancelar");
        panelBotones.add(modificar);
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