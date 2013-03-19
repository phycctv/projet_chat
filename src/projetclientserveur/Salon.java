/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

/**
 * <p> Salon est la classe permettant d'itentifier un salon </p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class Salon {

    private String identSalon;

    public Salon(String identSalon) {
        this.identSalon = identSalon;
    }

    public String getIdentSalon() {
        return identSalon;
    }

    public void setIdentSalon(String identSalon) {
        this.identSalon = identSalon;
    }
}
