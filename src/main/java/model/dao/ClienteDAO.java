package model.dao;

import model.entity.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    public Cliente criar(Cliente cliente) {
        Connection conexao = Banco.getConnection();
        String sql = "INSERT INTO CLIENTE (NOME, CPF, IDENDERECO) VALUES (?, ?, ?)";
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
        Connection conexao = Banco.getConnection();
        String sql = "UPDATE CLIENTE SET NOME = ?, CPF = ?, IDENDERECO = ? " +
                "WHERE ID = "+ cliente.getId();
        PreparedStatement pstmt = Banco.getPreparedStatement(conexao, sql);

        boolean retorno = false;
        try {
            assert pstmt != null;

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setInt(3, cliente.getEndereco().getId());

            if (pstmt.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: "+ e.getMessage());
        } finally {
            Banco.closeStatement(pstmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    public boolean remover(int idCliente) {
        Connection conexao = Banco.getConnection();
        String sql = "DELETE FROM CLIENTE WHERE id = "+idCliente;
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;

        try {
            if(!verificarLinhasAtivas(idCliente)) {
                assert stmt != null;
                if (stmt.executeUpdate(sql) == 1) {
                    retorno = true;
                }
            }


        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }

    private boolean verificarLinhasAtivas(int idCliente) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT count(*) FROM LINHA_TELEFONICA WHERE idCliente = "+idCliente;
        Statement stmt = Banco.getStatement(conexao);

        boolean retorno = false;
        try {

            ResultSet resultado = stmt.executeQuery(sql);
            if(resultado.next()) {
                retorno = resultado.getInt(1) > 0;
            }


        } catch (SQLException e) {
            System.out.println("Erro ao verificar linhas ativas de cliente: "+ e.getMessage());

        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }
        return retorno;
    }

    public Cliente buscarPorId(int id) {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM CLIENTE WHERE ID = "+ id;
        Statement stmt = Banco.getStatement(conexao);

        Cliente cliente = new Cliente();
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            if(resultado.next()) {
                cliente.setId(id);
                cliente.setNome(resultado.getString(2));
                cliente.setCpf(resultado.getString(3));
                cliente.setEndereco(enderecoDAO.buscarUnico(resultado.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por id: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return cliente;
    }

    public ArrayList<Cliente> buscarTodos() {
        Connection conexao = Banco.getConnection();
        String sql = "SELECT * FROM CLIENTE";
        Statement stmt = Banco.getStatement(conexao);

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setCpf(resultado.getString(3));
                cliente.setEndereco(enderecoDAO.buscarUnico(resultado.getInt(4)));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os clientes: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return clientes;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        Connection conexao = Banco.getConnection();
        String sql = "select * from cliente where cpf = "+ cpf;

        PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

        Cliente cliente = new Cliente();
        EnderecoDAO enderecoDAO = new EnderecoDAO();



        try {
            assert stmt != null;
            ResultSet resultado = stmt.executeQuery(sql);
            if(resultado.next()) {
                cliente.setId(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setCpf(resultado.getString(3));
                cliente.setEndereco(enderecoDAO.buscarUnico(resultado.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por cpf: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return cliente;
    }

    public boolean verificarCPF(String cpf) {
        boolean retorno = false;
        Connection conexao = Banco.getConnection();
        String sql = "SELECT count(ID) FROM CLIENTE where cpf = ?";

        PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


        try {
            stmt.setString(1, cpf);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()) {
                retorno = resultado.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os clientes: "+ e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conexao);
        }

        return retorno;
    }
}
