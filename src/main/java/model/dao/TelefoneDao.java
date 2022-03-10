package model.dao;

import model.entity.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TelefoneDAO {

    public Telefone criar(Telefone novoTelefone) {
        Connection conexao = Banco.getConnection();
        String sql = "INSERT INTO TELEFONE(DDD, NUMERO, TIPO, ATIVO, DDI) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conexao, sql);

        try {
            pstmt.setString(1, novoTelefone.getDdd());
            pstmt.setString(2, novoTelefone.getNumero());
            pstmt.setInt(3, novoTelefone.getTipo());
            pstmt.setBoolean(4, novoTelefone.isAtivo());
            pstmt.setString(5, novoTelefone.getDdi());

            pstmt.execute();

            ResultSet resultado = pstmt.getGeneratedKeys();

            if(resultado.next()) {
                novoTelefone.setId(resultado.getInt(1));
            }

        } catch (SQLException error) {
            System.out.println("Erro ao inserir telefone no TelefoneDAO: "+ error.getMessage());
        }
        return novoTelefone;
    }

    public boolean atualizar(Telefone novoTelefone) {

        return false;
    }

    public boolean remover(Telefone novoTelefone) {

        return false;
    }

    public Telefone buscarPorId(int id) {

        return null;
    }

    public List<Telefone> buscarTodos() {

        return null;
    }
}
