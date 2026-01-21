package resources;
import java.util.*;

public class Player {
	private boolean inGame = true;
	private ArrayList<Card> hand = new ArrayList<>();
	private Queue<Card> deck = new LinkedList<>();
	//Precondition: used on a player object
	//Postcondition: return all of the player cards (deck and card) in an ArrayList
	public ArrayList<Card> getAllCards(){
		ArrayList<Card> allCards = new ArrayList();
		for (Card c : deck){
			allCards.add(c);
		}
		for (Card c : hand){
			allCards.add(c);
		}
		return allCards;
	}
	//Precondition: used on a player object
	//Postcondition: return all cards of the player's deck as an ArrayList of Cards
	public Queue<Card> getDeck() {
		return deck;
	}
	//Precondition: i >= 0
	//Postcondition: make player drop cards for i time, and return them as an ArrayList of Cards
	//Deemed them losing if they don't have enough cards 
	public ArrayList<Card> removeCards(int i){// remove the last i num of card and return them, used when being tax 
		ArrayList<Card> cardRemoved = new ArrayList<>();
		if(i > getAllCards().size()){
			inGame = false;
			for(int k = 0; k < getAllCards().size(); i++){
				cardRemoved.add(this.playCard(0));
			}
		}
		else{
			for (int j = 0; j<i; j++){// loop i time
				cardRemoved.add(this.playCard(0));
			}
		}
		return cardRemoved;
	}
	//Precondition: used on a player object
	//Postcondition: return all cards in player hands as an ArrayList of Cards
	public ArrayList<Card> getHands(){
		return hand; 
	}

	//Precondition: c exist within player's hand and c != null.
	//Postcondition: play card(drop it from hand) and draw a card from the deck.
	public void playCard(Card c) {
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i).equals(c)){
				System.out.println("FOUND CARD, REMOVING IT FROM THE PLAYERS HAND!");
				hand.remove(i);
				if (deck.size() >= 1) {//draw a card of their deck is not empty
					hand.add(deck.remove());
				}
			}
		}
	}
	//Precondition: i <= hand.size() and c != null.
	//Postcondition: play card(drop it from hand), return it, and draw a card from the deck.
	public Card playCard(int i) {// play the number "i" its hand, draw from his deck and return the card
		Card cardplayed = hand.get(i);
		hand.remove(i);
		if (deck.size() >= 1) {//draw a card of their deck is not empty
			hand.add(deck.remove());
		}
		return cardplayed;
	}
	//Precondition: Card != null
	//Postcondition: c is added to the player's deck
	public void addCard(Card c){
	// this one is called when player is winning card from the river
		deck.add(c);	
	}
	//Precondition: Cards != null
	//Postcondition: cards is added to the player's deck
	public void addCards(ArrayList<Card> cards){
	// this one is called when player is winning card from the river
		for (Card card : cards){
			deck.add(card);
		}
	}
	//Postcondition: return player's hand
	public ArrayList<Card> GetHand() {
		return this.hand;
	}
	// Precondition: i <= hand.size()
	// Postcondition: return a random Card from player's hand
	public Card getCard(int i){
		return hand.get(Math.clamp(i, 0, hand.size()-1));
	}
	//Precondition: getAllCards return an empty array list of Card(player doesn't have a deck or hand)
	//Postcondition: give this player 14 random card from a Stardard poker deck from the Main class, 
	//so that there is no replicate
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
			
			Selected += 1;
			HoldingDeck.remove(RandomIndex);
		}
	}

	// when the player is initilized the Deck is automatically created.
	// constructor: no input
	public Player() {/// constructor precondition: deck.size() >= 0
	   CreateDeck();
	}
}