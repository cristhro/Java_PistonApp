package ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.componentes;

import ms.piston.Presentacion.Empleado.Vistas.listadoEmpleados.imp.EscuchadorListadoEmpleados;
import ms.piston.Presentacion.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    private JButton alta;
    private JButton baja;
    private JButton modificar;
    private JButton consultar;

    private ImageIcon trashIcon;
    private ImageIcon updateIcon;
    private ImageIcon addIcon;
    private ImageIcon searchIcon;

    private ActionListener escuchador;

    public PanelBotones(ActionListener escuchador) {
        this.escuchador = escuchador;

        this.alta = new JButton("Alta empleado");
        this.baja = new JButton("Baja empleado");
        this.modificar = new JButton("Modificar empleado");
        this.consultar = new JButton("Consultar empleado");

        this.trashIcon = new ImageIcon(Main.class.getResource("/img/trash.png"));
        this.updateIcon = new ImageIcon(Main.class.getResource("/img/update.gif"));
        this.addIcon = new ImageIcon(Main.class.getResource("/img/add.png"));
        this.searchIcon = new ImageIcon(Main.class.getResource("/img/Buscar.png"));

        configPane();
    }

    private void configPane() {
        baja.setIcon(trashIcon);
        alta.setIcon(addIcon);
        modificar.setIcon(updateIcon);
        consultar.setIcon(searchIcon);

        this.setLayout(new FlowLayout());

        alta.addActionListener(escuchador);
        baja.addActionListener(escuchador);
        modificar.addActionListener(escuchador);
        consultar.addActionListener(escuchador);

        alta.setActionCommand("alta");
        baja.setActionCommand("baja");
        modificar.setActionCommand("modificar");
        consultar.setActionCommand("consultar");

        this.add(alta);
        this.add(baja);
        this.add(modificar);
        this.add(consultar);
    }
}
