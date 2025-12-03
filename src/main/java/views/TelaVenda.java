package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Produto;
import model.bean.Usuario;
import model.bean.Venda;
import model.bean.VendaProduto;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;
import model.dao.VendaDAO;
import model.dao.VendaProdutoDAO;

/**
 * Tela para CRUD de Venda e itens (venda_produto).
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    private Venda vendaSelecionada;

    public TelaVenda() {
        initComponents();
        preencherCombos();
        preencherTabelaVendas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelVenda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        painelItens = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbProdutoItem = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidadeItem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorUnitarioItem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorVendaItem = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnAtualizarItem = new javax.swing.JButton();
        btnRemoverItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar Venda");

        painelVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Venda"));

        jLabel1.setText("Cliente");

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

        javax.swing.GroupLayout painelVendaLayout = new javax.swing.GroupLayout(painelVenda);
        painelVenda.setLayout(painelVendaLayout);
        painelVendaLayout.setHorizontalGroup(
            painelVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVendaLayout.createSequentialGroup()
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
        painelVendaLayout.setVerticalGroup(
            painelVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Usuario"
            }
        ));
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        painelItens.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens da Venda"));

        jLabel3.setText("Produto");

        cmbProdutoItem.setPreferredSize(new java.awt.Dimension(220, cmbProdutoItem.getPreferredSize().height));

        jLabel4.setText("Quantidade");

        jLabel5.setText("Valor unitario");

        txtValorUnitarioItem.setEditable(false);

        jLabel6.setText("Valor total");

        txtValorVendaItem.setEditable(false);

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
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorVendaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel6)
                    .addComponent(txtValorVendaItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem)
                    .addComponent(btnAtualizarItem)
                    .addComponent(btnRemoverItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto ID", "Descricao", "Quantidade", "Valor venda"
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
            .addComponent(painelVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(painelItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        cadastrarVenda();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarVenda();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirVenda();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        selecionarVenda();
    }//GEN-LAST:event_tblVendasMouseClicked

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
        cmbCliente.removeAllItems();
        cmbUsuario.removeAllItems();
        cmbProdutoItem.removeAllItems();

        ClienteDAO cdao = new ClienteDAO();
        for (Cliente c : cdao.read()) {
            cmbCliente.addItem(c);
        }
        UsuarioDAO udao = new UsuarioDAO();
        for (Usuario u : udao.read()) {
            cmbUsuario.addItem(u);
        }
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.read()) {
            cmbProdutoItem.addItem(p);
        }
        cmbProdutoItem.addActionListener(e -> atualizarValorUnitarioVenda());
        atualizarValorUnitarioVenda();
    }

    private void preencherTabelaVendas() {
        DefaultTableModel dtm = (DefaultTableModel) tblVendas.getModel();
        dtm.setRowCount(0);
        VendaDAO dao = new VendaDAO();
        for (Venda v : dao.read()) {
            dtm.addRow(new Object[]{
                v.getId(),
                v.getCliente(),
                v.getUsuario()
            });
        }
    }

    private void preencherTabelaItens() {
        DefaultTableModel dtm = (DefaultTableModel) tblItens.getModel();
        dtm.setRowCount(0);
        if (vendaSelecionada == null) {
            return;
        }
        VendaProdutoDAO dao = new VendaProdutoDAO();
        for (VendaProduto vp : dao.readByVenda(vendaSelecionada.getId())) {
            dtm.addRow(new Object[]{
                vp.getProduto().getId(),
                vp.getProduto().getDescricao(),
                vp.getQuantidade(),
                vp.getValorVenda()
            });
        }
    }

    private void limpar() {
        vendaSelecionada = null;
        cmbCliente.setSelectedIndex(-1);
        cmbUsuario.setSelectedIndex(-1);
        cmbProdutoItem.setSelectedIndex(-1);
        txtQuantidadeItem.setText("");
        txtValorUnitarioItem.setText("");
        txtValorVendaItem.setText("");
        tblVendas.clearSelection();
        tblItens.clearSelection();
        preencherTabelaItens();
    }

    private void selecionarVenda() {
        int linha = tblVendas.getSelectedRow();
        if (linha != -1) {
            int id = Integer.parseInt(tblVendas.getValueAt(linha, 0).toString());
            VendaDAO dao = new VendaDAO();
            vendaSelecionada = dao.read(id);
            if (vendaSelecionada != null) {
                cmbCliente.setSelectedItem(vendaSelecionada.getCliente());
                cmbUsuario.setSelectedItem(vendaSelecionada.getUsuario());
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
            txtValorVendaItem.setText(tblItens.getValueAt(linha, 3).toString());
            atualizarValorUnitarioVenda();
        }
    }

    private void cadastrarVenda() {
        if (cmbCliente.getSelectedItem() == null || cmbUsuario.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione cliente e usuario.");
            return;
        }
        vendaSelecionada = new Venda();
        vendaSelecionada.setCliente((Cliente) cmbCliente.getSelectedItem());
        vendaSelecionada.setUsuario((Usuario) cmbUsuario.getSelectedItem());
        new VendaDAO().create(vendaSelecionada);
        preencherTabelaVendas();
        limpar();
    }

    private void editarVenda() {
        if (vendaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda para editar.");
            return;
        }
        vendaSelecionada.setCliente((Cliente) cmbCliente.getSelectedItem());
        vendaSelecionada.setUsuario((Usuario) cmbUsuario.getSelectedItem());
        new VendaDAO().update(vendaSelecionada);
        preencherTabelaVendas();
        limpar();
    }

    private void excluirVenda() {
        if (vendaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma venda para excluir.");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Deseja excluir esta venda?") == JOptionPane.YES_OPTION) {
            new VendaDAO().destroy(vendaSelecionada);
            vendaSelecionada = null;
            preencherTabelaVendas();
            preencherTabelaItens();
            limpar();
        }
    }

    private void adicionarItem() {
        if (vendaSelecionada == null || vendaSelecionada.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Cadastre ou selecione uma venda antes de adicionar itens.");
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
            JOptionPane.showMessageDialog(this, "Quantidade ou valor invalido.");
            return;
        }
        double valorUnitario = ((Produto) cmbProdutoItem.getSelectedItem()).getValorUnitario();
        txtValorUnitarioItem.setText(String.valueOf(valorUnitario));
        double valor = valorUnitario * qtd;
        txtValorVendaItem.setText(String.valueOf(valor));
        VendaProduto vp = new VendaProduto();
        vp.setVenda(vendaSelecionada);
        vp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        vp.setQuantidade(qtd);
        vp.setValorVenda(valor);
        new VendaProdutoDAO().create(vp);
        preencherTabelaItens();
    }

    private void atualizarItem() {
        if (vendaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione a venda.");
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
            JOptionPane.showMessageDialog(this, "Quantidade ou valor invalido.");
            return;
        }
        double valorUnitario = ((Produto) cmbProdutoItem.getSelectedItem()).getValorUnitario();
        txtValorUnitarioItem.setText(String.valueOf(valorUnitario));
        double valor = valorUnitario * qtd;
        txtValorVendaItem.setText(String.valueOf(valor));
        VendaProduto vp = new VendaProduto();
        vp.setVenda(vendaSelecionada);
        vp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        vp.setQuantidade(qtd);
        vp.setValorVenda(valor);
        new VendaProdutoDAO().update(vp);
        preencherTabelaItens();
    }

    private void removerItem() {
        if (vendaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione a venda.");
            return;
        }
        if (cmbProdutoItem.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
            return;
        }
        VendaProduto vp = new VendaProduto();
        vp.setVenda(vendaSelecionada);
        vp.setProduto((Produto) cmbProdutoItem.getSelectedItem());
        new VendaProdutoDAO().destroy(vp);
        preencherTabelaItens();
    }

    private void atualizarValorUnitarioVenda() {
        Produto prod = (Produto) cmbProdutoItem.getSelectedItem();
        if (prod != null) {
            double valorUnitario = prod.getValorUnitario();
            txtValorUnitarioItem.setText(String.valueOf(valorUnitario));
            int qtd = 0;
            try {
                qtd = Integer.parseInt(txtQuantidadeItem.getText());
            } catch (NumberFormatException ex) {
                // ignora, assume 0
            }
            double total = valorUnitario * qtd;
            txtValorVendaItem.setText(String.valueOf(total));
        } else {
            txtValorVendaItem.setText("");
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
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Produto> cmbProdutoItem;
    private javax.swing.JComboBox<Usuario> cmbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelItens;
    private javax.swing.JPanel painelVenda;
    private javax.swing.JTable tblItens;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JTextField txtValorUnitarioItem;
    private javax.swing.JTextField txtValorVendaItem;
    // End of variables declaration//GEN-END:variables
}
