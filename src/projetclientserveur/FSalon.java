/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author zhangxi
 */
public class FSalon extends javax.swing.JFrame {

    /**
     * Creates new form FSalon
     */
    private Controleur controleur;
    private java.awt.Frame parent;
    private DefaultListModel listModel1;
    private ThreadAfficher messagesbox;
    private String identSalon;

    public FSalon(String identSalon, java.awt.Frame parent, Controleur controleur) {
        this.setControleur(controleur);
        this.parent = parent;
        this.identSalon = identSalon;
        setBounds(400, 300, 391, 353);
        initComponents();

        // String[] data = {this.controleur.getNomUtilisateur(), "asd"};

        this.jLabel1.setText(this.controleur.getNomUtilisateur() + java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString(" : "));
        listModel1 = new DefaultListModel();
        messagesbox = new ThreadAfficher(identSalon, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("MESSAGEAREA"), listModel1, jTextPaneMessage, controleur);
        messagesbox.start();
        //listModel1.addElement(this.controleur.getNomUtilisateur());
        this.jList1 = new JList(listModel1);
        jScrollPane2.setViewportView(jList1);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneMessage = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("projetclientserveur/Bundle"); // NOI18N
        setTitle(bundle.getString("SALON DE DISCUTION")); // NOI18N
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(jList1);

        jTextField1.setForeground(java.awt.Color.lightGray);
        jTextField1.setText(bundle.getString("ENTRE VOTRE MESSAGE ICI ...")); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText(bundle.getString("ENVOYER")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("JLABEL1")); // NOI18N

        jLabel2.setText(bundle.getString("PARTICIPANTS")); // NOI18N

        jTextPaneMessage.setEditable(false);
        jScrollPane1.setViewportView(jTextPaneMessage);

        jMenu1.setText(bundle.getString("SALON")); // NOI18N

        jMenuItem1.setText(bundle.getString("QUITTE SALON")); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(bundle.getString("AIDE")); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField1.getText().isEmpty() && jTextField1.getForeground() == Color.black) {
            try {

                // Récupération du flot de sortie
                OutputStream out = this.controleur.getSocket().getOutputStream();
                // Création du flot de sortie pour données typées
                DataOutputStream sortie = new DataOutputStream(out);
                sortie.writeUTF(controleur.getNomUtilisateur());
                sortie.writeUTF(jTextField1.getText());
                jTextField1.setText(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString(""));
            } catch (Exception e) {
                MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME DE CONNECTION, VOUS ÊTES DÉCO"));
                mb.setVisible(true);
            }
        }
        jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("QUITTER LE SALON?"));
        mb.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER && !jTextField1.getText().isEmpty()) {
            try {

                // Récupération du flot de sortie
                OutputStream out = this.controleur.getSocket().getOutputStream();
                // Création du flot de sortie pour données typées
                DataOutputStream sortie = new DataOutputStream(out);
                sortie.writeUTF(controleur.getNomUtilisateur());
                sortie.writeUTF(jTextField1.getText());
                jTextField1.setText(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString(""));
            } catch (Exception e) {
                MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME DE CONNECTION, VOUS ÊTES DÉCO"));
                mb.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getForeground() == Color.LIGHT_GRAY) {
            jTextField1.setText(null);
            jTextField1.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setForeground(Color.LIGHT_GRAY);
            jTextField1.setText(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("ENTRER VOTRE MESSAGE ICI ..."));
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            // Récupération du flot de sortie
            OutputStream out = this.controleur.getSocket().getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);
            sortie.writeUTF(this.controleur.getNomUtilisateur());
            sortie.writeUTF("je_veux_fermer_le_salon");
            sortie.writeUTF(identSalon);
        } catch (Exception e) {
            MessageBox mb = new MessageBox(this, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME DE LA FERMETURE DU SALON"));
            mb.setVisible(true);
        }
        try {
            messagesbox.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FSalon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPaneMessage;
    // End of variables declaration//GEN-END:variables
}
