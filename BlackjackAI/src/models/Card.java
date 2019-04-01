package models;

public class Card {

	private final CardValues value;
	public CardValues getValue() {
		return value;
	}
	
	private final CardSuits suit;
	public CardSuits getSuit() {
		return suit;
	}
	
	Card(CardValues value, CardSuits suit)
	{
		this.value = value;
		this.suit = suit;
	}
}
