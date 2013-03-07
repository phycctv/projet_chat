/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author zhangxi
 */
public class SimpleThread extends Thread {

    private String nom;
    private javax.swing.JTextArea messageArea;
    private DefaultListModel listModel1;
    private Controleur controleur;

    public SimpleThread(String nom, DefaultListModel listModel1, javax.swing.JTextArea messageArea, Controleur controleur) {
        this.nom = nom;
        this.listModel1 = listModel1;
        this.messageArea = messageArea;
        this.controleur = controleur;
    }

    public void run() {
        try {
            // Récupération du flot d'entrée
            InputStream in = this.controleur.getSocket().getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out0 = this.controleur.getSocket().getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie0 = new DataOutputStream(out0);
            sortie0.writeUTF("ok_je_suis_dans_le_salon");
            int nb = entree.readInt();
            for (int i = 0; i < nb; i++) {
                listModel1.addElement(entree.readUTF());
            }
            messageArea.append("------Bienvenue chez nous------");
            while (true) {
                String type = entree.readUTF();
                if (type.equals("message")) {
                    messageArea.append("\n" + entree.readUTF());
                    messageArea.setCaretPosition(messageArea.getDocument().getLength());
                } else if (type.equals("participant")) {
                    String nomParticipant = entree.readUTF();
                    listModel1.addElement(nomParticipant);
                    messageArea.append("\n" + nomParticipant + " est entée dans le salon.");
                    messageArea.setCaretPosition(messageArea.getDocument().getLength());
                } else if (type.equals("clientQuitter")) {
                    String clientQuitter = entree.readUTF();
                    listModel1.removeElement(clientQuitter);
                    messageArea.append("\n" + clientQuitter + " a quitté le salon.");
                    messageArea.setCaretPosition(messageArea.getDocument().getLength());
                }

            }
        } catch (Exception e) {
            System.out.println("Vous etes deco.");
        }
    }
}