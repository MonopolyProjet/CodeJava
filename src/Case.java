import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Case {
	private int numCase;
	private String nom;
	private int nbMaison;
	private int nbHotel;
	private String couleurCase;
	private Joueur proprietaire;
	
	private int loyer;
	private int loyer1maison;
	private int loyer2maison;
	private int loyer3maison;
	private int loyer4maison;
	private int loyerHotel;
	private int hypo;
	private int prixMaison;
	private int prixHotel;
	
	Case (String nom) { // est le nom de la carte qui doit etre construite
		
		// on d�clare le nouveau fichier
		File f = new File (nom +".txt");
		
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
			this.nom = nom;
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
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.nbMaison = 0;
		this.nbHotel = 0;
		this.proprietaire = null;
		
	} // fin du constructeur
	
	// Constructeur avec tout les nom, prix et couleur pour les propri�t�s
	Case (int numCase, String nom, int prix, String couleur) {
		this.numCase = numCase;
		this.nomCase = nom;
		this.prixCase = prix;
		this.nbMaison = 0;
		this.nbHotel = 0;
		this.couleurCase = couleur;
	}
	
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
		
	// methode pour supprimer une maison 
	private void suppHotel (int nbSupp) {
		this.nbHotel -= nbSupp;
	}
	
	// methode pour recuperer le nom
	String getNomCase () {
		return this.nomCase;
	}
	
	// methode pour recupere le numero de la case
	int getNumCase () {
		return this.numCase;
	}
	
	// methode pour recuperer le propri�taire
	private Joueur getProprietaire () {
		return this.proprietaire;
	}
	
	//methode pour recuperer le prix
	int getPrix () {
		return this.prixCase;
	}
	
	// methode toString
	public String toString() {
		String s = "";
		s = s + "Nom de la case : " +nomCase +"\n" +"Couleur : " +couleurCase +"\n" +"prix de la case : " +prixCase;
		return(s);
	}
}	// fin de la clase Case
