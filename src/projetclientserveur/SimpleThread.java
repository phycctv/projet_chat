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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author zhangxi
 */
public class SimpleThread extends Thread {

    private String nom;
    private JTextPane messagePane;
    private DefaultListModel listModel1;
    private Controleur controleur;
    private HTMLEditorKit kit;
    private HTMLDocument doc;

    public SimpleThread(String nom, DefaultListModel listModel1, JTextPane messagePane, Controleur controleur) {
        this.nom = nom;
        this.listModel1 = listModel1;
        this.messagePane = messagePane;
        this.controleur = controleur;
        this.kit = new HTMLEditorKit();
        this.doc = new HTMLDocument();
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

            messagePane.setEditorKit(kit);
            messagePane.setDocument(doc);
            kit.insertHTML(doc, doc.getLength(),
                    "<p ALIGN=\"center\">------ Bienvenue chez nous ------</p>", 0, 0, null);
            
            while (true) {
                String type = entree.readUTF();
                if (type.equals("message")) {
                    String sexe = entree.readUTF();
                    if (sexe.equals("garcon")) {
                        kit.insertHTML(doc, doc.getLength(), "<font color='blue'><b>"
                                + entree.readUTF() + " :</b></font><p>"
                                + entree.readUTF() + "</p>", 0, 0, null);
                    } else if (sexe.equals("fille")) {
                        kit.insertHTML(doc, doc.getLength(), "<font color='#FD6C9E'><b>"
                                + entree.readUTF() + " :</b></font><p>"
                                + entree.readUTF() + "</p>", 0, 0, null);
                    }
                    messagePane.setCaretPosition(messagePane.getDocument().getLength());
                    
                } else if (type.equals("participant")) {
                    String nomParticipant = entree.readUTF();
                    listModel1.addElement(nomParticipant);
                    kit.insertHTML(doc, doc.getLength(), "<p>" + nomParticipant
                            + " est entrée dans le salon.</p>", 0, 0, null);
                    messagePane.setCaretPosition(messagePane.getDocument().getLength());
                    
                } else if (type.equals("clientQuitter")) {
                    String clientQuitter = entree.readUTF();
                    listModel1.removeElement(clientQuitter);
                    kit.insertHTML(doc, doc.getLength(), "<p>" + clientQuitter
                            + " a quitté le salon.</p>", 0, 0, null);
                    messagePane.setCaretPosition(messagePane.getDocument().getLength());
                }

            }
        } catch (Exception e) {
            System.out.println("Vous etes deco.");
        }
    }
}