import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CarteCommunaute extends Carte{
	private int numCarteCommunaute;
	private String texte;
	private String type;
	
	// on va cr�er un constructeur qui construit les cartes a partir de la lecture d'un fichier .txt
	CarteCommunaute (int i) { // est l'indice de la carte a creer
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
			// on crer un scanner
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
}
