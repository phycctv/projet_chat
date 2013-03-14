/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

/**
 *
 * @author zhangxi
 */
public class FConnection extends javax.swing.JFrame {


    /**
     * Creates new form FConnection
     */
    private Controleur controleur;
    private FenetrePrincipal parent;

    public FConnection(FenetrePrincipal parent, Controleur controleur) {
        this.setControleur(controleur);
        setBounds(400, 300, 391, 353);
        initComponents();
        parent.setVisible(false);
        this.parent = parent;
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
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonConnect = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("projetclientserveur/Bundle"); // NOI18N
        setTitle(bundle.getString("CONNECTION")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText(bundle.getString("NOM UTILISATEUR :")); // NOI18N

        jTextFieldLogin.setForeground(java.awt.Color.lightGray);
        jTextFieldLogin.setText(bundle.getString("VOTRE LOGIN")); // NOI18N
        jTextFieldLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLoginFocusLost(evt);
            }
        });
        jTextFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyTyped(evt);
            }
        });

        jButtonConnect.setText(bundle.getString("CONNECTER")); // NOI18N
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText(bundle.getString("ANNULER")); // NOI18N
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("MOT DE PASSE :")); // NOI18N

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnnuler)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConnect))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(jPasswordField1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonConnect))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        // TODO add your handling code here:

        int rep = controleur.connection(jTextFieldLogin.getText(), new String(jPasswordField1.getPassword()));
        if (rep == 0) {
            this.dispose();
            this.controleur.setNomUtilisateur(jTextFieldLogin.getText().toString());
            this.controleur.setConncte(true);
            parent.getmItemConnection().setEnabled(false);
            parent.getmItemDeconnection().setEnabled(true);
            parent.setVisible(true);
        } else if (rep == 1) {
            MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("NOM UTILISATEUR NON EXISTE !"));
            mb.setVisible(true);
        } else if (rep == 2) {
            MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("MOT DE PASSE INCORRECTE !"));
            mb.setVisible(true);
        } else if (rep == 3) {
            MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME CONNECTION"));
            mb.setVisible(true);
        }

    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLoginFocusGained
        // TODO add your handling code here:
        if (jTextFieldLogin.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldLogin.setText(null);
            jTextFieldLogin.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldLoginFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jTextFieldLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLoginFocusLost
        if (jTextFieldLogin.getText().isEmpty()) {
            jTextFieldLogin.setForeground(Color.LIGHT_GRAY);
            jTextFieldLogin.setText(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("VOTRE LOGIN"));
        }
    }//GEN-LAST:event_jTextFieldLoginFocusLost

    private void jTextFieldLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !jTextFieldLogin.getText().isEmpty()) {
            jPasswordField1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextFieldLoginKeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !jTextFieldLogin.getText().isEmpty()) {
            jButtonConnect.doClick();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
