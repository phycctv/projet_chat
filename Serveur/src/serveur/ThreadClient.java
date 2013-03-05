/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author zhangxi
 */
public class ThreadClient extends Thread {

    private int numClient;
    private Socket socket_transfert;
    private Controleur controleur;
    private ArrayList<Socket> listClient;

    public ThreadClient(int numClient, Socket socket_transfert, Controleur controleur, ArrayList<Socket> listClient) {
        this.numClient = numClient;
        this.controleur = controleur;
        this.socket_transfert = socket_transfert;
        this.listClient = listClient;
    }

    public void run() {
        try {
            String ip = socket_transfert.getInetAddress().getHostAddress();
            int portCli = socket_transfert.getPort();
            System.out.println(ip + " : " + portCli);

            listClient.add(socket_transfert);
            // Récupération du flot d'entrée
            InputStream in = socket_transfert.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);

            while (true) {
                String i = entree.readUTF();
                String j = entree.readUTF();
                System.out.print(i + " : ");
                System.out.println(j);
                for (int k = 0; k < listClient.size(); k++) {
                    // Récupération du flot de sortie
                    OutputStream out = listClient.get(k).getOutputStream();
                    // Création du flot de sortie pour données typées
                    DataOutputStream sortie = new DataOutputStream(out);
                    sortie.writeUTF(i + " : " + j);
                }
              
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