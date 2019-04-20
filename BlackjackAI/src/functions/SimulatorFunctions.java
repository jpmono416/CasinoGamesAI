package functions;
import java.util.ArrayList;
import java.util.List;

import models.Card;
import models.Customer;
import models.Dealer;
import models.Deck;
import models.Player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class SimulatorFunctions {

	private Integer totalAmount = 0;
	public Integer getTotalAmount() { 
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	private final Integer amountOfDecks = 6;
	
	// Create all agents that affect the game
	private Deck deck = new Deck(amountOfDecks);
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	private Dealer dealer = new Dealer();
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	private Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public SimulatorFunctions()
	{
		this.deck.shuffleDeck(true);
		this.dealAllCards();
	}
	
	public void newAutoGame()
	{
		dealAllCards();
		
		// wait for player AI
		
		drawAllDealerCards();
		clearBoard();
	}
	
	public void dealAllCards()
	{

		while(customer.getCards().size() < 2)
		{
			drawExtraCustomerCards();
		}

		drawExtraDealerCards();
	}
	
	public void drawAllDealerCards()
	{
		while(dealer.checkNewCard())
		{
			drawExtraDealerCards();
		}
	}
	
	
	public String buildDealerJSON()
	{
		List<String> cardValues = new ArrayList<>();
		
		for(Card card : dealer.getCards())
		{
			cardValues.add(card.getValue().toString());
		}

		System.out.println("List: " + cardValues.toString());
		// Remove the first card because it is already in the board
		cardValues.remove(0);
		System.out.println("List updated: " + cardValues.toString());

		return "{ \"cardValue\" : " + cardValues.toString() + ", "
				+ " \"busted\" : " + dealer.checkBusted() + ", "
				+ " \"totalAmount\" : " + customer.getTotalAmount() + " }";
 	}
	
	/*
	 * This function is used on the AJAX request to draw a new card from the page.
	 * It creates the final JSON string which will be sent back in the response
	 */
	public String buildCustomerJSON()
	{
		
		return "{ \"cardValues\" : \"" + customer.getCards().get(dealer.getCards().size() - 1).getValue() + "\", "
				+ " \"busted\" : " + customer.checkBusted() + ", "
						+ " \"totalAmount\" : " + customer.getTotalAmount() +  " }";
	}
	
	public void drawExtraDealerCards()
	{
		dealer.addNewCard(deck.drawCard());
	}
	
	public void drawExtraCustomerCards()
	{
		customer.addNewCard(deck.drawCard());
	}
	
	
	/*
	 * This function clears the cards that the customers
	 * and dealers have before starting a new game.
	 */
	private void clearBoard()
	{
		
	}
	
	public <T extends Player> String generateJSON(T player)
	{
		
		try 
		{
			return new ObjectMapper().writeValueAsString(player);
		} 
		catch (JsonProcessingException e) 
		{
			String errorMessage = "An error ocurred during execution";
			e.printStackTrace();
			return errorMessage;
		}
	}
}
