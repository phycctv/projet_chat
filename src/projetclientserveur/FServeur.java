/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author zhangxi
 */
public class FServeur extends javax.swing.JFrame {

    /**
     * Creates new form FConnection
     */
    private Controleur controleur;
    private FenetrePrincipal parent;

    public FServeur(FenetrePrincipal parent, Controleur controleur) {
        this.setControleur(controleur);
        setBounds(400, 300, 391, 353);
        initComponents();
        parent.setVisible(false);
        this.parent = parent;
        jTextFieldServeur.setText(controleur.getServeur());
    }

    public Controleur getControleur() {
        return controleur;
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
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
        jTextFieldServeur = new javax.swing.JTextField();
        jButtonChanger = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("projetclientserveur/Bundle"); // NOI18N
        setTitle(bundle.getString("CHANGER SERVEUR")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText(bundle.getString("SERVEUR :")); // NOI18N

        jButtonChanger.setText(bundle.getString("CHANGER")); // NOI18N
        jButtonChanger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangerActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText(bundle.getString("ANNULER")); // NOI18N
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldServeur)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChanger, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldServeur)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonChanger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChangerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangerActionPerformed
        controleur.setServeur(jTextFieldServeur.getText());
        MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("SERVEUR MODIFIÉ"));
        mb.setVisible(true);
        this.dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_jButtonChangerActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonChanger;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldServeur;
    // End of variables declaration//GEN-END:variables
}