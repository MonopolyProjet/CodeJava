import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CarteChance extends Carte {
	private int numCarteChance;
	private String texte;
	private String type;
	
	// on va creer un constructeur qui construit les cartes a partir de la lecture d'un fichier .txt
	CarteChance (int i) { // est l'indice de la carte a creer
		int nbCarteChance = i;
		String description = ""; // va recevoir le texte de la carte
		String type =""; // va recevoir le type de la carte (bonus malus)
		
		// on d�clare le nouveau fichier
		File f = new File ("carte"+i +".txt");
		
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
				type = sc.nextLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.texte = description;
		this.type = type;
	} // fin du constructeur
	
}	// Fin de la classe CarteChance
