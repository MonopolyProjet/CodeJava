package src;

import java.awt.*;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fond extends JFrame{
	Image img = ImageIO.read(new File ("fond.jpg)"));
	//ImageLoader Image=new ImageLoader();
	public Fond() throws FileNotFoundException, IOException {
		this.setTitle("Monopoly");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    //this.setResizable(false); à voir
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphics g = null;
		JFrame frame = new JFrame();
		JPanel pnlFond = new JPanel();
		JPanel pnlCmd = new JPanel();
		GridLayout gL = new GridLayout(3,1);
		gL.setHgap(50);
		gL.setVgap(200);
		
		pnlCmd.setLayout(gL);
		JButton nvPartie = new JButton ("Nouvelle partie");
		JButton chPartie = new JButton ("Charger partie");
		JButton quit = new JButton ("Quitter");
		nvPartie.setBounds(1225, 625, 100, 50);
		chPartie.setBounds(1225, 525, 100, 50);
		quit.setBounds(1225, 425, 100, 50);
		
		pnlCmd.add(nvPartie);
		pnlCmd.add(chPartie);
		pnlCmd.add(quit);

		//pnlCmd.setBounds(1225, 525, 300, 200);
		pnlCmd.setSize(400, 400);
		pnlFond.add(new JLabel(new ImageIcon("src/Fond/fondMonop.jpg")));
		pnlFond.setSize(1050, 1050);
		
		frame.setLayout(new BorderLayout());

		frame.getContentPane().add(pnlFond,BorderLayout.WEST);
		frame.getContentPane().add(pnlCmd, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400,1050);
		frame.setVisible(true);
		
	}

}
