package views;

import controller.ClienteController;
import controller.LinhaTelefonicaController;
import controller.TelefoneController;
import model.entity.Cliente;
import model.entity.LinhaTelefonica;
import model.entity.Telefone;

import javax.swing.*;
import java.util.ArrayList;

public class AssociateClientWithPhone extends JFrame{
    private JComboBox clientComboBox;
    private JComboBox phoneComboBox;
    private JButton associateButton;
    private JButton clearLineButton;
    private JPanel panel;
    static LinhaTelefonicaController linhaTelefonicaController = new LinhaTelefonicaController();
    static LinhaTelefonica linhaTelefonica = new LinhaTelefonica();

    AssociateClientWithPhone() {

        setContentPane(panel);
        setSize(750, 250);

        searchClients();
        searchPhones();
        verifyIsActive();

        associateButton.addActionListener(e -> criarLinha());
        phoneComboBox.addActionListener(e -> verifyIsActive());
        clearLineButton.addActionListener(e-> disableLine());
    }

    private void disableLine() {
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        String message = linhaTelefonicaController.desativarLinha(telefone.getId());
        JOptionPane.showMessageDialog(null, message, "Criar linha telefonica", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verifyIsActive() {
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        boolean isActive = telefone.isAtivo();
        clearLineButton.setEnabled(isActive);
        associateButton.setEnabled(!isActive);
    }

    private void criarLinha() {
        Cliente cliente = (Cliente) clientComboBox.getSelectedItem();
        Telefone telefone = (Telefone) phoneComboBox.getSelectedItem();
        linhaTelefonica.setIdCliente(cliente.getId());
        linhaTelefonica.setIdTelefone(telefone.getId());
        String message = linhaTelefonicaController.criar(linhaTelefonica);
        JOptionPane.showMessageDialog(null, message, "Criar linha telefonica", JOptionPane.INFORMATION_MESSAGE);
    }

    private void searchPhones() {
        TelefoneController telefoneController = new TelefoneController();
        ArrayList<Telefone> telefones = telefoneController.buscarTodos();

        for (Telefone telefone : telefones) {
            phoneComboBox.addItem(telefone);
        }
    }

    private void searchClients() {
        ClienteController clienteController = new ClienteController();
        ArrayList<Cliente> clientes = clienteController.buscarTodos();

        for (Cliente cliente : clientes) {
            clientComboBox.addItem(cliente);
        }
    }


    public static void showScreen() {
        AssociateClientWithPhone associateClientWithPhone = new AssociateClientWithPhone();
        associateClientWithPhone.setLocationRelativeTo(null);
        associateClientWithPhone.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        associateClientWithPhone.setVisible(true);
    }
}
