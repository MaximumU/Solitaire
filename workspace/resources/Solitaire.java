package resources;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solitaire {
	public ArrayList<Player> players = new ArrayList<>();// player of the game
	public String winMessage = null;
	private int round = 1;//round number, use to indicate who is playing
	public int playerCount = 4; // number of player remaining
	private ArrayList<Card> river = new ArrayList<>();
	//Postcondition: return te players in this game
	public ArrayList<Player> getPlayers(){
		return players;
	}
	//Postcondition: return the round number
	public int getRound(){
		return round;
	}

	//Precondition: c != null.
	//Postcondition: The current player play card c, win or tax card accordingly.
	//Other player lose card from their hand accordingly, round number increase.
	public void newRound(Card c){
	// one round played: current player play c
		Player currentPlayer = this.GetPlayingPlayer();// this is the current player
		currentPlayer.playCard(c);// current player play deck
		river.add(c);// add the card into the player
		// Now we need to check if this player win anything
		ArrayList<Card> cardWon = new ArrayList<>();
		// rule #1 to win with pairs
		for (int i = river.size()-2; i >= 0; i--){// start from the second last card, ending at the first
			if (river.get(i).value == c.value){ // one card found with the same value with the card player
				for (int j = river.size()-1; j >= i; j--){// start from the end, ending at the card found previously
					cardWon.add(river.get(i));// adding each card to the card Won
					river.remove(i);// Removing each card move from the river
				}
				currentPlayer.addCards(cardWon);// giving the deck won to the Player
			}
		}

		// rule #2 to win all, with a jack played:
		if (c.value == 11){
			if (river.size() != 1){//if there is no card, a Jack can't win itself
				for (int i = 0; i < river.size(); i++){
				cardWon.add(river.get(i));// Adding all card in the river to CardWon
				river.remove(i);// Removing each card move from the river
				i--;//avoid skiping card
				}
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
		for (int i = 0; i < river.size(); i++){
			System.out.println(river.get(i).value);
		}
		for (Player s : players){
			s.draw();
		}
		//check if any player run out of card. If so, he's out of the game. and the number of player decrease
		for (int i = 0; i < players.size(); i++){//loop through the players
			if(players.get(i).getAllCards().size() == 0){//no card left?
				players.remove(i);// out of the game
				i--;//stay at the same index to avoid skipping
				playerCount--;// that's one less player
			}
		}
		// if there is only one player left, that player wins
		System.out.println("Player remaining: " + playerCount);
		if (playerCount == 1){
			winMessage = "Game over, ";
		}
		round++;
		
	}
	Player PlayingPlayer = null;
	ArrayList<Player>PlayerData = new ArrayList();
	//the part of your program that's in charge of game rules goes here.
	public Player GetPlayingPlayer() {
		if(round % playerCount == 0){
			return players.get(playerCount - 1);
		}
		return players.get((round % playerCount)-1); // the list starts at zero but round start at one	
	}

	public void IncremenentRound() {
		round++;
	};

	public ArrayList<Card> GetRiver() {
		return river;
	}

	public Solitaire() {// this is the constructor
		for (int i = 1; i <= Main.NUMPLAYER; i++) {
			players.add(new Player());
		}

		// initilizes all players, auto-creates deck.
	}
}
