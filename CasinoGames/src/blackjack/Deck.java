package blackjack;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

import blackjack.Card;;

public class Deck {

	private final Integer cardsOnADeck = 52;
	//private enum CardSuits { Hearts, Clubs, Diamonds, Spades };
	private List<Card> remainingCards;
	private List<Card> discardedCards;
	
	public Deck(Integer amountOfDecks)
	{
		final Integer totalAmountOfCards = amountOfDecks * this.cardsOnADeck;
		remainingCards = new ArrayList<>(totalAmountOfCards);
		discardedCards = new ArrayList<>(totalAmountOfCards);
		Integer counter = 1;
		
		while(counter <= amountOfDecks)
		{
			this.remainingCards.addAll(buildDeck());
		}
		 // TODO POSSIBLE IMPROVEMENT -> SAVE LIST AND JUST REPEAT
	}
	
	
	public List<Card> buildDeck()
	{
		List<Card> cardsOfDeck = new ArrayList<Card>(52);
		
		// Suit corresponds to the numeric value of each of the suits in a deck
		for(Integer suit = 1; suit <= 4; ++suit)
		{
			// Generate the 13 cards for one suit and create their objects
			List<Integer> cardList = IntStream.range(1, 13).boxed().collect(Collectors.toList());
			for(Integer cardNumber : cardList)
			{
				// Create Card objects with numeric and suit values
				Card tempCard = new Card(cardNumber, suit);
				cardsOfDeck.add(tempCard);
			}
		}
		
		return cardsOfDeck;
	}
	
	public void shuffleDeck(Integer extraCardsInDeck, Deck cardsToShuffle)
	{
		
	}
	
	public void shuffleDeck()
	{
		this.shuffleDeck(0, this);
	}
	
	/**
	 * Sort the whole deck and put it back into order.
	 * Put any discarded cards back on the deck and execute constructor
	 * to rebuild the deck with the same amount of cards.
	 */
	public void sortDeck()
	{
		if(this.discardedCards.size() >= 1)
		{
			this.remainingCards.addAll(this.discardedCards);
		}
		
		Integer amountOfDecks = this.remainingCards.size() / cardsOnADeck;
		
		// TODO FINISH -> COMPARABLE
	}
}
