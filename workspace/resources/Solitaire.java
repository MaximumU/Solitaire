package resources;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solitaire {
	Stack<Card> pile;
	
	ArrayList<Card> deck  = new ArrayList<Card>;
	for(int i = 1; i < 14; i ++){
		for(int j = 1; j < 5; j++){
			deck.add(Card(i,Suit(j)))
		}
	}

	player1.addCard();
	// dont hold the cards here

	
	
	Player PlayingPlayer = null;
	ArrayList<Player>PlayerData = new ArrayList();
	// getting playerdata will have player, and the data that is required for X player...;
	
	for (int i = 0; i < 4; i++) {
		PlayerData.add(new Player());
	}
	// players are all stored here.
	
	//the part of your program that's in charge of game rules goes here.
	public Player GetPlayingPlayer() {
		return PlayingPlayer;	
	}

	public void UpdatePlayingPlayer() {

	};

	
}
