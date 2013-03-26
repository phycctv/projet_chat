/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. haha
 */
package projetclientserveur;

import javax.swing.UIManager;

/**
 * <p> ProjetClientServeur est la classe qui contien le main qui permet d'exécuter
 * l'application </p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class ProjetClientServeur {

    /**
     * Récupère le graphisme du systeme pour swing et créé un objet Controleur
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Controleur controleur = new Controleur();
    }
}
