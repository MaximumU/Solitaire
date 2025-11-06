package resources;

import java.util.*;

public class Main {
	public static int CARDLIMIT = 52;
	public static int NUMPLAYER = 4;
	public static ArrayList<Card> PRIMARYDECK  = new ArrayList<Card>();

	Stack<Card> pile;

	static {
	
	boolean color;
	
	for(int i = 1; i <= 13; i ++){
		for(Card.Suit suit: Card.Suit.values()){

			PRIMARYDECK.add(new Card(i, suit));
		}
	}
	}

	public static double Lerp(double Start, double Goal, double Alpha) {
		return Start + (Goal - Start) * Alpha;
	}

	public static void main(String[] args) {
		Solitaire game = new Solitaire();
		GUI gui = new GUI(game);
		
	}
}