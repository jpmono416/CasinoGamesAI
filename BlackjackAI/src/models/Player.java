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
		Integer amount;
		if(card.getValue() >= 10) 
		{ 
			amount = 10; 
		} else { amount = card.getValue(); }
			
		totalAmount += amount;
	}
}
