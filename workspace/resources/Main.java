package resources;

import java.util.*;

public class Main {
	public static int cardLimit = 52;
	public static int numPlayer = 4;
	Stack<Card> pile;
	public static ArrayList<Card> TemplateDeck  = new ArrayList<Card>();

	static {
		boolean color;
	
	for(int i = 1; i < 14; i ++){
		for(int j = 1; j < 5; j++){
			if( i == 1 || i == 4)
				color = false;
			else
				color = true;
			TemplateDeck.add(new Card(i, Suit(j, color)));
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