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

	public void newRound(Card c){//precondition c != null
	//  one round played: current player play c
		Player currentPlayer = this.GetPlayingPlayer();// this is the current player
		currentPlayer.playCard(c);// current player play deck
		river.add(c);// add the card into the player
		// Now we need to check if this player win anything
		ArrayList<Card> cardWon = new ArrayList<>();
		// rule #1 to win
		for (int i = river.size()-2; i >= 0; i--){// start from the second last card, ending at the first
			if (river.get(i).value == c.value){
				for (int j = river.size(); j >= i; j--){
					cardWon.add(river.get(i));
					river.remove(i);// Removing each card move from the river
				}

				currentPlayer.addCard(cardWon);// giving the deck won to the Player
			}
		}

		// rule #2 to win all, with a jack played:
		if (c.value == 11){
			for (int i = 0; i < river.size(); i++){
				cardWon.add(river.get(i));
				river.remove(i);// Removing each card move from the river
			}
		}

		// rule #3 to tax, with an Ace played
		else if (c.value == 1){
			if (c.suit == Card.Suit.Diamonds){
				for (Player p : players){
					if (p != currentPlayer){
						
					}
				}
			}
			if (c.suit == Card.Suit.Clubs){
				
			}
			if (c.suit == Card.Suit.Hearts){
				
			}
			if (c.suit == Card.Suit.Spades){
				
			}

		}

		round++;
	}
	Player PlayingPlayer = null;
	ArrayList<Player>PlayerData = new ArrayList();
	//the part of your program that's in charge of game rules goes here.
	public Player GetPlayingPlayer() {
		return players.get(round % 4);	
	}

	public void IncremenentRound() {
		round++;
	};

	public Solitaire() {
		for (int i = 1; i <= Main.NUMPLAYER; i++) {
			players.add(new Player());
		}

		// initilizes all players, auto-creates deck.
	}

	
}
