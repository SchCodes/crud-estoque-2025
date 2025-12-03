package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Compra;
import model.bean.Fornecedor;
import model.bean.Usuario;

/**
 * CRUD de compra (fk fornecedor e usuario).
 */
public class CompraDAO {

    public void create(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "INSERT INTO compra(id_fornecedor, id_usuario) VALUES (?,?)";
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, c.getFornecedor().getId());
            stmt.setInt(2, c.getUsuario().getId());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }

    public ArrayList<Compra> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Compra> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM compra";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            while (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id_compra"));
                Fornecedor f = fornecedorDAO.read(rs.getInt("id_fornecedor"));
                Usuario u = usuarioDAO.read(rs.getInt("id_usuario"));
                c.setFornecedor(f);
                c.setUsuario(u);
                lista.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Compras. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return lista;
    }

    public Compra read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM compra WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id_compra"));
                Fornecedor f = new FornecedorDAO().read(rs.getInt("id_fornecedor"));
                Usuario u = new UsuarioDAO().read(rs.getInt("id_usuario"));
                c.setFornecedor(f);
                c.setUsuario(u);
                return c;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return null;
    }

    public void update(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE compra SET id_fornecedor = ?, id_usuario = ? WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, c.getFornecedor().getId());
            stmt.setInt(2, c.getUsuario().getId());
            stmt.setInt(3, c.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM compra WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
