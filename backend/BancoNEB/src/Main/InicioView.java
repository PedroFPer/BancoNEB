
package Main;


public class InicioView extends javax.swing.JFrame {


    public InicioView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ButtonAcessCont = new javax.swing.JButton();
        ButtonCadasCli = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Bem vindo ao BancoNEB!");

        ButtonAcessCont.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtonAcessCont.setText("Acessar Conta");
        ButtonAcessCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAcessContActionPerformed(evt);
            }
        });

        ButtonCadasCli.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtonCadasCli.setText("Quero ser Cliente!");
        ButtonCadasCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadasCliActionPerformed(evt);
            }
        });

        ButtonSair.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(ButtonAcessCont)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonCadasCli)
                        .addGap(258, 258, 258))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonSair)
                .addGap(336, 336, 336))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(ButtonAcessCont)
                .addGap(65, 65, 65)
                .addComponent(ButtonCadasCli)
                .addGap(80, 80, 80)
                .addComponent(ButtonSair)
                .addGap(143, 143, 143))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void ButtonCadasCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadasCliActionPerformed
        CadastroView cv = new CadastroView();
        this.dispose();
        cv.setVisible(true);
    }//GEN-LAST:event_ButtonCadasCliActionPerformed

    private void ButtonAcessContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAcessContActionPerformed
        LoginView lv = new LoginView();
        this.dispose();
        lv.setVisible(true);

    }//GEN-LAST:event_ButtonAcessContActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAcessCont;
    private javax.swing.JButton ButtonCadasCli;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
