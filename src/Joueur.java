import java.util.ArrayList;

public class Joueur {
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
	Joueur (String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.argent = 1500;
		this.listeCarteChance = new ArrayList <CarteChance> ();
		this.listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.listePropriete = new ArrayList <Case> ();
		this.caseActuelle = null;
		this.indiceCaseActuelle = 0;
	}
	
	//methode pour avancer le joueur
	void avancerJoueur (int numCase) {
		this.indiceCaseActuelle += numCase;
	}
	
	// methode pour recuperer la case actuelle
	Case getCaseActuelle() {
		return caseActuelle;
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
	
	void gagneArgent (int somme) {
		this.argent += somme;
	}
	
	void retirerArgent (int somme) {
		this.argent -= somme;
	}
	
	// methode pour savoir si le joueur a la case
	boolean aCase (Case c) {
		boolean trouve = false;
		int cpt = 0;
		// on parcourt la liste de ces propriétés
		while (!trouve)
		{
			if (listePropriete.get(cpt) == c)
				trouve = true;
			else
				cpt ++;
		}
		return trouve;
	}
	
} // Fin de la classe joueur
