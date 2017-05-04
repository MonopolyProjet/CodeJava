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
	
	public Case(String nom) { // est le nom de la carte qui doit etre construite
		
		// on d�clare le nouveau fichier
		File f = new File ("src/CartePropriete/" +nom +".txt");
		
		// si le fichier existe on va faire les op�ration suivante
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
			this.nom = sc.nextLine();
			if (nom!="depart"){
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
	
	// methode pour ajouter un hotel
	private void ajouteHotel (int nbHotel) {
		if (nbMaison == 4)
			this.nbHotel += nbHotel;
		else
			System.out.println("Il manque des maisons pour faire mettre un hotel ...");
	}
		
	// methode pour supprimer un hotel 
	private void suppHotel (int nbSupp) {
		this.nbHotel -= nbSupp;
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
		s = s + "Nom de la case : " +nom +"\n" +"Couleur : " +couleurCase +"\n" +"prix de la case : " +valeur +"\n";
		return(s);
	}
	
	
	
	/////////////////////////////////////////////////////
	//////////////// FONCTION MAIN //////////////////////
	/////////////////////////////////////////////////////
	
	public static void main (String [] args) {
	// on va cr�er 3 cartes (les trois premieres)
	Case c1 = new Case ("champs");
	Case c2 = new Case ("fayette");
	Case c3 = new Case ("foch");
	Case c4 = new Case ("depart");
	
	// on va les affichers
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);
	System.out.println(c4);
	}
}	// fin de la clase Case
