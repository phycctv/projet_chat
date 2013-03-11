/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.util.Locale;
import javax.swing.JMenuItem;

/**
 *
 * @author zhangxi
 */
public class FenetrePrincipal extends javax.swing.JFrame {

    private Controleur controleur;
    /**
     * Creates new form FenetrePrincipal
     */
    public FenetrePrincipal(Controleur controleur) {
        this.setControleur(controleur);
        setBounds(400, 300, 391, 353);
        initComponents();
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

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        mSession = new javax.swing.JMenu();
        mItemInscription = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mItemConnection = new javax.swing.JMenuItem();
        mItemDeconnection = new javax.swing.JMenuItem();
        mItemQuitter = new javax.swing.JMenuItem();
        mSalon = new javax.swing.JMenu();
        mItemSalon = new javax.swing.JMenuItem();
        mAide = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        butDeutsch = new javax.swing.JMenuItem();
        butEnglish = new javax.swing.JMenuItem();
        butEspañol = new javax.swing.JMenuItem();
        butFrancais = new javax.swing.JMenuItem();
        butNederlands = new javax.swing.JMenuItem();
        butItaliano = new javax.swing.JMenuItem();
        butChinois = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuDoc = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("projetclientserveur/Bundle"); // NOI18N
        setTitle(bundle.getString("PROJET CLIENT SERVEUR")); // NOI18N

        mSession.setText(bundle.getString("SESSION")); // NOI18N

        mItemInscription.setText(bundle.getString("INSCRIPTION")); // NOI18N
        mItemInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemInscriptionActionPerformed(evt);
            }
        });
        mSession.add(mItemInscription);
        mSession.add(jSeparator1);

        mItemConnection.setText(bundle.getString("CONNECTION")); // NOI18N
        mItemConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemConnectionActionPerformed(evt);
            }
        });
        mSession.add(mItemConnection);

        mItemDeconnection.setText(bundle.getString("DECONNECTION")); // NOI18N
        mItemDeconnection.setEnabled(false);
        mItemDeconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemDeconnectionActionPerformed(evt);
            }
        });
        mSession.add(mItemDeconnection);

        mItemQuitter.setText(bundle.getString("QUITTER")); // NOI18N
        mItemQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemQuitterActionPerformed(evt);
            }
        });
        mSession.add(mItemQuitter);

        jMenuBar1.add(mSession);

        mSalon.setText(bundle.getString("SALON")); // NOI18N

        mItemSalon.setText(bundle.getString("SALON")); // NOI18N
        mItemSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSalonActionPerformed(evt);
            }
        });
        mSalon.add(mItemSalon);

        jMenuBar1.add(mSalon);

        mAide.setText(bundle.getString("OPTION")); // NOI18N

        jMenu1.setText("Changer langue ");

        butDeutsch.setText("Deutsch");
        jMenu1.add(butDeutsch);

        butEnglish.setText("English");
        jMenu1.add(butEnglish);

        butEspañol.setText("Español");
        butEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEspañolActionPerformed(evt);
            }
        });
        jMenu1.add(butEspañol);

        butFrancais.setText("Français");
        butFrancais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFrancaisActionPerformed(evt);
            }
        });
        jMenu1.add(butFrancais);

        butNederlands.setText("Nederlands");
        butNederlands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNederlandsActionPerformed(evt);
            }
        });
        jMenu1.add(butNederlands);

        butItaliano.setText("Italiano");
        butItaliano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butItalianoActionPerformed(evt);
            }
        });
        jMenu1.add(butItaliano);

        butChinois.setText("中文 ");
        butChinois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butChinoisActionPerformed(evt);
            }
        });
        jMenu1.add(butChinois);

        mAide.add(jMenu1);

        jMenuItem2.setText(bundle.getString("CHANGER SERVEUR")); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mAide.add(jMenuItem2);

        jMenuDoc.setText(bundle.getString("AIDE")); // NOI18N
        jMenuDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDocActionPerformed(evt);
            }
        });
        mAide.add(jMenuDoc);

        jMenuBar1.add(mAide);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItemQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemQuitterActionPerformed
        MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("QUITTER ?"));
        mb.setVisible(true);
    }//GEN-LAST:event_mItemQuitterActionPerformed

    private void mItemSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSalonActionPerformed
        getControleur().fenetreSalon();
    }//GEN-LAST:event_mItemSalonActionPerformed

    private void mItemInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemInscriptionActionPerformed
        getControleur().fenetreInscription();
    }//GEN-LAST:event_mItemInscriptionActionPerformed

    private void mItemConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemConnectionActionPerformed
        getControleur().fenetreConnection();
    }
    
    public JMenuItem getmItemConnection() {
        return mItemConnection;
    }

    public JMenuItem getmItemInscription() {
        return mItemInscription;
    }

    public JMenuItem getmItemQuitter() {
        return mItemQuitter;
    }

    public JMenuItem getmItemSalon() {
        return mItemSalon;
    }//GEN-LAST:event_mItemConnectionActionPerformed

    public JMenuItem getmItemDeconnection() {
        return mItemDeconnection;
    }

    
    private void mItemDeconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemDeconnectionActionPerformed
        this.controleur.deconnection();
        this.controleur.setNomUtilisateur(null);
        this.mItemConnection.setEnabled(true);
        this.mItemDeconnection.setEnabled(false);
    }//GEN-LAST:event_mItemDeconnectionActionPerformed

    private void jMenuDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDocActionPerformed
        getControleur().fenetreAide();
    }//GEN-LAST:event_jMenuDocActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        getControleur().fenetreServeur();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void butFrancaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFrancaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butFrancaisActionPerformed

    private void butChinoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butChinoisActionPerformed
        // TODO add your handling code here:
        getControleur().setLangue(Locale.PRC);
    }//GEN-LAST:event_butChinoisActionPerformed

    private void butEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEspañolActionPerformed
        // TODO add your handling code here:
        //getControleur().setLangue(createSingleton("en__", "en", ""));
    }//GEN-LAST:event_butEspañolActionPerformed

    private void butItalianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butItalianoActionPerformed
        // TODO add your handling code here:
        getControleur().setLangue(Locale.PRC);
    }//GEN-LAST:event_butItalianoActionPerformed

    private void butNederlandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNederlandsActionPerformed
        // TODO add your handling code here:
        getControleur().setLangue(Locale.PRC);
    }//GEN-LAST:event_butNederlandsActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem butChinois;
    private javax.swing.JMenuItem butDeutsch;
    private javax.swing.JMenuItem butEnglish;
    private javax.swing.JMenuItem butEspañol;
    private javax.swing.JMenuItem butFrancais;
    private javax.swing.JMenuItem butItaliano;
    private javax.swing.JMenuItem butNederlands;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuDoc;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mAide;
    private javax.swing.JMenuItem mItemConnection;
    private javax.swing.JMenuItem mItemDeconnection;
    private javax.swing.JMenuItem mItemInscription;
    private javax.swing.JMenuItem mItemQuitter;
    private javax.swing.JMenuItem mItemSalon;
    private javax.swing.JMenu mSalon;
    private javax.swing.JMenu mSession;
    // End of variables declaration//GEN-END:variables
}
