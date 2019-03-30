package models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import models.Card;

import java.util.ArrayList;
import java.util.Collections;;

public class Deck {

	
	//private enum CardSuits { Hearts, Clubs, Diamonds, Spades };
	
	private final Integer cardsOnADeck = 52;
	public Integer getCardsOnADeck() {
		return cardsOnADeck;
	}
	
	private final Integer cardsNotShuffled = 20;
	public Integer getCardsNotShuffled() {
		return cardsNotShuffled;
	}

	private List<Card> remainingCards;
	public List<Card> getRemainingCards() { 
		return remainingCards;
	}
	public void setRemainingCards(List<Card> remainingCards) {
		this.remainingCards = remainingCards;
	}
	
	private List<Card> discardedCards;
	public List<Card> getDiscardedCards() {
		return discardedCards;
	}
	public void setDiscardedCards(List<Card> discardedCards) {
		this.discardedCards = discardedCards;
	}
	
	

	public Deck(Integer amountOfDecks)
	{
		final Integer totalAmountOfCards = amountOfDecks * getCardsOnADeck();
		remainingCards = new ArrayList<>(totalAmountOfCards);
		discardedCards = new ArrayList<>(totalAmountOfCards);
		Integer counter = 1;
		
		while(counter <= amountOfDecks)
		{
			getRemainingCards().addAll(buildDeck());
		}
		 // TODO POSSIBLE IMPROVEMENT -> SAVE LIST AND JUST REPEAT
	}
	
	
	public Card drawCard()
	{
		discardedCards.add(remainingCards.get(0));
		
		return remainingCards.remove(0);
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
	
	// Method for shuffling only a few discarded cards into the deck
	public void shuffleDeck(Boolean shuffleWholeDeck)
	{
		// Only shuffling discarded, add cards that are
		// yet to be processed and shuffled by the machine
		if(shuffleWholeDeck)
		{
			//shuffle Whole Deck
			remainingCards.addAll(discardedCards);
			Collections.shuffle(remainingCards);
			
		}
		else {
			//shuffle discarded cards only then add randomly into the remaining cards so discarded cards
			//will be anywhere in the shoe
			Collections.shuffle(discardedCards);
			for (int i = 1 ; i  < discardedCards.size(); ) {
				Collections.shuffle(remainingCards);
				remainingCards.add(discardedCards.get(i));
			}
			Collections.shuffle(remainingCards);
			discardedCards.clear();
		}
		
	}
	
	
	/**
	 * Sort the whole deck and put it back into order.
	 * Put any discarded cards back on the deck and execute constructor
	 * to rebuild the deck with the same amount of cards.
	 */
	public void sortDeck()
	{
		if(getDiscardedCards().size() >= 1)
		{
			getRemainingCards().addAll(getDiscardedCards());
		}
		
		Integer amountOfDecks = getRemainingCards().size() / cardsOnADeck;
		
		// TODO FINISH -> COMPARABLE
	}
}
