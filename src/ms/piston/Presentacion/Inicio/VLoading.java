package ms.piston.Presentacion.Inicio;

import ms.piston.Presentacion.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VLoading extends JFrame {

    public VLoading() {
        super();
        this.setUndecorated(true);
        JLabel label = new JLabel(new ImageIcon(Main.class.getResource("/img/loading.gif")));
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
}
