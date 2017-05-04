import java.util.ArrayList;
import java.util.Random;

public class Joueur{
	private String nom;
	private int argent;
	private Pion sonPion;
	private String couleur;
	ArrayList <CarteChance> listeCarteChance;
	ArrayList <CarteCommunaute> listeCarteCommunaute;
	ArrayList <Case> listePropriete;
	private Case caseActuelle;
	private int indiceCaseActuelle;
	 
	
	// constructeur 
	public Joueur (String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.argent = 1500;
		this.listeCarteChance = new ArrayList <CarteChance> ();
		this.listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.listePropriete = new ArrayList <Case> ();
		this.caseActuelle = new Case("depart");
		this.indiceCaseActuelle = 0;
	}
	
	//methode pour avancer le joueur
	public void avancerJoueur (int nbCases) {
		this.indiceCaseActuelle += nbCases;
	}
	
	//methode pour recuperer le nom du joueur
	public String getNom(){
		return(this.nom);
	}
	
	// methode pour recuperer la case actuelle
	public Case getCaseActuelle() {
		return caseActuelle;
	}
	// methode pour recuperer l'argent
	public int getArgent () {
		return this.argent;
	}
	
	// methode pour acheter une propriete
	public void acheterCase (Case c) {
		this.listePropriete.add(c);
		this.argent -= c.getPrix();
	}

	public void payerTaxe(int montantTaxe){
		this.argent-=montantTaxe;
	}
	
	public void gagneArgent (int somme) {
		this.argent += somme;
	}
	
	public void retirerArgent (int somme) {
		this.argent -= somme;
	}
	
	// methode pour savoir si le joueur a la case
	public boolean aCase (Case c) {
		boolean trouve = false;
		int cpt = 0;
		// on parcourt la liste de ces propri�t�s
		while (!trouve)
		{
			if (listePropriete.get(cpt) == c)
				trouve = true;
			else
				cpt ++;
		}
		return trouve;
	}
	
	public static void main(String[] args){
		Joueur Bob = new Joueur("Bob","Jaune");
	}
	
} // Fin de la classe joueur
