/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor. haha
 */
package projetclientserveur;

import javax.swing.UIManager;

/**
 *
 * @author zhangxi
 */
public class ProjetClientServeur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Controleur controleur = new Controleur();
        controleur.fenetrePrincipal();
    }
}
