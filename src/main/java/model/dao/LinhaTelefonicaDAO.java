package model.dao;

import model.entity.Cliente;
import model.entity.LinhaTelefonica;
import model.entity.Telefone;

import java.sql.*;
import java.util.ArrayList;

public class LinhaTelefonicaDAO {

    public LinhaTelefonica criar(LinhaTelefonica linha) {
        Connection conexao = Banco.getConnection();
        String sql = "INSERT INTO LINHA_TELEFONICA (IDTELEFONE, IDCLIENTE, DATAATIVACAO, DATADESATIVACAO) VALUES (?, ?, now(), null)";
        PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conexao, sql);

        try {
            pstmt.setInt(1, linha.getIdTelefone());
            pstmt.setInt(2, linha.getIdCliente());

            pstmt.execute();

            ResultSet resultado = pstmt.getGeneratedKeys();

            if(resultado.next()) {
                linha.setId(resultado.getInt(1));
            }
        } catch (SQLException error) {
            System.out.println("Erro ao criar linha telefonica: "+ error.getMessage());
        }

        return linha;
    }

    public boolean desativarLinhaTelefonica(int idLinha) {
        Connection conexao = Banco.getConnection();
        String sql = "UPDATE LINHA_TELEFONICA SET DATADESATIVACAO = now() WHERE id = "+idLinha;
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;

        try {
            assert stmt != null;
            if (stmt.executeUpdate(sql) == 1) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao desativar linha telefônica: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public ArrayList<Telefone> buscarLinhasPorCliente(int idCliente) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM LINHA_TELEFONICA WHERE IDCLIENTE = "+idCliente;
        Statement stmt = Banco.getStatement(conexao);

        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        TelefoneDAO telefoneDAO = new TelefoneDAO();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                Telefone telefone;
                telefone = telefoneDAO.buscarPorId(resultado.getInt(2));
                telefones.add(telefone);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os telefones por clientes: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return telefones;
    }

}
