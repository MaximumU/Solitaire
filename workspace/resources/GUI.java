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
import java.util.ArrayList;
import java.util.Stack;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	Solitaire game;
	JPanel middle;
	ArrayList<JPanel> cardDisplayed;

	
	public GUI(Solitaire game) {
		this.game = game;
		cardDisplayed = new ArrayList();
		// Create and set up the window.
		setTitle("CatFishing");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		// this supplies the background
		try {
			System.out.println(getClass().toString());
			Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
			setContentPane(new ImagePanel(blackImg));

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*******
		 * This is just a test to make sure images are being read correctly on your
		 * machine. Please replace
		 * once you have confirmed that the card shows up properly. The code below
		 * should allow you to play the solitare
		 * game once it's fully created.
		 */

		GridBagConstraints gbc = new GridBagConstraints();
		Color ColorSet = null;

		// makes visible river in center of board
		ColorSet = Color.MAGENTA;
		

		middle = new JPanel();
		middle.setSize(new Dimension(250,275));

		middle.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorSet));
		
		
		for (int i = 0; i < 4; i++) {
			// player card stack, initilization.

			// create player card stack
			Stack<Card> stack = new Stack();
			Player editingPlayer = game.getPlayers().get(i); // define player that is being edited in the for - loop

			System.out.println(i);

			// add user-cards to stack (cards 1, 2, 3 and already intiilized frooom player)

			stack.add(editingPlayer.getCard(3));
			stack.add(editingPlayer.getCard(2));
			stack.add(editingPlayer.getCard(1));

			// add the cards from the players general deck tooo the stack 😁
			
			// define a jpanel
			JPanel panel = new JPanel();
			gbc.fill = GridBagConstraints.HORIZONTAL;

			panel.setSize(new Dimension(250, 275));
			panel.setOpaque(false);
			panel.setLocation(Main.PlayerData[i][0], Main.PlayerData[i][1]);
			
			//editingPlayer.SetPrimaryPanel(panel); // get JPanel using player.getJPAnel()

			// sets the location of the cards depending on data set in Main.PlayerData, referr
			if(i == 2){
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.gridheight = 2;
				getContentPane().add(middle, gbc);
			}
			gbc.gridheight =1 ;
			// creates visible hands for each player, separated by colors, etc:
			if (i == 0) {
				ColorSet = Color.RED;
				gbc.gridx = 0;
				gbc.gridy = 0;
			} else if (i == 1) {
				ColorSet = Color.BLUE;
				gbc.gridx = 0;
				gbc.gridy = 1;
			} else if (i == 2) {
				ColorSet = Color.GREEN;
				gbc.gridx = 2;
				gbc.gridy = 0;
			} else if (i == 3) {
				ColorSet = Color.YELLOW;
				gbc.gridx = 2;
				gbc.gridy = 1;
			}

			

			// finalized:

			panel.setLayout(new FlowLayout());
			panel.add(drawPile(stack));
			getContentPane().add(panel, gbc);
			panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorSet));
			cardDisplayed.add(panel);
			editingPlayer.SetCardStack(stack);
		}
	
		// panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorSet));

		gbc.gridwidth = 250;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		/// getContentPane().add(panel1, gbc);

		/// Stack<Card> stack1 = new Stack();
		/// stack1.add(new Card(0, Card.Suit.Diamonds));

		// RepresentativePlayer.SetCardStack(stack1);

		// panel1.setLayout(new FlowLayout());
		// panel1.add(drawPile(stack1));

		/*
		 * JPanel panel2 = new JPanel();
		 * panel2.setSize(new Dimension(250, 275));
		 * panel2.setOpaque(false);
		 * panel2.setLocation(9,275);
		 * panel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
		 * gbc.gridx = 9;
		 * gbc.gridy = 300;
		 * gbc.gridwidth = 250;
		 * gbc.fill = GridBagConstraints.HORIZONTAL;
		 * getContentPane().add(panel2, gbc);
		 * 
		 * Stack<Card> stack2 = new Stack();
		 * 
		 * stack2.add(new Card(0, Card.Suit.Diamonds));
		 * stack2.add(game.getPlayers().get(1).getCard(3));
		 * stack2.add(game.getPlayers().get(1).getCard(2));
		 * stack2.add(game.getPlayers().get(1).getCard(1));
		 * 
		 * panel2.setLayout(new FlowLayout());
		 * panel2.add(drawPile(stack2));
		 * 
		 * JPanel panel3 = new JPanel();
		 * panel3.setSize(new Dimension(250, 550));
		 * panel3.setOpaque(false);
		 * panel3.setLocation(259,0);
		 * panel3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
		 * gbc.gridx = 259;
		 * gbc.gridy = 0;
		 * gbc.gridwidth = 250;
		 * gbc.fill = GridBagConstraints.HORIZONTAL;
		 * getContentPane().add(panel3, gbc);
		 * 
		 * JPanel panel4 = new JPanel();
		 * panel4.setSize(new Dimension(250, 275));
		 * panel4.setOpaque(false);
		 * panel4.setLocation(509,0);
		 * panel4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
		 * gbc.gridx = 509;
		 * gbc.gridy = 0;
		 * gbc.gridwidth = 250;
		 * gbc.fill = GridBagConstraints.HORIZONTAL;
		 * getContentPane().add(panel4, gbc);
		 * 
		 * Stack<Card> stack4 = new Stack();
		 * 
		 * stack4.add(new Card(0, Card.Suit.Diamonds));
		 * stack4.add(game.getPlayers().get(2).getCard(3));
		 * stack4.add(game.getPlayers().get(2).getCard(2));
		 * stack4.add(game.getPlayers().get(2).getCard(1));
		 * 
		 * panel4.setLayout(new FlowLayout());
		 * panel4.add(drawPile(stack4));
		 * 
		 * JPanel panel5 = new JPanel();
		 * panel5.setSize(new Dimension(250, 275));
		 * panel5.setOpaque(false);
		 * panel5.setLocation(509,275);
		 * panel5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
		 * gbc.gridx = 509;
		 * gbc.gridy = 300;
		 * gbc.gridwidth = 250;
		 * gbc.fill = GridBagConstraints.HORIZONTAL;
		 * getContentPane().add(panel5, gbc);
		 * 
		 * Stack<Card> stack5 = new Stack();
		 * 
		 * stack5.add(new Card(0, Card.Suit.Diamonds));
		 * stack5.add(game.getPlayers().get(3).getCard(3));
		 * stack5.add(game.getPlayers().get(3).getCard(2));
		 * stack5.add(game.getPlayers().get(3).getCard(1));
		 * 
		 * panel5.setLayout(new FlowLayout());
		 * panel5.add(drawPile(stack2));
		 * 
		 */

		this.setVisible(true);

	}

	public JLayeredPane drawPile(Stack<Card> stackIn) {
		JLayeredPane ret = new JLayeredPane();
		ret.setLayout(null);
		Object cards[];
		cards = stackIn.toArray(); // please note we convert this stack to an array so that we can iterate through
									// it backwards while drawing. You’ll need to cast each element inside cards to
									// a <Card> in order to use the methods to adjust their position
		// loop through the cards. Add them with a slight offset to the ret pane
		for (int i = 0; i < cards.length; i++) {
			Card c = (Card) cards[i];
			c.addMouseListener(this);
			c.setBounds(0, 20 * i, 100, 150);
			ret.add(c, 0);
		}
		ret.setPreferredSize(new Dimension(120, 300));
		ret.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.pink));
		return ret;

	}

	private Card card1;
	private Card card2;

	private Card CardHeld;
	// uppppphereee

	// card1.addMouseListener(this);
	// card2.addMouseListener(this);

	// <nameofcard>.addMouseListener(this);

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("CALLED DRAGGED");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("CALLED CLICKED");
		// System.out.println("CALLED CLICKED APPROPRIATLEY");
		System.out.println("mouse clicked");

		if (CardHeld != null) {
			return;
		}

		Player currentPlayer = game.GetPlayingPlayer();
		// currentPlayer.SetHeldCard
		Component MouseComponent = arg0.getComponent();

		Card CardHold = (Card) MouseComponent;
		CardHeld = CardHold;

		if (CardHold != null) {
			game.newRound(CardHold);
			System.out.println("card moved to river");
		}

	}

	@Override
	public void mouseEntered(MouseEvent MouseData) {
		// System.out.println(M);
		// TODO Auto-generated method stub
		// System.out.println("CALLED ENTEREEED");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/// System.out.println("CALLED EXITED");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("Mouse has been pressed");
		if (card1 == null) {
			card1 = ((Card) arg0.getComponent());
			card1.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
		} else {
			card2 = ((Card) arg0.getComponent());

			// rest of your logic here including checking to make sure if the move is legal,
			// checking if the game is over and updating the screen.
			card1 = null; // reset the card variables so you're ready for another move
			card2 = null;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("action was probably performed bro idk?");
		// TODO Auto-generated method stub

	}

	private void update() {
		// update card positions based on waht is being dragged?
		// set data in relations to
	}

	// private void update() {
	/*
	 * columns.removeAll();
	 * topColumns.removeAll();
	 * ArrayList<Stack<Card>> allColumns = game.getColumns();
	 * 
	 * for(Stack<Card> stack: allColumns) {
	 * topColumns.add(drawPile(stack, false));
	 * }
	 * 
	 * columns.add(drawDeck(game.getDeck()));
	 * columns.add(drawPile(game.getPile(), true));
	 * columns.add(drawFinal(game.hearts, "hearts"));
	 * columns.add(drawFinal(game.spades, "spades"));
	 * columns.add(drawFinal(game.diamonds, "diamonds"));
	 * columns.add(drawFinal(game.clubs, "clubs"));
	 * System.out.println("updating");
	 * 
	 * this.revalidate();
	 * this.repaint();
	 * }
	 */
}
