package model.bo;

import model.dao.ClienteDAO;
import model.entity.Cliente;

public class ClienteBO {

    public ClienteDAO clienteDAO = new ClienteDAO();

    public String criar(Cliente cliente) {
        String mensagem;

        if(clienteDAO.verificarCPF(cliente.getCpf())) {
            mensagem = "CPF informado ("+cliente.getCpf()+") já cadastrado!";
        } else {
            cliente = clienteDAO.criar(cliente);
            if(cliente.getId() > 0) {
                mensagem = "Cliente salvo com sucesso ( Identificador: "+cliente.getId()+" )";
            } else  {
                mensagem = "Erro ao salvar cliente";
            }
        }

        return mensagem;
    }

}