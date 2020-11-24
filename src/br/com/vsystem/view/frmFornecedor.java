
package br.com.vsystem.view;

import br.com.vsystem.dao.ClienteDAO;
import br.com.vsystem.dao.FornecedorDAO;
import br.com.vsystem.model.ClienteModel;
import br.com.vsystem.model.EnderecoModel;
import br.com.vsystem.model.FornecedorModel;
import br.com.vsystem.model.TelefoneModel;
import br.com.vsystem.model.Utilitarios;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmFornecedor extends javax.swing.JFrame {
    
    
    public boolean validarCamposNulos(){
        
        if(txtnomeFantasia.getText().isEmpty() || txtrazaoSocial.getText().isEmpty() || txtemail.getText().isEmpty() || txtcnpj.getText().isEmpty() || txtcelular.getText().isEmpty() || txttelefone.getText().isEmpty()
                || txtcep.getText().isEmpty() || txtcidade.getText().isEmpty() || txtend.getText().isEmpty() || txtnumero.getText().isEmpty() 
                || txtbairro.getText().isEmpty() || txtcomplemento.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, " " + "Preencha todos os dados!");
            
            return false;
            
        }
        else{
            return true;
        }
        
        
    }

    public void ativarDesativarComponentes(boolean ativar){
        
        if(ativar){
            txtcodigo.setEnabled(false);
            txtnomeFantasia.setEnabled(true);
            txtrazaoSocial.setEnabled(true);
            txtemail.setEnabled(true);
            txtcnpj.setEnabled(true);
            txtcelular.setEnabled(true);
            txttelefone.setEnabled(true);
            txtcep.setEnabled(true);
            txtcidade.setEnabled(true);
            txtend.setEnabled(true);
            txtnumero.setEnabled(true);
            cbestado.setEnabled(true);
            txtbairro.setEnabled(true);
            txtcomplemento.setEnabled(true);
            
            txtnomeFantasia.requestFocus();
            
        }
        else{
            txtcodigo.setEnabled(false);
            txtnomeFantasia.setEnabled(false);
            txtrazaoSocial.setEnabled(false);
            txtemail.setEnabled(false);
            txtcnpj.setEnabled(false);
            txtcelular.setEnabled(false);
            txttelefone.setEnabled(false);
            txtcep.setEnabled(false);
            txtcidade.setEnabled(false);
            txtend.setEnabled(false);
            txtnumero.setEnabled(false);
            cbestado.setEnabled(false);
            txtbairro.setEnabled(false);
            txtcomplemento.setEnabled(false);
        }
        
    }
    
    
    public frmFornecedor() {
        initComponents();
        ativarDesativarComponentes(false);
        
        tabelaFornecedores.setAutoResizeMode(tabelaFornecedores.AUTO_RESIZE_OFF);
        tabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(55);
        tabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaFornecedores.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabelaFornecedores.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabelaFornecedores.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelaFornecedores.getColumnModel().getColumn(6).setPreferredWidth(150);
        tabelaFornecedores.getColumnModel().getColumn(7).setPreferredWidth(200);
        tabelaFornecedores.getColumnModel().getColumn(8).setPreferredWidth(200);
        tabelaFornecedores.getColumnModel().getColumn(9).setPreferredWidth(300);
        tabelaFornecedores.getColumnModel().getColumn(10).setPreferredWidth(55);
        tabelaFornecedores.getColumnModel().getColumn(11).setPreferredWidth(55);
        tabelaFornecedores.getColumnModel().getColumn(12).setPreferredWidth(100);
        tabelaFornecedores.getColumnModel().getColumn(13).setPreferredWidth(120);
        setIcon();
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons8_cheap_2_32.png")));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpdadosfornecedor = new javax.swing.JPanel();
        txtcep = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        txtnomeFantasia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtcomplemento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        txttelefone = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbestado = new javax.swing.JComboBox<>();
        txtend = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtcnpj = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        txtrazaoSocial = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornecedores = new javax.swing.JTable();
        btnpesquisar1 = new javax.swing.JButton();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(80, 223, 152));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fornecedores");

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

        jTabbedPane1.setToolTipText("");

        jpdadosfornecedor.setBackground(new java.awt.Color(255, 255, 255));

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcep.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtcep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcepKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("Bairro:");

        txtbairro.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbairroActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setText("Cidade:");

        txtcidade.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtnomeFantasia.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel19.setText("Complemento:");

        txtcomplemento.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtcomplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomplementoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setText("Celular:");

        try {
            txtcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcelular.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel21.setText("Nº:");

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel22.setText("Telefone fixo:");

        txtnumero.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txttelefone.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel23.setText("Endereço:");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel24.setText("           Código: ");

        txtcodigo.setEditable(false);
        txtcodigo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel25.setText("             Nome:");

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel26.setText("UF:");

        cbestado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        txtend.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtendActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel28.setText("               CNPJ:");

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel29.setText("           CEP:");

        try {
            txtcnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###.####/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcnpj.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel27.setText("Razão Social:");

        txtrazaoSocial.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel30.setText("email:");

        txtemail.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpdadosfornecedorLayout = new javax.swing.GroupLayout(jpdadosfornecedor);
        jpdadosfornecedor.setLayout(jpdadosfornecedorLayout);
        jpdadosfornecedorLayout.setHorizontalGroup(
            jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpdadosfornecedorLayout.createSequentialGroup()
                                    .addComponent(txtnomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(89, 89, 89)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtcodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                                    .addComponent(txtrazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(256, 256, 256)))))
                    .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                                .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpdadosfornecedorLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel17))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                                                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpdadosfornecedorLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jpdadosfornecedorLayout.setVerticalGroup(
            jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdadosfornecedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtnomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtrazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpdadosfornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jTabbedPane1.addTab("Dados do fornecedor", jpdadosfornecedor);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");

        txtpesquisa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaActionPerformed(evt);
            }
        });
        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyPressed(evt);
            }
        });

        tabelaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Razão Social", "Email", "CNPJ", "Celular", "Telefone", "Cep", "Cidade", "Endereco", "Numero", "UF", "Bairro", "Complemento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFornecedores.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFornecedores);

        btnpesquisar1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnpesquisar1.setText("Atualizar");
        btnpesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnpesquisar1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisar1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta de fornecedores", jPanel2);

        btnnovo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnexcluir.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnovo)
                .addGap(18, 18, 18)
                .addComponent(btnsalvar)
                .addGap(18, 18, 18)
                .addComponent(btneditar)
                .addGap(18, 18, 18)
                .addComponent(btnexcluir)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexcluir)
                    .addComponent(btneditar)
                    .addComponent(btnsalvar)
                    .addComponent(btnnovo))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyPressed
        String nome = "%" + txtpesquisa.getText() + "%";

        FornecedorDAO fornDAO = new FornecedorDAO();
        
        List<FornecedorModel> lista = fornDAO.PesquisarPorNome(nome);

        DefaultTableModel dados = (DefaultTableModel) tabelaFornecedores.getModel();

        dados.setNumRows(0);

        for (FornecedorModel f : lista) {
            dados.addRow(new Object[]{
                f.getFornecedor_id(),
                f.getNome_fantasia(),
                f.getRazao_social(),
                f.getEmail(),
                f.getCnpj(),
                f.getTelefone().getCelular(),
                f.getTelefone().getTelefone(),
                f.getEndereco().getCep(),
                f.getEndereco().getCidade(),
                f.getEndereco().getEndereco(),
                f.getEndereco().getNumero(),
                f.getEndereco().getEstado(),
                f.getEndereco().getBairro(),
                f.getEndereco().getComplemento(),
               
            });

        }
    }//GEN-LAST:event_txtpesquisaKeyPressed

    private void tabelaFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecedoresMouseClicked
        
        //Carregar Dados para atualização
        
        jTabbedPane1.setSelectedIndex(0);
        ativarDesativarComponentes(true);

        txtcodigo.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 0).toString());
        txtnomeFantasia.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 1).toString());
        txtrazaoSocial.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 2).toString());
        txtcnpj.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 3).toString());
        txtemail.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 4).toString());
        txtcelular.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 5).toString());
        txttelefone.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 6).toString());
        txtcep.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 7).toString());
        txtcidade.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 8).toString());
        txtend.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 9).toString());
        txtnumero.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 10).toString());
        cbestado.setSelectedItem(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 11).toString());
        txtbairro.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 12).toString());
        txtcomplemento.setText(tabelaFornecedores.getValueAt(tabelaFornecedores.getSelectedRow(), 13).toString());
        
        
    }//GEN-LAST:event_tabelaFornecedoresMouseClicked

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        Utilitarios util = new Utilitarios();
        jTabbedPane1.setSelectedIndex(0);
        util.LimpaTela(jpdadosfornecedor);
        ativarDesativarComponentes(true);
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        
        if(validarCamposNulos()){
            
        FornecedorModel forn = new FornecedorModel();
        EnderecoModel end = new EnderecoModel();
        TelefoneModel tel = new TelefoneModel();
        
        forn.setNome_fantasia(txtnomeFantasia.getText());
        forn.setRazao_social(txtrazaoSocial.getText());
        forn.setCnpj(txtcnpj.getText());
        forn.setEmail(txtemail.getText());
        forn.setApagado("N");
        
        end.setCep(txtcep.getText());
        end.setEndereco(txtend.getText());
        end.setNumero(txtnumero.getText());
        end.setComplemento(txtcomplemento.getText());
        end.setBairro(txtbairro.getText());
        end.setCidade(txtcidade.getText());
        end.setEstado(cbestado.getSelectedItem().toString());
        end.setApagado("N");
        
        tel.setCelular(txtcelular.getText());
        tel.setTelefone(txttelefone.getText());
        tel.setApagado("N");
        
       
        
        FornecedorDAO fornDAO = new FornecedorDAO();
        fornDAO.cadastrarCliente(forn, end, tel);
        
        new Utilitarios().LimpaTela(jpdadosfornecedor);
        
        }
        
  
        
        
        
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        
        if(validarCamposNulos()){
        
        FornecedorModel forn = new FornecedorModel();
        EnderecoModel end = new EnderecoModel();
        TelefoneModel tel = new TelefoneModel();
        
        forn.setFornecedor_id(Integer.parseInt(txtcodigo.getText()));
        forn.setNome_fantasia(txtnomeFantasia.getText());
        forn.setRazao_social(txtrazaoSocial.getText());
        forn.setCnpj(txtcnpj.getText());
        forn.setEmail(txtemail.getText());
        forn.setApagado("N");
        
        end.setCep(txtcep.getText());
        end.setEndereco(txtend.getText());
        end.setNumero(txtnumero.getText());
        end.setComplemento(txtcomplemento.getText());
        end.setBairro(txtbairro.getText());
        end.setCidade(txtcidade.getText());
        end.setEstado(cbestado.getSelectedItem().toString());
        end.setApagado("N");
        
        tel.setCelular(txtcelular.getText());
        tel.setTelefone(txttelefone.getText());
        tel.setApagado("N");
        
        
        FornecedorDAO fornDAO = new FornecedorDAO();
        fornDAO.alterarFornecedor(forn, end, tel);
        
        new Utilitarios().LimpaTela(jpdadosfornecedor);
            
        }
        
        
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        
         Object[] options = { "Sim", "Não" };
        switch (JOptionPane.showOptionDialog(null, "Deseja excluir o cadastro?", "Confirmação", JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options, options[0])) {
            case 0:
                FornecedorModel forn = new FornecedorModel();
        
                forn.setFornecedor_id(Integer.parseInt(txtcodigo.getText()));
                forn.setApagado("S");
        
                FornecedorDAO fornDAO = new FornecedorDAO();
                fornDAO.excluirFornecedor(forn);
        
        new Utilitarios().LimpaTela(jpdadosfornecedor);
                break;
            case 1:
                break;
        }
        
            
        
        
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void btnpesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisar1ActionPerformed
        
        txtpesquisa.setText("");
        
        FornecedorDAO fornDAO = new FornecedorDAO();
        List<FornecedorModel> lista = fornDAO.listarTodos();

        DefaultTableModel dados = (DefaultTableModel) tabelaFornecedores.getModel();
        
        dados.setNumRows(0);

        for (FornecedorModel f : lista) {
            dados.addRow(new Object[]{
                f.getFornecedor_id(),
                f.getNome_fantasia(),
                f.getRazao_social(),
                f.getEmail(),
                f.getCnpj(),
                
                f.getTelefone().getCelular(),
                f.getTelefone().getTelefone(),
                f.getEndereco().getCep(),
                f.getEndereco().getCidade(),
                f.getEndereco().getEndereco(),
                f.getEndereco().getNumero(),
                f.getEndereco().getEstado(),
                f.getEndereco().getBairro(),
                f.getEndereco().getComplemento(),
               
            });

        }
    }//GEN-LAST:event_btnpesquisar1ActionPerformed

    private void txtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtendActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcomplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomplementoActionPerformed

    private void txtbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbairroActionPerformed

    private void txtcepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcepKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            Utilitarios util = new Utilitarios();

            String endereco[] = util.buscarCep(txtcep.getText());

            txtend.setText(endereco[7]);
            txtbairro.setText(endereco[15]);
            txtcidade.setText(endereco[19]);
            cbestado.setSelectedItem(endereco[23]);

        }

    }//GEN-LAST:event_txtcepKeyPressed

    private void txtpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnpesquisar1;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpdadosfornecedor;
    private javax.swing.JTable tabelaFornecedores;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcelular;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JFormattedTextField txtcnpj;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtnomeFantasia;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtrazaoSocial;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables
}
