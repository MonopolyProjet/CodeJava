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
	
	
	// fonction pour creer les joueurs
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
	
	// fonction pour voir si une propriete n'est pas deja a quelqu'un
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
			if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==7)
			{
				lesJoueurs.get(ordre).setIndCaseActuelle("lyon", 15);
				if(lesJoueurs.get(ordre).getCaseActuelle().appartientA())
				{
					if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1) 
					{
						lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);
						lesJoueurs.get(ordre).retirerArgent(25000);
						}
						else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2)
						{
							lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);;
							lesJoueurs.get(ordre).retirerArgent(50000);
						}
						else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3)
						{
							lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);
							lesJoueurs.get(ordre).retirerArgent(100000);
						}
						else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4)
						{
							lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(200000);
							lesJoueurs.get(ordre).retirerArgent(200000);
						}
					}
				}
				else if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==22)
				{
					lesJoueurs.get(ordre).setIndCaseActuelle("nord", 15);
						if(lesJoueurs.get(ordre).getCaseActuelle().appartientA())
						{
							if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);
								lesJoueurs.get(ordre).retirerArgent(25000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);;
								lesJoueurs.get(ordre).retirerArgent(50000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);
								lesJoueurs.get(ordre).retirerArgent(100000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(200000);
								lesJoueurs.get(ordre).retirerArgent(200000);
							}
						}
					}
					else if (lesJoueurs.get(ordre).getCaseActuelle().getNumCase()==36)
					{
						lesJoueurs.get(ordre).setIndCaseActuelle("montparnasse", 5);
						lesJoueurs.get(ordre).gagneArgent(200000);
						if(lesJoueurs.get(ordre).getCaseActuelle().appartientA())
						{
							if(lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==1) 
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(25000);
								lesJoueurs.get(ordre).retirerArgent(25000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==2)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(50000);
								lesJoueurs.get(ordre).retirerArgent(50000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==3)
							{
								lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().gagneArgent(100000);
								lesJoueurs.get(ordre).retirerArgent(100000);
							}
							else if (lesJoueurs.get(ordre).getCaseActuelle().getProprietaire().getNbGares()==4)
							{
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
			lesJoueurs.get(ordre).passeCaseDepart();
		break;
		case 13:
			// "Avancez jusqu'aux boulevard de la villette. Si vous passez par la case départ, recevez M200 milles."
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
		} // fin du switch
	} // fin de la méthode
	
	
	// methode pour tirer une carte caisse de communaute et l'ensemble de l'execution qui en suit
	private void tirerCarteCaisseCommunaute (Plateau p, int ordre) {
		// on tire une carte au hasard dans la liste des cartes
		CarteCommunaute co = p.getCarteCommunaute(nombreAlea());
		// on va l'afficher
		System.out.println(co);
		
		// on recuperer l'indice de la carte
		int indCarte = co.getNum();
		switch (indCarte)
		{
		case 1:
			// "La taxe d'habitation augmente. Payer M40 milles par maison. Payer M115 milles par hôtel."
			int prixMaison = 40000, prixHotel = 115000;
			// on compte cb d'hotel et cb de maison
			int nbMaison = 0, nbHotel = 0;
			// on parcourt tout ses propriété et on compte le nombre de maison et d'hotem
			// on recupere le nombre de propriété
			int nbProp = lesJoueurs.get(ordre).getNbProp();
			// boucle pour avoir compter
			for (int i=0; i<nbProp; i++)
			{
				// compteur prend le nombre de maison sur la propriete du joueur
				nbMaison += lesJoueurs.get(ordre).getProprieteJoueur(i).getNbMaison();
				nbHotel += lesJoueurs.get(ordre).getProprieteJoueur(i).getNbHotel();
			}
			// on fait le total de ce qu'il va devoir depenser
			int retrait = nbMaison * prixMaison + nbHotel * prixHotel;
			// on le retire au joueur
			lesJoueurs.get(ordre).retirerArgent(retrait);
			p.ajouterArgentPlateau(retrait);
		break;
		case 2:
			// "Vous organisez une fête privée sur les bords de Seine. Payer M50 milles."
			lesJoueurs.get(ordre).retirerArgent(50000);
			p.ajouterArgentPlateau(50000);
		break;
		case 3:
			// "Votre compagnie ferroviaire dégage de gros profits. Recevez M200 milles."
			lesJoueurs.get(ordre).gagneArgent(200000);
		break;
		case 4:
			// "Le fisc effectue un contrôle de vos impôts. Allez en prion. Avancez tout droit en prison. 
			//Ne passez pas par la case départ. Ne toucher pas M200 milles."
			Case cPrison = p.getCase(11);
			lesJoueurs.get(ordre).avancerJoueur(cPrison, 11);
			System.out.println("Vous etes maintenant en prison ...");
		break;
		case 5:
			// "Vous bénéficiez d'une remise d'impôt. Recevez M50 milles."
			lesJoueurs.get(ordre).gagneArgent(50000);
		break;
		case 6:
			// "L'organisation de votre propre festival de musique vous rapporte M10 milles."
			lesJoueurs.get(ordre).gagneArgent(10000);
			break;
		case 7:
			// "Tout le monde se cotise pour participer à un séjour à la campagne. Chacun vous verse M10 milles."
			int somme = (nbJoueur - 1) * 10000;
			lesJoueurs.get(ordre).gagneArgent(somme);
			// on enleve l'argent a tout les autres joueurs
			for (int i=0; i<ordre; i++)
				lesJoueurs.get(i).retirerArgent(10000);
			for (int j=ordre+1; j<nbJoueur+1; j++)
				lesJoueurs.get(j).retirerArgent(10000);
		break;
		case 8:
			// "Votre boutique parisienne vous rapport M25 milles."
			lesJoueurs.get(ordre).gagneArgent(25000);
		break;
		case 9:
			// "Vous louez votre musée d'art pour une exposition internationale. Recevez M100 milles."
			lesJoueurs.get(ordre).gagneArgent(100000);
		break;
		case 10:
			// "Vous organisez le festival de la Saint-Patrick à Pigale.Payer M100 milles."
			lesJoueurs.get(ordre).retirerArgent(100000);
			p.ajouterArgentPlateau(100000);
		break;
		case 11:
			// "Vous revendez votre costume du carnaval. Recevez M20 milles."
			lesJoueurs.get(ordre).gagneArgent(20000);
		break;
		case 12:
			// "Vous dépensez M50 milles au marché de noël des Champs Elysées."
			lesJoueurs.get(ordre).retirerArgent(50000);
			p.ajouterArgentPlateau(50000);
		break;
		case 13:
			// "Avancez jusqu'à la case départ. Touchez M200 milles."
			Case cDepart = p.getCase(1);
			lesJoueurs.get(ordre).avancerJoueur(cDepart, 1);
			System.out.println("Vous etes maintenant à la case départ.");
			lesJoueurs.get(ordre).passeCaseDepart();
		break;
		case 14:
			// "VOUS ETES LIBERE DE PRISON. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue."
			lesJoueurs.get(ordre).ajouterCarteCommunaute(co);
		break;
		case 15:
			// "Les entrées de votre soirée spéciale Karaoké vous rapportent M10 milles."
			lesJoueurs.get(ordre).gagneArgent(10000);
		break;
		case 16:
			// "Vous louez votre batiment destiné aux sciences à une équipe de chercheurs étrangers. Recevez M100 milles."
			lesJoueurs.get(ordre).gagneArgent(100000);
		break;
		}	
	} // fin de la méthode pour tirer une carte caisse de communaute
	
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
			// si il y a double 6 il ramasse l'argent sur la plateau
			if (nbCasesAvance == 12)
			{
				lesJoueurs.get(ordre).gagneArgent(p.getArgentPlateau());
				p.retirerArgentPlateau();	// on remet l'argent du plateau a 0
			}
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
				jeu.tirerCarteCaisseCommunaute(p, ordre);				
			}
			else
			{
				// on va voir si le joueur veut acheter la propriété
				if (lesJoueurs.get(ordre).veutAcheter(lesJoueurs.get(ordre)))		// si le joueur veut acheter
				{
					//il l'acheter et on donne une phrase de réponse
					lesJoueurs.get(ordre).acheterCase(lesJoueurs.get(ordre).getCaseActuelle());
					System.out.println("Vous avez bien acheter cette propriete");
				}
				else	// on va mettre au enchere la popriété
					mettreAuxEncheres(ordre);
			}
			
			ordre++;	// pour passer au joueur suivant (2)			
		} // fin du switch
				
	} // Fin de la fonction main
	
} 	// Fin de la classe Jeu
