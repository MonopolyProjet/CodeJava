package src;

import java.util.ArrayList;

public class Plateau {
	static ArrayList <Case> touteCase;
	static ArrayList <CarteChance> listeCarteChance;
	static ArrayList <CarteCommunaute> listeCarteCommunaute;
	private int nbCase;
	private static int argentPlateau; // argent qui est poser sur le plateau
	
	// constructeur vide
	Plateau () {
		touteCase = new ArrayList <Case> ();
		listeCarteChance = new ArrayList <CarteChance> ();
		listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.nbCase = 39;
		this.argentPlateau = 0;
	
		// on cr�er toutes les cartes chance
		for (int i=1; i<16; i++) // 16 cartes en tout
			listeCarteChance.add(new CarteChance(i));
		
		// on cr�er toutes les cartes caisse de communaute
		for (int j=1; j<16; j++) // toujours 16 cartes
			listeCarteCommunaute.add(new CarteCommunaute(j));
		
		// on cr�er toutes les cases
		touteCase.add(new Case("depart"));
		touteCase.add(new Case("belleville"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("lecourbe"));
		touteCase.add(new Case("impots_sur_le_revenu"));
		touteCase.add(new Case("montparnasse"));
		touteCase.add(new Case("vaugirard"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("courcelles"));
		touteCase.add(new Case("republique"));
		touteCase.add(new Case("prison"));
		touteCase.add(new Case("villette"));
		touteCase.add(new Case("electricite"));
		touteCase.add(new Case("neuilly"));
		touteCase.add(new Case("paradis"));
		touteCase.add(new Case("lyon"));
		touteCase.add(new Case("mozart"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("saint-michel"));
		touteCase.add(new Case("pigalle"));
		touteCase.add(new Case("parc_gratuit"));
		touteCase.add(new Case("matignon"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("malesherbes"));
		touteCase.add(new Case("henri-martin"));
		touteCase.add(new Case("nord"));
		touteCase.add(new Case("saint-honore"));
		touteCase.add(new Case("bourse"));
		touteCase.add(new Case("eau"));
		touteCase.add(new Case("fayette"));
		touteCase.add(new Case("aller_prison"));
		touteCase.add(new Case("breteuil"));
		touteCase.add(new Case("foch"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("capucines"));
		touteCase.add(new Case("saint-lazare"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("champs"));
		touteCase.add(new Case("taxe_de_luxe"));
		touteCase.add(new Case("paix"));
		
	} // fin du constructeur
	
	// methode pour afficher l'argent sur le plateau
	private static int getArgentPlateau () {
		return argentPlateau;
	}
	
	// methode pour recuperer (donner a un joueur) l'argent qu'il y a sur le plateau
	private static int recupererArgent (Joueur j) {
		int tempSomme = 0;
		tempSomme = argentPlateau;
		// on le donne au joueur 
		j.gagneArgent (tempSomme);
		// on remet l'argenta 0;
		retirerArgentPlateau ();
		return tempSomme;
	}
	
	// methode pour ajouter de l'argent sur le plateau
	private void ajouterArgentPlateau (int somme) {
		this.argentPlateau += somme;
	}

	// methode pour reinitialis� l'argent sur le plateau
	private static void retirerArgentPlateau() {
		argentPlateau = 0;
	}
	
	
	//////////////////////////////////////////////////
	/////////// FONCTION MAIN ////////////////////////
	//////////////////////////////////////////////////
	public static void main (String [] args) {
		// on créer un plateau
		Plateau p = new Plateau ();
		System.out.println("Plateau crée");
		
		// on s'occupe de l'argent sur le plateau
		// on ajoute de k'argent au plateau (2 milles)
		p.ajouterArgentPlateau(2);
		// on affiche 
		System.out.println("Argent sur le plateau : " +getArgentPlateau());
		// on donne l'argent a un joueur et on reaffcihe la somme sur le plateau
		Joueur j = new Joueur ("Ludo", "bleu");
		recupererArgent(j);
		System.out.println("Argent sur le plateau apres avoir recuperer par joueur : " +getArgentPlateau());
		
		
	}
}	// fin de la classe Plateau
