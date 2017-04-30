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
	
	
	// fonction pour créer les joueurs
	public void creerJoueur (int nbJoueur) {
		
		Scanner sc2 = new Scanner(System.in); // Scanner pour les String
		this.nbJoueur = nbJoueur;
		
		int i = 0; // compteur pour la déclaration des joueurs
		int tempInd = 0;
		String tempNom, tempPion = "";
		
		System.out.println("\n" +"Vous aller entrer les noms de tout les joueurs avant de commencer la partie" +"\n");
		while (i<nbJoueur) {
			System.out.println("\n" +"Entrer le nom d'un des joueur");
			tempNom = sc2.nextLine();
			System.out.println("Entrez le numero du motif du pion que le joueur veut");
			// on va affichier le tableau des motifs avec le tableau qui contient les noms des pions
			for (i=0; i<8; i++)
				System.out.println(i +" : " +tabPion[i]);
			
			// on recupere la reponse
			tempInd = sc2.nextInt ();
			// tableau pour les pions qui ont déjà été pris
			int pionDejaPris[] = {10, 10, 10}; // valeur impossible a prendre
			// on parcourt le tableau des deja choisi
			for (int j=0 ; j<8; j++)
			{
				if (tempInd == pionDejaPris[j])
					System.out.println("Ce pion a déjè été pris par un autre joueur");
				else
				{
					tempPion = tabPion[tempInd];
					// on va stocker dans un tableau la liste des piions deja pris
					pionDejaPris[j] = tempInd;
				}
			}
			
			// ajoute a la liste de joueur et declaration des objets joueur
			lesJoueurs.add(new Joueur (tempNom, tempPion));
			
			i++; // on augmente i pour stocker dans une autre case et arreter la boucle
		}		
	}
	
	// fonction pour tirer un dé
	private int lanceDe () {
		Random r = new Random();
		int nbAlea = 2 + r.nextInt(13 - 2);
		
		return nbAlea;
	}

	/////////////////////////////////////////////////////
	/////////////// FONCTIONS MAIN //////////////////////
	/////////////////////////////////////////////////////
	public static void main (String [] args) {
		
		// On créer le jeu
		Scanner sc = new Scanner(System.in); // pour le type string
		System.out.println ("Veuillez entrer le nom de la partie");
		String nom = sc.nextLine();
		Jeu jeu = new Jeu (nom);
		
		// On va créer le plateau de jeu
		Plateau p = new Plateau ();
		
		// on va créer les joueurs mais on doit savoir combien il y en a
		System.out.println("\n" +"Entrer mainenant le nombre de joueur de cette partie (entre 2 et 8)");
		int nbJoueur = sc.nextInt();
		// on appel la méthode pour créer les joueur
		jeu.creerJoueur(nbJoueur);
		
		
		// on va faire marché les joueurs
		int ordre = 0; // pour savoir a quel joueur on en est
		switch (ordre)
		{
		case 0:	// il va lancer son dé et on va le faire avancer
				int avance = jeu.lanceDe();
				// on avance le joueur
				lesJoueurs.get(ordre).avancerJoueur(avance);
				
				if () // on vérifie que la case n'appartient pas a quelqu'un avant de demander de l'acheter
				// on va demander si il veut acheter la propriété en lui montrant son argent
				System.out.println("Votre argent : " +lesJoueurs.get(ordre).getArgent());
				System.out.println("Voulez vous achetez la propriété : " +p.getCase(avance));
				System.out.println(" 1) Oui");
				System.out.println(" 2) Non");
				int op = sc.nextInt();
				
				if (op == 1)
					lesJoueurs.get(ordre).acheterCase(p.getCase(avance));
				
		} 	// fin du switch pour l'ordre des joueurs
				
				
		
		
		
	} // Fin de la fonction main
	
} 	// Fin de la classe Jeu
