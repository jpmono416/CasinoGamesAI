package functions;
import models.Customer;
import models.Dealer;
import models.Deck;

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
		
		// wait for player 
		
		drawAllDealerCards();
		clearBoard();
	}
	
	public void dealAllCards()
	{

		while(customer.getCards().size() < 2)
		{
			customer.getCards().add(deck.drawCard());
		}

		dealer.getCards().add(deck.drawCard());
	}
	
	public void drawAllDealerCards()
	{
		while(dealer.checkNewCard())
		{
			dealer.getCards().add(deck.drawCard());
		}
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
}
