package resources;
import java.util.*;

public class Player {
	private ArrayList<Card> hand = new ArrayList<>();
	private ArrayList<Card> AllCards = new ArrayList<>();

	private Queue<Card> deck = new LinkedList<>();
	private Stack<Card> PrimaryCardStack = null;

	/* public ArrayList<Card> removeCards(int i){ // remove the last i num of card and return them, used when being tax 
		if 
	
	} */ 
	public void playCard(Card c) {// play card and draw a card from the deck
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i).equals(c)){
				hand.remove(i);
				if (deck.size() >= 1) {//draw a card of their deck is not empty
					hand.add(deck.remove());
				}
			}
		}
	}
	public Card playCard(int i) {// play the number "i" its hand, draw from his deck and return the card
		Card cardplayed = hand.get(i);
		
		hand.remove(i);

		if (deck.size() >= 1) {//draw a card of their deck is not empty
			hand.add(deck.remove());
		}

		return cardplayed;
	}
	
	public void addCard(Card c){// playCard remove, 
	// this one is called when player is winning card from the river
		deck.add(c);
		
	}
	public void addCard(ArrayList<Card> cards){// playCard remove, 
	// this one is called when player is winning card from the river
		for (Card card : cards){
			deck.add(card);
		}
	}
	// need method of storing random cards.
	public Card getCard(int i){
		return hand.get(Math.clamp(i, 0, hand.size()-1));
	}

	public void SetCardStack(Stack<Card> CardStack) {
		this.PrimaryCardStack = CardStack;
	}
	
	public void CreateDeck() {
		ArrayList<Card> HoldingDeck = Main.PRIMARYDECK;

		int Selected = 0;
		int Searching = Main.CARDLIMIT / Main.NUMPLAYER;

		while (Selected < Searching) { 
			int RandomIndex = (int) (Math.random() * HoldingDeck.size());

			if (Selected < 3) {
				this.hand.add(HoldingDeck.get(RandomIndex));
			} else {
				this.deck.add(HoldingDeck.get(RandomIndex));
			};

			AllCards.add(HoldingDeck.get(RandomIndex));
			
			Selected += 1;
			HoldingDeck.remove(RandomIndex);
		}
	}

	// when the player is initilized the Deck is automatically created.
	public Player() {/// constructor precondition: deck.size() >= 0
	   CreateDeck();
	}
}