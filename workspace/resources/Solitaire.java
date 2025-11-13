package resources;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solitaire {
	public ArrayList<Player> players = new ArrayList<>();// player of the game
	private int round = 1;//round number, use to indicate who is playing
	private List<Card> river = new ArrayList<>();
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void newRound(Card c){//precondition c != null.
	//  one round played: current player play c
		Player currentPlayer = this.GetPlayingPlayer();// this is the current player
		currentPlayer.playCard(c);// current player play deck
		river.add(c);// add the card into the player
		// Now we need to check if this player win anything
		ArrayList<Card> cardWon = new ArrayList<>();
		// rule #1 to win with pairs
		for (int i = river.size()-2; i >= 0; i--){// start from the second last card, ending at the first
			if (river.get(i).value == c.value){ // one card found with the same value with the card player
				for (int j = river.size(); j >= i; j--){// start from the end, ending at the card found previously
					cardWon.add(river.get(i));// adding each card to the card Won
					river.remove(i);// Removing each card move from the river
				}
				currentPlayer.addCards(cardWon);// giving the deck won to the Player
			}
		}

		// rule #2 to win all, with a jack played:
		if (c.value == 11){
			for (int i = 0; i < river.size(); i++){
				cardWon.add(river.get(i));// Adding all card in the river to CardWon
				river.remove(i);// Removing each card move from the river
			}
		}

		// rule #3 to tax, with an Ace played
		else if (c.value == 1){/// An Ace is played
			if (c.suit == Card.Suit.Diamonds){// An Ace of Diamonds
				for (Player p : players){
					if (p != currentPlayer){
						cardWon.addAll(p.removeCards(1));
						// remove 1 card from each player(not including the current one)
						// and add them to the Card Won
					}
				}
			}
			if (c.suit == Card.Suit.Clubs){// An Ace of Clubs
				for (Player p : players){
					if (p != currentPlayer){
						cardWon.addAll(p.removeCards(2));
						// remove 2 card from each player(not including the current one)
						// and add them to the Card Won
					}
				}
			}
			if (c.suit == Card.Suit.Hearts){// An Ace of Hearts
				for (Player p : players){
					if (p != currentPlayer){
						cardWon.addAll(p.removeCards(3));
						// remove 3 card from each player(not including the current one)
						// and add them to the Card Won
					}
				}
			}
			if (c.suit == Card.Suit.Spades){// An Ace of Spades
				for (Player p : players){
					if (p != currentPlayer){
						cardWon.addAll(p.removeCards(4));
						// remove 4 card from each player(not including the current one)
						// and add them to the Card Won
					}
				}
			}
		}

		currentPlayer.addCards(cardWon);// give the current player the card that he deserve
		round++;
		
	}
	Player PlayingPlayer = null;
	ArrayList<Player>PlayerData = new ArrayList();
	//the part of your program that's in charge of game rules goes here.
	public Player GetPlayingPlayer() {
		return players.get((round % 4)-1); // the list starts at zero but round start at one	
	}

	public void IncremenentRound() {
		round++;
	};

	public Solitaire() {// this is the constructor
		for (int i = 1; i <= Main.NUMPLAYER; i++) {
			players.add(new Player());
		}

		// initilizes all players, auto-creates deck.
	}
}
