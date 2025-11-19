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

    private JLabel MainLabel = null;
    private ArrayList<JPanel> cardDisplayed;
    // first element corrospond with river; the other four stand for each of the four player respecfully.

    
    public GUI(Solitaire game) {
        this.game = game;
		ArrayList<Player> players = game.getPlayers();
        cardDisplayed = new ArrayList();
        // Create and set up the window.
        setTitle("CatFishing");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        gbc.anchor = GridBagConstraints.PAGE_START; // Align to the left

        JPanel back = new JPanel();
        back.setLayout(new GridBagLayout());
        Color ColorSet = null;


        // makes visible river in center of board
		middle = new JPanel();
		cardDisplayed.add(middle);
        ColorSet = Color.MAGENTA;
        middle.setSize(new Dimension(250,275));
        middle.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorSet));

        
        for (int i = 0; i < Main.NUMPLAYER; i++) {
            // player card stack, initilization.

            // create player card stack
            Stack<Card> stack = new Stack();
            Player editingPlayer = game.getPlayers().get(i); // define player that is being edited in the for - loop

            System.out.println(i);

            // add user-cards to stack (cards 1, 2, 3 and already intiilized frooom player)
			
          /*  stack.add(editingPlayer.getCard(3));
            stack.add(editingPlayer.getCard(2));
            stack.add(editingPlayer.getCard(1)); */

            // add the cards from the players general deck tooo the stack 😁
            
            // define a jpanel
			
            JPanel panel = new JPanel();
            panel.setSize(new Dimension(250, 200));
            panel.setMinimumSize(new Dimension(200,350));
            panel.setMaximumSize(new Dimension(200, 350));
            panel.setOpaque(false);
            panel.setLocation(Main.PlayerData[i][0], Main.PlayerData[i][1]);
            
            //editingPlayer.SetPrimaryPanel(panel); // get JPanel using player.getJPAnel()

            // sets the location of the cards depending on data set in Main.PlayerData, referr
            if(i == 2){
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.gridheight = 2;
                back.add(middle, gbc);
				middle.setOpaque(false);
                middle.setMinimumSize(new Dimension(250,700));
                middle.setMaximumSize(new Dimension(250, 700));
            }
            if(i == 3){
                gbc.gridx = 3;
                gbc.gridy = 0;
                JPanel handsizedisplay = new JPanel();
                JLabel handsizedTempLay = new JLabel("Hand sizes: Player 1 (" + players.get(0).getDeck().size() + "), Player 2 ("
                    + players.get(1).getDeck().size() + "), Player 3 (" + players.get(2).getDeck().size() + "), Player 4 ("
                    + players.get(3).getDeck().size() + ")");
                back.add(handsizedisplay,gbc);
                this.MainLabel = handsizedTempLay;
                handsizedisplay.add(handsizedTempLay);
            }
            gbc.gridheight =1 ;
            // creates visible hands for each player, separated by colors, etc:
            if (i == 0) {
                ColorSet = Color.RED;
                gbc.gridx = 0;
                gbc.gridy =0;
        
            } else if (i == 1) {
                ColorSet = Color.BLUE;
                gbc.gridx = 0;
                gbc.gridy =1;
        
            } else if (i == 2) {
                System.out.println("here");
                ColorSet = Color.GREEN;
        	gbc.gridx = 2;
                gbc.gridy =0;
            } 
            else if (i == 3) {
                ColorSet = Color.YELLOW;
                gbc.gridx = 2;
                gbc.gridy =1;
        
            }

           // finalized:
			panel.setLayout(new FlowLayout());
			panel.add(drawShownPile(players.get(i).getHands(), 50));
			back.add(panel, gbc);
			panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ColorSet));
			
			//add panel to arraylist of panels here
			cardDisplayed.add(panel);
        }

		

        back.setSize(900,800);
        back.setOpaque(false);

        this.add(back);
        this.repaint();
        this.setVisible(true);

    }

    // this is just another drayPile method, but it takes in a arrayList instead of a stack
	public JLayeredPane drawShownPile(ArrayList<Card> stackIn, int cardDistance) {
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
			c.setBounds(0, cardDistance * i, 100, 150);
			ret.add(c, 0);
		}

		ret.setPreferredSize(new Dimension(120, 300));
		ret.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.pink));
		return ret;

	}
	//public void update(){// called when a new round is played
        
    // } 

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
        System.out.println("mouse clicked successfully");
		Player currentPlayer = game.GetPlayingPlayer();
		Card CardSelected = (Card) arg0.getComponent();
		
		if (CardSelected != null) {
            // System.out.println("BOIII IM PLAYING");
			// ensure that card selected is a card that the current player actually owns.

			// iterate through player hand, check if it is valid. if it is owner card then put it into river.
			ArrayList<Card> PlayerHand = currentPlayer.GetHand();
			
			boolean IsOwnerCard = false;
			
			// iterate through entire hand, ensure that u have
			for (int i = 0; i < PlayerHand.size(); i++) {
				Card FoundCard = PlayerHand.get(i);

				if (FoundCard == CardSelected) {
					IsOwnerCard = true;
					break;
				}
			}

			if (!IsOwnerCard) {
                System.out.println("bruh im not owner card lel");
				return;
			}

            System.out.println("PLAYED CARD SELECTED!");
			game.newRound(CardSelected);
			this.update();
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
      //  JPanel validPanel = cardDisplayed.get(game.getRound);

        for (int i = 0; i < Main.NUMPLAYER; i++) {
			Player SelectedPlayer = game.getPlayers().get(i);
			ArrayList<Card> PlayerHand = SelectedPlayer.getHands();
			JPanel UserPanel = cardDisplayed.get(i+1); 

            // still feel like the player should hold this since its specific to them and shld use getters to get this, i dont grasp why this is being held in gui
			// sure it makes sense like technologically but when you think of itlogically a player should own their own stuff
			
			UserPanel.removeAll();
            
			UserPanel.add(this.drawShownPile(PlayerHand, 60));
		}

        ArrayList<Card> CardRiver = game.GetRiver();
        
        middle.removeAll();
        middle.add(this.drawShownPile(CardRiver, 20));

        if (this.MainLabel != null) {
            ArrayList<Player>  players = game.getPlayers();

            MainLabel.setText("Deck sizes: Player 1 (" + players.get(0).getDeck().size() + "), Player 2 ("
                + players.get(1).getDeck().size() + "), Player 3 (" + players.get(2).getDeck().size() + "), Player 4 ("
                + players.get(3).getDeck().size() + ")");
        }

        this.repaint();
        this.setVisible(true);
        // just refreshes everything 🧑‍🌾🧑‍🌾;
    }
}

    