package model.bo;

import model.dao.ClienteDAO;
import model.entity.Cliente;

import java.util.ArrayList;
import java.util.Objects;

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

    public ArrayList<Cliente> buscarTodos() {
        return clienteDAO.buscarTodos();
    }

    public boolean remover(int id) {
        return clienteDAO.remover(id);
    }

    public Cliente buscarClientePorCPF(String cpf) {
        return clienteDAO.buscarClientePorCPF(cpf);
    }

    public String editar(Cliente cliente, String actualCpf) {
        String mensagem;

        if(!Objects.equals(actualCpf, cliente.getCpf()) && clienteDAO.verificarCPF(cliente.getCpf())) {
            mensagem = "CPF informado ("+cliente.getCpf()+") já cadastrado!";
        } else {
            boolean clienteAtualizado = clienteDAO.atualizar(cliente);
            if(clienteAtualizado) {
                mensagem = "Cliente atualizado com sucesso!";
            } else  {
                mensagem = "Erro ao atualizar cliente";
            }
        }

        return mensagem;
    }
}
