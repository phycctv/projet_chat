package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author zhangxi
 */
public class Controleur implements Serializable {

    private static final long serialVersionUID = 1L;
    //private ServerSocket socket_ecoute;
    private HashMap<String, Utilisateur> utilisateurs;

    public Controleur() {
        this.setUtilisateurs(new HashMap<String, Utilisateur>());
    }

    private void setUtilisateurs(HashMap<String, Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    private HashMap<String, Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateur(Utilisateur utilisateur, String login) {
        this.getUtilisateurs().put(login, utilisateur);
    }

    public Utilisateur getUtilisateur(String login) {
        return this.getUtilisateurs().get(login);
    }

    //public ServerSocket getSocket_ecoute() {
    //  return socket_ecoute;
    //}
    //public void setSocket_ecoute(ServerSocket socket_ecoute) {
    //    this.socket_ecoute = socket_ecoute;
    //}
    public void lancer() {
        int port = 0;
        ServerSocket socket_ecoute = null;

        try {
            port = 5015;
        } catch (NumberFormatException e) {
            System.out.println("Je peut pas récupérer le port du serveur :(");
        }
        try {
            socket_ecoute = new ServerSocket(port);
        } catch (IOException e) {
            if (port < 1024) {
                System.out.println("Port réservé au super utilisateur ;)");
            } else if (port > 65536) {
                System.out.println("Port trop grand, ca n'existe pas du tout du tout etc ... ;)");
            } else {
                System.out.println("Port déjà utilisé, norage ;)");
            }
        }
        System.out.println("J'attend les client :)");
        int numClient = 0;
        ArrayList<Socket> listClient = new ArrayList<Socket>();
        while (true) {
            Socket socket_transfert = null;
            try {
                socket_transfert = socket_ecoute.accept();  // appel bloquant
                numClient++;
            } catch (IOException e) {
                System.out.println("Problème pour attendre un client :'(");
            }
            try {
                // Récupération du flot d'entrée
                InputStream in = socket_transfert.getInputStream();
                // Création du flot d'entrée pour données typées
                DataInputStream entree = new DataInputStream(in);
                // Récupération du flot de sortie
                OutputStream out = socket_transfert.getOutputStream();
                // Création du flot de sortie pour données typées
                DataOutputStream sortie = new DataOutputStream(out);
                String parametre = entree.readUTF();

                if (parametre.equals("connection")) {
                    String nomClient = entree.readUTF();
                    String mdp = entree.readUTF();
                    if (getUtilisateur(nomClient) == null) {
                        sortie.writeInt(1);
                    } else if (getUtilisateur(nomClient).getMdp() != mdp) {
                        sortie.writeInt(2);
                    } else {
                        sortie.writeInt(0);
                        ThreadClient client = new ThreadClient(numClient, socket_transfert, this, listClient);
                        client.start();
                        listClient.remove(socket_transfert);
                    }
                } else if (parametre.equals("inscription")) {
                    ThreadInscription inscription = new ThreadInscription(numClient, socket_transfert, this);
                    inscription.start();
                    this.sauve();
                } else if (parametre.equals("testlogin")) {
                    if (getUtilisateur(entree.readUTF()) == null) {
                        sortie.writeInt(1);
                    } else {
                        sortie.writeInt(0);
                    }
                }

            } catch (Exception e) {
                System.out.println("Problème ouverture connection/inscription : " + e.toString());
            }
            System.out.println("mouahaha");

        }
    }

    public Controleur restaure() {
        try {
            FileInputStream fichier = new FileInputStream("Fsauv.ser");
            ObjectInputStream in = new ObjectInputStream(fichier);
            return ((Controleur) in.readObject());
        } catch (Exception e) {
            System.out.println("Pbs de Restauration ou fichier non encore créé");
            return this;
        }
    }

    /**
     * sauvegarde des objets de l'application
     */
    private void sauve() {
        try {
            FileOutputStream f = new FileOutputStream("Fsauv.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
        } catch (Exception e) {
            System.out.println("Pb de Sauvegarde dans le fichier");
        }
    }
}
