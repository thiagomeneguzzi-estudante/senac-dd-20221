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

public class NovoCliente extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JComboBox comboBoxEnderecos;
    private JButton button1;
    private JPanel panel;

    EnderecoController enderecoController = new EnderecoController();
    ArrayList<Endereco> enderecos = enderecoController.buscarTodos();

    public NovoCliente() {
        setContentPane(panel);
        setSize(750, 250);
        buscarEnderecos();

        comboBoxEnderecos.setSelectedIndex(-1);


        button1.addActionListener(e -> {
            Cliente cliente = new Cliente();
            ClienteController clienteController = new ClienteController();
            cliente.setNome(nome.getText());
            cliente.setCpf(cpf.getText());
            cliente.setEndereco((Endereco) comboBoxEnderecos.getSelectedItem());
            String mensagem = clienteController.criar(cliente);
            JOptionPane.showMessageDialog(null, mensagem, "Adicionar cliente", JOptionPane.INFORMATION_MESSAGE);
            clearClientForm();
        });

        cpf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String insertedCPF = cpf.getText();
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.buscarClientePorCPF(insertedCPF);
                if(cliente.getId() != 0) {
                    nome.setText(cliente.getNome());
                    for (int i = 0; i < enderecos.toArray().length; i++) {
                        if(enderecos.get(i).getId() == cliente.getEndereco().getId()) {
                            comboBoxEnderecos.setSelectedIndex(i);
                        }
                    }
                } else {
                    clearClientForm();
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

    public static void showScreen(){
        NovoCliente cliente = new NovoCliente();
        cliente.setLocationRelativeTo(null);
        cliente.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cliente.setVisible(true);
    }
}
