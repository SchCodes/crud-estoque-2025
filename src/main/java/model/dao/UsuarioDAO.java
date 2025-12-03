package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 * CRUD de usuario.
 */
public class UsuarioDAO {

    public void create(Usuario u) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO usuario(login, senha, email) VALUES (?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Usuario. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public ArrayList<Usuario> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM usuario";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                lista.add(u);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Usuarios. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return lista;
    }

    public Usuario read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM usuario WHERE id_usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                return u;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Usuario. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return null;
    }

    public void update(Usuario u) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE usuario SET login = ?, senha = ?, email = ? WHERE id_usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setString(3, u.getEmail());
            stmt.setInt(4, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Usuario. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(Usuario u) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM usuario WHERE id_usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Usuario. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
