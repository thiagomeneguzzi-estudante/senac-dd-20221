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
    private JButton addButton;
    private JButton deleteButton;
    private JButton refreshTableButton;
    private JPanel jpanel;
    private JButton editarButton;

    ClienteController clienteController = new ClienteController();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    ClientsList() {
        setContentPane(jpanel);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
        clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        editarButton.setEnabled(false);
        deleteButton.setEnabled(false);

        criarLista();

        addButton.addActionListener(e -> {
            new ManageClient(null);
        });
        deleteButton.addActionListener(e -> {
            new DeletarCliente(getClientFromRow(clientTable.getSelectedRow()));
        });
        editarButton.addActionListener(e -> {
            new ManageClient(getClientFromRow(clientTable.getSelectedRow()));
        });
        refreshTableButton.addActionListener(e -> criarLista());

        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(clientTable.getSelectedRow() != 0) {
                    editarButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                } else {
                    editarButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }

            }
        });
    }

    private void criarLista() {
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
