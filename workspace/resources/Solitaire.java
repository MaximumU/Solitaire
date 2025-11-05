package resources;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solitaire {
	private List<Player> players = new ArrayList<>(numPlayer);// player of the game
	private int round = 1;//round number, use to indicate who is playing
	private List<Card> river = new ArrayList<>();



	public void newRound(Card c){// one round played. precondition c != null
		Player currentPlayer = players.get(round % numPlayer);// this is the current player
		currentPlayer.playCard(c);// current player play deck
		river.add(c);// add the card into the player
		// Now we need to check if this player win anything
		for (int i = river.size()-2; i >= 0; i--){// start from the second last card, ending at the first
			if (river.get(i).value == c.value){
				currentPlayer.addCard();
			}
		}
	}
	Player PlayingPlayer = null;
	ArrayList<Player>PlayerData = new ArrayList();
	//the part of your program that's in charge of game rules goes here.
	public Player GetPlayingPlayer() {
		return players.get(round % numPlayer);	
	}

	public void UpdatePlayingPlayer() {

	};

	public Solitaire() {

	}

	
}
