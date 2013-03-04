/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 *
 * @author zhangxi
 */
public class SimpleThread extends Thread {

    private String nom;
    private javax.swing.JTextArea messageArea;
    private Controleur controleur;

    public SimpleThread(String nom, javax.swing.JTextArea messageArea, Controleur controleur) {
        this.nom = nom;
        this.messageArea = messageArea;
        this.controleur = controleur;
    }

    public void run() {
        try {
            // Récupération du flot d'entrée
            InputStream in = this.controleur.getSocket().getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            while (true) {
                messageArea.append(entree.readUTF() + "\n");
            }
        } catch (Exception e) {
        }
    }
}