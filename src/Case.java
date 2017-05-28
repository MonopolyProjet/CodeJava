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
	
	private boolean hypotheque = false;
	
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
		this.hypotheque = false;
		
	} // fin du constructeur
	
	//////////////////////////////////////////////////////////
	////// Ensenble des getteur pour les loyers //////////////
	public int getLoyer () {
		return this.loyer;
	}
	public int getLoyer1Maison () {
		return this.loyer1maison;
	}
	public int getLoyer2Maison () {
		return this.loyer2maison;
	}
	public int getLoyer3Maison () {
		return this.loyer3maison;
	}
	public int getLoyer4Maison () {
		return this.loyer4maison;
	}
	public int getLoyerHotel () {
		return this.loyerHotel;
	}
	public int getHypo () {
		return this.hypo;
	}
	
	// methode pour ajouter une maison
	void ajouteMaison (int nbMaison, Joueur j) {
		this.nbMaison += nbMaison;
		// on enleve l'argent au joueur
		j.retirerArgent(nbMaison * prixMaison);
	}
	
	// methode pour supprimer une maison 
	private void suppMaion (int nbSupp) {
		this.nbMaison -= nbSupp;
	}
	
	//methode pour recuperer le nombre de maison sur la case
	int getNbMaison() {
		return nbMaison;
	}
	
	// methode pour ajouter un hotel
	void ajouteHotel(Joueur j) { // il ne peut y avoir que une maison
		if (nbMaison == 4)
		{
			this.nbHotel = 1;
			this.nbMaison = 0;
			// on enleve l'argent au joueur
			j.retirerArgent(prixHotel);
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
	int getNbHotel () {
		return nbHotel;
	}
	
	// methode pour retourner la couleur
	public String getCouleur() {
		return this.couleurCase;
	}
	
	//procedure return boolean true if it belongs to someone
	public boolean appartientA(){
		if (this.proprietaire!=null) return(true);
		else return(false);
	}
		
	// methode pour recuperer le nom
	String getNomCase () {
		return this.nom;
	}
	
	// methode pour retourner le numero de la case
	public int getNumCase() {
		return (this.numCase);
	}
	
	// methode pour assigner un propri�taire
	void ajouterProprio (Joueur j) {
		this.proprietaire = j;
	}
	
	// methode pour recuperer le propri�taire
	Joueur getProprietaire () {
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
			s = s +nom;
		// pour les compagnies
		else if (nom == "eau" || nom == "electricite")
			s = s  +nom +"\n" +"Prix de la case : " +valeur +"\n" +"Multiplié par " +loyer1maison +" la somme des dés si vous avez une des compagnies, sinon par " +loyer2maison;
		//pour les gares
		else if (nom == "lyon" || nom == "nord" || nom == "saint-lazare" || nom == "montparnasse")
			s = s +"gare " +nom +"\n" +"Prix de la case : " +valeur +"\n" +"Somme a multiplié par le nombre de gare : " +loyer1maison;
		// pour les cartes de propriété
		else
			s = s +nom +"\n" +"Couleur : " +couleurCase +"\n" +"prix de la case : " +valeur +"\n" +"Loyer: " +loyer +"\n" +"1 maison: " +loyer1maison +"\n" +"2 maisons: " +loyer2maison +"\n" +"3 maisons: " +loyer3maison +"\n" +"4 maisons: " +loyer4maison +"\n" +"loyerHôtel: " +loyerHotel +"\n" +"Prix immobilié: " +prixMaison;
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
	// c1.ajouteMaison (4);
	// on ajoute un hotel
	// c1.ajouteHotel();
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

	// methode pour marquer qu'une propriete est hypotheque
	public void hypothequer() {
		this.hypotheque = true;		
	}
	
	// methode pour qu'une case ne soit plus hypotheque
	public void dehypothequer() {
		this.hypotheque = false;
	}
	
	// methode pour vois si une case est hypotheque
	public boolean estHypotheque () {
		return this.hypotheque;
	}
	
}	// fin de la clase Case
