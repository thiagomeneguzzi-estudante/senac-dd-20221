package views;

import controller.ClienteController;
import controller.EnderecoController;
import model.entity.Cliente;
import model.entity.Endereco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AddressList extends JPanel{
    private JPanel panel1;
    private JTable addressTable;
    private JButton deleteButton;
    private JButton addButton;
    private JButton refreshTableButton;

    public AddressList() {
        add(panel1);
        setSize(550, 350);
        setMinimumSize(new Dimension(550, 250));
        addressTable.setEnabled(false);

        criarLista();

//        addButton.addActionListener(e -> );
//        deleteButton.addActionListener(e -> );
        refreshTableButton.addActionListener(e -> criarLista());
    }

    private void criarLista() {
        EnderecoController enderecoController = new EnderecoController();
        ArrayList<Endereco> enderecos = enderecoController.buscarTodos();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Rua", "CEP", "Cidade", "UF"}, 0);
        addressTable.setModel(tableModel);
        tableModel.addRow(new Object[]{"ID", "Rua", "CEP", "Cidade", "UF"});

        for (Endereco endereco: enderecos) {
            tableModel.addRow(new Object[]{(endereco.getId()), (endereco.getRua()), (endereco.getCep()), (endereco.getCidade()), (endereco.getUf())});
        }
    }

}
