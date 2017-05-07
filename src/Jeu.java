package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

public class Jeu {
	// les attributs
	String nom;
	static int nbJoueur;
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

	// methode pour lancer les dés
	private int lanceDes () {
		int nbAlea = 0;
		
		Random r = new Random(); //Génération du nombre aléatoire
		nbAlea = 2 + r.nextInt(12 - 2); //On fait en sorte que le nombre soit compris entre 2 et 12
		
		return nbAlea;
	}
	
	// methode pour tirer un nombre au hasard (pour les cartes)
	private static int nombreAlea () {
		int nbAlea = 0;
		
		Random r = new Random(); //Génération du nombre aléatoire
		nbAlea = 2 + r.nextInt(16); //On fait en sorte que le nombre soit compris entre 2 et 12
		
		return nbAlea;
	}
		
	// methode pour les encheres
	private static void mettreAuxEncheres (int ordre) {
		// on parcourt tout la liste de joueur pour qu'il rencherissent chacun leur tour jusqu'a ce qu'ils ne veulent plus
		boolean arret = false; // pour dire quand arrete
		int cptAbsen = 0; 			// compteur pour lr nombre de "non"
		int valeurProp = lesJoueurs.get(ordre).getCaseActuelle().getPrix();
		int indiceJoueur = 0;		// pour savoir quel joueur va acheter au final
		int nbParti = nbJoueur - 1;  // pour compter le nombre de participant
		while (!arret)
		{
			for (int i=0; i< nbParti; i++)
			{
				// si il veut acheter, on ajoute 0.5 mille a la valeur de la carte
				if (lesJoueurs.get(i).veutAcheter(lesJoueurs.get(i)))
				{
					valeurProp += 50;
					indiceJoueur = i;
				}
				else
				{
					cptAbsen++;
					nbParti --;
					if (nbParti == 1)
						arret = true;
				}
			}
		}
		// le joueur qui a encherie en dernier va acheter la propriété
		lesJoueurs.get(indiceJoueur).acheterCase(lesJoueurs.get(ordre).getCaseActuelle());
	}
	
