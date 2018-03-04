/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_p3;

import java.util.*;

/**
 * This class creates an instance of a the card game where two players 
 * evaluate the top card in their hand against a discard pile to determine
 * whether they draw more cards or not. A winner is declared when a player
 * has emptied their hand.
 * @author danzc
 *
 */
public class GameModel {
	private final int SUITS = 4; //There are 4 suits in a deck
	private final int FACES = 13; //There are 13 cards per suit
	private final int HANDSIZE = 7; //Game instructions say initial deal 
							//should result with each player having 7 cards
							//in their hand.
	private 	Queue[] hands; //Array of each players hand each represented
							//by a queue. 
	private Stack deal; //The stack that represents the dealing deck.
	private Stack discard = new Stack(); //The stack that represents the 
							//discard pile. 
	private String[] plyrs; //Holds names of players
	private ArrayList<Integer> deck = new ArrayList<>(); //An array with all 
							//elements needed to represent each card in a deck
	private int winnerIndex; //Holds index of winner in player array
	private boolean winner = false; //initialize existence of winner to false
	
	/**
	 * Constructor of GameModel. Initializes a new game. 
	 * @param players			A array of strings holding player names.
	 */
	public GameModel(String[] players) {
		plyrs = players;
		deal = new Stack(initializeNewDealDeck());
		hands = new Queue[plyrs.length];
		for (int q = 0; q < plyrs.length; q++) {
			hands[q] = new Queue();
		}
		dealTheCards(); //Deal the cards out to all players
		discard.push(deal.pop()); //Add the first card to the discard pile from the deal deck. 
	}
	
	/**
	 * Sets up a deck of cards according to standard deck parameters
	 * defined by class constants. Method then calls the shuffle method
	 * and returns the deck ready use as by a deal stack. 
	 * @return deck				ArrayList of integers representing a deck
	 * 							of cards.
	 */
	private ArrayList<Integer> initializeNewDealDeck() {
		for (int i = 1; i <= SUITS; i++) {
			for(int j = 1; j <= FACES; j++) {
				deck.add(j);
			}
		shuffleDeck(deck);
		}
		return deck;
	}
		
	/**
	 * Checks to see if there is a winner
	 * @return boolean			True if there is a winner, false otherwise
	 */
	public boolean getWinner() {
		return winner;
	}
	
	/**
	 * Gets the index of the player in the plyrs array who won.
	 * @return winnerIndex		Integer representing the index of
	 * 							the winning player. 
	 */
	public int getWinnerIndex() {
		return winnerIndex;
	}
	
	/**
	 * Performs the necessary actions of a player to take a complete turn.
	 * Checks to see if the turn results in a win and makes sure the deal
	 * stack continues to have cards to draw from for the next turn.
	 * @param index				Index of player who's turn it is. 
	 */
	public String takeTurn(int index) {
		String s;
		if(discard.peek() > hands[index].peek()) {
			s = "Your card is LOWER, discard and pick up 2 " +
								"cards.\n";
			discard.push(hands[index].dequeue());
			hands[index].enqueue(deal.pop());
			if (deal.empty()) {
				turnOver();
			}
			hands[index].enqueue(deal.pop());
		} 
		else if (discard.peek() == hands[index].peek()) {
			s = "Your card is EQUAL, discard and pick up 1 " +
								"card.\n";
			discard.push(hands[index].dequeue());
			hands[index].enqueue(deal.pop());
		}
		else {
			s = "Your card is HIGHER, discard only.\n";
			discard.push(hands[index].dequeue());
		}
		if (hands[index].empty()) {
			winnerIndex = index;
			winner = true;
		}
		if (deal.empty()) {
			turnOver();
		}
		return s;
	}
	
	/**
	 * When the deal stack is empty, rules of the game say to take all but 
	 * the current top of the discard stack and move them to the deal stack.
	 * This method pops the discard method into pushes to a tempStack before
	 * then popping that stack into the deal stack because otherwise the
	 * values would go into the deal deck backwards.
	 */
	public void turnOver() {
		int tempVal = discard.pop();
		Stack tempStack = new Stack();
		while (!discard.empty()) {
			tempStack.push(discard.pop());
		}
		while (!tempStack.empty()) {
			deal.push(tempStack.pop());
		}
		discard.push(tempVal);
	}
	
	/**
	 * Gets all the necessary details of the turn into a single string.
	 * @param index				Index of the player who's turn it is
	 * @return String			Holding various details about the current
	 * 							game's status.
	 */
	public String turnDetails(int index) {
		return "\n" + plyrs[index] + "'s turn, cards:\n" + 
				hands[index].toString() + "\nDiscard pile card: " + 
				discard.peek() + "\nYour current card: " + hands[index].peek();
	}
	
	/**
	 * Performs the initial dealing of the deck out to the players.
	 * pops the deal stack to enqueue that value into the player's 
	 * hand. Dealing is done in a "Round Robin" fashion.
	 */
	public void dealTheCards() {
		for (int i = 0; i < HANDSIZE; i++)
			for (int j = 0; j < plyrs.length; j++)
				hands[j].enqueue(deal.pop());
	}
	
	/**
	 * Get the all values from the deck. 
	 * @return String			From stack's toString method.
	 */
	public String getDealDeck() {
		return deal.toString();
	}
	

	/**
	 * Shuffles the cards using the
	 * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">
	 * Fisher-Yates algorithm</a>
	 * @param cards				Array representing a deck to shuffle.
	 */
	private void shuffleDeck(ArrayList<Integer> cards) {
	    Random rand = new Random();
	    for (int i = cards.size(); i > 1; i--) {
	        int j = rand.nextInt(i);
	        int temp = cards.get(i - 1);
	        cards.set(i - 1, cards.get(j));
	        cards.set(j, temp);
	    }
	}
}
