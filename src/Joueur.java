import java.util.ArrayList;

public class Joueur {
	private String nom;
	private int argent;
	private Pion sonPion;
	private String couleur;
	ArrayList <CarteChance> listeCarteChance;
	ArrayList <CarteCommunaute> listeCarteCommunaute;
	ArrayList <Case> listePropriete;
	private int caseActuelle;
	 
	
	// constructeur 
	Joueur (String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.argent = 1500;
		this.listeCarteChance = new ArrayList <CarteChance> ();
		this.listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.listePropriete = new ArrayList <Case> ();
	}
	
	//methode pour avancer le joueur
	void avancerJoueur (int numCase) {
		this.caseActuelle += numCase;
	}
	
	// methode pour recuperer l'argent
	int getArgent () {
		return this.argent;
	}
	
	// methode pour acheter une propriete
	void acheterCase (Case c) {
		this.listePropriete.add(c);
		this.argent -= c.getPrix();
	}

	void payerTaxe(int montantTaxe){
		this.argent-=montantTaxe;
	}
	
} // Fin de la classe joueur
