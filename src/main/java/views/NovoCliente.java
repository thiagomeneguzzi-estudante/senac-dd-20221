package views;

import controller.ClienteController;
import controller.EnderecoController;
import model.entity.Cliente;
import model.entity.Endereco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class NovoCliente extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JComboBox comboBoxEnderecos;
    private JButton button1;
    private JPanel panel;

    public NovoCliente() {
        setContentPane(panel);
        setSize(750, 250);

        buscarEnderecos();

        button1.addActionListener(e -> {
            Cliente cliente = new Cliente();
            ClienteController clienteController = new ClienteController();
            cliente.setNome(nome.getText());
            cliente.setCpf(cpf.getText());
            cliente.setEndereco((Endereco) comboBoxEnderecos.getSelectedItem());
            String mensagem = clienteController.criar(cliente);
            JOptionPane.showMessageDialog(null, mensagem, "Adicionar cliente", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
    }

    private void buscarEnderecos() {
        EnderecoController enderecoController = new EnderecoController();
        ArrayList<Endereco> enderecos = enderecoController.buscarTodos();

        for (Endereco endereco: enderecos) {
            comboBoxEnderecos.addItem(endereco);
        }
    }

    public static void showScreen(){
        NovoCliente cliente = new NovoCliente();
        cliente.setLocationRelativeTo(null);
        cliente.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cliente.setVisible(true);
    }
}
