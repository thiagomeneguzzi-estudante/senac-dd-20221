package views;

import controller.EnderecoController;
import model.entity.Endereco;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AddressList extends JPanel {
    private JPanel panel1;
    private JTable addressTable;
    private JButton deleteAddressButton;
    private JButton addAddressButton;
    private JButton refreshTableButton;
    private JButton editAddressButton;

    public AddressList() {
        add(panel1);
        addressTable.setEnabled(false);

        criarLista();

        addAddressButton.addActionListener(e -> addNewAddress());
        deleteAddressButton.addActionListener(e -> deleteAddress());
        editAddressButton.addActionListener(e -> editAddress());
        refreshTableButton.addActionListener(e -> criarLista());
    }

    private void addNewAddress() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteAddress() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void editAddress() {
        JOptionPane.showMessageDialog(null, "Método ainda não implementado", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void criarLista() {
        EnderecoController enderecoController = new EnderecoController();
        ArrayList<Endereco> enderecos = enderecoController.buscarTodos();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Rua", "CEP", "Cidade", "UF"}, 0);
        addressTable.setModel(tableModel);

        for (Endereco endereco: enderecos) {
            tableModel.addRow(new Object[]{(endereco.getId()), (endereco.getRua()), (endereco.getCep()), (endereco.getCidade()), (endereco.getUf())});
        }
    }

}
