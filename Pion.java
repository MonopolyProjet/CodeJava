import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Pion {
	private String nom;
	
	// constructeur
	Pion (String forme, int i){
		// construction des pions avec lecture dans un fichier
		
		String description = ""; // va recevoir le texte de la carte
			// on déclare le nouveau fichier
			File f = new File ("pion"+i +".txt");
			
			// si le fichier existe on va faire les opération suivante
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
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			this.nom = description;
		this.nom = forme;
	}
}
