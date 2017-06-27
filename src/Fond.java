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
	
	
	private JButton btnFinTour;
	
	//declaration de tout les panels
	private JPanel panelGauche;	
	private JPanel panelDroit;
	private JPanel panelSolde;
	private JPanel panelCommunication;
	private JPanel panelGestionPartie;
	private JPanel panelBoutonsAction;
	private JPanel panelBoutonsCommuns;
	private JPanel panelInterraction;
	private JPanel panelBoutons;
	private JPanel panelQuitter;
		
	// declaration label
	private JLabel labelAnnonceArgentPlateau;
	private JLabel labelSoldePlateau;
	private JLabel labelAnnonceArgentJoueur;
	private JLabel labelSoldeJoueur;
	private JLabel labelCommunication;
	
	
	private JLabel fondMonopoly;
	private JLabel soldePlateau;
	private JLabel soldeJoueur;
	
	// declaration du textField
	private JTextField zone1;
	
	// declaration de l'image
	private Icon imageMonopoly;
	
	// constructeur
	Fond (Jeu sonJeu){
		
		// on lui donne son jeu
		this.jeu = sonJeu;
		
		// on cree tout les boutons
		btnFinTour = new JButton("Fin Tour");
		btnAcheter = new JButton("Acheter");
		
		//on cree tout les panels
		panelGauche = new JPanel();
		panelDroit = new JPanel();
		panelSolde = new JPanel();
		panelInterraction = new JPanel();
		panelBoutons = new JPanel();
		
		// on cree tout les labels pour la communication
		fondMonopoly = new JLabel("", SwingConstants.CENTER);
		soldePlateau = new JLabel("Solde Plateau : ");
		soldeJoueur = new JLabel("Solde Joueur : ");
		
		// on cree le text field
		zone1 = new JTextField();
		
		// on cree l'image
		imageMonopoly = new ImageIcon("src/imageMonopoly.jpg");
		
		// on donne toutes les propriété de la fenetre
		JFrame mainFrame = new JFrame("Monopoly");
		// on dit que la croix ferme automatiquement la fenetre
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// on fait en sorte que la fenetre soit sur tout l'ecran
        mainFrame.setSize(1000, 1000);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // on la rend visible
        mainFrame.setVisible(true);
		
		
		BorderLayout layoutDroit = new BorderLayout(); //Utile aussi pour le panel Solde
		
		Font font = new Font("Yu Gothic UI Semibold", Font.PLAIN, 36);
		
		
		/////////////Panel Gauche
		// on lui donne son layout
		panelGauche.setLayout(new GridLayout(1,1));
		// on change la couleur du fond
		panelGauche.setBackground(Color.BLACK);
		// on fixe l'image du plateau
		fondMonopoly.setIcon(imageMonopoly);
		panelGauche.add(fondMonopoly);
		// on l'ajoute a la fenetre
		mainFrame.add(panelGauche);
		
		
		//Panel communication va contenir les retours du jeu + le panel pour les boutons
		panelInterraction.setLayout(new GridLayout(2,1));
		panelInterraction.add(zone1);
		zone1.setEnabled(false);
		panelInterraction.add(panelBoutons);
		
		
		
		
		//Panel Boutons qui contient tous les boutons
		
		// on va faire deux boutons en haut pour charger, nouvelle est sauvegarde
		// layout avec les trois partie
		panelBoutons.setLayout(new GridLayout (3,1));
		
		// on créer le panel du haut
		panelGestionPartie = new JPanel();
		panelGestionPartie.setLayout (new GridLayout(1,3));
		
		// on declare les boutons correspondants et on leur fixe le actionListener
		btnNouvellePartie = new JButton("Nouvelle Partie");
		btnNouvellePartie.addActionListener(this);
		btnChargerPartie = new JButton("Charger Partie");
		btnChargerPartie.addActionListener(this);
		btnSauverPartie = new JButton("Sauver Partie");
		btnSauverPartie.addActionListener(this);
		
		// on y ajoute les boutons dans le bon ordre
		panelGestionPartie.add(btnNouvellePartie);
		panelGestionPartie.add(btnChargerPartie);
		panelGestionPartie.add(btnSauverPartie);
		
		// on ajoute ce panel au panel bouton
		panelBoutons.add(panelGestionPartie);
		
		
		// 			Panel  avec tout les bouton d'interraction
		// on va placer les boutons en grille au dessus d'un grand bouton pour finir son tour
		panelBoutonsAction = new JPanel();
		panelBoutonsAction.setLayout(new BorderLayout());
		
		// on cree tout les boutons et en meme temps on met l'actionListener
		panelBoutonsCommuns = new JPanel();
		panelBoutonsCommuns.setLayout(new GridLayout (2,3));
		
		btnLancerDes = new JButton ("Lancer les dés");
		btnLancerDes.addActionListener(this);
		btnAcheterMaison = new JButton("Acheter une maison");
		btnAcheterMaison.addActionListener(this);
		btnAcheterHotel = new JButton ("Acheter un hôtel");
		btnAcheterHotel.addActionListener(this);
		btnSortiPrison = new JButton("Payer quotion");
		btnSortiPrison.addActionListener(this);
		btnAcheter = new JButton("Acheter propriété");
		btnAcheter.addActionListener(this);
		btnPasAcheter = new JButton("Ne pas acheter propriété");
		btnPasAcheter.addActionListener(this);
		
		// on les ajoute bien au layout
		panelBoutonsCommuns.add(btnLancerDes);
		panelBoutonsCommuns.add(btnAcheterMaison);
		panelBoutonsCommuns.add(btnAcheterHotel);
		panelBoutonsCommuns.add(btnSortiPrison);
		panelBoutonsCommuns.add(btnAcheter);
		panelBoutonsCommuns.add(btnPasAcheter);
		
		// on ajoute ce panel au conteneur
		panelBoutons.add(panelBoutonsCommuns);
		
		// on ajout celui pour finir son tour
		btnFinTour = new JButton("Fin de tour");
		btnFinTour.addActionListener(this);
		panelBoutonsAction.add(btnFinTour, BorderLayout.SOUTH);

		
		
		

		//			Panel Droit
		// on va faire un layout avec 3 lignes : les soldes, la communication, les boutons et un moyen de quitter en bas
		panelDroit.setLayout(new GridLayout (4,1));
		
		// on fait les différent panel
		
		// panel pour les soldes
		panelSolde.setLayout(new GridLayout(1,4));
		labelAnnonceArgentPlateau = new JLabel("Argent plateau:", JLabel.RIGHT);
		labelAnnonceArgentPlateau.setFont(font);
		
		labelSoldePlateau = new JLabel ("", JLabel.RIGHT);
		
		this.labelAnnonceArgentJoueur = new JLabel ("Argent joueur: ", JLabel.RIGHT);
		labelAnnonceArgentJoueur.setFont(font);
		
		labelSoldeJoueur = new JLabel ("", JLabel.RIGHT);
		
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
		
		// on ajoute le panel avec les boutons
		panelDroit.add(panelBoutons);
		
		
		// panel pour le bouton quitter
		panelQuitter = new JPanel ();
		btnQuitter = new JButton("Quitter");
		panelQuitter.add(btnQuitter);
		// on l'ajoute a panel droit
		panelDroit.add(panelQuitter);
		
		mainFrame.setLayout(new GridLayout(1,2));
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		btnNouvellePartie.addActionListener(this);
		btnSauverPartie.addActionListener(this);
		btnChargerPartie.addActionListener(this);
		btnFinTour.addActionListener(this);
		btnAcheter.addActionListener(this);
	} 
	
	// pour gerer les actions qui vont etre faite avec les boutons
	public void actionPerformed(ActionEvent e){	
		
	}
	
	
	// pour ordonner l'affichage
	public static void main (String args[]){
		Fond f = new Fond();
		f.setSize(1400,1050);
		f.setVisible(true);	
		
		
	}
}
