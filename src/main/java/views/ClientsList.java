package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ClientsList extends JFrame{
    private JTable clientTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton refreshTableButton;
    private JPanel jpanel;
    private JButton editarButton;

    ClientsList() {
        setContentPane(jpanel);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
//        clientTable.setEnabled(false);

        criarLista();

        addButton.addActionListener(e -> NovoCliente.showScreen());
        deleteButton.addActionListener(e -> DeletarCliente.showScreen());
        refreshTableButton.addActionListener(e -> criarLista());
    }

    private void criarLista() {
        ClienteController clienteController = new ClienteController();
        ArrayList<Cliente> clientes = clienteController.buscarTodos();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);
        clientTable.setModel(tableModel);
        tableModel.addRow(new Object[]{"ID", "Nome", "CPF"});

        for (Cliente cliente: clientes) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getNome()), (cliente.getCpf())});
        }
    }

    public static void showScreen() {
        ClientsList clientsList = new ClientsList();
        clientsList.setLocationRelativeTo(null);
        clientsList.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        clientsList.setVisible(true);
    }

}
