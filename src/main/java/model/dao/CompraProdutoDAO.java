package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.CompraProduto;
import model.bean.Produto;

/**
 * Manipula itens de compra (tabela compra_produto).
 */
public class CompraProdutoDAO {

    public void create(CompraProduto cp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO compra_produto(id_compra, id_produto, quantidade) VALUES (?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, cp.getCompra().getId());
            stmt.setInt(2, cp.getProduto().getId());
            stmt.setInt(3, cp.getQuantidade());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item adicionado na compra!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar item na compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public ArrayList<CompraProduto> readByCompra(int idCompra) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<CompraProduto> itens = new ArrayList<>();
        try {
            String query = "SELECT * FROM compra_produto WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idCompra);
            rs = stmt.executeQuery();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            while (rs.next()) {
                CompraProduto cp = new CompraProduto();
                cp.setQuantidade(rs.getInt("quantidade"));
                cp.setProduto(produtoDAO.read(rs.getInt("id_produto")));
                // preenchendo apenas o id da compra
                model.bean.Compra compra = new model.bean.Compra();
                compra.setId(idCompra);
                cp.setCompra(compra);
                itens.add(cp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar itens da compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return itens;
    }

    public void update(CompraProduto cp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE compra_produto SET quantidade = ? WHERE id_compra = ? AND id_produto = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, cp.getQuantidade());
            stmt.setInt(2, cp.getCompra().getId());
            stmt.setInt(3, cp.getProduto().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item da compra atualizado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar item da compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(CompraProduto cp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM compra_produto WHERE id_compra = ? AND id_produto = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, cp.getCompra().getId());
            stmt.setInt(2, cp.getProduto().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item removido da compra!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir item da compra. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
