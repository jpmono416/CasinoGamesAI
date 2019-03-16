package functions;
import java.util.ArrayList;
import java.util.List;

import models.Customer;
import models.Dealer;
import models.Deck;

public class SimulatorFunctions {

	private Integer totalAmount = 0;
	// Create all agents that affect the game
	private Deck deck = new Deck(6);
	private Dealer dealer = new Dealer();
	private List<Customer> customers = new ArrayList<>();
			
	
	public void newAutoGame()
	{
		dealAllCards();
		
		// wait for player 
		
		drawAllDealerCards();
		clearBoard();
	}
	
	private void dealAllCards()
	{
		// Draw two cards for each customer, then the dealer
		for(Customer currentCustomer : customers)
		{
			while(currentCustomer.getCards().size() < 2)
			{
				currentCustomer.getCards().add(deck.drawCard());
			}
		}
		
		/*
		 * Usually dealer's card is dealt before 2nd card of the 
		 * customers but this is way more resource-effective
		 */
		dealer.getCards().add(deck.drawCard());
	}
	
	private void drawAllDealerCards()
	{
		while(dealer.checkNewCard())
		{
			dealer.getCards().add(deck.drawCard());
		}
	}
	
	
	private void drawExtraCustomerCards(Integer customerID)
	{
		customers.get(customerID).addNewCard(deck.drawCard());
	}
	
	
	/*
	 * This function clears the cards that the customers
	 * and dealers have before starting a new game.
	 */
	private void clearBoard()
	{
		
	}
}
