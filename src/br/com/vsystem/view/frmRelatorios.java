
package br.com.vsystem.view;

import br.com.vsystem.dao.VendaDAO;
import br.com.vsystem.model.VendaModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class frmRelatorios extends javax.swing.JFrame {

    public frmRelatorios() {
        initComponents();
    }
    
    LocalDate data_inicio;
    LocalDate data_fim;
    public void Hora(String h1, String h2){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        data_inicio = LocalDate.parse(h1, formato);
        data_fim = LocalDate.parse(h2, formato);

    }
  /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorioCliente = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtdatainicio = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtdatafim = new javax.swing.JFormattedTextField();
        btnPesquisarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaRelatorioDia = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaRelatorioProdutos = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtdatainicio1 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        txtdatafim1 = new javax.swing.JFormattedTextField();
        btnPesquisarProduto = new javax.swing.JButton();
        btnGerar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(80, 223, 152));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Relatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        tabelaRelatorioCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Qtd. Compras", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRelatorioCliente.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaRelatorioCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatorioClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRelatorioCliente);

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel18.setText("Data inicial: ");

        try {
            txtdatainicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdatainicio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtdatainicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatainicioActionPerformed(evt);
            }
        });
        txtdatainicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdatainicioKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel19.setText("Data final:");

        try {
            txtdatafim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdatafim.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtdatafim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatafimActionPerformed(evt);
            }
        });
        txtdatafim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdatafimKeyPressed(evt);
            }
        });

        btnPesquisarCliente.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.setMaximumSize(new java.awt.Dimension(71, 25));
        btnPesquisarCliente.setMinimumSize(new java.awt.Dimension(71, 25));
        btnPesquisarCliente.setPreferredSize(new java.awt.Dimension(71, 25));
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdatainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdatafim, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtdatafim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txtdatainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Relatório de clientes", jPanel2);

        tabelaRelatorioDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Cliente", "Preço Total", "Data/Hora", "Nome Vendedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRelatorioDia.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaRelatorioDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatorioDiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaRelatorioDia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatório do dia", jPanel3);

        tabelaRelatorioProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade Vendida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRelatorioProdutos.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaRelatorioProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatorioProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaRelatorioProdutos);

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setText("Data inicial: ");

        try {
            txtdatainicio1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdatainicio1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtdatainicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatainicio1ActionPerformed(evt);
            }
        });
        txtdatainicio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdatainicio1KeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel21.setText("Data final:");

        try {
            txtdatafim1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdatafim1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtdatafim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatafim1ActionPerformed(evt);
            }
        });
        txtdatafim1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdatafim1KeyPressed(evt);
            }
        });

        btnPesquisarProduto.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnPesquisarProduto.setText("Pesquisar");
        btnPesquisarProduto.setMaximumSize(new java.awt.Dimension(71, 25));
        btnPesquisarProduto.setMinimumSize(new java.awt.Dimension(71, 25));
        btnPesquisarProduto.setPreferredSize(new java.awt.Dimension(71, 25));
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdatainicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdatafim1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtdatainicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txtdatafim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatório de Produtos", jPanel4);

        btnGerar2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnGerar2.setText("Gerar");
        btnGerar2.setMaximumSize(new java.awt.Dimension(71, 25));
        btnGerar2.setMinimumSize(new java.awt.Dimension(71, 25));
        btnGerar2.setPreferredSize(new java.awt.Dimension(71, 25));
        btnGerar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGerar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaRelatorioClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatorioClienteMouseClicked

       
    }//GEN-LAST:event_tabelaRelatorioClienteMouseClicked

    private void tabelaRelatorioDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatorioDiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaRelatorioDiaMouseClicked

    private void tabelaRelatorioProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatorioProdutosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaRelatorioProdutosMouseClicked

    private void txtdatainicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatainicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatainicioActionPerformed

    private void txtdatainicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatainicioKeyPressed

    }//GEN-LAST:event_txtdatainicioKeyPressed

    private void txtdatafimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatafimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatafimActionPerformed

    private void txtdatafimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatafimKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatafimKeyPressed

    private void txtdatainicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatainicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatainicio1ActionPerformed

    private void txtdatainicio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatainicio1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatainicio1KeyPressed

    private void txtdatafim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatafim1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatafim1ActionPerformed

    private void txtdatafim1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatafim1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatafim1KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        
        
        
        Hora(txtdatainicio.getText(), txtdatafim.getText());
        
        
        VendaDAO dao = new VendaDAO();
        
        List<VendaModel> lista = dao.RelatorioVendasCliente(data_inicio, data_fim);
        
        DefaultTableModel dados = (DefaultTableModel) tabelaRelatorioCliente.getModel();
        dados.setNumRows(0);
        
        for (VendaModel v : lista) {
            
                                    
            dados.addRow(new Object[]{
                v.getCliente().getCliente_id(),
                v.getCliente().getNome(),
                v.getItemvenda().getQtd(),
                v.getTotal_venda()
            });

        }
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        VendaDAO clidao = new VendaDAO();
        List<VendaModel> lista = clidao.RelatorioDiario();

        DefaultTableModel dados = (DefaultTableModel) tabelaRelatorioDia.getModel();
        
        //teste

        dados.setNumRows(0);

        for (VendaModel c : lista) {
            dados.addRow(new Object[]{
                c.getCliente().getCliente_id(),
                c.getTotal_venda(),
                c.getData_venda(),
                c.getUsuario().getNome()
            });

        }
    }//GEN-LAST:event_formWindowActivated

    private void btnGerar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerar2ActionPerformed
  
        Document documento = new Document();
        
        String ArquivoPdf = "Relatorio";
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ArquivoPdf));
            documento.open();
            
            Paragraph p = new Paragraph("Relatório de Vendas");
            p.setAlignment(1);
            documento.add(p);
            
            p = new Paragraph("          ");
            documento.add(p);
            
            PdfPCell cel1 = new PdfPCell(new Paragraph("Código Cliente"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Preço Total"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Data/Hora"));
            PdfPCell cel4 = new PdfPCell(new Paragraph("Nome Vendedor"));
            
            PdfPTable table = new PdfPTable(4);
            
            int i = jTabbedPane1.getSelectedIndex();


            if (i == 0){
                cel1 = new PdfPCell(new Paragraph("Código Cliente"));
                cel2 = new PdfPCell(new Paragraph("Nome"));
                cel3 = new PdfPCell(new Paragraph("Qtd. Compras"));
                cel4 = new PdfPCell(new Paragraph("Valor total"));
                
                table.addCell(cel1);
                table.addCell(cel2);
                table.addCell(cel3);
                table.addCell(cel4);
                
                    
                VendaDAO dao = new VendaDAO();
                List<VendaModel> lista1 = dao.RelatorioVendasCliente(data_inicio, data_fim);
        
                for (VendaModel v : lista1) {
            
                          
                    cel1 = new PdfPCell(new Paragraph(v.getCliente().getCliente_id()+" "));
                    cel2 = new PdfPCell(new Paragraph(v.getCliente().getNome() + ""));
                    cel3 = new PdfPCell(new Paragraph(v.getItemvenda().getQtd() + ""));
                    cel4 = new PdfPCell(new Paragraph(v.getTotal_venda() + ""));
            
            
                    table.addCell(cel1);
                    table.addCell(cel2);
                    table.addCell(cel3);
                    table.addCell(cel4);
                }
            
            }
            
            if (i == 1){
            //RELATORIO DO DIA     
                cel1 = new PdfPCell(new Paragraph("Código Cliente"));
                cel2 = new PdfPCell(new Paragraph("Preço Total"));
                cel3 = new PdfPCell(new Paragraph("Data/Hora"));
                cel4 = new PdfPCell(new Paragraph("Nome Vendedor"));
            
            
                table.addCell(cel1);
                table.addCell(cel2);
                table.addCell(cel3);
                table.addCell(cel4);
            
                VendaDAO clidao = new VendaDAO();
                List<VendaModel> lista = clidao.RelatorioDiario();

     
                for (VendaModel c : lista) {
                
                    cel1 = new PdfPCell(new Paragraph(c.getCliente().getCliente_id()+" "));
                    cel2 = new PdfPCell(new Paragraph(c.getTotal_venda() + ""));
                    cel3 = new PdfPCell(new Paragraph(c.getData_venda() + ""));
                    cel4 = new PdfPCell(new Paragraph(c.getUsuario().getNome() + ""));
            
            
                    table.addCell(cel1);
                    table.addCell(cel2);
                    table.addCell(cel3);
                    table.addCell(cel4);
                }
            
            }
            
            
            if (i == 2){
                table = new PdfPTable(3);
                
                PdfPCell cel5 = new PdfPCell(new Paragraph("Código"));
                PdfPCell cel6 = new PdfPCell(new Paragraph("Descrição"));
                PdfPCell cel7 = new PdfPCell(new Paragraph("Quantidade"));

                
                table.addCell(cel5);
                table.addCell(cel6);
                table.addCell(cel7);

                System.out.println(i);
                    
                VendaDAO dao = new VendaDAO();
                List<VendaModel> lista1 = dao.RelatorioVendasProdutos(data_inicio, data_fim);
        
                for (VendaModel v : lista1) {
            
                          
                    cel5 = new PdfPCell(new Paragraph(v.getProduto().getProduto_id()+" "));
                    cel6 = new PdfPCell(new Paragraph(v.getProduto().getDescricao() + ""));
                    cel7 = new PdfPCell(new Paragraph(v.getItemvenda().getQtd() + ""));

                          
            
                    table.addCell(cel5);
                    table.addCell(cel6);
                    table.addCell(cel7);

                    
                }
            
             
            
            }
                
                
                
            documento.add(table);
            documento.close();
            Desktop.getDesktop().open(new File(ArquivoPdf));
               
        }catch(Exception e){
        }
                
         
    }//GEN-LAST:event_btnGerar2ActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        Hora(txtdatainicio1.getText(), txtdatafim1.getText());
        
        
        VendaDAO dao = new VendaDAO();
        
        List<VendaModel> lista = dao.RelatorioVendasProdutos(data_inicio, data_fim);
        
        DefaultTableModel dados = (DefaultTableModel) tabelaRelatorioProdutos.getModel();
        dados.setNumRows(0);
        
        for (VendaModel v : lista) {
            
                                    
            dados.addRow(new Object[]{
                v.getProduto().getProduto_id(),
                v.getProduto().getDescricao(),
                v.getItemvenda().getQtd()
                
            });

        }
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar2;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaRelatorioCliente;
    private javax.swing.JTable tabelaRelatorioDia;
    private javax.swing.JTable tabelaRelatorioProdutos;
    private javax.swing.JFormattedTextField txtdatafim;
    private javax.swing.JFormattedTextField txtdatafim1;
    private javax.swing.JFormattedTextField txtdatainicio;
    private javax.swing.JFormattedTextField txtdatainicio1;
    // End of variables declaration//GEN-END:variables
}
