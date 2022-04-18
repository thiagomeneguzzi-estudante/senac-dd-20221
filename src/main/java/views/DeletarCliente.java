package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import java.util.ArrayList;

public class DeletarCliente extends JFrame {
    private static final ClienteController clienteController = new ClienteController();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private JComboBox comboBox1;
    private JButton button1;
    private JPanel panel1;


    public DeletarCliente(Cliente clientFromRow) {
        setContentPane(panel1);
        setSize(350, 200);

        buscarTodosClientes();
        setSelectedClient(clientFromRow);

        button1.addActionListener(e -> {
            boolean removed = clienteController.remover(Integer.parseInt(((comboBox1.getSelectedItem().toString().split("-")[0]).trim())));
            if(removed) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso", "Deletar cliente", JOptionPane.INFORMATION_MESSAGE);
                comboBox1.removeItemAt(comboBox1.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(null, "Usuário possui linha telefônica ativa", "Deletar cliente", JOptionPane.ERROR_MESSAGE);
            }
        });

        showScreen();
    }

    private void buscarTodosClientes() {
        clientes = clienteController.buscarTodos();
        for (Cliente cliente : clientes) {
            comboBox1.addItem(cliente.getId()+" - "+cliente.getNome());
        }
    }

    private void setSelectedClient(Cliente clientFromRow) {
        for (int i = 0; i < clientes.toArray().length; i++) {
            if(clientes.get(i).getId() == clientFromRow.getId()) {
                comboBox1.setSelectedIndex(i);
            }
        }
    }

    public void showScreen() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