	// methode pour tirer une carte chance et l'ensemble de l'execution qui en suit
	private void tirerCarteChance(Plateau p, int ordre) {
		// on tire une carte au hasard dans la liste des cartes
		CarteChance chance = p.getCarteChance(nombreAlea());
		// on va l'afficher
		System.out.println(chance);
		
		// on va s'occuper de chacunes des cartes
		// on recuperer l'indice de la carte
				int indCarte = chance.getNum();
				switch (indCarte)
				{
				case 1:
					//"Aller tout droit en prison"
					lesJoueurs.get(ordre).setIndCaseActuelle("prison", 10);
					break;
				case 2:
					//"Aller à la gare la plus proche. Si vous passez par la case départ recevez 200 000
					if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==7) {
						lesJoueurs.get(ordre).setIndCaseActuelle("lyon", 15);
						if(lesJoueurs.get(ordre).getCaseActuelle().appartientA()){
							if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);;
								lesJoueurs.get(ordre).retirerArgent(25000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);;
								lesJoueurs.get(ordre).retirerArgent(50000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);;
								lesJoueurs.get(ordre).retirerArgent(100000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(200000);;
								lesJoueurs.get(ordre).retirerArgent(200000);
							}
						}
					}
					else if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==22) {
						lesJoueurs.get(ordre).setIndCaseActuelle("nord", 15);
						if(lesJoueurs.get(ordre).getCaseActuelle().appartientA()){
							if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);;
								lesJoueurs.get(ordre).retirerArgent(25000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);;
								lesJoueurs.get(ordre).retirerArgent(50000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);;
								lesJoueurs.get(ordre).retirerArgent(100000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(200000);;
								lesJoueurs.get(ordre).retirerArgent(200000);
							}
						}
					}
					else if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==36) {
						lesJoueurs.get(ordre).setIndCaseActuelle("montparnasse", 5);
						lesJoueurs.get(ordre).gagneArgent(200000);
						if(lesJoueurs.get(ordre).getCaseActuelle().appartientA()){
							if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);;
								lesJoueurs.get(ordre).retirerArgent(25000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2) {
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);;
								lesJoueurs.get(ordre).retirerArgent(50000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);;
								lesJoueurs.get(ordre).retirerArgent(100000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4){
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(200000);;
								lesJoueurs.get(ordre).retirerArgent(200000);
							}
						}
					}

					break;
				case 3:
					//"Rdv case Henri-Martin. Si vous passez par la case départ recevez 200 000"
					lesJoueurs.get(ordre).setIndCaseActuelle("henri-martin", 24);
					if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()>24){
						lesJoueurs.get(ordre).gagneArgent(200000);
					}
					break;
				case 4:
					//"Avancez jusqu'aux Champs Elysées."
					lesJoueurs.get(ordre).setIndCaseActuelle("champs", 37);
					break;
				case 5:
					//"Votre club de danse orientale dans le centre de Paris vous rapporte M1.5 mille."
					lesJoueurs.get(ordre).gagneArgent(1500);
					break;
				case 6:
					//﻿"Payer M15 mille pour nettoyer les 32 fenêtres du Louvres."
					lesJoueurs.get(ordre).payerTaxe(15000);
					p.ajouterArgentPlateau(15000);
				case 7:
					//"Payer M50 milles à chaque joueur en échange de nourriture provenant du monde entier." 
					for(int i=0; i<nbJoueur; i++){
						if(ordre!=i) {
							lesJoueurs.get(ordre).payerTaxe(50000);
							lesJoueurs.get(i).gagneArgent(50000);
						}
					}
					break;
				case 8:
					break;
				case 9:
					//"Reculez de trois cases."
					lesJoueurs.get(ordre).reculerJoueur(3);
					break;
				case 10:
					//"Sortie de prison, vous pouvez garder cette carte pour sortir de prison"
					lesJoueurs.get(ordre).ajouterCarteChance(new CarteChance(10));
					break;
				case 11:
					break;
				case 12:
					//"Avancez jusqu'à la case départ, recevez M200 milles."
					lesJoueurs.get(ordre).setIndCaseActuelle("depart", 0);
					lesJoueurs.get(ordre).gagneArgent(200000);
					break;
				case 13:
					lesJoueurs.get(ordre).setIndCaseActuelle("villette", 11);
					if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()>11){
						lesJoueurs.get(ordre).gagneArgent(200000);
					}
					break;
				case 14:
					break;
				case 15:
					//"Votre entreprise de réparation de bicyclette vous rapporte 50000"
					lesJoueurs.get(ordre).gagneArgent(50000);
					break;
				case 16:
					//"Vous faites redécorer vos propriétés par un designer de renommée internationale. 
					//Pour chaque maison payer M25 milles, pour chaque hôtel payer M100 Milles."
					lesJoueurs.get(ordre).payerTaxe(lesJoueurs.get(ordre).getNbMaisons()*25000);
					lesJoueurs.get(ordre).payerTaxe(lesJoueurs.get(ordre).getNbHotels()*100000);
					break;
				}
	}
	
	
	/////////////////////////////////////////////////////
	//////////////// FONCTION MAIN //////////////////////
	/////////////////////////////////////////////////////
	public static void main (String [] args) {
		
		// On cr�er le jeu
		Scanner sc = new Scanner(System.in); // pour le type string
		System.out.println ("Veuillez entrer le nom de la partie");
		String nom = sc.nextLine();
		// on créer le jeu et le plateau
		Jeu jeu = new Jeu (nom);
		Plateau p = new Plateau();
		
		// On va cr�er le plateau de jeu
		//Plateau p = new Plateau ();
		
		// on va cr�er les joueurs mais on doit savoir combien il y en a
		System.out.println("\n" +"Entrez mainenant le nombre de joueur de cette partie (entre 2 et 8)");
		int nbJoueur = sc.nextInt();
		// on appel la m�thode pour cr�er les joueur
		jeu.creerJoueur(nbJoueur);
		
		
		// on va faire march� les joueurs
		int ordre = 0;
		switch (ordre) {
		case 0:
			System.out.println(lesJoueurs.get(ordre).getNom() + " est à la case : " + lesJoueurs.get(ordre).getCaseActuelle());
			// on le fais avancer en lancant les dés
			int nbCasesAvance = jeu.lanceDes();
			int ind = lesJoueurs.get(ordre).getIndCaseActuelle() + nbCasesAvance;
			lesJoueurs.get(ordre).avancerJoueur(p.getCase(ind), nbCasesAvance);
			
			// phrase pour dire de combien de case le joueur a avancé et on affiche sa case actuelle
			System.out.println(lesJoueurs.get(ordre).getNom() + " avance de " + nbCasesAvance + " cases.");
			System.out.println(lesJoueurs.get(ordre).getNom() + " est à la case : " + lesJoueurs.get(ordre).getCaseActuelle());
			
			/////////////////////////////////////////////////////////////////////////////
			/// ON VA VOIR L'ACTION A REALISER EN FONCTION DU TYPE DE LA CASE ///////////
			
			if (lesJoueurs.get(ordre).getCaseActuelle().getNomCase() == "chance")	// si c'est une case de type chance
			{
				
			}
			else if (lesJoueurs.get(ordre).getCaseActuelle().getNomCase() == "communaute")	// si c'est une case de type caisse de communaute
			{
				
			}
			else
				// on va voir si le joueur veut acheter la propriété
				if (lesJoueurs.get(ordre).veutAcheter(lesJoueurs.get(ordre)))		// si le joueur veut acheter
				{
					//il l'acheter et on donne une phrase de réponse
					lesJoueurs.get(ordre).acheterCase(lesJoueurs.get(ordre).getCaseActuelle());
					System.out.println("Vous avez bien acheté cette propriete");
				}
				else	// on va mettre aux encheres la popriété
					mettreAuxEncheres(ordre);
			
			ordre++;	// pour passer au joueur suivant (2)			
		} // fin du switch
				
	} // Fin de la fonction main
	
} 	// Fin de la classe Jeu
