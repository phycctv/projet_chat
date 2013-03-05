package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author zhangxi
 */
public class Controleur {

    private ServerSocket socket_ecoute;

    public Controleur() {
        int port = 0;
        ServerSocket socket_ecoute = null;
        Socket socket_transfert = null;
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
        System.out.println("J'attend un client :)");

    }

    public ServerSocket getSocket_ecoute() {
        return socket_ecoute;
    }

    public void setSocket_ecoute(ServerSocket socket_ecoute) {
        this.socket_ecoute = socket_ecoute;
    }

    public void login(Socket socket_transfert) {

        try {
            socket_transfert = socket_ecoute.accept();  // appel bloquant
        } catch (IOException e) {
            System.out.println("Problème pour attendre un client :'(");
        }
        try {
            String ip = socket_transfert.getInetAddress().getHostAddress();
            int portCli = socket_transfert.getPort();
            System.out.println(ip + " : " + portCli);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("Je peut pas attendre");
            }
            // Récupération du flot d'entrée
            InputStream in = socket_transfert.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket_transfert.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);
            while (true) {
                String i = entree.readUTF();
                String j = entree.readUTF();
                System.out.print(i + " : ");
                System.out.println(j);
                sortie.writeUTF(i + " : " + j);
            }


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
