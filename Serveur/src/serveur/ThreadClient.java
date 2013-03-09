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
public class ThreadClient extends Thread {

    private int numClient;
    private Socket socket_transfert;
    private Controleur controleur;
    private String nomClient;
    private Utilisateur utilisateur;

    public ThreadClient(int numClient, Socket socket_transfert, Controleur controleur, String nomClient) {
        this.numClient = numClient;
        this.controleur = controleur;
        this.socket_transfert = socket_transfert;
        this.nomClient = nomClient;
        this.utilisateur = controleur.getUtilisateur(nomClient);
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Socket getSocket_transfert() {
        return socket_transfert;
    }

    public void setSocket_transfert(Socket socket_transfert) {
        this.socket_transfert = socket_transfert;
    }

    public void run() {
        try {
            String ip = socket_transfert.getInetAddress().getHostAddress();
            int portCli = socket_transfert.getPort();
            System.out.println(ip + " : " + portCli);

            controleur.getListClient().add(this);
            // Récupération du flot d'entrée
            InputStream in = socket_transfert.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out0 = socket_transfert.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie0 = new DataOutputStream(out0);
            String ok = entree.readUTF();
            if (ok.equals("ok_je_suis_dans_le_salon")) {
                System.out.println("Client : " + nomClient + " est entré dans le salon");
                sortie0.writeInt(controleur.getListClient().size());
                for (int k = 0; k < controleur.getListClient().size(); k++) {
                    sortie0.writeUTF(controleur.getListClient().get(k).getNomClient());
                }
                for (int k = 0; k < controleur.getListClient().size(); k++) {
                    if (!controleur.getListClient().get(k).getNomClient().equals(nomClient)) {
                        // Récupération du flot de sortie
                        OutputStream out1 = controleur.getListClient().get(k).getSocket_transfert().getOutputStream();
                        // Création du flot de sortie pour données typées
                        DataOutputStream sortie1 = new DataOutputStream(out1);
                        sortie1.writeUTF("participant");
                        sortie1.writeUTF(nomClient);
                    }
                }
                while (true) {
                    nomClient = entree.readUTF();
                    String j = entree.readUTF();
                    System.out.print(nomClient + " : ");
                    System.out.println(j);
                    for (int k = 0; k < controleur.getListClient().size(); k++) {
                        // Récupération du flot de sortie
                        OutputStream out = controleur.getListClient().get(k).getSocket_transfert().getOutputStream();
                        // Création du flot de sortie pour données typées
                        DataOutputStream sortie = new DataOutputStream(out);
                        sortie.writeUTF("message");
                        if (utilisateur.isSexe()) {
                            sortie.writeUTF("garcon");
                        } else {
                            sortie.writeUTF("fille");
                        }
                        sortie.writeUTF(nomClient);
                        sortie.writeUTF(j);
                    }

                }
            }
        } catch (Exception e) {
            controleur.getListClient().remove(this);
            if (e.toString()=="java.io.EOFException" || e.toString()=="java.net.SocketException") {
                System.out.println("Client : " + nomClient + " a quitté la session");
                try {
                    for (int k = 0; k < controleur.getListClient().size(); k++) {
                        if (!controleur.getListClient().get(k).getNomClient().equals(nomClient)) {
                            // Récupération du flot de sortie
                            OutputStream out1 = controleur.getListClient().get(k).getSocket_transfert().getOutputStream();
                            // Création du flot de sortie pour données typées
                            DataOutputStream sortie1 = new DataOutputStream(out1);
                            sortie1.writeUTF("clientQuitter");
                            sortie1.writeUTF(nomClient);
                        }
                    }
                } catch (Exception e2) {
                    System.out.println("petit PROBLEME : " + e2.toString());
                }
            } else {
                System.out.println("GROS PROBLEME : " + e.toString());
                System.out.println("Donc client : " + nomClient + " est déco par serveur");
                try {
                    for (int k = 0; k < controleur.getListClient().size(); k++) {
                        if (!controleur.getListClient().get(k).getNomClient().equals(nomClient)) {
                            // Récupération du flot de sortie
                            OutputStream out1 = controleur.getListClient().get(k).getSocket_transfert().getOutputStream();
                            // Création du flot de sortie pour données typées
                            DataOutputStream sortie1 = new DataOutputStream(out1);
                            sortie1.writeUTF("clientQuitter");
                            sortie1.writeUTF(nomClient);
                        }
                    }
                } catch (Exception e2) {
                    System.out.println("petit PROBLEME : " + e2.toString());
                }
            }
        }
        try {
            socket_transfert.close();
        } catch (IOException e) {
            System.out.println("Problème pour fermer la connection :'(");
        }
    }
}