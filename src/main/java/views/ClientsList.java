package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClientsList extends JFrame{
    private JTable clientTable;
    private JButton addClientButton;
    private JButton deleteClientButton;
    private JButton refreshTableButton;
    private JPanel jpanel;
    private JButton editClientButton;

    private static final ClienteController clienteController = new ClienteController();
    private ArrayList<Cliente> clientes;

    ClientsList() {
        setContentPane(jpanel);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        editClientButton.setEnabled(false);
        deleteClientButton.setEnabled(false);

        buildClientsList();

        addClientButton.addActionListener(e -> addNewClient());
        deleteClientButton.addActionListener(e -> deleteClient());
        editClientButton.addActionListener(e -> editClient());
        refreshTableButton.addActionListener(e -> buildClientsList());

        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                verifyRowToEnableEditAndDeleteButtons();
            }
        });
    }

    private void editClient() {
        new ManageClient(getClientFromRow(clientTable.getSelectedRow()));
    }

    private void deleteClient() {
        new DeletarCliente(getClientFromRow(clientTable.getSelectedRow()));
    }

    private void addNewClient() {
        new ManageClient(null);
    }

    private void verifyRowToEnableEditAndDeleteButtons() {
        if(clientTable.getSelectedRow() != 0) {
            editClientButton.setEnabled(true);
            deleteClientButton.setEnabled(true);
        } else {
            editClientButton.setEnabled(false);
            deleteClientButton.setEnabled(false);
        }
    }

    private void buildClientsList() {
        clientes = clienteController.buscarTodos();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "CPF"}, 0);
        clientTable.setModel(tableModel);
        tableModel.addRow(new Object[]{"ID", "Nome", "CPF"});

        for (Cliente cliente: clientes) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getNome()), (cliente.getCpf())});
        }
    }

    private Cliente getClientFromRow(int index) {
        return clientes.get(index-1);
    }

    public static void showScreen() {
        ClientsList clientsList = new ClientsList();
        clientsList.setLocationRelativeTo(null);
        clientsList.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        clientsList.setVisible(true);
    }

}
