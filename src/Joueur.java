package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joueur{
	private String nom;
	private int argent;
	private String couleur;
	private ArrayList <CarteChance> listeCarteChance;
	private ArrayList <CarteCommunaute> listeCarteCommunaute;
	private ArrayList <Case> listePropriete;
	private Case caseActuelle;
	private int indiceCaseActuelle;
	private int nbGares;
	 
	
	// constructeur 
	public Joueur (String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.argent = 150000;
		this.listeCarteChance = new ArrayList <CarteChance> ();
		this.listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.listePropriete = new ArrayList <Case> ();
		this.caseActuelle = new Case("depart",0);
		this.indiceCaseActuelle = 0;
		this.nbGares = 0;
	};
	
	//méthode pour connaitre le nb de maisons qu'il possède en tout
	public int getNbMaisons(){
		int nbMaisons=0;
		for(int i=0; i<listePropriete.size();i++){
			nbMaisons+=listePropriete.get(i).getNbMaison();
		}
		return(nbMaisons);
	}
	
	//méthode pour connaitre le nb d'hotel qu'il possède en tout
	public int getNbHotels(){
		int nbHotels=0;
		for(int i=0; i<listePropriete.size();i++){
			nbHotels+=listePropriete.get(i).getNbHotel();
		}
		return(nbHotels);
	}
	
	//méthode pour faire reculer un joueur
	public void reculerJoueur(int nbCases){
		this.indiceCaseActuelle=this.getIndCaseActuelle()-nbCases;
	}
			
	// methode a lancer quand on passe la case depart
	public void passeCaseDepart () {
		gagneArgent(200000);
	}
	
	// methode pour ajouter carte de communaute
	public void ajouterCarteCommunaute (CarteCommunaute carte){
		listeCarteCommunaute.add(carte);
	}
	
	//methode pour ajouter une carte chance
	public void ajouterCarteChance(CarteChance e){
		this.listeCarteChance.add(e);
	}
		
	//methode pour avancer le joueur
	public void avancerJoueur (Case c, int nbCases) {
		this.caseActuelle = c;
		this.indiceCaseActuelle += nbCases;
	}
	
	// methode pour changer la case actuelle depuis une case donnée
	public void setIndCaseActuelle(String nomCase, int numCase){
		this.caseActuelle = new Case(nomCase,numCase);
	}
	
	// methode pour recupere l'indice de la case actuelle
	public int getIndCaseActuelle() {
		return indiceCaseActuelle;
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
	
	// methode pour demander si le joueur veut acheter la propriété
	public boolean veutAcheter () {
		boolean veut = false;
		// on affiche le nom pour savoir a qui on parle
		System.out.println(nom);
		System.out.println("Voulez vous acheter la propriété ? (entrer le numéro de votre réponse)");
		System.out.println("1) Oui");
		System.out.println("2) Non");
		
		Scanner sc = new Scanner(System.in); // pour le type string
		int rep = sc.nextInt();
		if (rep == 1)
			veut = true;
		return veut;
	}
	
	// methode pour acheter une propriete
	public void acheterCase (Case c) {
		//on va verifier qu'il peut l'acheter
		if (argent >= c.getPrix())
		{
			this.listePropriete.add(c);	// on ajoute la propriete a sa liste de propriete
			this.argent -= c.getPrix();	// on retire l'argent
			// on l'informe sur son argent
			System.out.println("Il vous reste desormais " +argent +" mille(s)");
		}
		else
			System.out.println("Le joueur n'a pas assez d'argent");
	}

	// methode pour acheter une propriete
	public void acheterCaseEnchere (Case c, int somme) {
		//on va verifier qu'il peut l'acheter
		if (argent >= somme)
		{
			this.listePropriete.add(c);	// on ajoute la propriete a sa liste de propriete
			this.argent -= somme;	// on retire l'argent
			// on l'informe sur son argent
			System.out.println("Il vous reste desormais " +argent +" mille(s)");
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
	
	// methode pour renvnoyer le nombre de propriété que le joueur a
	public int getNbProp () {
		return listePropriete.size();
	}
	
	// methode pour retourner une propriété du joueur
	public Case getProprieteJoueur (int ind) {
		return listePropriete.get(ind);
	}
	
	//Methode pour donner le nombre de gares d'un joueur (utilisé pour les cartes)
	public int getNbGares(){
		return(this.nbGares);
	}
		
	//////////////////////////////////////////////////
	/////////// FONCTION MAIN ////////////////////////
	//////////////////////////////////////////////////
	public static void main (String [] args) {
		Joueur j = new Joueur("Bob","Jaune");
		// j.avancerJoueur(6);
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
		Case c = new Case("champs", 0);
		
		j.acheterCase(c);
		// on va vérifier qu'il est la case
		if (j.aCase (c))
			System.out.println("Le joueur a bien la case : " +c);
		else
			System.out.println("La transaction n'a pas fonctionné");
		
		// on va afficher toute les propriétés du joueur
		Case c2 = new Case("pigalle", 1);
		j.acheterCase(c2);
		j.afficherPropri();
		
		// on affiche le joueur directement
		System.out.println(j);
		
	} // fin main
		
} // Fin de la classe joueur
