import java.util.ArrayList;

public class Plateau {
	static ArrayList <Case> touteCase;
	static ArrayList <CarteChance> listeCarteChance;
	static ArrayList <CarteCommunaute> listeCarteCommunaute;
	private int nbCase;
	private int argentPlateau; // argent qui est poser sur le plateau
	
	// constructeur vide
	Plateau () {
		touteCase = new ArrayList <Case> ();
		listeCarteChance = new ArrayList <CarteChance> ();
		listeCarteCommunaute = new ArrayList <CarteCommunaute> ();
		this.nbCase = 39;
	
		// on créer toutes les cartes chance
		for (int i=0; i<15; i++) // 16 cartes en tout
			listeCarteChance.add(new CarteChance(i));
		
		// on créer toutes les cartes caisse de communaute
		for (int j=0; j<15; j++) // toujours 16 cartes
			listeCarteCommunaute.add(new CarteCommunaute(j));
		
		// on créer toutes les cases
		touteCase.add(new Case("depart"));
		touteCase.add(new Case("belleville"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("lecourbe"));
		touteCase.add(new Case("impots sur le revenu"));
		touteCase.add(new Case("monparnasse"));
		touteCase.add(new Case("vaugirard"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("courcelles"));
		touteCase.add(new Case("republique"));
		touteCase.add(new Case("prison"));
		touteCase.add(new Case("villette"));
		touteCase.add(new Case("electricite"));
		touteCase.add(new Case("neuilly"));
		touteCase.add(new Case("paradis"));
		touteCase.add(new Case("lyon"));
		touteCase.add(new Case("mozart"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("saint-michel"));
		touteCase.add(new Case("pigalle"));
		touteCase.add(new Case("parc-gratuit"));
		touteCase.add(new Case("matignon"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("malesherbes"));
		touteCase.add(new Case("henri-martin"));
		touteCase.add(new Case("nord"));
		touteCase.add(new Case("saint-honore"));
		touteCase.add(new Case("bourse"));
		touteCase.add(new Case("eau"));
		touteCase.add(new Case("fayette"));
		touteCase.add(new Case("aller-prison"));
		touteCase.add(new Case("breteuil"));
		touteCase.add(new Case("foch"));
		touteCase.add(new Case("communaute"));
		touteCase.add(new Case("capucines"));
		touteCase.add(new Case("saint-lazare"));
		touteCase.add(new Case("chance"));
		touteCase.add(new Case("champs"));
		touteCase.add(new Case("taxe-de-luxe"));
		touteCase.add(new Case("paix"));
		
		
	}
	
	// fonction pour renvoyer une case identifiée avec son numero de case
	Case getCase (int numCase) {
		boolean trouve = false;
		int i = 0, indCase=0;
		
		while (!trouve) {
			if (touteCase.get(i).getNumCase() == numCase )
			{
				indCase = i;
				trouve = true;
			}
			else
				i++;
		}
		return touteCase.get(indCase);
	}
}	// fin de la classe Plateau
