package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Fond extends JPanel implements ActionListener{
	// declaration du jeu avec lequel il est associe
	private Jeu jeu;
	
	// declaration de tout les boutons
	private JButton btnNouvellePartie;
	private JButton btnChargerPartie;
	private JButton btnSauverPartie;
	
	private JButton btnLancerDes;
	private JButton btnAcheterMaison;
	private JButton btnAcheterHotel;
	private JButton btnSortiPrison;
	private JButton btnAcheter;
	private JButton btnPasAcheter;
	private JButton btnQuitter;
	private JButton bouttonOK;
	
	
	private JButton btnFinTour;
	
	//declaration de tout les panels
	private JPanel panelGauche;	
	private JPanel panelDroit;
	private JPanel panelSolde;
	private JPanel panelCommunication;
	private JPanel panelInfoSaisieJoueur;
	private JPanel panelCouleur;
	private JPanel panelBoutonsAction;
	private JPanel panelBoutonsCommuns;
	
	//tout les panels de boutons possible
	private JPanel panelGestionPartie;
	private JPanel panelLancerDe;
	private JPanel panelHimo;
	private JPanel panelSortiPrison;
	private JPanel panelAchat;
	private JPanel panelSaisie;
	private JPanel panelSaisieJoueur;
	
	private JPanel panelInterraction;
	private JPanel panelBoutons;
	private JPanel panelQuitter;
		
	// declaration label
	private JLabel labelAnnonceJoueurJoue;
	private JLabel labelAnnonceArgentPlateau;
	private JLabel labelSoldePlateau;
	private JLabel labelAnnonceArgentJoueur;
	private JLabel labelSoldeJoueur;
	private JLabel labelCommunication;
	private JLabel labelAnnonceLancerDe;
	private JLabel annonceInfoCbJoueur;
	private JLabel infoCbJoueur;
	private JLabel labelConsigne;
	private JLabel fondMonopoly;
	private JLabel soldePlateau;
	private JLabel soldeJoueur;
	private JLabel annonceCouleur;
	private JLabel labelInfo;
	
	// declaration du textField
	private JTextField zone1;
	// on cree le text field
	private JTextField fieldNomPartie;
	private JTextField fieldSaisieJoueur;
	
	// declaration de l'image
	private Icon imageMonopoly;
	
	private JComboBox comboCouleur;
	
	// constructeur
	Fond (){
		
		
		this.setLayout(new GridLayout (1, 2));
		
		
		//on cree tout les panels
		panelGauche = new JPanel();
		panelDroit = new JPanel();
		
		panelInterraction = new JPanel();
		panelBoutons = new JPanel();
		
		
		
		
		
				/////////////Panel Gauche
		// on lui donne son layout
		panelGauche.setLayout(new GridLayout(1,1));
		// on cree l'image
		fondMonopoly = new JLabel(new ImageIcon("src\\imageMonopoly.jpg"));
		//panelGauche.setLayout(new BorderLayout());
		panelGauche.add(fondMonopoly);

		
		// on l'ajoute a la fenetre
		this.add(panelGauche);
		
		
		
		
		
		//		Panel Droit
		// on va faire un layout avec 3 lignes : les soldes, la communication, les boutons et un moyen de quitter en bas
		panelDroit.setLayout(new GridLayout (6,1));
		
		// on fait les differents panel
		
		// panel pour afficher le nom du joueur qui va jouer
		labelAnnonceJoueurJoue = new JLabel ("", JLabel.CENTER);
		panelDroit.add(labelAnnonceJoueurJoue);
		
		// panel pour les soldes
		Font font = new Font("Yu Gothic UI Semibold", Font.PLAIN, 26);
		panelSolde = new JPanel();
		panelSolde.setLayout(new GridLayout(1,4));
		labelAnnonceArgentPlateau = new JLabel("Argent plateau :", JLabel.LEFT);
		labelAnnonceArgentPlateau.setFont(font);
		labelSoldePlateau = new JLabel ("", JLabel.LEFT);
		
		labelAnnonceArgentJoueur = new JLabel ("Argent joueur : ", JLabel.LEFT);
		labelAnnonceArgentJoueur.setFont(font);
		labelSoldeJoueur = new JLabel ("", JLabel.LEFT);
		// on ajoute les elements au panel
		panelSolde.add(labelAnnonceArgentPlateau);
		panelSolde.add(labelSoldePlateau);
		panelSolde.add(labelAnnonceArgentJoueur);
		panelSolde.add(labelSoldeJoueur);
		// on l'ajoute au panel droit
		panelDroit.add(panelSolde);
		
		// panel pour le label de communication
		panelCommunication = new JPanel();
		labelCommunication = new JLabel ("", JLabel.CENTER);
		panelCommunication.add(labelCommunication);
		// on l'ajoute au panel droit
		panelDroit.add(panelCommunication);
		
		
		///////// Panel Boutons qui contient tous les boutons //////////////
		
		// on va creer tous les panel possible avec les boutons
		panelGestionPartie = new JPanel ();
		panelGestionPartie.setLayout(new GridLayout (1,3));
		// on declare les boutons correspondants et on leur fixe le actionListener
		btnNouvellePartie = new JButton("Nouvelle partie");
		btnNouvellePartie.addActionListener(this);
		btnChargerPartie = new JButton("Charger partie");
		btnChargerPartie.addActionListener(this);
		btnSauverPartie = new JButton("Sauver partie");
		btnSauverPartie.addActionListener(this);
		// on y ajoute les boutons dans le bon ordre
		panelGestionPartie.add(btnNouvellePartie);
		panelGestionPartie.add(btnChargerPartie);
		panelGestionPartie.add(btnSauverPartie);
		// on ajoute ce panel au panel bouton
		panelDroit.add(panelGestionPartie);
		
		
		// panel pour la saisie des informations des partie
		panelSaisie = new JPanel();
		labelInfo = new JLabel("Entrez le nom de la partie", JLabel.CENTER);
		JTextField fieldNomPartie = new JTextField();
		bouttonOK = new JButton ("Ok");
		bouttonOK.addActionListener(this);
		panelSaisie.setLayout(new GridLayout (3, 1));
		panelSaisie.add(labelInfo);
		panelSaisie.add(fieldNomPartie);
		panelSaisie.add(bouttonOK);
		// on ajoute au panel droit
		panelBoutons.add(panelSaisie);
		
		// panel pour la saisie des joueurs
		panelSaisieJoueur = new JPanel ();
		panelSaisieJoueur.setLayout(new GridLayout(4,1));
		JPanel panelInfoSaisieJoueur = new JPanel ();
		panelInfoSaisieJoueur.setLayout(new GridLayout (1,2));
		JLabel annonceInfoCbJoueur = new JLabel ("Joueur deja enregistre :", JLabel.LEFT);
		JLabel infoCbJoueur = new JLabel ("", JLabel.LEFT);
		panelInfoSaisieJoueur.add(annonceInfoCbJoueur);
		panelInfoSaisieJoueur.add(infoCbJoueur);
		panelSaisieJoueur.add(panelInfoSaisieJoueur);
		JLabel labelConsigne = new JLabel ("Entrez le nom du joueur a ajouter");
		panelSaisieJoueur.add(labelConsigne);
		JTextField fieldSaisieJoueur = new JTextField ("Nom du joueur");
		panelSaisieJoueur.add(fieldSaisieJoueur);
		// pour les couleurs
		JPanel panelCouleur = new JPanel ();
		panelCouleur.setLayout(new GridLayout (1, 2));
		JLabel annonceCouleur = new JLabel ("Choisisez une couleur");
		panelCouleur.add(annonceCouleur);
		// on fait une liste deroulente
		JComboBox comboCouleur = new JComboBox ();
		comboCouleur.addItem("Rouge");
		comboCouleur.addItem("Bleu");
		comboCouleur.addItem("Noir");
		comboCouleur.addItem("Rose");
		comboCouleur.addItem("Marron");
		comboCouleur.addItem("Mauve");
		comboCouleur.addItem("Cyan");
		comboCouleur.addItem("Vert");
		panelCouleur.add(comboCouleur);
		// pour valider ou finir
		JPanel panelBoutonsSaisieJoueur = new JPanel ();
		panelBoutonsSaisieJoueur.setLayout(new GridLayout (1,2));
		JButton boutonAjouter = new JButton ("Ajouter");
		boutonAjouter.addActionListener(this);
		panelSaisieJoueur.add(boutonAjouter);
		JButton boutonTerminerSaisie = new JButton ("Terminer");
		boutonTerminerSaisie.addActionListener(this);
		panelSaisieJoueur.add(boutonTerminerSaisie);
		panelBoutons.add(panelSaisieJoueur);
		
		//panel pour les boutons d'achat de l'immobilier
		panelHimo = new JPanel ();
		panelHimo.setLayout(new GridLayout(1,2));
		btnAcheterMaison = new JButton("Acheter une maison");
		btnAcheterMaison.addActionListener(this);
		btnAcheterHotel = new JButton ("Acheter un hotel");
		btnAcheterHotel.addActionListener(this);
		panelHimo.add(btnAcheterMaison);
		panelHimo.add(btnAcheterHotel);
		// on l'ajout au panel droit
		panelBoutons.add(panelHimo);
		
		// panel pour lancer les des
		panelLancerDe = new JPanel ();
		panelLancerDe.setLayout(new GridLayout(2,1));
		labelAnnonceLancerDe = new JLabel ("Lancer les des pour avancer");
		btnLancerDes = new JButton ("Lancer les des");
		btnLancerDes.addActionListener(this);
		panelLancerDe.add(labelAnnonceLancerDe);
		panelLancerDe.add(btnLancerDes);
		// on l'ajout au panel droit
		panelBoutons.add(panelLancerDe);
		
		// panel pour les boutons sortir de prison
		panelSortiPrison = new JPanel ();
		panelSortiPrison.setLayout(new GridLayout (1,2));
		btnSortiPrison = new JButton("Payer quotion");
		btnSortiPrison.addActionListener(this);
		panelSortiPrison.add(btnLancerDes);
		panelSortiPrison.add(btnSortiPrison);
		// on l'ajout au panel droit
		panelBoutons.add(panelSortiPrison);
		
		// panel pour savoir si veut acheter
		panelAchat = new JPanel ();
		panelAchat.setLayout(new GridLayout (1,2));
		btnAcheter = new JButton("Acheter propriete");
		btnAcheter.addActionListener(this);
		btnPasAcheter = new JButton("Ne pas acheter propriete");
		btnPasAcheter.addActionListener(this);
		panelAchat.add(btnAcheter);
		panelAchat.add(btnPasAcheter);
		// on l'ajout au panel droit
		panelBoutons.add(panelAchat);
		
		
		
		// on ajoute le panel avec les boutons
		panelDroit.add(panelBoutons);
		
		
		// panel pour le bouton quitter
		panelQuitter = new JPanel ();
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		panelQuitter.add(btnQuitter);
		// on l'ajoute a panel droit
		panelDroit.add(panelQuitter);		
		
		// on ajoute le panel droit a la fenetre
		this.add(panelDroit);
		
		// on va rendre le premier panel necessaire visible
		panelSaisie.setVisible(false);
		panelSaisieJoueur.setVisible(false);
		panelLancerDe.setVisible(false);
		panelHimo.setVisible(false);
		panelSortiPrison.setVisible(false);
		panelAchat.setVisible(false);
	} 
	
	// pour gerer les actions qui vont etre faite avec les boutons
	public void actionPerformed(ActionEvent e){	
		// selon chaque bouton on va traiter les actions
		// bouton nouvelle partie
		if (e.getActionCommand() == "Nouvelle partie")
		{
			System.out.println("Test nouvelle partie");
			// on change les affichages pour pouvoir ecrire le nom de la partie
			panelSaisie.setVisible(true);
			panelSaisieJoueur.setVisible(false);
			panelLancerDe.setVisible(false);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
		}
		else if (e.getActionCommand()== "Ok")
		{
			// on cree la partie
			this.jeu = new Jeu(this.fieldNomPartie.getText());
			// on chage l'affichage pour entre les joueurs
			panelSaisie.setVisible(false);
			panelSaisieJoueur.setVisible(true);
			panelLancerDe.setVisible(false);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			//on rend les boutons inactifs
			this.btnNouvellePartie.setEnabled(false);
			this.btnChargerPartie.setEnabled(false);
		}	
			// si le joueur doit etre ajouter
		else if (e.getActionCommand() == "Ajouter")
		{
					// on recupere le nom
					String tempNom = fieldSaisieJoueur.getText();
					// la couleur
					int tempCouleur = this.comboCouleur.getSelectedIndex();
					// jeu.ajouterJoueur(tempNom, tempCouleur);
				}
				if (e.getActionCommand() == "Terminer")
				{
					// on change les panels
					panelSaisie.setVisible(false);
					panelSaisieJoueur.setVisible(false);
					panelLancerDe.setVisible(true);
					panelHimo.setVisible(false);
					panelSortiPrison.setVisible(false);
					panelAchat.setVisible(false);
				}
			}
			this.labelCommunication.setText("Nouvelle partie crée vous allez pouvoir jouer");
			// on va créer tout les joueurs un par un
			
		}
		// bouton charger partie
		else if (e.getActionCommand() == "Charger partie")
		{
			System.out.println("Test charger partie");
			// on change les affichages
			panelSaisie.setVisible(true);
			panelSaisieJoueur.setVisible(false);
			panelLancerDe.setVisible(false);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			if (e.getActionCommand()== "Ok")
			{
				// this.jeu = new Jeu(this.fieldNomPartie.getText(), 1);
			}
			this.labelCommunication.setText("Partie chargée");
			// on change les affichages
			panelSaisie.setVisible(false);
			panelSaisieJoueur.setVisible(false);
			panelLancerDe.setVisible(true);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			//on rend les boutons inactifs
			this.btnNouvellePartie.setEnabled(false);
			this.btnChargerPartie.setEnabled(false);
		}
		// bouton de sauvegarde
		else if (e.getActionCommand()== "Sauver partie")
		{
			System.out.println("Test sauver partie");
			jeu.sauvegarde(jeu.getPlateau());
			this.labelCommunication.setText("Partie sauvegardée");
			
			// on cache le panel de gestion et on met les autres
			panelSaisie.setVisible(false);
			panelSaisieJoueur.setVisible(false);
			panelLancerDe.setVisible(true);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
		}
		// lorsque l'on lance les des
		else if (e.getActionCommand() == "Lancer les des")
		{
			System.out.println("Test Lancer Des");
			// on rend le panel visible
			panelSaisie.setVisible(false);
			panelSaisieJoueur.setVisible(false);
			panelLancerDe.setVisible(true);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			// on fait avancer son pion
			// jeu.avancerJoueur();
		}
		//pour le bouton quitter
		else if (e.getActionCommand() == "Quitter")
		{
			System.out.println("Test Quitter");
			
			int retour = JOptionPane.showConfirmDialog(this,"Oui - Non", "Sauvegarder avant de quitter ?",JOptionPane.OK_CANCEL_OPTION);
			if(retour == JOptionPane.YES_OPTION)
			{
				this.jeu.sauvegarde(this.jeu.getPlateau());
				this.labelCommunication.setText("Partie sauvegardée");
				System.exit(0);
			}
			else if (retour == JOptionPane.NO_OPTION)
				System.exit(0);
		}
		
			
	} // fin du actionPerformed
}// fin de la classe Fond
