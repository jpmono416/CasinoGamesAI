package models;

public class Card {

	private final Integer value;
	public Integer getValue() {
		return value;
	}
	
	private final Integer suit;
	public Integer getSuit() {
		return suit;
	}
	
	Card(Integer value, Integer suit)
	{
		this.value = value;
		this.suit = suit;
	}
}
