import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	private static String nomFichier = "test.txt";
	
	// Fonction main
	public static void main (String [] args) {
	// on déclare le nouveau fichier
	File f = new File ("test.txt");
	String resultat; // va prendre le resultat de la lecture
	
	// on va sortir quelques informations sur le fichier
	System.out.println ("nom du fichier par méthode : " +f.getName());
	System.out.println("Chemin absolu du fichier : " +f.getAbsolutePath());
	
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
		while (sc.hasNextLine())
		{
			resultat = sc.nextLine();
			System.out.println(resultat);
		}
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	
	} // fin de la fonction main
} // fin de la classe
