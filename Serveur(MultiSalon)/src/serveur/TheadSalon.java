/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.net.ServerSocket;

/**
 * <p> TheadSalon est la classe qui execute un salon.</p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class TheadSalon extends Thread {

    private Controleur controleur;
    private ServerSocket socket_ecoute;

    public TheadSalon(Controleur controleur, ServerSocket socket_ecoute) {
        this.controleur = controleur;
        this.socket_ecoute = socket_ecoute;
    }

    public void run() {

        controleur.lancer(socket_ecoute);
    }
}
