/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author zhangxi
 */
public class ThreadInscription extends Thread {

    private int numClient;
    private Socket socket_transfert;
    private Controleur controleur;
    private Utilisateur utilisateur;

    public ThreadInscription(int numClient, Socket socket_transfert, Controleur controleur) {
        this.numClient = numClient;
        this.controleur = controleur;
        this.socket_transfert = socket_transfert;
    }

    public void run() {
        try {
            String ip = socket_transfert.getInetAddress().getHostAddress();
            int portCli = socket_transfert.getPort();
            System.out.println(ip + " : " + portCli);
            // Récupération du flot d'entrée
            InputStream in = socket_transfert.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket_transfert.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);
            String login = entree.readUTF();
            String mdp = entree.readUTF();
            String email = entree.readUTF();
            String dateNais = entree.readUTF();
            int sexe1 = entree.readInt();
            boolean sexe2;
            if (sexe1==1) {
                sexe2=true;
            } else {
                sexe2=false;
            }

            utilisateur = new Utilisateur(login, mdp, email, dateNais, sexe2);

            controleur.setUtilisateur(utilisateur, login);
            
            System.out.println("Nouvelle utilisateur : "+login);
            sortie.writeInt(1);


        } catch (Exception e) {
            System.out.println("GROS PROBLEME : " + e.toString());
        }
        try {
            socket_transfert.close();
        } catch (IOException e) {
            System.out.println("Problème pour fermer la connection :'(");
        }
    }
}