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

    private Salon salon;
    private int numClient;
    private Socket socket_transfert;
    private Controleur controleur;
    private String nomClient;
    private Utilisateur utilisateur;

    public ThreadClient(int numClient, Socket socket_transfert, Controleur controleur, String nomClient) {
        //this.salon = salon;
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
            // Récupération du flot d'entrée
            InputStream in = socket_transfert.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out0 = socket_transfert.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie0 = new DataOutputStream(out0);

            String j = "j_attends";
            while (j.equals("j_attends")) {
                String ok = "non";
                while (!ok.equals("ok_je_suis_dans_un_salon")) {

                    String demande = entree.readUTF();
                    System.out.println(nomClient + " demande la liste des salons");
                    System.out.println(demande);
                    if (demande.equals("je_veux_la_liste_des_salon")) {
                        sortie0.writeInt(this.controleur.getSalons().size());

                        System.out.println(this.controleur.getSalons().size());
                        for (String key : this.controleur.getSalons().keySet()) {
                            sortie0.writeUTF(key);
                        }
                        ok = entree.readUTF();
                        if (ok.equals("ok_je_suis_dans_un_salon")) {
                            break;
                        }
                    }
                }

                if (ok.equals("ok_je_suis_dans_un_salon")) {
                    String nomSalon = entree.readUTF();
                    salon = controleur.getSalon(nomSalon);
                    salon.getListeClients().add(this);
                    System.out.println("Client : " + nomClient + " est entré dans le salon : " + salon.getIdentSalon());
                    sortie0.writeInt(salon.getListeClients().size());
                    for (int k = 0; k < salon.getListeClients().size(); k++) {
                        sortie0.writeUTF(salon.getListeClients().get(k).getNomClient());
                    }
                    for (int k = 0; k < salon.getListeClients().size(); k++) {
                        if (!salon.getListeClients().get(k).getNomClient().equals(nomClient)) {
                            // Récupération du flot de sortie
                            OutputStream out1 = salon.getListeClients().get(k).getSocket_transfert().getOutputStream();
                            // Création du flot de sortie pour données typées
                            DataOutputStream sortie1 = new DataOutputStream(out1);
                            sortie1.writeUTF("participant");
                            sortie1.writeUTF(nomClient);
                        }
                    }

                    while (!j.equals("je_veux_fermer_le_salon")) {
                        nomClient = entree.readUTF();
                        j = entree.readUTF();
                        if (!j.equals("je_veux_fermer_le_salon")) {
                            System.out.print(nomClient + " : ");
                            System.out.println(j);
                            for (int k = 0; k < salon.getListeClients().size(); k++) {
                                // Récupération du flot de sortie
                                OutputStream out = salon.getListeClients().get(k).getSocket_transfert().getOutputStream();
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
                        } else {
                            try {
                                for (int k = 0; k < salon.getListeClients().size(); k++) {
                                    if (!salon.getListeClients().get(k).getNomClient().equals(nomClient)) {
                                        // Récupération du flot de sortie
                                        OutputStream out1 = salon.getListeClients().get(k).getSocket_transfert().getOutputStream();
                                        // Création du flot de sortie pour données typées
                                        DataOutputStream sortie1 = new DataOutputStream(out1);
                                        sortie1.writeUTF("clientQuitter");
                                        sortie1.writeUTF(nomClient);
                                    }
                                }
                            } catch (Exception e2) {
                                System.out.println("petit PROBLEME : " + e2.toString());
                            }
                            nomSalon = entree.readUTF();
                            sortie0.writeUTF("fermer_salon");
                            System.out.println("OK");
                            salon.getListeClients().remove(this);
                            System.out.println("OK");
                        }
                    }
                    System.out.println(nomClient + " a ferme " + nomSalon);
                    j = "j_attends";
                }
            }
        } catch (Exception e) {
            if (salon.getListeClients().contains(this)) {
                salon.getListeClients().remove(this);
            }
            if (e.toString().equals("java.io.EOFException") || e.toString().equals("java.net.SocketException: Connection reset")) {
                System.out.println("Client : " + nomClient + " a quitté la session");
                try {
                    for (int k = 0; k < salon.getListeClients().size(); k++) {
                        if (!salon.getListeClients().get(k).getNomClient().equals(nomClient)) {
                            // Récupération du flot de sortie
                            OutputStream out1 = salon.getListeClients().get(k).getSocket_transfert().getOutputStream();
                            // Création du flot de sortie pour données typées
                            DataOutputStream sortie1 = new DataOutputStream(out1);
                            sortie1.writeUTF("clientQuitterS");
                            sortie1.writeUTF(nomClient);
                        }
                    }
                } catch (Exception e2) {
                    System.out.println("petit PROBLEME : " + e2.toString());
                }
            } else if (e.toString().equals("java.net.SocketException: socket closed")) {
                System.out.println("Salon " + salon.getIdentSalon() + " fermer, donc client : " + nomClient + " est déco par serveur.");
            } else {
                System.out.println("GROS PROBLEME : " + e.toString());
                System.out.println("Donc client : " + nomClient + " est déco par serveur");
                try {
                    for (int k = 0; k < salon.getListeClients().size(); k++) {
                        if (!salon.getListeClients().get(k).getNomClient().equals(nomClient)) {
                            // Récupération du flot de sortie
                            OutputStream out1 = salon.getListeClients().get(k).getSocket_transfert().getOutputStream();
                            // Création du flot de sortie pour données typées
                            DataOutputStream sortie1 = new DataOutputStream(out1);
                            sortie1.writeUTF("clientQuitterS");
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