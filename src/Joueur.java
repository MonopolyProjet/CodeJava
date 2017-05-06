package src;

import java.util.ArrayList;
import java.util.Random;

public class Joueur{
	private String nom;
	private int argent;
	private String couleur;
	private ArrayList <CarteChance> listeCarteChance;
	private ArrayList <CarteCommunaute> listeCarteCommunaute;
	private ArrayList <Case> listePropriete;
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
		//on va verifier qu'il peut l'acheter
		if (argent >= c.getPrix())
		{
			this.listePropriete.add(c);
			this.argent -= c.getPrix();
		}
		else
			System.out.println("Le joueur n'a pas assez d'argent");
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
	
	// methode pour afficher toutes les propriété d'un joueur sous forme de liste
	private void afficherPropri() {
		System.out.println("Le joueur possède toute les propriétés suivantes : " +"\n");
		// on parcourt toutes ses propriétes et on les affiche
		for (int i=0; i<listePropriete.size(); i++)
		{
			System.out.println(listePropriete.get(i) +"\n");
		}
	}
	
	// methode toString du joueur
	public String toString() {
		String s = "";
		
		s = s +"Le joueur s'appel : " +nom +", il a la couleur " +couleur +" et a : " +argent +" milles";
		return s;
	}
	
	
	//////////////////////////////////////////////////
	/////////// FONCTION MAIN ////////////////////////
	//////////////////////////////////////////////////
	public static void main (String [] args) {
		Joueur j = new Joueur("Bob","Jaune");
		j.avancerJoueur(6);
		//on affiche le nom du joueur
		System.out.println("Le nom du joueur est : " +j.getNom());
		// on affiche la case actuelle du joueur
		System.out.println("La case actuelle du joueur est : " +"\n" +j.getCaseActuelle());
		// on affiche l'argent qu'il a 
		System.out.println("Le joueur a : " +j.getArgent() +" mille(s)");
		// on lui ajoute 10 mille et on lui retirera mille
		j.gagneArgent(10000);
		System.out.println("Le joueur a : " +j.getArgent() +" mille(s) apres l'ajout");
		j.retirerArgent(1000);
		System.out.println("Le joueur a : " +j.getArgent() +" mille(s) apres le retrait");
		
		//on va lui faire acheter une propriete
		Case c = new Case("champs");
		
		j.acheterCase(c);
		// on va vérifier qu'il est la case
		if (j.aCase (c))
			System.out.println("Le joueur a bien la case : " +c);
		else
			System.out.println("La transaction n'a pas fonctionné");
		
		// on va afficher toute les propriétés du joueur
		Case c2 = new Case("pigalle");
		j.acheterCase(c2);
		j.afficherPropri();
		
		// on affiche le joueur directement
		System.out.println(j);
		
	} // fin main
		
} // Fin de la classe joueur
