package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
	
	private JPanel panelBoutonsAction;
	private JPanel panelBoutonsCommuns;
	
	//tout les panels de boutons possible
	private JPanel panelGestionPartie;
	private JPanel panelLancerDe;
	private JPanel panelHimo;
	private JPanel panelSortiPrison;
	private JPanel panelAchat;
	private JPanel panelSaisie;
	
	private JPanel panelInterraction;
	private JPanel panelBoutons;
	private JPanel panelQuitter;
		
	// declaration label
	private JLabel labelAnnonceArgentPlateau;
	private JLabel labelSoldePlateau;
	private JLabel labelAnnonceArgentJoueur;
	private JLabel labelSoldeJoueur;
	private JLabel labelCommunication;
	private JLabel labelAnnonceLancerDe;
	
	private JLabel fondMonopoly;
	private JLabel soldePlateau;
	private JLabel soldeJoueur;
	
	private JLabel labelInfo;
	
	// declaration du textField
	private JTextField zone1;
	// on cree le text field
	private JTextField fieldNomPartie;
	
	// declaration de l'image
	private Icon imageMonopoly;
	
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
		// on change la couleur du fond
		panelGauche.setBackground(Color.BLACK);
		// on fixe l'image du plateau
		// on cree l'image
		imageMonopoly = new ImageIcon("src/imageMonopoly.jpg");
		fondMonopoly.setIcon(imageMonopoly);
		panelGauche.add(fondMonopoly);
		
		// on l'ajoute a la fenetre
		this.add(panelGauche);
		
		
		
		
		
		//		Panel Droit
		// on va faire un layout avec 3 lignes : les soldes, la communication, les boutons et un moyen de quitter en bas
		panelDroit.setLayout(new GridLayout (4,1));
		
		// on fait les diff��rents panel
		
		// panel pour les soldes
		Font font = new Font("Yu Gothic UI Semibold", Font.PLAIN, 36);
		panelSolde = new JPanel();
		panelSolde.setLayout(new GridLayout(1,4));
		labelAnnonceArgentPlateau = new JLabel("Argent plateau:", JLabel.LEFT);
		labelAnnonceArgentPlateau.setFont(font);
		labelSoldePlateau = new JLabel ("", JLabel.LEFT);
		
		labelAnnonceArgentJoueur = new JLabel ("Argent joueur: ", JLabel.LEFT);
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
		panelGestionPartie.setLayout(new GridLayout (3,1));
		
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
		panelBoutons.add(panelGestionPartie);
		
		
		// panel pour la saisie des informations des partie
		panelSaisie = new JPanel();
		labelInfo = new JLabel("Entrez le nom de la partie", JLabel.CENTER);
		JTextField fieldNomPartie = new JTextField();
		bouttonOK = new JButton ("Ok");
		bouttonOK.addActionListener(this);
		
		panelSaisie.setLayout(new GridLayout (3, 1));
		panelSaisie.add(labelInfo);
		panelSaisie.add(labelInfo);
		
		
		//panel pour les boutons d'achat de l'immobilier
		panelHimo = new JPanel ();
		panelHimo.setLayout(new GridLayout(1,2));
		btnAcheterMaison = new JButton("Acheter une maison");
		btnAcheterMaison.addActionListener(this);
		btnAcheterHotel = new JButton ("Acheter un hotel");
		btnAcheterHotel.addActionListener(this);
		panelHimo.add(btnAcheterMaison);
		panelHimo.add(btnAcheterHotel);
		
		
		// panel pour lancer les des
		panelLancerDe = new JPanel ();
		panelLancerDe.setLayout(new GridLayout(2,1));
		labelAnnonceLancerDe = new JLabel ("Lancer les des pour avancer")
		btnLancerDes = new JButton ("Lancer les des");
		btnLancerDes.addActionListener(this);
		panelLancerDe.add(labelAnnonceLancerDe);
		panelLancerDe.add(btnLancerDes);
		
		// panel pour les boutons sortir de prison
		panelSortiPrison = new JPanel ();
		panelSortiPrison.setLayout(new GridLayout (1,2));
		btnSortiPrison = new JButton("Payer quotion");
		btnSortiPrison.addActionListener(this);
		panelSortiPrison.add(btnLancerDes);
		panelSortiPrison.add(btnSortiPrison);
		
		// panel pour savoir si veut acheter
		panelAchat = new JPanel ();
		panelAchat.setLayout(new GridLayout (1,2));
		btnAcheter = new JButton("Acheter propriete");
		btnAcheter.addActionListener(this);
		btnPasAcheter = new JButton("Ne pas acheter propriete");
		btnPasAcheter.addActionListener(this);
		panelAchat.add(btnAcheter);
		panelAchat.add(btnPasAcheter);
		
		
		
		
		// on les ajoute tout les panel au panel "panelBoutons"
		panelBoutons.add(panelGestionPartie);
		panelBoutons.add(panelSaisie);
		panelBoutons.add(panelLancerDe);
		panelBoutons.add(panelHimo);
		panelBoutons.add(panelSortiPrison);
		panelBoutons.add(panelAchat);		
		
		// on ajoute le panel avec les boutons
		panelDroit.add(panelBoutons);
		
		
		// panel pour le bouton quitter
		panelQuitter = new JPanel ();
		btnQuitter = new JButton("Quitter");
		panelQuitter.add(btnQuitter);
		// on l'ajoute a panel droit
		panelDroit.add(panelQuitter);		
		
		// on ajoute le panel droit a la fenetre
		this.add(panelDroit);
		
		// on va rendre le premier panel necessaire visible
		panelGestionPartie.setVisible(true);
		panelSaisie.setVisible(false);
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
			// on change les affichages
			panelGestionPartie.setVisible(false);
			panelSaisie.setVisible(true);
			panelLancerDe.setVisible(false);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			if (e.getActionCommand()== "Ok")
			{
				this.jeu = new Jeu(this.fieldNomPartie.getText());
			}
			this.labelCommunication.setText("Nouvelle partie crée");
			// on va créer tout les joueurs un par un
			
		}
		// bouton charger partie
		else if (e.getActionCommand() == "Charger partie")
		{
			// on change les affichages
			panelGestionPartie.setVisible(false);
			panelSaisie.setVisible(true);
			panelLancerDe.setVisible(false);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
			if (e.getActionCommand()== "Ok")
			{
				this.jeu = new Jeu(this.fieldNomPartie.getText(), 1);
			}
			this.labelCommunication.setText("Partie chargée");
		}
		// bouton de sauvegarde
		else if (e.getActionCommand()== "Sauver partie")
		{
			jeu.sauvegarde(jeu.getPlateau());
			this.labelCommunication.setText("Partie sauvegardée");
			
			// on cache le panel de gestion et on met les autres
			panelGestionPartie.setVisible(false);
			panelSaisie.setVisible(false);
			panelLancerDe.setVisible(true);
			panelHimo.setVisible(false);
			panelSortiPrison.setVisible(false);
			panelAchat.setVisible(false);
		}
		else if (e.getActionCommand() == "Lancer les des")
		{
			jeu.
		}
		
			
	}
	
	
	// pour ordonner l'affichage
	public static void main (String args[]){
		Fond f = new Fond();
		f.setSize(1400,1050);
		f.setVisible(true);	
		
		
	}
}
