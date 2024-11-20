
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bem vindo ao BancoNEB!");

        ButtonAcessCont.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ButtonAcessCont.setText("Acessar Conta");
        ButtonAcessCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAcessContActionPerformed(evt);
            }
        });

        ButtonCadasCli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ButtonCadasCli.setText("Quero ser Cliente!");
        ButtonCadasCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadasCliActionPerformed(evt);
            }
        });

        ButtonSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(ButtonCadasCli))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(ButtonSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(ButtonAcessCont)))
                .addGap(0, 248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(ButtonAcessCont)
                .addGap(66, 66, 66)
                .addComponent(ButtonCadasCli)
                .addGap(83, 83, 83)
                .addComponent(ButtonSair)
                .addGap(139, 139, 139))
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
