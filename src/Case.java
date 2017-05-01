
public class Case {
	private int numCase;
	private String nomCase;
	private int prixCase;
	private int nbMaison;
	private int nbHotel;
	private String couleurCase;
	private Joueur proprietaire;
	
	//constructeur vide
	Case () {
		
	}
	
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
