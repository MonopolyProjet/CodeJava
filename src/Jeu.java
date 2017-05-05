package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

public class Jeu {
	// les attributs
	String nom;
	int nbJoueur;
	static ArrayList <Joueur> lesJoueurs;
	
	
	//constructeur
	Jeu (String nom) {
		this.nom = nom;
		lesJoueurs = new ArrayList <Joueur> ();
	}
	
	
	// fonction pour cr�er les joueurs
	public void creerJoueur (int nbJoueur) {

		this.nbJoueur = nbJoueur;
		
		int i = 0; // compteur pour la d�claration des joueurs
		int tempCouleur;
		String tempNom;
		ArrayList arrayPions = new ArrayList <String>();
		arrayPions.add("Rouge");
		arrayPions.add("Bleu");
		arrayPions.add("Noir");
		arrayPions.add("Rose");
		arrayPions.add("Marron");
		arrayPions.add("Mauve");
		arrayPions.add("Cyan");
		arrayPions.add("Vert");
		
		System.out.println("\n" +"Vous devez entrer les noms de tous les joueurs avant de commencer la partie" +"\n");
		while (i<nbJoueur) {
			Scanner sc2 = new Scanner(System.in); // Scanner pour les String
			System.out.println("\n" +"Entrez le nom d'un des joueurs: ");
			tempNom = sc2.nextLine();
			System.out.println("Entrez la couleur du pion que le joueur veut: ");
			
			// on va afficher le tableau des pions avec leurs couleurs
			
			for (int j=0; j<8-i; j++){
				System.out.println( j + ": " + arrayPions.get(j));
			}
			
			// on recupere la reponse
			tempCouleur = sc2.nextInt ();
			
			// ajoute a la liste de joueur et declaration des objets joueur
			lesJoueurs.add(new Joueur (tempNom, (String)arrayPions.get(tempCouleur)));
			
			arrayPions.remove(tempCouleur);//on enlève la couleur qui a déjà été prise
			i++; // on augmente i pour stocker dans une autre case et arreter la boucle
		}		
	}
	
	// fonction pour voir si une propri�t� n'est pas d�j� a quelqu'un
	boolean appartientDeja (Case c) {
		boolean appartient = false;
		
		for (int i=0; i<nbJoueur; i++)
		{
			if (lesJoueurs.get(i).aCase(c))
				appartient = true;
		}
		return appartient;
	}

	/////////////////////////////////////////////////////
	//////////////// FONCTION MAIN //////////////////////
	/////////////////////////////////////////////////////
	public static void main (String [] args) {
		
		// On cr�er le jeu
		Scanner sc = new Scanner(System.in); // pour le type string
		System.out.println ("Veuillez entrer le nom de la partie");
		String nom = sc.nextLine();
		Jeu jeu = new Jeu (nom);
		
		// On va cr�er le plateau de jeu
		//Plateau p = new Plateau ();
		
		// on va cr�er les joueurs mais on doit savoir combien il y en a
		System.out.println("\n" +"Entrez mainenant le nombre de joueur de cette partie (entre 2 et 8)");
		int nbJoueur = sc.nextInt();
		// on appel la m�thode pour cr�er les joueur
		jeu.creerJoueur(nbJoueur);
		
		
		// on va faire march� les joueurs
		int i=0;
		while(i<20){
			System.out.println(lesJoueurs.get(i).getNom() + " est à la case : " + lesJoueurs.get(i).getCaseActuelle());
			Random r = new Random(); //Génération du nombre aléatoire
			int nbCases = 2 + r.nextInt(12 - 2); //On fait en sorte que le nombre soit compris entre 2 et 12
			lesJoueurs.get(i).avancerJoueur(nbCases);
			System.out.println(lesJoueurs.get(i).getNom() + " avance de " + nbCases + " cases.");
			System.out.println(lesJoueurs.get(i).getNom() + " est à la case : " + lesJoueurs.get(i).getCaseActuelle());
			i++;			
		}
				
	} // Fin de la fonction main
	
} 	// Fin de la classe Jeu
