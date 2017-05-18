package src;

import java.awt.*;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fond extends JFrame{

	private static final long serialVersionUID = 3827913327888251420L;
	//Image img = ImageIO.read(new File ("fond.jpg)"));
	private JFrame frame;// = new JFrame();
	private JPanel pnlFond;// = new JPanel();
	private JPanel pnlCmd;// = new JPanel();
	private BorderLayout bL;// = new BorderLayout();
	private JTextArea tA;// = new JTextArea();
	
	public Fond() throws FileNotFoundException, IOException {
		this.setTitle("Monopoly");
	    this.setLocationRelativeTo(null);
	    this.setResizable(false); // à voir
	    this.frame = new JFrame();
	    this.pnlFond=new JPanel();
	    this.pnlCmd=new JPanel();
	    this.bL = new BorderLayout();
	    this.tA = new JTextArea();
	    
		Graphics g = null;		

		bL.setHgap(50);
		bL.setVgap(200);
		
		pnlCmd.setLayout(bL);
		
		//creation des boutons
		JButton nvPartie = new JButton ("Nouvelle partie");
		JButton chPartie = new JButton ("Charger partie");
		JButton svPartie = new JButton ("Sauver partie");
		JButton quit = new JButton ("Quitter");
		
		//Ajout des boutons au panel
		pnlCmd.add(nvPartie);
		pnlCmd.add(chPartie);
		pnlCmd.add(svPartie);
		pnlCmd.add(quit);
		
		// Reglage de la taille du panel et de la photo de fond de la frame
		pnlCmd.setSize(400, 400);
		pnlFond.add(new JLabel(new ImageIcon("src/Fond/fondMonop.jpg")));
		pnlFond.setSize(1050, 1050);
		pnlFond.setVisible(true);
		
		frame.setLayout(new BorderLayout());

		frame.getContentPane().add(pnlFond,BorderLayout.WEST);
		frame.getContentPane().add(pnlCmd, BorderLayout.CENTER);
			}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Fond f = new Fond();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1400,1050);
		f.setVisible(true);
		
	}

}
