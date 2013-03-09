/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author bodinjo
 */
public class Controleur {

    private FenetrePrincipal fp;
    private boolean conncte;
    private String nomUtilisateur;
    private Socket socket;
    private DataOutputStream sortie;
    private FSalon fSalon = null;
    private String serveur = "localhost";

    public Controleur() {
        conncte = false;
        fenetrePrincipal();
    }

    public String getServeur() {
        return serveur;
    }

    public void setServeur(String serveur) {
        this.serveur = serveur;
    }

    public boolean isConncte() {
        return conncte;
    }

    public void setConncte(boolean conncte) {
        this.conncte = conncte;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getSortie() {
        return sortie;
    }

    public void setSortie(DataOutputStream sortie) {
        this.sortie = sortie;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void fenetrePrincipal() {
        this.fp = new FenetrePrincipal(this);
        fp.setVisible(true);
    }

    public void fenetreInscription() {
        FInscription fIns = new FInscription(fp, this);
        fIns.setVisible(true);
    }

    public void fenetreConnection() {
        FConnection fConn = new FConnection(fp, this);
        fConn.setVisible(true);
    }

    public void fenetreServeur() {
        FServeur fServeur = new FServeur(fp, this);
        fServeur.setVisible(true);
    }

    public void fenetreAide() {
        FAide fAide = new FAide(fp, this);
        fAide.setVisible(true);
    }

    public void fenetreSalon() {
        if (nomUtilisateur != null) {
            if (fSalon == null) {
                fSalon = new FSalon(fp, this);
            }
            fSalon.setVisible(true);
        } else {
            MessageBox mb = new MessageBox(fp, true, "Vous n'etes pas connecté");
            mb.setVisible(true);
        }
    }

    public int connection(String nomUtilisateur0, String mdp) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            socket = new Socket(serveur, port);
            // Récupération du flot de sortie
            OutputStream out = socket.getOutputStream();
            // Création du flot de sortie pour données typées
            sortie = new DataOutputStream(out);
            // Récupération du flot d'entrée
            InputStream in = socket.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            sortie.writeUTF("connection");
            sortie.writeUTF(nomUtilisateur0);
            sortie.writeUTF(mdp);
            return entree.readInt();
        } catch (Exception e) {
            System.out.println("probleme connection");
            return 3;
        }

    }

    public void deconnection() {
        if (fSalon != null) {
            fSalon.dispose();
            fSalon = null;
        }
        try {
            socket.close();

        } catch (Exception e) {
            System.out.println("probleme déco");
        }

    }

    public boolean testLogin(String login) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            Socket socket2 = new Socket(serveur, port);
            // Récupération du flot d'entrée
            InputStream in = socket2.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket2.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);

            sortie.writeUTF("testlogin");

            sortie.writeUTF(login);

            int reponse = entree.readInt();
            socket2.close();

            if (reponse == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean inscrire(String login, String mdp, String email, String dateNais, Boolean sexe) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            Socket socket2 = new Socket(serveur, port);
            // Récupération du flot d'entrée
            InputStream in = socket2.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket2.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);

            sortie.writeUTF("inscription");

            sortie.writeUTF(login);
            sortie.writeUTF(mdp);
            sortie.writeUTF(email);
            sortie.writeUTF(dateNais);
            if (sexe) {
                sortie.writeInt(1);
            } else {
                sortie.writeInt(0);
            }

            int reponse = entree.readInt();
            socket2.close();

            if (reponse == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
