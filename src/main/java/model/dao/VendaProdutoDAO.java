package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.VendaProduto;
import model.bean.Venda;

/**
 * Manipula itens de venda (tabela venda_produto).
 */
public class VendaProdutoDAO {

    public void create(VendaProduto vp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO venda_produto(id_venda, id_produto, quantidade, valor_venda) VALUES (?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, vp.getVenda().getId());
            stmt.setInt(2, vp.getProduto().getId());
            stmt.setInt(3, vp.getQuantidade());
            stmt.setDouble(4, vp.getValorVenda());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item adicionado na venda!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar item na venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public ArrayList<VendaProduto> readByVenda(int idVenda) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<VendaProduto> itens = new ArrayList<>();
        try {
            String query = "SELECT * FROM venda_produto WHERE id_venda = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idVenda);
            rs = stmt.executeQuery();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            while (rs.next()) {
                VendaProduto vp = new VendaProduto();
                vp.setQuantidade(rs.getInt("quantidade"));
                vp.setValorVenda(rs.getDouble("valor_venda"));
                Produto produto = produtoDAO.read(rs.getInt("id_produto"));
                vp.setProduto(produto);
                Venda venda = new Venda();
                venda.setId(idVenda);
                vp.setVenda(venda);
                itens.add(vp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar itens da venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return itens;
    }

    public void update(VendaProduto vp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE venda_produto SET quantidade = ?, valor_venda = ? WHERE id_venda = ? AND id_produto = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, vp.getQuantidade());
            stmt.setDouble(2, vp.getValorVenda());
            stmt.setInt(3, vp.getVenda().getId());
            stmt.setInt(4, vp.getProduto().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item da venda atualizado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar item da venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void destroy(VendaProduto vp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM venda_produto WHERE id_venda = ? AND id_produto = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, vp.getVenda().getId());
            stmt.setInt(2, vp.getProduto().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item removido da venda!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir item da venda. Erro: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
