import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CarteChance extends Carte {
	private int numCarteChance;
	private String texte;
	
	
	// on va creer un constructeur qui construit les cartes a partir de la lecture d'un fichier .txt
	CarteChance (int i) { // est l'indice de la carte a creer
		this.numCarteChance = i;
		String description = ""; // va recevoir le texte de la carte
		
		
		// on d�clare le nouveau fichier
		File f = new File ("src/CarteChance/carte"+i +".txt");
		
		// si le fichier existe on va faire les op�ration suivante
		if (f.exists())
		{
			// on test si pas de probleme
			try {
				f.createNewFile();
			}
			// si erreur
			catch (IOException e)
			{
				e.printStackTrace();
			}
		} // fin du if
		
		// on va s'occuper de la lecture
		try (FileInputStream fis = new FileInputStream(f)) {
			// on creer un scanner
			Scanner sc = new Scanner (fis);
			// on attrape maintenant ligne par ligne (tant qu'il y en a)
				description = sc.nextLine();
				
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.texte = description;
		
	} // fin du constructeur
	
	
	// methode toString pour afficher une carte chance
	public String toString () {
		String s = "";
		s = s +"num carte : " +numCarteChance +"\n" +texte;
		return s;
	}
	
	
	/////////////////////////////////////////////////////
	//////////////// FONCTION MAIN //////////////////////
	/////////////////////////////////////////////////////
	
	public static void main (String [] args) {
		// on va cr�er 3 cartes (les trois premieres)
		CarteChance c1 = new CarteChance (1);
		CarteChance c2 = new CarteChance (2);
		CarteChance c3 = new CarteChance (3);
		
		// on va les affichers
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}	// Fin de la classe CarteChance
