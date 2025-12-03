package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Usuario;
import model.bean.Venda;

/**
 * CRUD de venda (fk cliente e usuario).
 */
public class VendaDAO {

    public void create(Venda v) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "INSERT INTO venda(id_cliente, id_usuario) VALUES (?,?)";
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, v.getCliente().getId());
            stmt.setInt(2, v.getUsuario().getId());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                v.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }

    public ArrayList<Venda> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM venda";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            ClienteDAO clienteDAO = new ClienteDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id_venda"));
                Cliente c = clienteDAO.read(rs.getInt("id_cliente"));
                Usuario u = usuarioDAO.read(rs.getInt("id_usuario"));
                v.setCliente(c);
                v.setUsuario(u);
                lista.add(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Vendas. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return lista;
    }

    public Venda read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM venda WHERE id_venda = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id_venda"));
                Cliente c = new ClienteDAO().read(rs.getInt("id_cliente"));
                Usuario u = new UsuarioDAO().read(rs.getInt("id_usuario"));
                v.setCliente(c);
                v.setUsuario(u);
                return v;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return null;
    }

    public void update(Venda v) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE venda SET id_cliente = ?, id_usuario = ? WHERE id_venda = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, v.getCliente().getId());
            stmt.setInt(2, v.getUsuario().getId());
            stmt.setInt(3, v.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(Venda v) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM venda WHERE id_venda = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, v.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
