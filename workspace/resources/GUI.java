package resources;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	Solitaire game;
   public GUI(Solitaire game){
	   this.game= game;
        //Create and set up the window.
       setTitle("CatFishing");
       setSize(900,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	setLayout(new GridBagLayout());
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

		JPanel panel1 = new JPanel();
		panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.gridwidth = 250;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(panel1, gbc);

		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
		gbc.gridx = 9;
        gbc.gridy = 300;
        gbc.gridwidth = 250;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(panel2, gbc);

		JPanel panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
		gbc.gridx = 259;
        gbc.gridy = 0;
        gbc.gridwidth = 250;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(panel3, gbc);

		JPanel panel4 = new JPanel();
		panel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
		gbc.gridx = 509;
        gbc.gridy = 0;
        gbc.gridwidth = 250;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(panel4, gbc);

		JPanel panel5 = new JPanel();
		panel5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
		gbc.gridx = 509;
        gbc.gridy = 300;
        gbc.gridwidth = 250;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(panel5, gbc);
       
       // this supplies the background
       try {
		System.out.println(getClass().toString());
		Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
		setContentPane(new ImagePanel(blackImg));

       }catch(IOException e) {
    	   e.printStackTrace();
       }
       
       /*******
        * This is just a test to make sure images are being read correctly on your machine. Please replace
        * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
        * game once it's fully created.
        */
       Card card = new Card(2, Card.Suit.Diamonds);
       System.out.println(card);
       this.add(card);    

        this.setVisible(true);
    }


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
