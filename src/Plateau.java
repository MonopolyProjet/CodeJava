package src;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plateau {
	static ArrayList <Case> touteCase;
	static ArrayList <CarteChance> listeCarteChance;
	static ArrayList <CarteCommunaute> listeCarteCommunaute;
	private int nbCase;
	private static int argentPlateau; // argent qui est poser sur le plateau
	
	// constructeur vide
	Plateau () {
		touteCase = new ArrayList <Case> ();
		listeCarteChance = new ArrayList <CarteChance> ();
		listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.nbCase = 39;
		this.argentPlateau = 0;
	
		// on cr�er toutes les cartes chance
		for (int i=1; i<16; i++) // 16 cartes en tout
			listeCarteChance.add(new CarteChance(i));
		
		// on cr�er toutes les cartes caisse de communaute
		for (int j=1; j<16; j++) // toujours 16 cartes
			listeCarteCommunaute.add(new CarteCommunaute(j));
		
		// on cr�er toutes les cases
		touteCase.add(new Case("depart", touteCase.size()));
		touteCase.add(new Case("belleville", touteCase.size()));
		touteCase.add(new Case("communaute", touteCase.size()));
		touteCase.add(new Case("lecourbe", touteCase.size()));
		touteCase.add(new Case("impots_sur_le_revenu", touteCase.size()));
		touteCase.add(new Case("montparnasse", touteCase.size()));
		touteCase.add(new Case("vaugirard", touteCase.size()));
		touteCase.add(new Case("chance", touteCase.size()));
		touteCase.add(new Case("courcelles", touteCase.size()));
		touteCase.add(new Case("republique", touteCase.size()));
		touteCase.add(new Case("prison", touteCase.size()));
		touteCase.add(new Case("villette", touteCase.size()));
		touteCase.add(new Case("electricite",touteCase.size()));
		touteCase.add(new Case("neuilly", touteCase.size()));
		touteCase.add(new Case("paradis", touteCase.size()));
		touteCase.add(new Case("lyon", touteCase.size()));
		touteCase.add(new Case("mozart", touteCase.size()));
		touteCase.add(new Case("communaute", touteCase.size()));
		touteCase.add(new Case("saint-michel", touteCase.size()));
		touteCase.add(new Case("pigalle", touteCase.size()));
		touteCase.add(new Case("parc_gratuit", touteCase.size()));
		touteCase.add(new Case("matignon", touteCase.size()));
		touteCase.add(new Case("chance", touteCase.size()));
		touteCase.add(new Case("malesherbes", touteCase.size()));
		touteCase.add(new Case("henri-martin", touteCase.size()));
		touteCase.add(new Case("nord", touteCase.size()));
		touteCase.add(new Case("saint-honore", touteCase.size()));
		touteCase.add(new Case("bourse", touteCase.size()));
		touteCase.add(new Case("eau", touteCase.size()));
		touteCase.add(new Case("fayette", touteCase.size()));
		touteCase.add(new Case("aller_prison", touteCase.size()));
		touteCase.add(new Case("breteuil", touteCase.size()));
		touteCase.add(new Case("foch", touteCase.size()));
		touteCase.add(new Case("communaute", touteCase.size()));
		touteCase.add(new Case("capucines", touteCase.size()));
		touteCase.add(new Case("saint-lazare", touteCase.size()));
		touteCase.add(new Case("chance", touteCase.size()));
		touteCase.add(new Case("champs", touteCase.size()));
		touteCase.add(new Case("taxe_de_luxe", touteCase.size()));
		touteCase.add(new Case("paix", touteCase.size()));
		
	} // fin du constructeur
	
	// methode pour sauvegarder le joueur
	public void sauvegarde(String nomPartie, String nomFichier) {
		try
		{
			// on y place le nouveau fichier text
			File dossier = new File ("Sauv" +nomPartie +File.separator);
			if (dossier.isDirectory() == false)
					dossier.mkdir();
			
			// on créer le fichier dans le dossier de la sauvegarde
			File file = new File (dossier +File.separator +nomFichier);
						
				
			PrintWriter pw = new PrintWriter (file);
			pw.write(this.nom +"\n");
			pw.write(this.argent +"\n");
			pw.write(this.couleur +"\n");
			// on écrit tout les numeros de carte chance qu'il a (apres un saut de ligne)
			for (int x=0; x<listeCarteChance.size(); x++)
				pw.write(this.listeCarteChance.get(x).getNum() +"\n");
			pw.write("\n");
			// on écrit tout les numeros de carte comunaute qu'il a (apres un saut de ligne)
			for (int z=0; z<listeCarteCommunaute.size(); z++)
				pw.write(this.listeCarteCommunaute.get(z).getNum() +"\n");
			pw.write("\n");
			// on écrit tout les noms de carte de propriete qu'il a (apres un saut de ligne)
				for (int w=0; w<listePropriete.size(); w++)
					pw.write(this.listePropriete.get(w).getNomCase() +"\n");
			pw.write("\n");
			// nom de la case actuelle
			pw.write(this.caseActuelle.getNomCase());
			pw.write(this.indiceCaseActuelle);
			pw.write(this.nbGares);
			// on gere si il est en prison
			if (this.enPrison == true)
				pw.write("true");
			else
				pw.write("false");
			pw.write(this.nbTourEnPrison);
			pw.close();
		}
		catch (IOException exception)
		{
			System.out.println("Impossible d'écrire la sauvegarde " +exception.getMessage());
		}
	}
		
	// methode pour retourner une case en fonction de son numero
	Case getCase (int ind) {
		return touteCase.get(ind);
	}
	
	// methode pour remettre la pile de carte comme il faut
	public void mettreAjourListeCarteChance(){
		// on stock la premiere
		CarteChance tempCarte = listeCarteChance.get(0);
		// on supprime cette carte
		listeCarteChance.remove(0);
		// et on la rajoute à la fin
		listeCarteChance.add(tempCarte);
	}
	
	// methode pour remettre la pile de carte comme il faut
	public void mettreAjourListeCarteCo(){
		// on stock la premiere
		CarteCommunaute tempCarte = listeCarteCommunaute.get(0);
		// on supprime cette carte
		listeCarteCommunaute.remove(0);
		// et on la rajoute à la fin
		listeCarteCommunaute.add(tempCarte);
	}
		
	// methode pour rechercher une case a partir de son nom
	public Case rechercherCase (String nom) {
		// on parcourt toute les case et on renvoi celle qui a ce nom
		int indice = 0;
		for (int i=0; i<touteCase.size(); i++)
		{
			if (touteCase.get(i).getNomCase() == nom)
				indice = i;
		}
		return touteCase.get(indice);
	}
		
	// methode pour recuperer une carte chance en fonction d'un nombre aleatoire
	CarteChance getCarteChance (int nb) {
		return listeCarteChance.get(nb);
	}
	
	// methode pour recuperer une carte chance en fonction d'un nombre aleatoire
	public CarteCommunaute getCarteCommunaute (int nb) {
		return listeCarteCommunaute.get(nb);
	}
		
	// methode pour afficher l'argent sur le plateau
	static int getArgentPlateau () {
		return argentPlateau;
	}
	
	// methode pour recuperer (donner a un joueur) l'argent qu'il y a sur le plateau
	static int recupererArgent (Joueur j) {
		int tempSomme = 0;
		tempSomme = argentPlateau;
		// on le donne au joueur 
		j.gagneArgent (tempSomme);
		// on remet l'argenta 0;
		retirerArgentPlateau ();
		return tempSomme;
	}
	
	// methode pour ajouter de l'argent sur le plateau
	public void ajouterArgentPlateau (int somme) {
		this.argentPlateau += somme;
	}

	// methode pour reinitialis� l'argent sur le plateau
	public static void retirerArgentPlateau() {
		argentPlateau = 0;
	}
	
	
	//////////////////////////////////////////////////
	/////////// FONCTION MAIN ////////////////////////
	//////////////////////////////////////////////////
	public static void main (String [] args) {
		// on créer un plateau
		Plateau p = new Plateau ();
		System.out.println("Plateau crée");
		
		// on s'occupe de l'argent sur le plateau
		// on ajoute de k'argent au plateau (2 milles)
		p.ajouterArgentPlateau(2);
		// on affiche 
		System.out.println("Argent sur le plateau : " +getArgentPlateau());
		// on donne l'argent a un joueur et on reaffcihe la somme sur le plateau
		Joueur j = new Joueur ("Ludo", "bleu");
		recupererArgent(j);
		System.out.println("Argent sur le plateau apres avoir recuperer par joueur : " +getArgentPlateau());
		
		
	}
}	// fin de la classe Plateau
