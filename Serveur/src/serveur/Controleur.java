package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
            
            ThreadClient client = new ThreadClient(numClient, socket_transfert, this, listClient);
            client.start();
            
        }
    }

    public ServerSocket getSocket_ecoute() {
        return socket_ecoute;
    }

    public void setSocket_ecoute(ServerSocket socket_ecoute) {
        this.socket_ecoute = socket_ecoute;
    }

    public void login() {
    }
}
