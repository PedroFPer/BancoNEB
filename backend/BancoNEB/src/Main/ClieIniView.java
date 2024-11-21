
package Main;

import ControllerRelatorio.ControllerRelatClien;

public class ClieIniView extends javax.swing.JFrame {
    private boolean saldoVisivel = false;
    private int idCliente;
    
    ControllerRelatClien controllerRelatClien = new ControllerRelatClien();

    public ClieIniView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ButtVerSaldo = new javax.swing.JButton();
        TextSaldo = new javax.swing.JLabel();
        ButtExtrato = new javax.swing.JButton();
        ButtTrans = new javax.swing.JButton();
        ButtCred = new javax.swing.JButton();
        ButtEmpre = new javax.swing.JButton();
        ButtAlteInf = new javax.swing.JButton();
        ButtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("BANCO NEB");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Bem vindo (a) !");

        ButtVerSaldo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtVerSaldo.setText("Ver Saldo");
        ButtVerSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtVerSaldoActionPerformed(evt);
            }
        });

        TextSaldo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TextSaldo.setText("Saldo: ******");

        ButtExtrato.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtExtrato.setText("Extrato");

        ButtTrans.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtTrans.setText("Transação");

        ButtCred.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtCred.setText("Crédito");
        ButtCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtCredActionPerformed(evt);
            }
        });

        ButtEmpre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtEmpre.setText("Empréstimo");

        ButtAlteInf.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtAlteInf.setText("Alterar Informações Pessoais");

        ButtSair.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(ButtVerSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(ButtAlteInf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(ButtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtCred, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtEmpre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtVerSaldo)
                    .addComponent(TextSaldo))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtTrans)
                    .addComponent(ButtExtrato))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtEmpre)
                    .addComponent(ButtCred))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(ButtAlteInf)
                .addGap(48, 48, 48)
                .addComponent(ButtSair)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    private void ButtVerSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtVerSaldoActionPerformed

        if (saldoVisivel) {
            TextSaldo.setText("Saldo: *****");
            saldoVisivel = false;
        } else {
            Double saldoAtual = controllerRelatClien.controllerVericSaldoAtual(idCliente);
            if (saldoAtual != null) {
                TextSaldo.setText("Saldo: " + saldoAtual.toString());
                saldoVisivel = true;
            } else {
                System.out.println("Erro ao verificar saldo.");
            }
        }
    }//GEN-LAST:event_ButtVerSaldoActionPerformed

    private void ButtCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtCredActionPerformed

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
            java.util.logging.Logger.getLogger(ClieIniView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClieIniView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClieIniView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClieIniView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClieIniView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtAlteInf;
    private javax.swing.JButton ButtCred;
    private javax.swing.JButton ButtEmpre;
    private javax.swing.JButton ButtExtrato;
    private javax.swing.JButton ButtSair;
    private javax.swing.JButton ButtTrans;
    private javax.swing.JButton ButtVerSaldo;
    private javax.swing.JLabel TextSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
