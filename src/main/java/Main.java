
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.LinhaTelefonicaDAO;
import model.dao.TelefoneDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.LinhaTelefonica;
import model.entity.Telefone;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        Endereco endereco = new Endereco("Mauro Ramos", "88047655", "SC", "Florianópolis", 268);
//        EnderecoDAO enderecoDAO = new EnderecoDAO();
//        Endereco enderecoAdicionado = enderecoDAO.criar(endereco);
//
//        Cliente cliente = new Cliente("Thiago", "11481764977", null, enderecoAdicionado);
//        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente clienteCriado = clienteDAO.criar(cliente);
//        System.out.println(clienteCriado);
//        clienteAdded.setNome("Leonardo");
//        boolean removeu = clienteDAO.remover(1);
//        System.out.println(removeu);

//        endereco.setCidade("Florianópolis");
//        endereco.setId(2);
//        boolean atualizou = enderecoDAO.atualizar(endereco);
//        System.out.println(atualizou);
//        boolean atualizou = enderecoDAO.remover(1);
//        System.out.println(atualizou);
//        ArrayList<Endereco> enderecos = enderecoDAO.buscarTodos();
//        System.out.println(enderecos);

//        Telefone telefone = new Telefone("99188192", "51", "332", 1, false);
//        TelefoneDAO telefoneDAO = new TelefoneDAO();
//        telefoneDAO.criar(telefone);
//        telefoneDAO.remover(1);

//        LinhaTelefonica linha = new LinhaTelefonica(3, 2);
        LinhaTelefonicaDAO linhaDAO = new LinhaTelefonicaDAO();
//        linhaDAO.criar(linha);

//        ArrayList<Telefone> telefones = linhaDAO.buscarLinhasPorCliente(2);
//        System.out.println(telefones);
        boolean desativou = linhaDAO.desativarLinhaTelefonica(4);
        System.out.println(desativou);
    }
}
