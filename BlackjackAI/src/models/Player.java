package models;

import java.util.ArrayList;
import java.util.List;

public class Player {

	Integer totalAmount = 0;
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	List<Card> cards = new ArrayList<>();
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
	public Boolean checkBusted()
	{
		if(getTotalAmount() > 21)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * TODO add card to list and update totalAmount
	 */
	public void addNewCard(Card card)
	{
		// Add a new card to the total
		switch(card.getValue().getNumericalValue())
		{
			case(11) :
				// Ace plays as 11 or 1 depending on whether the player busts
				if(totalAmount + 11 > 21)
				{
					totalAmount += 1;
				} else { totalAmount += 11; }
				break;
			default:
				totalAmount += card.getValue().getNumericalValue(); 
				break;
		}
	}
}
