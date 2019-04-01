package models;

public enum CardValues {

	ACE(11, "A"),
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	TEN(10, "10"),
	JACK(10, "J"),
	QUEEN(10, "Q"),
	KING(10, "K") //Top 3 values are worth 10
	;
	
	private final String cardValue;
	@Override
	public String toString()
	{
		return this.cardValue;
	}
	
	private final Integer numericalValue;
	public Integer getNumericalValue() { 
		return numericalValue;
	}

	
	CardValues(Integer numericalValue, String value)
	{
		this.cardValue = value;
		this.numericalValue = numericalValue;
	}

}
