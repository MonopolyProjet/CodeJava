package src;

import javax.swing.*;
import java.awt.*;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fond extends JPanel implements ActionListener{
	
	private JButton btnNouvellePartie = new JButton("Nouvelle Partie");
	private JButton btnSauverPartie = new JButton("Sauver Partie");
	private JButton btnChargerPartie = new JButton("Charger Partie");
	private JButton btnFinTour = new JButton("Fin Tour");
	private JButton btnAcheter = new JButton("Acheter");
	
	private JPanel panelGauche = new JPanel();
	private JLabel fondMonopoly = new JLabel("", SwingConstants.CENTER);
	private Icon imageMonopoly = new ImageIcon("src/imageMonopoly.jpg");
	
	private JPanel panelDroit = new JPanel();
	private JPanel panelSolde = new JPanel();
	private JPanel panelInterraction = new JPanel();
	private JPanel panelBoutons = new JPanel();
	private JTextField zone1 = new JTextField();
	private JLabel soldePlateau = new JLabel("Solde Plateau : ");
	private JLabel soldeJoueur = new JLabel("Solde Joueur : ");
		
	Fond (){
		
		Font f = new Font("Yu Gothic UI Semibold", Font.PLAIN, 36);
		JFrame mainFrame = new JFrame();
		GridLayout layoutGauche = new GridLayout(1,1);
		BorderLayout layoutDroit = new BorderLayout(); //Utile aussi pour le panel Solde
		
		
		//Panel Gauche
		panelGauche.setLayout(layoutGauche);
		panelGauche.setBackground(Color.BLACK);
		fondMonopoly.setIcon(imageMonopoly);
		panelGauche.add(fondMonopoly);
		mainFrame.add(panelGauche);
		
		//Panel Boutons qui contient tous les boutons
		panelBoutons.setLayout(new GridLayout(4,2));
		panelBoutons.add(btnNouvellePartie);
		panelBoutons.add(btnSauverPartie);
		panelBoutons.add(btnChargerPartie);
		panelBoutons.add(btnFinTour);
		panelBoutons.add(btnAcheter);
		
		//Panel communication va contenir les retours du jeu + le panel pour les boutons
		panelInterraction.setLayout(new GridLayout(2,1));
		panelInterraction.add(zone1);
		zone1.setEnabled(false);
		panelInterraction.add(panelBoutons);

		//Panel Droit
		panelDroit.setLayout(layoutDroit);
		panelSolde.setLayout(new GridLayout(1,2));
		soldePlateau.setFont(f);
		soldeJoueur.setFont(f);
		panelSolde.add(soldePlateau);
		panelSolde.add(soldeJoueur);	
		panelDroit.add(BorderLayout.NORTH, panelSolde);
		panelDroit.add(BorderLayout.CENTER, panelInterraction);
		mainFrame.add(panelDroit);
		
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
	
	public void actionPerformed(ActionEvent e){	
		
	}
	
	public static void main (String args[]){
		Fond f = new Fond();
		f.setSize(1400,1050);
		f.setVisible(true);	
		
		
	}
}
