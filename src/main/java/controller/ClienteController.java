package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

import java.util.ArrayList;

public class ClienteController {

    static final ClienteBO clienteBO = new ClienteBO();

    public String criar(Cliente cliente) {
        String mensagem = "";
        if(cliente == null) {
            mensagem = "Informe todos os dados do novo cliente";
        } else if(cliente.getCpf().trim().length() != 11) {
            try{
                Long.parseLong(cliente.getCpf());
            } catch(NumberFormatException exception) {
                mensagem = "CPF deve ter somente números";
            }
            mensagem += "CPF deve conter 11 dígitos.";
        } else {
            mensagem = clienteBO.criar(cliente);
        }


        return mensagem;
    }

    public ArrayList<Cliente> buscarTodos() {
        return clienteBO.buscarTodos();
    }

    public boolean remover(int id) {
        return clienteBO.remover(id);
    }
}
