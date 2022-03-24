package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import java.util.ArrayList;

public class DeletarCliente extends JFrame {
    private static final ClienteController clienteController = new ClienteController();

    private JComboBox comboBox1;
    private JButton button1;
    private JPanel panel1;


    public DeletarCliente() {
        setContentPane(panel1);
        setSize(350, 200);

        buscarTodosClientes();

        button1.addActionListener(e -> {
            boolean removed = clienteController.remover(Integer.parseInt(((comboBox1.getSelectedItem().toString().split("-")[0]).trim())));
            if(removed) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso", "Deletar cliente", JOptionPane.INFORMATION_MESSAGE);
                comboBox1.removeItemAt(comboBox1.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(null, "Usuário possui linha telefônica ativa", "Deletar cliente", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void buscarTodosClientes() {
        ArrayList<Cliente> clientes = clienteController.buscarTodos();
        for (Cliente cliente : clientes) {
            comboBox1.addItem(cliente.getId()+" - "+cliente.getNome());
        }
    }

    public static void showScreen() {
        DeletarCliente deletarCliente = new DeletarCliente();
        deletarCliente.setLocationRelativeTo(null);
        deletarCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        deletarCliente.setVisible(true);
    }

}
