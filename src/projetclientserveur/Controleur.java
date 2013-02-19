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
    private FenetrePrincipal fp;
    public Controleur() {
    }
    
    public void fenetrePrincipal() {
        this.fp = new FenetrePrincipal(this);
        fp.setVisible(true);
    }
    
    public void fenetreInscription() {
        Inscription fIns = new Inscription(fp,this);
        fIns.setVisible(true);
    }
    
}
