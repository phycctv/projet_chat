/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetclientserveur;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * <p> Controleur est la classe qui regroupe toutes les méthodes principals du
 * client </p>
 *
 * @author J. Bodin et X. Zhang
 * @version 1.0
 */
public class Controleur {

    /**
     * Variable de Controleur
     *
     * @see FSalon
     * @see FPrincipal
     * @see DataOutputStream
     */
    private FPrincipal fp;
    private boolean connecter;
    private String nomUtilisateur;
    private Socket socket;
    private DataOutputStream sortie;
    private FSalon fSalon = null;
    private Image icone;
    /**
     * L'adresse du serveur. Ce serveur est changeable.
     *
     * @see Controleur#getServeur()
     * @see Controleur#setServeur(String)
     */
    private String serveur = "localhost";

    /**
     * Constructeur Controleur. <p> A la construction de l'objet Controleur, on
     * initialise connecter à false et on créé l'objet FPrincipal. </p>
     *
     * @see Controleur#connecter
     * @see Controleur#fenetrePrincipal()
     */
    public Controleur() {
        connecter = false;
        icone = Toolkit.getDefaultToolkit().getImage("WindowsLiveMessenger.png");
        fenetrePrincipal();
    }

    /**
     * Retourne l'adresse du serveur actuellement configuré
     *
     * @return L'adresse du serveur
     */
    public String getServeur() {
        return serveur;
    }

    /**
     * Met à jour l'adresse du serveur
     *
     * @param serveur La nouvelle adresse du serveur
     *
     */
    public void setServeur(String serveur) {
        this.serveur = serveur;
    }

    /**
     * Retourne si l'utilisateur est connecter.
     *
     * @return Vrais ou Faux
     */
    public boolean isConnecte() {
        return connecter;
    }

    /**
     * Met à jour si un utilisateur est connecté ou pas
     *
     * @param connecter Vrais ou faux si l'utilisateur ce connecte ou déco.
     *
     */
    public void setConnecte(boolean connecter) {
        this.connecter = connecter;
    }

    /**
     * Retourne le nom de l'utilisateur
     *
     * @return Le nom du membre
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    /**
     * Met à jour le nom de l'utilisateur actuellement connecté
     *
     * @param nomUtilisateur Le nom de l'utilisateur connecté
     *
     */
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    /**
     * Retourne le socket
     *
     * @return Le socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Met à jour le socket
     *
     * @param socket Le nouveau socket du client.
     *
     * @see Socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Retourne la dataOutputStream
     *
     * @return La sortie
     */
    public DataOutputStream getSortie() {
        return sortie;
    }

    /**
     * Met à jour la variable sortie
     *
     * @param sortie La nouvelle sortie.
     *
     * @see DataOutputStream
     */
    public void setSortie(DataOutputStream sortie) {
        this.sortie = sortie;
    }

    /**
     * Met à jour la langue de l'application
     *
     * @param pays Le nouveau pays.
     *
     * @see Locale
     */
    public void setLangue(Locale pays) {
        Locale.setDefault(pays);
        fp.dispose();
        fenetrePrincipal();
    }

    /**
     * Cree la fenetre principal et la rend visible
     *
     * @see FPrincipal
     */
    public void fenetrePrincipal() {
        this.fp = new FPrincipal(this);
        fp.setVisible(true);
        fp.setIconImage(icone);
    }

    /**
     * Cree la fenetre inscription et la rend visible
     *
     * @see FInscription
     */
    public void fenetreInscription() {
        FInscription fIns = new FInscription(fp, this);
        fIns.setVisible(true);
        fIns.setIconImage(icone);
    }

    /**
     * Cree la fenetre de connection et la rend visible
     *
     * @see FConnection
     */
    public void fenetreConnection() {
        FConnection fConn = new FConnection(fp, this);
        fConn.setVisible(true);
        fConn.setIconImage(icone);
    }

    /**
     * Cree la fenetre de modification du serveur et la rend visible
     *
     * @see FServeur
     */
    public void fenetreServeur() {
        FServeur fServeur = new FServeur(fp, this);
        fServeur.setVisible(true);
        fServeur.setIconImage(icone);
    }

    /**
     * Cree la fenetre d'aide et la rend visible
     *
     * @see FAide
     */
    public void fenetreAide() {
        FAide fAide = new FAide(fp, this);
        fAide.setVisible(true);
        fAide.setIconImage(icone);
    }

    /**
     * Cree une fenetre d'un salon de discution et la rend visible
     *
     * @see FSalon
     */
    public void fenetreSalon(String identSalon) {
        if (nomUtilisateur != null) {
            //if (fSalon == null) {
            fSalon = new FSalon(identSalon, fp, this);
            // }
            fp.setVisible(false);
            fSalon.setVisible(true);
            fSalon.setIconImage(icone);
        } else {
            MessageBox mb = new MessageBox(fp, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("VOUS N'ETES PAS CONNECTÉ"));
            mb.setVisible(true);
        }
    }

