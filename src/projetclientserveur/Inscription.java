/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.awt.Color;

/**
 *
 * @author bodinjo
 */
public class Inscription extends javax.swing.JFrame {

    private Controleur controleur;
    /**
     * Creates new form Inscription
     */
    private java.awt.Frame parent;
    private String login;
    private String mdp;
    private String email;
    private String dateNais;
    private boolean sexe;

    public Inscription(java.awt.Frame parent, Controleur controleur) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonVerifier = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMDP1 = new javax.swing.JTextField();
        jTextFieldMDP2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDateNaiss = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonFille = new javax.swing.JRadioButton();
        jRadioButtonGarcon = new javax.swing.JRadioButton();
        jButtonInscription = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom utilisateur :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 17, -1, -1));

        jTextFieldLogin.setForeground(java.awt.Color.lightGray);
        jTextFieldLogin.setText("Choisir un login");
        jTextFieldLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLoginMouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 12, 133, -1));

        jButtonVerifier.setText("Vérifier");
        jButtonVerifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerifierActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVerifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 57, -1, -1));

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonQuitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 57, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 104, 463, 10));

        jLabel2.setText("Mot de passe :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 137, -1, -1));

        jLabel3.setText("Confirmation :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 170, -1, -1));

        jTextFieldMDP1.setForeground(java.awt.Color.lightGray);
        jTextFieldMDP1.setText("Choisir un mot de passe");
        jTextFieldMDP1.setEnabled(false);
        jTextFieldMDP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldMDP1MouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldMDP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 132, 180, -1));

        jTextFieldMDP2.setForeground(java.awt.Color.lightGray);
        jTextFieldMDP2.setText("Confirmer MDP");
        jTextFieldMDP2.setEnabled(false);
        jTextFieldMDP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldMDP2MouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldMDP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 165, 180, -1));

        jLabel4.setText("Adresse email :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 215, -1, -1));

        jTextFieldEmail.setForeground(java.awt.Color.lightGray);
        jTextFieldEmail.setText("exemple@exemple.fr");
        jTextFieldEmail.setEnabled(false);
        jTextFieldEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailMouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 210, 223, -1));

        jLabel5.setText("Date de naissance :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 260, -1, -1));

        jTextFieldDateNaiss.setForeground(java.awt.Color.lightGray);
        jTextFieldDateNaiss.setText("01/01/2000");
        jTextFieldDateNaiss.setEnabled(false);
        jTextFieldDateNaiss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldDateNaissMouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldDateNaiss, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 255, 92, -1));

        jLabel6.setText("Sexe :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 303, -1, -1));

        buttonGroup1.add(jRadioButtonFille);
        jRadioButtonFille.setSelected(true);
        jRadioButtonFille.setText("Fille");
        jRadioButtonFille.setEnabled(false);
        getContentPane().add(jRadioButtonFille, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 300, -1, -1));

        buttonGroup1.add(jRadioButtonGarcon);
        jRadioButtonGarcon.setText("Garçon");
        jRadioButtonGarcon.setEnabled(false);
        getContentPane().add(jRadioButtonGarcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 328, -1, -1));

        jButtonInscription.setText("Inscription");
        jButtonInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscriptionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 368, -1, -1));

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 368, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldLoginMouseClicked
        if (jTextFieldLogin.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldLogin.setText(null);
            jTextFieldLogin.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldLoginMouseClicked

    private void jButtonVerifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerifierActionPerformed
        if (jTextFieldLogin.getForeground() != Color.LIGHT_GRAY) {
            if (!jTextFieldLogin.getText().isEmpty()) {
                login = jTextFieldLogin.getText();
                if (true) {
                    jButtonQuitter.setEnabled(false);
                    jButtonVerifier.setEnabled(false);
                    jTextFieldLogin.setEnabled(false);
                    jTextFieldEmail.setEnabled(true);
                    jTextFieldMDP1.setEnabled(true);
                    jTextFieldMDP2.setEnabled(true);
                    jTextFieldDateNaiss.setEnabled(true);
                    jRadioButtonFille.setEnabled(true);
                    jRadioButtonGarcon.setEnabled(true);
                } else {
                    MessageBox mb = new MessageBox(this, true, "Nom d'utilisateur déjà utilisé");
                    mb.setVisible(true);
                }
            } else {
                MessageBox mb = new MessageBox(this, true, "Champs login vide");
                mb.setVisible(true);
            }
        } else {
            MessageBox mb = new MessageBox(this, true, "Champs login vide");
            mb.setVisible(true);
        }
    }//GEN-LAST:event_jButtonVerifierActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        this.dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jTextFieldMDP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldMDP1MouseClicked
        if (jTextFieldMDP1.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldMDP1.setText(null);
            jTextFieldMDP1.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldMDP1MouseClicked

    private void jTextFieldMDP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldMDP2MouseClicked
        if (jTextFieldMDP2.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldMDP2.setText(null);
            jTextFieldMDP2.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldMDP2MouseClicked

    private void jTextFieldEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailMouseClicked
        if (jTextFieldEmail.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldEmail.setText(null);
            jTextFieldEmail.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldEmailMouseClicked

    private void jTextFieldDateNaissMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissMouseClicked
        if (jTextFieldDateNaiss.getForeground() == Color.LIGHT_GRAY) {
            jTextFieldDateNaiss.setText(null);
            jTextFieldDateNaiss.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldDateNaissMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        jButtonQuitter.setEnabled(true);
        jButtonVerifier.setEnabled(true);
        jTextFieldLogin.setEnabled(true);
        jTextFieldEmail.setEnabled(false);
        jTextFieldMDP1.setEnabled(false);
        jTextFieldMDP2.setEnabled(false);
        jTextFieldDateNaiss.setEnabled(false);
        jRadioButtonFille.setEnabled(false);
        jRadioButtonGarcon.setEnabled(false);
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jButtonInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscriptionActionPerformed
        mdp = jTextFieldMDP1.getText();
        if (mdp.equals(jTextFieldMDP2.getText())) {
            email = jTextFieldEmail.getText();
            dateNais = jTextFieldDateNaiss.getText();
            if (jRadioButtonFille.isSelected()) {
                sexe = false;
            } else {
                sexe = true;
            }
          //  getControleur().inscrire(login, mdp, email, dateNais, sexe);
            MessageBox mb = new MessageBox(this, true, "L'utilisateur : "+login+" est inscrit");
            mb.setVisible(true);
        } else {
            MessageBox mb = new MessageBox(this, true, "Mot de passe différent");
            mb.setVisible(true);
        }
    }//GEN-LAST:event_jButtonInscriptionActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonInscription;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonVerifier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButtonFille;
    private javax.swing.JRadioButton jRadioButtonGarcon;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldDateNaiss;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldMDP1;
    private javax.swing.JTextField jTextFieldMDP2;
    // End of variables declaration//GEN-END:variables
}
