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

public class ManageClient extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JComboBox<Endereco> comboBoxAddresses;
    private JButton button1;
    private JPanel panel;

    private static final EnderecoController enderecoController = new EnderecoController();
    private ArrayList<Endereco> enderecos = enderecoController.buscarTodos();
    private Cliente cliente = new Cliente();
    private static final ClienteController clienteController = new ClienteController();

    ManageClient(Cliente clientToEdit) {
        setContentPane(panel);
        setSize(750, 250);
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
                dispose();
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

        showScreen(clientToEdit);
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
        comboBoxAddresses.setSelectedItem(-1);
    }

    private void findAddresses() {
        for (Endereco endereco: enderecos) {
            comboBoxAddresses.addItem(endereco);
        }
    }

    public void showScreen(Cliente clientToEdit){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        if(clientToEdit != null) {
            setEditableClient(clientToEdit);
        }
        this.setVisible(true);
    }
}
