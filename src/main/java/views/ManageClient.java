package views;

import controller.ClienteController;
import controller.EnderecoController;
import model.dao.ClienteDAO;
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
    private JComboBox comboBoxEnderecos;
    private JButton button1;
    private JPanel panel;

    private static Cliente clientEdit;

    EnderecoController enderecoController = new EnderecoController();
    ArrayList<Endereco> enderecos = enderecoController.buscarTodos();
    Cliente cliente = new Cliente();
    ClienteController clienteController = new ClienteController();

    public ManageClient(Cliente clientToEdit) {
        setContentPane(panel);
        setSize(750, 250);
        buscarEnderecos();

        comboBoxEnderecos.setSelectedIndex(-1);

        button1.addActionListener(e -> {
            if(clientToEdit != null) {
                cliente.setId(clientToEdit.getId());
                cliente.setNome(nome.getText());
                cliente.setCpf(cpf.getText());
                cliente.setEndereco((Endereco) comboBoxEnderecos.getSelectedItem());
                String mensagem = clienteController.editar(cliente, clientToEdit.getCpf());
                JOptionPane.showMessageDialog(null, mensagem, "Editar cliente", JOptionPane.INFORMATION_MESSAGE);
                if(mensagem.equals("Cliente atualizado com sucesso!")) {
                    clearClientForm();
                    dispose();
                }
            } else {
                cliente.setNome(nome.getText());
                cliente.setCpf(cpf.getText());
                cliente.setEndereco((Endereco) comboBoxEnderecos.getSelectedItem());
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
                Cliente cliente = clienteController.buscarClientePorCPF(insertedCPF);
                if(cliente.getId() != 0) {
                    nome.setText(cliente.getNome());
                    for (int i = 0; i < enderecos.toArray().length; i++) {
                        if(enderecos.get(i).getId() == cliente.getEndereco().getId()) {
                            comboBoxEnderecos.setSelectedIndex(i);
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
                    ClienteDAO clienteDAO = new ClienteDAO();
                    Cliente cliente = clienteDAO.buscarClientePorCPF(insertedCPF);
                    if(cliente != null) {
                        nome.setText(cliente.getNome());
                        for (int i = 0; i < enderecos.toArray().length; i++) {
                            if(enderecos.get(i).getId() == cliente.getEndereco().getId()) {
                                comboBoxEnderecos.setSelectedIndex(i);
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
                comboBoxEnderecos.setSelectedIndex(i);
            }
        }
    }

    private void clearClientForm() {
        nome.setText("");
        cpf.setText("");
        comboBoxEnderecos.setSelectedItem(-1);
    }

    private void buscarEnderecos() {
        for (Endereco endereco: enderecos) {
            comboBoxEnderecos.addItem(endereco);
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
