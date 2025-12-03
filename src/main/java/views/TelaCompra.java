package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Compra;
import model.bean.CompraProduto;
import model.bean.Fornecedor;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CompraDAO;
import model.dao.CompraProdutoDAO;
import model.dao.FornecedorDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 * Tela para CRUD de Compra e itens (compra_produto).
 */
public class TelaCompra extends javax.swing.JInternalFrame {

    private Compra compraSelecionada;

    public TelaCompra() {
        initComponents();
        preencherCombos();
        preencherTabelaCompras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCompra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbFornecedor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        painelItens = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbProdutoItem = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidadeItem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorUnitarioItem = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnAtualizarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar Compra");

        painelCompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Compra"));

        jLabel1.setText("Fornecedor");

        jLabel2.setText("Usuario");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCompraLayout = new javax.swing.GroupLayout(painelCompra);
        painelCompra.setLayout(painelCompraLayout);
        painelCompraLayout.setHorizontalGroup(
            painelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCompraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        painelCompraLayout.setVerticalGroup(
            painelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fornecedor", "Usuario"
            }
        ));
        tblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompras);

        painelItens.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens da Compra"));

        jLabel3.setText("Produto");

        cmbProdutoItem.setPreferredSize(new java.awt.Dimension(220, cmbProdutoItem.getPreferredSize().height));

        jLabel4.setText("Quantidade");

        jLabel5.setText("Valor unitario");

        txtValorUnitarioItem.setEditable(false);

        btnAddItem.setText("Adicionar");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnAtualizarItem.setText("Atualizar");
        btnAtualizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarItemActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelItensLayout = new javax.swing.GroupLayout(painelItens);
        painelItens.setLayout(painelItensLayout);
        painelItensLayout.setHorizontalGroup(
            painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProdutoItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoverItem)
                .addContainerGap())
        );
        painelItensLayout.setVerticalGroup(
            painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProdutoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorUnitarioItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem)
                    .addComponent(btnAtualizarItem)
                    .addComponent(btnRemoverItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto ID", "Descricao", "Quantidade"
            }
        ));
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(painelItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrarCompra();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarCompra();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirCompra();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked
        selecionarCompra();
    }//GEN-LAST:event_tblComprasMouseClicked

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        adicionarItem();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnAtualizarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarItemActionPerformed
        atualizarItem();
    }//GEN-LAST:event_btnAtualizarItemActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        removerItem();
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked
        selecionarItem();
    }//GEN-LAST:event_tblItensMouseClicked

    private void preencherCombos() {
        cmbFornecedor.removeAllItems();
        cmbUsuario.removeAllItems();
        cmbProdutoItem.removeAllItems();

        FornecedorDAO fdao = new FornecedorDAO();
        for (Fornecedor f : fdao.read()) {
            cmbFornecedor.addItem(f);
        }
        UsuarioDAO udao = new UsuarioDAO();
        for (Usuario u : udao.read()) {
            cmbUsuario.addItem(u);
        }
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.read()) {
            cmbProdutoItem.addItem(p);
        }
        cmbProdutoItem.addActionListener(e -> atualizarValorUnitarioCompra());
        atualizarValorUnitarioCompra();
    }

    private void preencherTabelaCompras() {
        DefaultTableModel dtm = (DefaultTableModel) tblCompras.getModel();
        dtm.setRowCount(0);
        CompraDAO dao = new CompraDAO();
        for (Compra c : dao.read()) {
            dtm.addRow(new Object[]{
                c.getId(),
                c.getFornecedor(),
                c.getUsuario()
            });
        }
    }

    private void preencherTabelaItens() {
        DefaultTableModel dtm = (DefaultTableModel) tblItens.getModel();
        dtm.setRowCount(0);
        if (compraSelecionada == null) {
            return;
        }
        CompraProdutoDAO dao = new CompraProdutoDAO();
        for (CompraProduto cp : dao.readByCompra(compraSelecionada.getId())) {
            dtm.addRow(new Object[]{
                cp.getProduto().getId(),
                cp.getProduto().getDescricao(),
                cp.getQuantidade()
            });
        }
    }

    private void limpar() {
        compraSelecionada = null;
        cmbFornecedor.setSelectedIndex(-1);
        cmbUsuario.setSelectedIndex(-1);
        txtQuantidadeItem.setText("");
        txtValorUnitarioItem.setText("");
        tblCompras.clearSelection();
        tblItens.clearSelection();
        preencherTabelaItens();
    }

    private void selecionarCompra() {
        int linha = tblCompras.getSelectedRow();
        if (linha != -1) {
            int id = Integer.parseInt(tblCompras.getValueAt(linha, 0).toString());
            CompraDAO dao = new CompraDAO();
            compraSelecionada = dao.read(id);
            if (compraSelecionada != null) {
                cmbFornecedor.setSelectedItem(compraSelecionada.getFornecedor());
                cmbUsuario.setSelectedItem(compraSelecionada.getUsuario());
                preencherTabelaItens();
            }
        }
    }

    private void selecionarItem() {
        int linha = tblItens.getSelectedRow();
        if (linha != -1) {
            int idProd = Integer.parseInt(tblItens.getValueAt(linha, 0).toString());
            for (int i = 0; i < cmbProdutoItem.getItemCount(); i++) {
                if (cmbProdutoItem.getItemAt(i).getId() == idProd) {
                    cmbProdutoItem.setSelectedIndex(i);
                    break;
                }
            }
            txtQuantidadeItem.setText(tblItens.getValueAt(linha, 2).toString());
            atualizarValorUnitarioCompra();
        }
    }

    private void cadastrarCompra() {
        if (cmbFornecedor.getSelectedItem() == null || cmbUsuario.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione fornecedor e usuario.");
            return;
        }
        compraSelecionada = new Compra();
        compraSelecionada.setFornecedor((Fornecedor) cmbFornecedor.getSelectedItem());
        compraSelecionada.setUsuario((Usuario) cmbUsuario.getSelectedItem());
        new CompraDAO().create(compraSelecionada);
        preencherTabelaCompras();
        limpar();
    }

    private void editarCompra() {
        if (compraSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma compra para editar.");
            return;
        }
        compraSelecionada.setFornecedor((Fornecedor) cmbFornecedor.getSelectedItem());
        compraSelecionada.setUsuario((Usuario) cmbUsuario.getSelectedItem());
        new CompraDAO().update(compraSelecionada);
        preencherTabelaCompras();
        limpar();
    }

    private void excluirCompra() {
        if (compraSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma compra para excluir.");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Deseja excluir esta compra?") == JOptionPane.YES_OPTION) {
            new CompraDAO().destroy(compraSelecionada);
            compraSelecionada = null;
            preencherTabelaCompras();
            preencherTabelaItens();
            limpar();
        }
    }

    private void adicionarItem() {
        if (compraSelecionada == null || compraSelecionada.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre ou selecione uma compra antes de adicionar itens.");
            return;
        }
        if (cmbProdutoItem.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }
        int qtd;
        try {
            qtd = Integer.parseInt(txtQuantidadeItem.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade invalida.");
            return;
        }
        CompraProduto cp = new CompraProduto();
        cp.setCompra(compraSelecionada);
        cp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        cp.setQuantidade(qtd);
        new CompraProdutoDAO().create(cp);
        preencherTabelaItens();
    }

    private void atualizarItem() {
        if (compraSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione a compra.");
            return;
        }
        if (cmbProdutoItem.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }
        int qtd;
        try {
            qtd = Integer.parseInt(txtQuantidadeItem.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade invalida.");
            return;
        }
        CompraProduto cp = new CompraProduto();
        cp.setCompra(compraSelecionada);
        cp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        cp.setQuantidade(qtd);
        new CompraProdutoDAO().update(cp);
        preencherTabelaItens();
    }

    private void removerItem() {
        if (compraSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione a compra.");
            return;
        }
        if (cmbProdutoItem.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }
        CompraProduto cp = new CompraProduto();
        cp.setCompra(compraSelecionada);
        cp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        new CompraProdutoDAO().destroy(cp);
        preencherTabelaItens();
    }

    private void atualizarValorUnitarioCompra() {
        Produto prod = (Produto) cmbProdutoItem.getSelectedItem();
        if (prod != null) {
            txtValorUnitarioItem.setText(String.valueOf(prod.getValorUnitario()));
        } else {
            txtValorUnitarioItem.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAtualizarItem;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JComboBox<Fornecedor> cmbFornecedor;
    private javax.swing.JComboBox<Produto> cmbProdutoItem;
    private javax.swing.JComboBox<Usuario> cmbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelCompra;
    private javax.swing.JPanel painelItens;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JTextField txtValorUnitarioItem;
    // End of variables declaration//GEN-END:variables
}
