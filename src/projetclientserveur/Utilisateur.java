package projetclientserveur;

import java.util.Date;
/**
 *
 * @author zhangxi
 */
public class Utilisateur {

    private String login;
    private String mdp;
    private String email;
    private Date dateNais;
    private boolean sexe;

    public Utilisateur(String login, String mdp, String email, Date dateNais, boolean sexe) {
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.dateNais = dateNais;
        this.sexe = sexe;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

}
