import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Case {
	private String nom;
	private int loyer;
	private int loyer1maison;
	private int loyer2maison;
	private int loyer3maison;
	private int loyer4maison;
	private int loyerHotel;
	private int hypo;
	private int prixMaison;
	private int prixHotel;
	
	//constructeur vide
	Case (String nom) {
		// on déclare le nouveau fichier
		File f = new File (nom +".txt");
			
		// si le fichier existe on va faire les opération suivante
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
			// on crer un scanner
			Scanner sc = new Scanner (fis);
			// on attrape maintenant ligne par ligne (tant qu'il y en a)
			this.nom = sc.nextLine();
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
	
	// methode pour recuperer le propriétaire
	private Joueur getProprietaire () {
		return this.proprietaire;
	}
	
	//methode pour recuperer le prix
	int getPrix () {
		return this.prixCase;
	}
	
	// methode toString
	private String toString () {
		String s = "";
		s = s + "Nom de la case : " +nomCase +"\n" +"Couleur : " +couleurCase +"\n" +"prix de la case : " +prixCase;
	}
}	// fin de la clase Case
