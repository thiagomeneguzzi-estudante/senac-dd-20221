package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class ClientsList extends JPanel {
    private JTable clientTable;
    private JButton addClientButton;
    private JButton deleteClientButton;
    private JButton refreshTableButton;
    private JPanel jpanel;
    private JButton editClientButton;

    private static final ClienteController clienteController = new ClienteController();
    private ArrayList<Cliente> clientes;

    ClientsList() {
        add(jpanel);

        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        editClientButton.setEnabled(false);
        deleteClientButton.setEnabled(false);

        buildClientsList();

        deleteClientButton.addActionListener(e -> removeClient());
        refreshTableButton.addActionListener(e -> buildClientsList());
        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(clientTable.getSelectedRow());
                verifyRowToEnableEditAndDeleteButtons();
            }
        });
    }

    private void verifyRowToEnableEditAndDeleteButtons() {
        if(clientTable.getSelectedRow() >= 0) {
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

        for (Cliente cliente: clientes) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getNome()), (cliente.getCpf())});
        }
    }

    private Cliente getClientFromRow(int index) {
        return clientes.get(index);
    }

    public void removeClient() {
        Cliente cliente = getSelectedClient();
        int option = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar este cliente?", "Deletar cliente", JOptionPane.YES_NO_OPTION);
        if(option == 0) {
            String message = clienteController.remover(cliente.getId());
            JOptionPane.showMessageDialog(null, message, "Deletar cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public JButton getEditClientButton() {
        return editClientButton;
    }

    public Cliente getSelectedClient() {
        return getClientFromRow(clientTable.getSelectedRow());
    }

    public JButton getAddClientButton() {
        return addClientButton;
    }

}
