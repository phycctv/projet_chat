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

    public Controleur() {
        conncte = false;
        fenetrePrincipal();
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
        Inscription fIns = new Inscription(fp, this);
        fIns.setVisible(true);
    }

    public void fenetreConnection() {
        FConnection fConn = new FConnection(fp, this);
        fConn.setVisible(true);
    }

    public void fenetreSalon() {
        if (nomUtilisateur != null) {
            FSalon fSalon = new FSalon(fp, this);
            fSalon.setVisible(true);
        } else {
            MessageBox mb = new MessageBox(fp, true, "Vous n'etes pas conncté");
            mb.setVisible(true);
        }
    }

    public void connection() {
        try {
            String host = "transit";
            int port = 5015;
            System.out.println(host + " : " + port);
            socket = new Socket(host, port);
            // Récupération du flot d'entrée
            InputStream in = socket.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);
            //sortie.writeInt(42);
            //sortie.writeUTF("Bonjour la Chine, hihi héhé");
            //sortie.write(socket.getInetAddress().getAddress());
            //socket.close();
        } catch (Exception e) {
            System.out.println("Je peut pas m'exécuter :(");
        }

    }

    public void deconnection() {
        try {
            String host = "transit";
            int port = 5015;
            System.out.println(host + " : " + port);
            socket = new Socket(host, port);
            // Récupération du flot d'entrée
            InputStream in = socket.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket.getOutputStream();
            // Création du flot de sortie pour données typées
            sortie = new DataOutputStream(out);
            socket.close();
        } catch (Exception e) {
            System.out.println("Je peut pas m'exécuter :(");
        }

    }
}
