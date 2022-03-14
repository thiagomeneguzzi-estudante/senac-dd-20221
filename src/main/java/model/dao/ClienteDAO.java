package model.dao;

import model.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public Cliente criar(Cliente cliente) {
        Connection conexao = Banco.getConnection();
        String sql = "INSERT INTO CLIENTE NOME = ?, CPF = ?, IDENDERECO = ?";
        PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conexao, sql);

        try {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setInt(3, cliente.getEndereco().getId());

            pstmt.execute();

            ResultSet resultado = pstmt.getGeneratedKeys();

            if(resultado.next()) {
                cliente.setId(resultado.getInt(1));
            }
        } catch (SQLException error) {
            System.out.println("Erro ao inserir cliente: "+ error.getMessage());
        }


        return cliente;
    }

    public boolean atualizar(Cliente cliente) {
        boolean retorno = false;

        return retorno;
    }

    public boolean remover(int idCliente) {
        boolean retorno = false;

        return retorno;
    }

    public Cliente buscarPorId(int id) {

        return null;
    }

    public ArrayList<Cliente> buscarTodos() {

        return null;
    }
}
