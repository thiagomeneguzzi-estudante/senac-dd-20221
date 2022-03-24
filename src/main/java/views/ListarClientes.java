package views;

import controller.ClienteController;
import model.entity.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarClientes extends  JFrame{
    private JTable table1;
    private JPanel panel1;
    private JButton button1;
    private JButton excluirButton;
    private JButton atualizarTabelaButton;
    String col[] = {"ID", "Nome", "CPF"};

    ListarClientes() {
        setContentPane(panel1);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));

        criarLista();

        button1.addActionListener(e -> {
            NovoCliente.showScreen();
        });
        excluirButton.addActionListener(e -> {
            DeletarCliente.showScreen();
        });
        atualizarTabelaButton.addActionListener(e -> {
            criarLista();
        });
    }

    private void criarLista() {
        ClienteController clienteController = new ClienteController();
        ArrayList<Cliente> clientes = clienteController.buscarTodos();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        table1.setModel(tableModel);

        for (Cliente cliente: clientes) {
            tableModel.addRow(new Object[]{(cliente.getId()), (cliente.getNome()), (cliente.getCpf())});
        }
    }

    public static void showScreen() {
        ListarClientes listaClientes = new ListarClientes();
        listaClientes.setLocationRelativeTo(null);
        listaClientes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listaClientes.setVisible(true);
    }

    public static void dismissScreen() {
        ListarClientes listaClientes = new ListarClientes();
        listaClientes.dispose();
    }

}
