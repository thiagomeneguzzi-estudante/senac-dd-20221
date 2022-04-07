package views;

import javax.swing.*;
import java.awt.*;

public class Enderecos extends JFrame{
    private JRadioButton radioButton;
    private JPanel panel1;
    private JTextField txtTeste;

    public Enderecos() {
        setContentPane(panel1);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
    }

    public static void showScreen() {
        Enderecos enderecos = new Enderecos();
        enderecos.setLocationRelativeTo(null);
        enderecos.setVisible(true);
    }

    public static void dismissScreen() {
        Enderecos enderecos = new Enderecos();
        enderecos.dispose();
    }
}
