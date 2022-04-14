package views;

import controller.ClienteController;
import controller.LinhaTelefonicaController;
import controller.TelefoneController;
import model.entity.Cliente;
import model.entity.LinhaTelefonica;
import model.entity.Telefone;

import javax.swing.*;
import java.util.ArrayList;

public class AssociateClientWithPhone extends JPanel{
    private JComboBox clientComboBox;
    private JComboBox phoneComboBox;
    private JButton associateButton;
    private JButton clearLineButton;
    private JPanel panel;
    static LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
    static LinhaTelefonica linhaTelefonica = new LinhaTelefonica();
    ArrayList<Telefone> telefones = new ArrayList<Telefone>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    AssociateClientWithPhone() {

        add(panel);
        setSize(750, 250);

        updateData();

        associateButton.addActionListener(e -> criarLinha());
        phoneComboBox.addActionListener(e -> verifyIsActive());
        clearLineButton.addActionListener(e-> disableLine());
    }

    private void disableLine() {
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        String message = linhaTelefonicaController.desativarLinha(telefone.getId());
        JOptionPane.showMessageDialog(null, message, "Criar linha telefonica", JOptionPane.INFORMATION_MESSAGE);
        updateData();
    }

    private void verifyIsActive() {
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        if(telefone != null) {
            boolean isActive = telefone.isAtivo();
            int clientId = linhaTelefonicaController.getClientIdByPhoneId(telefone.getId());
            if(isActive && clientId > 0) {
                for (Cliente cliente: clientes) {
                    if(cliente.getId() == clientId) {
                        clientComboBox.setSelectedItem(cliente);
                    }
                }
            }
            clientComboBox.setEnabled(!isActive);
            clearLineButton.setEnabled(isActive);
            associateButton.setEnabled(!isActive);
        }

    }

    private void criarLinha() {
        Cliente cliente = (Cliente) clientComboBox.getSelectedItem();
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        linhaTelefonica.setIdCliente(cliente.getId());
        linhaTelefonica.setIdTelefone(telefone.getId());
        String message = linhaTelefonicaController.criar(linhaTelefonica);
        JOptionPane.showMessageDialog(null, message, "Criar linha telefonica", JOptionPane.INFORMATION_MESSAGE);
        updateData();
    }

    private void updateData() {
        searchPhones();
        searchClients();
        clearLineButton.setEnabled(false);
        associateButton.setEnabled(false);
    }

    private void searchPhones() {
        TelefoneController telefoneController = new TelefoneController();
        phoneComboBox.removeAllItems();
        telefones = telefoneController.buscarTodos();

        for (Telefone telefone : telefones) {
            phoneComboBox.addItem(telefone);
        }
        phoneComboBox.setSelectedIndex(-1);
    }

    private void searchClients() {
        ClienteController clienteController = new ClienteController();
        clientComboBox.removeAllItems();
        clientes = clienteController.buscarTodos();

        for (Cliente cliente : clientes) {
            clientComboBox.addItem(cliente);
        }
        clientComboBox.setSelectedIndex(-1);
    }

}
