package model.bo;

import model.dao.EnderecoDAO;
import model.entity.Endereco;

import java.util.ArrayList;

public class EnderecoBO {

    public Endereco criar(Endereco endereco) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.criar(endereco);
    }

    public ArrayList<Endereco> buscarTodos() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.buscarTodos();
    }
}
