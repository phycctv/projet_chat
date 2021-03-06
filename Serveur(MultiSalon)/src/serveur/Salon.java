/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p> Salon est la classe permettant d'itentifier un salon côté serveur </p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L;
    private String identSalon;
    private ArrayList<ThreadClient> listeClients;

    public Salon(String identSalon) {
        this.identSalon = identSalon;
        this.listeClients = new ArrayList<ThreadClient>();
    }

    public ArrayList<ThreadClient> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<ThreadClient> listeClients) {
        this.listeClients = listeClients;
    }

    public String getIdentSalon() {
        return identSalon;
    }

    public void setIdentSalon(String identSalon) {
        this.identSalon = identSalon;
    }
}
