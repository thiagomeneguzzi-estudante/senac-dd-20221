package controller;

import model.bo.ClienteBO;
import model.entity.Cliente;

public class ClienteController {

    public String criar(Cliente cliente) {
        ClienteBO clienteBO = new ClienteBO();

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
}
