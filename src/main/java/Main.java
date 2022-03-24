import controller.ClienteController;
import controller.EnderecoController;
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.LinhaTelefonicaDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.LinhaTelefonica;
import views.DeletarCliente;
import views.NovoCliente;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DeletarCliente.showScreen();
    }

    private static void testarCadastroClienteComJOptionPane() {
        EnderecoController enderecoController = new EnderecoController();
        ClienteController clienteController = new ClienteController();
        ArrayList<Endereco> enderecos;

        enderecos = enderecoController.buscarTodos();

        String name = JOptionPane.showInputDialog(null, "Digite o nome do cliente: ", "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
        String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente: ", "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
        Endereco endereco = (Endereco) JOptionPane.showInputDialog(null, "Selecione o endereço", "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE, null, enderecos.toArray(), null);

        Cliente novoCliente = new Cliente(name, cpf, null, endereco);
        String mensagem = clienteController.criar(novoCliente);

        JOptionPane.showMessageDialog(null, mensagem, "Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void testarCadastroDeEndereco() {
        String rua = JOptionPane.showInputDialog(null, "Digite a rua: ", "Cadastro de endereço", JOptionPane.QUESTION_MESSAGE);
        String cep = JOptionPane.showInputDialog(null, "Digite a cep: ", "Cadastro de endereço", JOptionPane.QUESTION_MESSAGE);
        String uf = JOptionPane.showInputDialog(null, "Digite a uf: ", "Cadastro de endereço", JOptionPane.QUESTION_MESSAGE);
        String cidade = JOptionPane.showInputDialog(null, "Digite a cidade: ", "Cadastro de endereço", JOptionPane.QUESTION_MESSAGE);
        String numero = JOptionPane.showInputDialog(null, "Digite a numero: ", "Cadastro de endereço", JOptionPane.QUESTION_MESSAGE);

        Endereco endereco = new Endereco(rua, cep, uf, cidade, Integer.parseInt(numero));
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Endereco enderecoCriado = enderecoDAO.criar(endereco);

        if(enderecoCriado.getId() > 0) {
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso", "Cadastro de endereço", JOptionPane.INFORMATION_MESSAGE);
        } else  {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar endereço", "Cadastro de endereço", JOptionPane.ERROR_MESSAGE);
        }

    }

}
