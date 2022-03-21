package controller;

import model.bo.EnderecoBO;
import model.entity.Endereco;
import java.util.ArrayList;

public class EnderecoController {

    public Endereco criar(Endereco endereco) {
        EnderecoBO enderecoBO = new EnderecoBO();
        return enderecoBO.criar(endereco);
    }

    public ArrayList<Endereco> buscarTodos() {
        EnderecoBO enderecoBO = new EnderecoBO();
        return enderecoBO.buscarTodos();
    }
}
