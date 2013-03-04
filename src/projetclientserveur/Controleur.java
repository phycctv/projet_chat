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
    private boolean conncte;
    private String nomUtilisateur;

    public Controleur() {
        conncte = false;
        fenetrePrincipal();
    }

    public boolean isConncte() {
        return conncte;
    }

    public void setConncte(boolean conncte) {
        this.conncte = conncte;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void fenetrePrincipal() {
        this.fp = new FenetrePrincipal(this);
        fp.setVisible(true);
    }

    public void fenetreInscription() {
        Inscription fIns = new Inscription(fp, this);
        fIns.setVisible(true);
    }

    public void fenetreConnection() {
        FConnection fConn = new FConnection(fp, this);
        fConn.setVisible(true);
    }

    public void fenetreSalon() {
        if (nomUtilisateur != null) {
            FSalon fSalon = new FSalon(fp, this);
            fSalon.setVisible(true);
        } else {
            MessageBox mb = new MessageBox(fp, true, "Vous n'etes pas conncté");
            mb.setVisible(true);
        }
    }
}
