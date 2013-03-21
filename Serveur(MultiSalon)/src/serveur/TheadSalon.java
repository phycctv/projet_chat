/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author zhangxi
 */
public class TheadSalon extends Thread {

    private Controleur controleur;
    private String nomSalon;

    public TheadSalon(Controleur controleur, String nomSalon) {
        this.controleur=controleur;
    }

    public void run() {

        controleur.lancer();
    }
    
    
    /*
     * int port = 0; ServerSocket socket_ecoute = null;
     *
     * try { port = 5015; } catch (NumberFormatException e) {
     * System.out.println("Je peut pas récupérer le port du serveur :("); } try
     * { socket_ecoute = new ServerSocket(port); } catch (IOException e) { if
     * (port < 1024) { System.out.println("Port réservé au super utilisateur
     * ;)"); } else if (port > 65536) { System.out.println("Port trop grand, ca
     * n'existe pas du tout du tout etc ... ;)"); } else {
     * System.out.println("Port déjà utilisé, norage ;)"); } }
     * System.out.println("J'attend les client :)"); int numClient = 0;
     * //this.getSalon(nomPremierSalon).setListeClients(new
     * ArrayList<ThreadClient>()); while (true) { Socket socket_transfert =
     * null; try { socket_transfert = socket_ecoute.accept(); // appel bloquant
     * numClient++; } catch (IOException e) { System.out.println("Problème pour
     * attendre un client :'("); } try { // Récupération du flot d'entrée
     * InputStream in = socket_transfert.getInputStream(); // Création du flot
     * d'entrée pour données typées DataInputStream entree = new
     * DataInputStream(in); // Récupération du flot de sortie OutputStream out =
     * socket_transfert.getOutputStream(); // Création du flot de sortie pour
     * données typées DataOutputStream sortie = new DataOutputStream(out);
     * String parametre = entree.readUTF();
     *
     * if (parametre.equals("connection")) { String nomClient =
     * entree.readUTF(); String mdp = entree.readUTF(); if
     * (controleur.getUtilisateur(nomClient) == null) { sortie.writeInt(1); }
     * else if (!controleur.getUtilisateur(nomClient).getMdp().equals(mdp)) {
     * sortie.writeInt(2); } else { sortie.writeInt(0); ThreadClient client =
     * new ThreadClient(controleur.getSalon(nomSalon), numClient,
     * socket_transfert, controleur, nomClient); client.start();
     * controleur.getSalon(nomSalon).getListeClients().remove(client); } } else
     * if (parametre.equals("inscription")) { ThreadInscription inscription =
     * new ThreadInscription(numClient, socket_transfert, controleur);
     * inscription.start(); //controleur.sauve(); } else if
     * (parametre.equals("testlogin")) { if
     * (controleur.getUtilisateur(entree.readUTF()) == null) {
     * sortie.writeInt(1); } else { sortie.writeInt(0); } }
     *
     * } catch (Exception e) { System.out.println("Problème ouverture
     * connection/inscription : " + e.toString()); }
     * System.out.println("mouahaha");
     *
     * }
     * }
     */

    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }
}
