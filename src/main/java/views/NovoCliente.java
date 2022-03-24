package views;

import javax.swing.*;

public class NovoCliente extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JComboBox comboBoxEnderecos;
    private JButton button1;
    private JPanel panel;

    public NovoCliente() {
        setContentPane(panel);
        setSize(350, 250);
        button1.addActionListener(e -> {

        });
    }

    public static void showScreen(){
        NovoCliente cliente = new NovoCliente();
        cliente.setLocationRelativeTo(null);
        cliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cliente.setVisible(true);
    }
}
