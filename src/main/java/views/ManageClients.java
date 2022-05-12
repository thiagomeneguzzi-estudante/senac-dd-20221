package views;

import controller.ClienteController;
import controller.EnderecoController;
import model.entity.Cliente;
import model.entity.Endereco;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ManageClients extends JPanel {

    private JTextField nome;
    private JTextField cpf;
    private JComboBox<Endereco> comboBoxAddresses;
    private JButton button1;
    private JPanel panel;

    private static final EnderecoController enderecoController = new EnderecoController();
    private ArrayList<Endereco> enderecos = enderecoController.buscarTodos();
    private Cliente cliente = new Cliente();
    private static final ClienteController clienteController = new ClienteController();

    ManageClients(Cliente clientToEdit) {
        add(panel);
        findAddresses();

        comboBoxAddresses.setSelectedIndex(-1);

        button1.addActionListener(e -> {
            if(clientToEdit != null) {
                cliente.setId(clientToEdit.getId());
                cliente.setNome(nome.getText());
                cliente.setCpf(cpf.getText());
                cliente.setEndereco((Endereco) comboBoxAddresses.getSelectedItem());
                String mensagem = clienteController.editar(cliente, clientToEdit.getCpf());
                JOptionPane.showMessageDialog(null, mensagem, "Editar cliente", JOptionPane.INFORMATION_MESSAGE);
                clearClientForm();
            } else {
                cliente.setNome(nome.getText());
                cliente.setCpf(cpf.getText());
                cliente.setEndereco((Endereco) comboBoxAddresses.getSelectedItem());
                String mensagem = clienteController.criar(cliente);
                JOptionPane.showMessageDialog(null, mensagem, "Adicionar cliente", JOptionPane.INFORMATION_MESSAGE);
                clearClientForm();
            }

        });

        cpf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String insertedCPF = cpf.getText();
                Cliente client = clienteController.buscarClientePorCPF(insertedCPF);
                if(client.getId() != 0) {
                    nome.setText(client.getNome());
                    for (int i = 0; i < enderecos.toArray().length; i++) {
                        if(enderecos.get(i).getId() == client.getEndereco().getId()) {
                            comboBoxAddresses.setSelectedIndex(i);
                        }
                    }
                }
            }
        });
        cpf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);

                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    String insertedCPF = cpf.getText();
                    Cliente client = clienteController.buscarClientePorCPF(insertedCPF);
                    if(client != null) {
                        nome.setText(client.getNome());
                        for (int i = 0; i < enderecos.toArray().length; i++) {
                            if(enderecos.get(i).getId() == client.getEndereco().getId()) {
                                comboBoxAddresses.setSelectedIndex(i);
                            }
                        }
                    }
                }
            }
        });

        if(clientToEdit != null) {
            setEditableClient(clientToEdit);
        }

    }

    private void setEditableClient(Cliente clientToEdit) {
        nome.setText(clientToEdit.getNome());
        cpf.setText(clientToEdit.getCpf());
        for (int i = 0; i < enderecos.toArray().length; i++) {
            if(enderecos.get(i).getId() == clientToEdit.getEndereco().getId()) {
                comboBoxAddresses.setSelectedIndex(i);
            }
        }
    }

    private void clearClientForm() {
        nome.setText("");
        cpf.setText("");
        comboBoxAddresses.setSelectedItem(null);
    }

    private void findAddresses() {
        for (Endereco endereco: enderecos) {
            comboBoxAddresses.addItem(endereco);
        }
    }

}
