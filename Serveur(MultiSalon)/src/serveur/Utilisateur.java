package serveur;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author zhangxi
 */
public class Utilisateur implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String login;
    private String mdp;
    private String email;
    private String dateNais;
    private boolean sexe;

    public Utilisateur(String login, String mdp, String email, String dateNais, boolean sexe) {
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.dateNais = dateNais;
        this.sexe = sexe;
    }

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
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
