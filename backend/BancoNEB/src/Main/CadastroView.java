/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import ControllerCadastro.ControllerCadastro;
import DTO.ClienteDTO;
import ServiceCadastro.ServiceCadastro;
import ServiceRelatorio.ServiceRelatClien;
import UtilVerif.UtilVericCpf;
import UtilVerif.UtilVericSenha;
import UtilVerif.UtilVerifTelefone;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class CadastroView extends javax.swing.JFrame {

    ControllerCadastro controllerCadastro = new ControllerCadastro();
    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
    ServiceCadastro serviceCadastro = new ServiceCadastro();
    UtilVerifTelefone utilVerifTelefone = new UtilVerifTelefone();
    UtilVericCpf utilVericCpf = new UtilVericCpf();
    UtilVericSenha utilVericSenha = new UtilVericSenha();

    public CadastroView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        TextCpf = new javax.swing.JTextField();
        TextTelef = new javax.swing.JTextField();
        TextEmail = new javax.swing.JTextField();
        TextLogr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextSenhEnt = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        TextSenhAut = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        TextCid = new javax.swing.JTextField();
        TextBair = new javax.swing.JTextField();
        TextRef = new javax.swing.JTextField();
        TextEstad = new javax.swing.JTextField();
        TextPais = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ButtonCadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro Cliente");

        TextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNomeActionPerformed(evt);
            }
        });

        TextLogr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextLogrActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("CPF");

        jLabel4.setText("Telefone");

        jLabel5.setText("Senha de Entrada");

        jLabel6.setText("Email");

        TextSenhEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSenhEntActionPerformed(evt);
            }
        });

        jLabel7.setText("Senha de Autorização");

        TextSenhAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSenhAutActionPerformed(evt);
            }
        });

        jLabel8.setText("Logradouro");

        jLabel9.setText("Bairro:");

        jLabel10.setText("Cidade:");

        jLabel11.setText("Estado:");

        jLabel12.setText("País:");

        jLabel13.setText("Referencia:");

        ButtonCadas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ButtonCadas.setText("Cadastra");
        ButtonCadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TextLogr, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(168, 168, 168))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(TextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextSenhEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextSenhAut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(234, 234, 234))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(TextBair, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(TextRef, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextPais)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(TextCid)
                                    .addComponent(TextEstad))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(ButtonCadas)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextSenhEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextSenhAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextLogr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextEstad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(ButtonCadas)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextSenhEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSenhEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSenhEntActionPerformed

    private void TextSenhAutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSenhAutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSenhAutActionPerformed

    private void TextLogrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextLogrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextLogrActionPerformed

    private void ButtonCadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadasActionPerformed

        try {
            // Coletar valores dos campos
            String nomeCliente = TextNome.getText().trim();
            String cpf = TextCpf.getText().trim();
            String telefone = TextTelef.getText().trim();
            String email = TextEmail.getText().trim();
            String senhaEntrada = new String(TextSenhEnt.getPassword()).trim();
            String senhaAutorizacao = new String(TextSenhAut.getPassword()).trim();
            String logradouro = TextLogr.getText().trim();
            String bairro = TextBair.getText().trim();
            String cidade = TextCid.getText().trim();
            String estado = TextEstad.getText().trim();
            String pais = TextPais.getText().trim();
            String referencia = TextRef.getText().trim();

            // Validação Nome
            if (nomeCliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação CPF
            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O CPF não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!utilVericCpf.vericQuant(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF inválido! Deve conter 11 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (serviceRelatClien.serviceVericCpfExis(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação Telefone
            if (telefone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O telefone não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!utilVerifTelefone.vericQuant(telefone)) {
                JOptionPane.showMessageDialog(this, "Telefone inválido! Deve conter 13 caracteres (com DDD).", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação Email
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O email não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação Senhas
            if (senhaEntrada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A senha de entrada não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!utilVericSenha.vericQuant(senhaEntrada)) {
                JOptionPane.showMessageDialog(this, "Senha de entrada inválida! Deve conter 8 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (senhaAutorizacao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A senha de autorização não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!utilVericSenha.vericQuant(senhaAutorizacao)) {
                JOptionPane.showMessageDialog(this, "Senha de autorização inválida! Deve conter 8 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação Endereço
            if (logradouro.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado.isEmpty() || pais.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos de endereço devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar data de nascimento
            String dataNascStr = JOptionPane.showInputDialog(this, "Informe a data de nascimento (yyyy-MM-dd):");
            if (dataNascStr == null || dataNascStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A data de nascimento não pode estar vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalDate dataNascimento;
            try {
                dataNascimento = LocalDate.parse(dataNascStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (Period.between(dataNascimento, LocalDate.now()).getYears() < 16) {
                    JOptionPane.showMessageDialog(this, "É necessário ter pelo menos 16 anos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar objeto DTO e salvar
            ClienteDTO clienteDTO = new ClienteDTO(
                    nomeCliente, cpf, telefone, logradouro, bairro, cidade, estado, pais,
                    email, senhaEntrada, referencia, dataNascimento, senhaAutorizacao
            );
            boolean vericCadas = controllerCadastro.controllerCadastroClie(clienteDTO);

            if (vericCadas) {
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Ocorreu um problema com o cadastro, por tente novamente mais tarde", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_ButtonCadasActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadas;
    private javax.swing.JTextField TextBair;
    private javax.swing.JTextField TextCid;
    private javax.swing.JTextField TextCpf;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextEstad;
    private javax.swing.JTextField TextLogr;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextPais;
    private javax.swing.JTextField TextRef;
    private javax.swing.JPasswordField TextSenhAut;
    private javax.swing.JPasswordField TextSenhEnt;
    private javax.swing.JTextField TextTelef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
