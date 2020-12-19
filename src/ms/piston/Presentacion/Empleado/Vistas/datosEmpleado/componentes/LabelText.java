package ms.piston.Presentacion.Empleado.Vistas.datosEmpleado.componentes;

import javax.swing.*;
import java.awt.*;

public class LabelText extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabelText(String texto) {
        this.label = new JLabel(texto);
        this.textField = new JTextField(16);

        configPane();
    }

    private void configPane() {
        this.setLayout(new FlowLayout());
        this.label.setPreferredSize(new Dimension(150, 15));
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
