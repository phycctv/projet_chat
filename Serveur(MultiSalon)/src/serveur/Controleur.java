package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * <p> Controleur est la classe qui regroupe toutes les méthodes principals du
 * serveur </p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class Controleur implements Serializable {

    /**
     * Variable de Controleur
     *
     * @see Utilisateur
     * @see Salon
     */
    private static final long serialVersionUID = 1L;
    private HashMap<String, Utilisateur> utilisateurs;
    private HashMap<String, Salon> salons;
    private HashMap<String, Salon> salonsNonLancer;
    private String nomPremierSalon = "Premier Salon";
    private boolean serveurEnLigne;

    /**
     * Constructeur Controleur. <p> A la construction de l'objet Controleur, on
     * initialise les différents HashMap. </p>
     *
     * @see Controleur#setSalon(serveur.Salon, java.lang.String)
     * @see Controleur#setSalonNonLancer(serveur.Salon, java.lang.String)
     * @see Controleur#setSalons(java.util.HashMap)
     */
    public Controleur() {
        this.setUtilisateurs(new HashMap<String, Utilisateur>());
        this.setSalons(new HashMap<String, Salon>());
        this.setSalonsNonLancer(new HashMap<String, Salon>());
        this.setSalon(new Salon(nomPremierSalon), nomPremierSalon);
    }

    /**
     * Retourne le nom du premier salon
     *
     * @return nomPremierSalon
     */
    public String getNomPremierSalon() {
        return nomPremierSalon;
    }

    /**
     * Met à jour le nom du premier salon
     *
     * @param nomPremierSalon Nom du premier salon
     *
     */
    public void setNomPremierSalon(String nomPremierSalon) {
        this.nomPremierSalon = nomPremierSalon;
    }

    /**
     * Retourne l'ensemble des utilisateurs
     */
    private HashMap<String, Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    /**
     * Met à jour la liste des utilisateurs
     *
     * @param utilisateurs Liste utilisateur
     *
     */
    private void setUtilisateurs(HashMap<String, Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    /**
     * Retourne un utilisateur suivant son nom de login
     *
     * @return Utilisateur
     */
    public Utilisateur getUtilisateur(String login) {
        return this.getUtilisateurs().get(login);
    }

    /**
     * Rajoute un utilisateur à la liste d'utilisateur
     *
     * @param utilisateur L'utilisateur
     * @param login Son login
     *
     */
    public void setUtilisateur(Utilisateur utilisateur, String login) {
        this.getUtilisateurs().put(login, utilisateur);
    }

    /**
     * Retourne la liste des salons
     */
    public HashMap<String, Salon> getSalons() {
        return salons;
    }

    /**
     * Met à jour la liste des salons
     *
     * @param salons
     *
     */
    public void setSalons(HashMap<String, Salon> salons) {
        this.salons = salons;
    }

    /**
     * Retourne un salon suivant son nom
     *
     * @return Salon
     */
    public Salon getSalon(String identSalon) {
        return this.getSalons().get(identSalon);
    }

    /**
     * Rajoute un salon à la liste des salons
     *
     * @param salon
     * @param identSalon
     *
     */
    public void setSalon(Salon salon, String identSalon) {
        this.getSalons().put(identSalon, salon);
    }

    /**
     * Retourne la liste des salons non lancer
     */
    public HashMap<String, Salon> getSalonsNonLancer() {
        return salonsNonLancer;
    }

    /**
     * Met à jour la liste des salons non lancer
     *
     * @param salonsNonLancer
     *
     */
    public void setSalonsNonLancer(HashMap<String, Salon> salonsNonLancer) {
        this.salonsNonLancer = salonsNonLancer;
    }

    /**
     * Retourne un Salon suivant son identifiant
     *
     * @return Salon
     */
    public Salon getSalonNonLancer(String identSalon) {
        return this.getSalonsNonLancer().get(identSalon);
    }

    /**
     * Rajoute un Salon non lancer à la liste
     *
     * @param salon
     * @param identSalon
     *
     */
    public void setSalonNonLancer(Salon salon, String identSalon) {
        this.getSalonsNonLancer().put(identSalon, salon);
    }

    /**
     * Retourne si le serveur est en ligne
     *
     * @return serveurEnLigne Vrais ou Faux
     */
    public boolean isServeurEnLigne() {
        return serveurEnLigne;
    }

    /**
     * Met à jour le serveur est en ligne
     *
     * @param serveurEnLigne Vrais ou Faux
     *
     */
    public void setServeurEnLigne(boolean serveurEnLigne) {
        this.serveurEnLigne = serveurEnLigne;
    }

    /**
     * Cree la fenetre principal et la rend visible
     *
     * @see FPrincipal
     */
    public void fenetrePrincipal() {
        FPrincipal fp = new FPrincipal(this);
        fp.setVisible(true);

    }

    /**
     * Initialise le serveur avec le port 5015
     */
    public ServerSocket init() {
        ServerSocket socket_ecoute = null;
        int port = 0;
        try {
            port = 5015;
        } catch (NumberFormatException e) {
            System.out.println("Je peut pas récupérer le port du serveur :(");
        }
        try {
            socket_ecoute = new ServerSocket(port);
        } catch (IOException e) {
            if (port < 1024) {
                System.out.println("Port réservé au super utilisateur ;)");
            } else if (port > 65536) {
                System.out.println("Port trop grand, ca n'existe pas du tout du tout etc ... ;)");
            } else {
                System.out.println("Port déjà utilisé, norage ;)");
            }
        }
        return socket_ecoute;
    }

    /**
     * Ouvre un salon
     *
     * @see Controleur#setSalon(serveur.Salon, java.lang.String)
     */
    public void ouvrirUnSalon(String identSalon) {
        this.setSalon(getSalonsNonLancer().remove(identSalon), identSalon);
    }

    /**
     * Ferme un salon
     *
     * @see Controleur#setSalonNonLancer(serveur.Salon, java.lang.String)
     */
    public void fermerUnSalon(String identSalon) {
        notification(identSalon);
        this.setSalonNonLancer(getSalons().remove(identSalon), identSalon);

    }

    /**
     * Notifie les utilisateurs du salon en parametre qu'il a été fermé par le
     * serveur.
     *
     * @return identSalon
     */
    public boolean notification(String identSalon) {
        try {
            Salon s = getSalon(identSalon);
            for (int i = 0; i < s.getListeClients().size(); i++) {
                Socket socket_transfert = s.getListeClients().get(i).getSocket_transfert();
                // Récupération du flot de sortie
                OutputStream out = socket_transfert.getOutputStream();
                // Création du flot de sortie pour données typées
                DataOutputStream sortie = new DataOutputStream(out);
                sortie.writeUTF("notification");
                sortie.writeUTF("le_serveur_ferme_le_salon");
                socket_transfert.close();
            }
        } catch (Exception e) {
            System.out.println("Problème de notification : " + e.toString());
            return false;
        }
        return true;
    }

    /**
     * Lance le serveur pour un client, soit pour inscrire, soit pour connecter
     * soit pour un salon
     *
     * @param socket_ecoute
     */
    public void lancer(ServerSocket socket_ecoute) {

        System.out.println("J'attend les clients :)");
        int numClient = 0;
        while (!socket_ecoute.isClosed()) {
            Socket socket_transfert = null;
            try {
                socket_transfert = socket_ecoute.accept();  // appel bloquant
                numClient++;
            } catch (IOException e) {
                MessageBox mb = new MessageBox(null, true, "Serveur stoppé!!!  tous les clients sont déconnectés");
                mb.setVisible(true);
                System.out.println("Serveur stoppé!!!");
            }
            if (!socket_ecoute.isClosed()) {
                try {
                    // Récupération du flot d'entrée
                    InputStream in = socket_transfert.getInputStream();
                    // Création du flot d'entrée pour données typées
                    DataInputStream entree = new DataInputStream(in);
                    // Récupération du flot de sortie
                    OutputStream out = socket_transfert.getOutputStream();
                    // Création du flot de sortie pour données typées
                    DataOutputStream sortie = new DataOutputStream(out);
                    String parametre = entree.readUTF();

                    if (parametre.equals("connection")) {
                        String nomClient = entree.readUTF();
                        String mdp = entree.readUTF();
                        if (getUtilisateur(nomClient) == null) {
                            sortie.writeInt(1);
                        } else if (!getUtilisateur(nomClient).getMdp().equals(mdp)) {
                            sortie.writeInt(2);
                        } else {
                            sortie.writeInt(0);
                            ThreadClient client = new ThreadClient(numClient, socket_transfert, this, nomClient);
                            client.start();
                        }
                    } else if (parametre.equals("inscription")) {
                        ThreadInscription inscription = new ThreadInscription(numClient, socket_transfert, this);
                        inscription.start();
                        //this.sauve();
                    } else if (parametre.equals("testlogin")) {
                        if (getUtilisateur(entree.readUTF()) == null) {
                            sortie.writeInt(1);
                        } else {
                            sortie.writeInt(0);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Problème ouverture connection/inscription : " + e.toString());
                }
            }

        }
    }

    /**
     * Permet de restaurer les données du serveur (Utilisateur, Salon)
     */
    public Controleur restaure() {
        try {
            FileInputStream fichier = new FileInputStream("Fsauv.ser");
            ObjectInputStream in = new ObjectInputStream(fichier);
            return ((Controleur) in.readObject());
        } catch (Exception e) {
            System.out.println("Pbs de Restauration ou fichier non encore créé");
            return this;
        }
    }

    /**
     * Permet de sauvegarder les données du serveur (Utilisateur, Salon)
     */
    public void sauve() {
        try {
            FileOutputStream f = new FileOutputStream("Fsauv.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
        } catch (Exception e) {
            System.out.println("Pb de Sauvegarde dans le fichier" + e.getMessage());
            System.out.println("Pour bien sauvegarder tous les données, il est conseillé de fermer tous les salons");
        }
    }
}
