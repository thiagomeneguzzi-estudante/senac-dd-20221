
import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.entity.Endereco;
import model.entity.Telefone;

public class Main {

    public static void main(String[] args) {

//        Endereco endereco = new Endereco("Mauro Ramos", "88047655", "SC", "Florianópolis", 268);
//        EnderecoDAO enderecoDAO = new EnderecoDAO();
//        enderecoDAO.criar(endereco);
//        endereco.setCidade("Florianópolis");
//        endereco.setId(2);
//        boolean atualizou = enderecoDAO.atualizar(endereco);
//        System.out.println(atualizou);
//        boolean atualizou = enderecoDAO.remover(1);
//        System.out.println(atualizou);
//        ArrayList<Endereco> enderecos = enderecoDAO.buscarTodos();
//        System.out.println(enderecos);

        Telefone telefone = new Telefone("991857390", "48", "55", 1, true);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.criar(telefone);

    }
}