    /**
     * Pour se connecter au serveur avec des identifiants valide
     *
     * @param nomUtilisateur0 Le nom de l'utilisateur souhaitant se connecter
     * @param mdp Le mot de passe de l'utilisateur souhaitant se connecter
     *
     */
    public int connection(String nomUtilisateur0, String mdp) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            socket = new Socket(serveur, port);
            // Récupération du flot de sortie
            OutputStream out = socket.getOutputStream();
            // Création du flot de sortie pour données typées
            sortie = new DataOutputStream(out);
            // Récupération du flot d'entrée
            InputStream in = socket.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            sortie.writeUTF("connection");
            sortie.writeUTF(nomUtilisateur0);
            sortie.writeUTF(mdp);
            return entree.readInt();
        } catch (Exception e) {
            System.out.println(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME CONNECTION"));
            return 3;
        }
    }

    /**
     * Pour récupérer la liste des salons disponible *
     */
    public void recupererListeSalon() {

        try {
            // Récupération du flot d'entrée
            InputStream in = this.getSocket().getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = this.getSocket().getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie0 = new DataOutputStream(out);
            sortie0.writeUTF("je_veux_la_liste_des_salon");
            int nb = entree.readInt();
            System.out.println("Il y a " + nb + " Salon(s)");
            fp.setListeSalon(new DefaultListModel());
            fp.setjList1(new JList(fp.getListeSalon()));
            for (int i = 0; i < nb; i++) {
                String nom = entree.readUTF();
                fp.getListeSalon().addElement(nom);
                System.out.println(nom);
            }
            fp.getjScrollPane1().setViewportView(fp.getjList1());

            if (nb != 0) {
                fp.getjButtonEntrer().setEnabled(true);
                fp.getjList1().setSelectedIndex(0);
            } else {
                MessageBox mb = new MessageBox(fp, true, java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("Aucun salon lance sur ce serveur"));
                mb.setVisible(true);
            }

        } catch (Exception e) {
            System.out.println("Vous etes deco.");
            deconnection();
        }
    }

    /**
     * Pour actualiser la liste des salons disponible
     *
     * @see Controleur#recupererListeSalon()
     */
    public void actualiser() {
        try {
            // Récupération du flot de sortie
            OutputStream out0 = this.getSocket().getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie0 = new DataOutputStream(out0);
            sortie0.writeUTF("non");
        } catch (Exception e) {
            System.out.println("Probleme de la connection.");
        }
        this.recupererListeSalon();
    }

    /**
     * Message si le salon a été fermé par le serveur
     *
     * @see FSalon#fermerParServeur()
     */
    public void salonFermerParServeur() {
        MessageBox mb = new MessageBox(fSalon, true, "Désolé, Le salon est fermer par le serveur");
        mb.setVisible(true);
        fSalon.fermerParServeur();
    }

    /**
     * Pour se deconnecter du serveur
     */
    public void deconnection() {
        //if (fSalon != null) {
        // fSalon.dispose();
        fSalon = null;
        // }
        try {
            socket.close();

        } catch (Exception e) {
            System.out.println(java.util.ResourceBundle.getBundle("projetclientserveur/Bundle").getString("PROBLEME DÉCO"));
        }
        setNomUtilisateur(null);
        fp.getmItemConnection().setEnabled(true);
        fp.getmItemDeconnection().setEnabled(false);
        fp.getMenuLangue().setEnabled(true);
        fp.getMItemServeur().setEnabled(true);
        fp.setListeSalon(new DefaultListModel());
        fp.getjScrollPane1().setVisible(false);
        fp.getjButtonActualiser().setVisible(false);
        fp.getjButtonEntrer().setVisible(false);

    }

    /**
     * Vérifie si le login choisi lors de l'inscription n'est pas déjà utiliser
     *
     * @param login Le nom de l'utilisateur à tester
     *
     */
    public int testLogin(String login) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            Socket socket2 = new Socket(serveur, port);
            // Récupération du flot d'entrée
            InputStream in = socket2.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket2.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);

            sortie.writeUTF("testlogin");

            sortie.writeUTF(login);

            int reponse = entree.readInt();
            socket2.close();

            if (reponse == 1) {
                return 1;
            } else {
                return 2;
            }
        } catch (Exception e) {
            return 3;
        }
    }

    /**
     * Inscrit un utilisateur sur le serveur
     *
     * @param login Le nom de d'utilisateur
     * @param mdp Le mot de passe du nouvel utilisateur
     * @param email Le email du nouvel utilisateur
     * @param dateNais La date de naissance du nouvel utilisateur
     * @param sexe Le sexe du nouvel utilisateur sous forme booléen, vrais si un
     * garçon, faux si une fille.
     *
     */
    public boolean inscrire(String login, String mdp, String email, String dateNais, Boolean sexe) {
        try {
            int port = 5015;
            System.out.println(serveur + " : " + port);
            Socket socket2 = new Socket(serveur, port);
            // Récupération du flot d'entrée
            InputStream in = socket2.getInputStream();
            // Création du flot d'entrée pour données typées
            DataInputStream entree = new DataInputStream(in);
            // Récupération du flot de sortie
            OutputStream out = socket2.getOutputStream();
            // Création du flot de sortie pour données typées
            DataOutputStream sortie = new DataOutputStream(out);

            sortie.writeUTF("inscription");

            sortie.writeUTF(login);
            sortie.writeUTF(mdp);
            sortie.writeUTF(email);
            sortie.writeUTF(dateNais);
            if (sexe) {
                sortie.writeInt(1);
            } else {
                sortie.writeInt(0);
            }

            int reponse = entree.readInt();
            socket2.close();

            if (reponse == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
