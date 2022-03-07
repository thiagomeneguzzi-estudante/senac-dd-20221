
import model.Cliente;
import model.Endereco;
import model.Telefone;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Endereco endereco1 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone1 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);
        ArrayList<Telefone> telefones1 = new ArrayList<Telefone>();
        telefones1.add(telefone1);
        Cliente cliente1 = new Cliente("Thiago", "114.817.649-77", telefones1, endereco1);
        clientes.add(cliente1);

        Endereco endereco2 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone2 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);
        ArrayList<Telefone> telefones2 = new ArrayList<Telefone>();
        telefones2.add(telefone2);
        Cliente cliente2 = new Cliente("Thiago", "114.817.649-77", telefones2, endereco2);
        clientes.add(cliente2);

        Endereco endereco3 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone3 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);
        ArrayList<Telefone> telefones3 = new ArrayList<Telefone>();
        telefones3.add(telefone3);
        Cliente cliente3 = new Cliente("Thiago", "114.817.649-77", telefones3, endereco3);
        clientes.add(cliente3);

        Endereco endereco4 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone4 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);
        ArrayList<Telefone> telefones4 = new ArrayList<Telefone>();
        telefones4.add(telefone4);
        Cliente cliente4 = new Cliente("Thiago", "114.817.649-77", telefones4, endereco4);
        clientes.add(cliente4);

        Endereco endereco5 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone5 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);
        ArrayList<Telefone> telefones5 = new ArrayList<Telefone>();
        telefones5.add(telefone5);
        Cliente cliente5 = new Cliente("Thiago", "114.817.649-77", telefones5, endereco5);
        clientes.add(cliente5);

        System.out.println(clientes.get(1).toString());

    }
}
