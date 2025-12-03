package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;

/**
 * CRUD de fornecedor.
 */
public class FornecedorDAO {

    public void create(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            String query = "INSERT INTO fornecedor(nome, rua, numero, telefone) VALUES (?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getRua());
            stmt.setString(3, f.getNumero());
            stmt.setString(4, f.getTelefone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Fornecedor. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public ArrayList<Fornecedor> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM fornecedor";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setRua(rs.getString("rua"));
                f.setNumero(rs.getString("numero"));
                f.setTelefone(rs.getString("telefone"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Fornecedores. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return lista;
    }

    public Fornecedor read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM fornecedor WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setRua(rs.getString("rua"));
                f.setNumero(rs.getString("numero"));
                f.setTelefone(rs.getString("telefone"));
                return f;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return null;
    }

    public void update(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE fornecedor SET nome = ?, rua = ?, numero = ?, telefone = ? WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getRua());
            stmt.setString(3, f.getNumero());
            stmt.setString(4, f.getTelefone());
            stmt.setInt(5, f.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Fornecedor. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, f.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Fornecedor. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
