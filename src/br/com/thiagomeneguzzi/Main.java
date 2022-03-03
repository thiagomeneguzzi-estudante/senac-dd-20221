package br.com.thiagomeneguzzi;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Telefone> telefones1 = new ArrayList<Telefone>();

        Endereco endereco1 = new Endereco("Rua 14 Bis", 88047655, "Santa catarina", "Florianópolis", 268);
        Telefone telefone1 = new Telefone(991857390, 48, 55, Telefone.TIPO_FIXO, true);

        telefones1.add(telefone1);

        Cliente cliente1 = new Cliente("Thiago", "114.817.649-77", telefones1, endereco1);

        clientes.add(cliente1);

        System.out.println(clientes.get(0).toString());

    }
}
