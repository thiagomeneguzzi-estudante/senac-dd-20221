package model.dao;

import model.entity.Telefone;
import selector.PhoneSelector;

import java.sql.*;
import java.util.ArrayList;

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
            System.out.println("Erro ao inserir telefone: "+ error.getMessage());
        }
        return novoTelefone;
    }

    public boolean atualizar(Telefone telefone) {
        Connection conexao = Banco.getConnection();
        String sql = "UPDATE TELEFONE SET DDD = ?, NUMERO = ?, TIPO = ?, ATIVO = ?, DDI = ? " +
                "WHERE ID = "+ telefone.getId();
        PreparedStatement pstmt = Banco.getPreparedStatement(conexao, sql);

        boolean retorno = false;
        try {
            assert pstmt != null;

            pstmt.setString(1, telefone.getDdd());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setInt(3, telefone.getTipo());
            pstmt.setBoolean(4, telefone.isAtivo());
            pstmt.setString(5, telefone.getDdi());

            if (pstmt.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar telefone: "+ e.getMessage());
        } finally {
            Banco.closeStatement(pstmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public boolean remover(int idTelefone) {
        Connection conexao = Banco.getConnection();
        String sql = "DELETE FROM TELEFONE WHERE id = "+idTelefone;
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;

        try {
            assert stmt != null;
            if (stmt.executeUpdate(sql) == 1) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover telefone: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public Telefone buscarPorId(int idTelefone) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM TELEFONE WHERE ID = "+ idTelefone;
        Statement stmt = Banco.getStatement(conexao);

        Telefone telefone = new Telefone();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            if(resultado.next()) {
                telefone.setId(idTelefone);
                telefone.setDdd(resultado.getString(2));
                telefone.setNumero(resultado.getString(3));
                telefone.setTipo(resultado.getInt(4));
                telefone.setAtivo(resultado.getBoolean(5));
                telefone.setDdi(resultado.getString(6));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar telefone por id: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return telefone;
    }

    public ArrayList<Telefone> buscarTodos() {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM TELEFONE";
        Statement stmt = Banco.getStatement(conexao);

        ArrayList<Telefone> telefones = new ArrayList<Telefone>();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                Telefone telefone = new Telefone();

                telefone.setId(resultado.getInt(1));
                telefone.setDdd(resultado.getString(2));
                telefone.setNumero(resultado.getString(3));
                telefone.setTipo(resultado.getInt(4));
                telefone.setAtivo(resultado.getBoolean(5));
                telefone.setDdi(resultado.getString(6));

                telefones.add(telefone);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os telefones: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return telefones;
    }

    public boolean isActive(int idTelefone) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT count(*) FROM TELEFONE WHERE ID = "+idTelefone+" and ativo = true";
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;

        try {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                retorno = result.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao verificar se linha telefônica está ativa: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public ArrayList<Telefone> buscarTodosComFiltro(PhoneSelector phoneSelector) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM TELEFONE";
        Statement stmt = Banco.getStatement(conexao);

        if(phoneSelector.temFiltro()) {
            sql = createQueryWithFilter(phoneSelector, sql);
        }

        ArrayList<Telefone> telefones = new ArrayList<Telefone>();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                Telefone telefone = new Telefone();

                telefone.setId(resultado.getInt(1));
                telefone.setDdd(resultado.getString(2));
                telefone.setNumero(resultado.getString(3));
                telefone.setTipo(resultado.getInt(4));
                telefone.setAtivo(resultado.getBoolean(5));
                telefone.setDdi(resultado.getString(6));

                telefones.add(telefone);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os telefones: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return telefones;
    }

    private String createQueryWithFilter(PhoneSelector phoneSelector, String sql) {

        sql += " WHERE ";
        boolean first = true;

        if ((phoneSelector.getDdi() != null) && (phoneSelector.getDdi().trim().length() > 0)) {
            if (!first) {
                sql += " AND ";
            }
            sql += "ddi LIKE '%" + phoneSelector.getDdi() + "%'";
            first = false;
        }

        if ((phoneSelector.getDdd() != null) && (phoneSelector.getDdd().trim().length() > 0)) {
            if (!first) {
                sql += " AND ";
            }
            sql += "ddd like '%" + phoneSelector.getDdd() + "%'";
            first = false;
        }

        if (phoneSelector.getEstado().equalsIgnoreCase("ativado") || phoneSelector.getEstado().equalsIgnoreCase("desativado")) {
            String active = phoneSelector.getEstado().equalsIgnoreCase("ativado") ? "1" : "0";
            if (!first) {
                sql += " AND ";
            }

            sql += "ativo = " + active ;
            first = false;
        }

        return sql;

    }
}
