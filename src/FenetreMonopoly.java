package src;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreMonopoly {
	public static void main (String [] args){
		// on donne toutes les propriete de la fenetre
		JFrame mainFrame = new JFrame("Monopoly");
		
		// on dit que la croix ferme automatiquement la fenetre
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// on fait en sorte que la fenetre soit sur tout l'ecran
	    mainFrame.setSize(1000, 1000);
	    mainFrame.setAlwaysOnTop(true);
	    mainFrame.pack();
	    mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	    // on recupere la forme
	    Fond fond = new Fond ();
	    mainFrame.add(fond);
	    
	    // on la rend visible
		mainFrame.setVisible(true);
	}
}
