/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

/**
 *
 * @author bodinjo
 */
public class Controleur {

    public Controleur() {
    }
    
    public void fenetrePrincipal() {
        FenetrePrincipal fp = new FenetrePrincipal(this);
        fp.setVisible(true);
    }
    
    public void fenetreInscription() {
        Inscription fIns = new Inscription(this);
        fIns.setVisible(true);
    }
    
}
