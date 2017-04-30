import java.util.ArrayList;

public class Plateau {
	static ArrayList <Case> touteCase;
	static ArrayList <CarteChance> listeCarteChance;
	static ArrayList <CarteCommunaute> listeCarteCommunaute;
	private int nbCase;
	
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
		touteCase.add(new Case(1,"Départ",0));
		touteCase.add(new Case(2,"Boulevard De Belleville",60, "marron"));
		touteCase.add(new Case(3,"Caisse de communauté",0));
		touteCase.add(new Case(4,"Rue Lecourbe",60, "marron"));
		touteCase.add(new Case(5,"Impôt sur le revenu",0));
		touteCase.add(new Case(6,"Gare Monparnasse",200));
		touteCase.add(new Case(7,"Rue De Vaugirard",100, "bleu clair"));
		touteCase.add(new Case(8,"Chance",0));
		touteCase.add(new Case(9,"Rue De Courcelles",100, "bleu clair"));
		touteCase.add(new Case(10,"Avenue De La République",120, "bleu clair"));
		touteCase.add(new Case(11,"Prison",0));
		touteCase.add(new Case(12,"Boulevard De La Vilette",140, "violet"));
		touteCase.add(new Case(13,"Compagnie de distribution de l'éléctricité",150));
		touteCase.add(new Case(14,"Avenue de Neuilly",140, "violet"));
		touteCase.add(new Case(15,"Rue De Paradis",160, "violet"));
		touteCase.add(new Case(16,"Gare de Lyon",200));
		touteCase.add(new Case(17,"Avenue Mozart",180, "orange"));
		touteCase.add(new Case(18,"Caisse de communauté",0));
		touteCase.add(new Case(19,"Boulevard Saint-Michel",180, "orange"));
		touteCase.add(new Case(20,"Place Pigalle",200, "orange"));
		touteCase.add(new Case(21,"Parc Gratuit",0));
		touteCase.add(new Case(22,"Avenue Matignon",220, "rouge"));
		touteCase.add(new Case(23,"Chance",0));
		touteCase.add(new Case(24,"Boulevard Malesherbes",220, "rouge"));
		touteCase.add(new Case(25,"Avenue Henri-Martin",240, "rouge"));
		touteCase.add(new Case(26,"Gare du Nord",200));
		touteCase.add(new Case(27,"Faubourg Saint-Honoré",260, "jaune"));
		touteCase.add(new Case(28,"Place De La Bourse",260, "jaune"));
		touteCase.add(new Case(29,"Compagnie de distribution des eaux",150));
		touteCase.add(new Case(30,"Rue La Fayette",280, "jaune"));
		touteCase.add(new Case(31,"Allez en prison",0));
		touteCase.add(new Case(32,"Avenue De Breteuil",300, "vert"));
		touteCase.add(new Case(33,"Avenue Foch",300, "vert"));
		touteCase.add(new Case(34,"Caisse de communauté",0));
		touteCase.add(new Case(35,"Boulevard Des Capucines",320, "vert"));
		touteCase.add(new Case(36,"Gare Saint-Lazare",200));
		touteCase.add(new Case(37,"Chance",0));
		touteCase.add(new Case(38,"Avenue Des Champs-Eleysées",350, "bleu fonce"));
		touteCase.add(new Case(39,"Taxe de luxe",100));
		touteCase.add(new Case(40,"Rue De La Paix",400, "bleu fonce"));
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
