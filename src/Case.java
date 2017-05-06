package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Case {
	private int numCase;
	private String nom;
	private int nbMaison;
	private int nbHotel;
	private Joueur proprietaire;
	private int valeur;
	
	private int loyer;
	private String couleurCase;
	private int loyer1maison;
	private int loyer2maison;
	private int loyer3maison;
	private int loyer4maison;
	private int loyerHotel;
	private int hypo;
	private int prixMaison;
	private int prixHotel;
	
	// constructeur
	public Case(String nom, int ind) { // est le nom de la carte qui doit etre construite
		this.numCase = ind;
		// on d�clare le nouveau fichier
		File f = new File ("src/CartePropriete/" +nom +".txt");
		
		// si le fichier existe on va faire les operation suivante
		if (f.exists())
		{
			// on test si pas de probleme
			try {
				f.createNewFile();
			}
			// si erreur
			catch (IOException e)
			{
				e.printStackTrace();
			}
		} // fin du if
		
		// on va s'occuper de la lecture
		try (FileInputStream fis = new FileInputStream(f)) {
			// on creer un scanner
			Scanner sc = new Scanner (fis);
			// on attrape maintenant ligne par ligne (tant qu'il y en a)
			// pour les cartes sans valeurs numérique de loyer dedans
			if (nom == "depart" || nom == "aller_prison" || nom == "impots_sur_le_revenu" || nom == "chance" || nom == "communaute" || nom == "parc_gratuit" || nom == "taxe_de_luxe" || nom == "prison")
				this.nom = sc.nextLine();
			// pour les gares
			else if (nom == "lyon" || nom == "nord" || nom == "montparnasse" || nom == "saint-lazare")
			{
				this.nom = sc.nextLine();
				this.loyer1maison = sc.nextInt();
				this.loyer2maison = sc.nextInt();
				this.loyer3maison = sc.nextInt();
				this.loyer4maison = sc.nextInt();
				this.hypo = sc.nextInt();
			}
			// pour les compagnies d'eau et electricite
			else if (nom == "eau" || nom == "electricite")
			{
				this.nom = sc.nextLine();
				this.loyer1maison = sc.nextInt();
				this.loyer2maison = sc.nextInt();
			}
			// pour les cartes de propriété
			else
			{
				this.nom = sc.nextLine();
				this.couleurCase = sc.nextLine();
				this.loyer = sc.nextInt();
				this.loyer1maison = sc.nextInt();
				this.loyer2maison = sc.nextInt();
				this.loyer3maison = sc.nextInt();
				this.loyer4maison = sc.nextInt();
				this.loyerHotel = sc.nextInt();
				this.hypo = sc.nextInt();
				this.prixMaison = sc.nextInt();
				this.prixHotel = sc.nextInt();
			}
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// valeurs par defauts
		this.valeur = 2 * this.hypo;
		this.nbMaison = 0;
		this.nbHotel = 0;
		this.proprietaire = null;
		
	} // fin du constructeur
	
	// methode pour ajouter une maison
	private void ajouteMaison (int nbMaison) {
		this.nbMaison += nbMaison;
	}
	
	// methode pour supprimer une maison 
	private void suppMaion (int nbSupp) {
		this.nbMaison -= nbSupp;
	}
	
	//methode pour recuperer le nombre de maison sur la case
	private int getNbMaison() {
		return nbMaison;
	}
	// methode pour ajouter un hotel
	private void ajouteHotel () { // il ne peut y avoir que une maison
		if (nbMaison == 4)
		{
			this.nbHotel = 1;
			this.nbMaison = 0;
		}
		else
			System.out.println("Il manque des maisons pour faire mettre un hotel ...");
	}
		
	// methode pour supprimer un hotel 
	private void suppHotel () {
		this.nbHotel--;
		this.nbMaison = 4;
	}
	
	// methode pour recupererle nombre d'hotel
	private int getNbHotel () {
		return nbHotel;
	}
	
	// methode pour recuperer le nom
	String getNomCase () {
		return this.nom;
	}
	
	// methode pour assigner un propri�taire
	void ajouterProprio (Joueur j) {
		this.proprietaire = j;
	}
	
	// methode pour recuperer le propri�taire
	private Joueur getProprietaire () {
		return this.proprietaire;
	}
	
	//methode pour recuperer le prix
	int getPrix () {
		return this.valeur;
	}
	
	// methode toString
	public String toString() {
		String s = "";
		// pour les cases sans valeur de loyer
		if (nom == "depart" || nom == "aller_prison" || nom == "prison" || nom == "impots_sur_le_revenu" || nom == "chance" || nom == "communaute" || nom == "parc_gratuit" || nom == "taxe_de_luxe")
			s = s + "Nom de la case : " +nom;
		// pour les comapgnies
		else if (nom == "eau" || nom == "electricite")
			s = s +"Nom de la case : " +nom +"\n" +"Prix de la case : " +valeur;
		//pour les gares
		else if (nom == "lyon" || nom == "nord" || nom == "saint-lazare" || nom == "montparnasse")
			s = s +"Nom de la case : " +nom +"\n" +"Prix de la case : " +valeur;
		// pour les cartes de propriété
		else
			s = s + "Nom de la case : " +nom +"\n" +"Couleur : " +couleurCase +"\n" +"prix de la case : " +valeur +"\n";
		return(s);
	}
	
	
	
	/////////////////////////////////////////////////////
	//////////////// FONCTION MAIN //////////////////////
	/////////////////////////////////////////////////////
	
	public static void main (String [] args) {
	// on va cr�er 3 cartes (les trois premieres)
	Case c1 = new Case ("champs", 0);
	Case c2 = new Case ("fayette", 1);
	Case c3 = new Case ("foch", 2);
	Case c4 = new Case ("depart", 3);
	Case c5 = new Case ("chance", 4);
	
	// on va les affichers
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(c4);
	
	// on affiche le nom de la case
	c1.getNomCase();
	
	// on créer un propriétaire
	Joueur j1 = new Joueur ("Ludo", "bleu");
	
	// on ajoute un propriétaire 
	c1.ajouterProprio (j1);
	// on recupere le propriétaire et on l'affiche
	System.out.println(c1.getProprietaire ());
	
	// on ajoute a la case champs elysée 4 maisons
	c1.ajouteMaison (4);
	// on ajoute un hotel
	c1.ajouteHotel();
	// on affiche le nombre d'hotel sur la case
	System.out.println("Il y a : " +c1.getNbHotel() +" hôtel sur cette case");
	System.out.println("Il y a : " +c1.getNbMaison() +" maisons sur cette case");
	// on supprime l'hotel et on réaffiche le nombre d'hotel
	c1.suppHotel();
	System.out.println("Il y a : " +c1.getNbHotel() +" hôtel sur cette case");
	System.out.println("Il y a : " +c1.getNbMaison() +" maisons sur cette case");
	// puis on supprime une maison et on la réaffiche
	c1.suppMaion(1);
	System.out.println("Il y a : " +c1.getNbMaison() +" maisons sur cette case");
	
	// enfin on affiche la valeur de la case
	System.out.println("Le prix de cette propriété est de : " +c1.getPrix());
	}
}	// fin de la clase Case
