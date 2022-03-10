package model.dao;

import model.entity.Endereco;

import java.sql.*;
import java.util.ArrayList;

public class EnderecoDAO {

    public Endereco criar(Endereco novoEndereco) {
        Connection conexao = Banco.getConnection();
        String sql = "INSERT INTO ENDERECO(RUA, UF, CIDADE, NUMERO, CEP) " +
                "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conexao, sql);
        try {
            assert pstmt != null;

            pstmt.setString(1, novoEndereco.getRua());
            pstmt.setString(2, novoEndereco.getUf());
            pstmt.setString(3, novoEndereco.getCidade());
            pstmt.setInt(4, novoEndereco.getNumero());
            pstmt.setString(5, novoEndereco.getCep());

            pstmt.execute();
            ResultSet resultado = pstmt.getGeneratedKeys();

            if(resultado.next()) {
                novoEndereco.setId(resultado.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir endereço no EnderecoDAO: "+ e.getMessage());
        } finally {
            Banco.closeStatement(pstmt);
            Banco.closeConnection(conexao);
        }

        return novoEndereco;
    }

    public boolean atualizar(Endereco enderecoAtualizado) {
        Connection conexao = Banco.getConnection();
        String sql = "UPDATE ENDERECO SET RUA = ?, UF = ?, CIDADE = ?, NUMERO = ?, CEP = ? " +
            "WHERE ID = "+ enderecoAtualizado.getId();
        PreparedStatement pstmt = Banco.getPreparedStatement(conexao, sql);

        boolean retorno = false;
        try {
            assert pstmt != null;

            pstmt.setString(1, enderecoAtualizado.getRua());
            pstmt.setString(2, enderecoAtualizado.getUf());
            pstmt.setString(3, enderecoAtualizado.getCidade());
            pstmt.setInt(4, enderecoAtualizado.getNumero());
            pstmt.setString(5, enderecoAtualizado.getCep());

            if (pstmt.executeUpdate() > 0) {
              retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar endereço: "+ e.getMessage());
        } finally {
            Banco.closeStatement(pstmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public Endereco buscarUnico(int idEndereco) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM ENDERECO WHERE ID = "+ idEndereco;
        Statement stmt = Banco.getStatement(conexao);

        Endereco endereco = new Endereco();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            if(resultado.next()) {
                endereco.setId(idEndereco);
                endereco.setRua(resultado.getString(2));
                endereco.setUf(resultado.getString(3));
                endereco.setCidade(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setCep(resultado.getString(6));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereço por id: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return endereco;
    }

    public ArrayList<Endereco> buscarTodos() {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM ENDERECO";
        Statement stmt = Banco.getStatement(conexao);

        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(resultado.getInt(1));
                endereco.setRua(resultado.getString(2));
                endereco.setUf(resultado.getString(3));
                endereco.setCidade(resultado.getString(4));
                endereco.setNumero(resultado.getInt(5));
                endereco.setCep(resultado.getString(6));

                enderecos.add(endereco);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereço por id: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return enderecos;
    }

    public boolean remover(int idEndereco) {
        Connection conexao = Banco.getConnection();
        String sql = "DELETE FROM ENDERECO WHERE id = "+idEndereco;
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;

        try {
            assert stmt != null;
            if (stmt.executeUpdate(sql) == 1) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar endereço: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

}
