package functions;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import models.Card;
import models.Neural;

public class AIFunctions {

	private Integer amountOfHands;
	public Integer getAmountOfHands() {
		return amountOfHands;
	}
	public void setAmountOfHands(Integer amountOfHands) {
		this.amountOfHands = amountOfHands;
	}

	private Map<Integer,Map<Integer,Boolean>> stats = new HashMap<>();
	public Map<Integer, Map<Integer, Boolean>> getStats() {
		return stats;
	}
	public void setStats(Map<Integer, Map<Integer, Boolean>> stats) {
		this.stats = stats;
	}

	@JsonIgnore
	Neural aiObject = new Neural();
	public Neural getAiObject() {
		return aiObject;
	}
	public void setAiObject(Neural aiObject) {
		this.aiObject = aiObject;
	}
	
	
	// This needs to be set from the controller
	@JsonIgnore
	SimulatorFunctions simFuncts;
	public SimulatorFunctions getSimFuncts() {
		return simFuncts;
	}
	public void setSimFuncts(SimulatorFunctions simFuncts) {
		this.simFuncts = simFuncts;
	}
	
	Integer dealerStartingAmount;
	public Integer getDealerStartingAmount() {
		return dealerStartingAmount;
	}
	public void setDealerStartingAmount(Integer dealerStartingAmount) {
		this.dealerStartingAmount = dealerStartingAmount;
	}
	
	Integer customerStartingAmount;
	public Integer getCustomerStartingAmount() {
		return customerStartingAmount;
	}
	public void setCustomerStartingAmount(Integer customerStartingAmount) {
		this.customerStartingAmount = customerStartingAmount;
	}
	
	Integer handsPlayed = 0;
	public Integer getHandsPlayed() {
		return handsPlayed;
	}
	public void setHandsPlayed(Integer handsPlayed) {
		this.handsPlayed = handsPlayed;
	}
	
	Integer handsWon = 0;
	public Integer getHandsWon() {
		return handsWon;
	}
	public void setHandsWon(Integer handsWon) {
		this.handsWon = handsWon;
	}
	
	Integer handsLost = 0;
	public Integer getHandsLost() {
		return handsLost;
	}
	public void setHandsLost(Integer handsLost) {
		this.handsLost = handsLost;
	}
	
	Double WLRatio = 0.0;
	public Double getWLRatio() {
		return WLRatio;
	}
	public void setWLRatio(Double wLRatio) {
		WLRatio = wLRatio;
	}
	
	
	public void autoGame()
	{
		// Define a couple of required functions
		Integer counter = 1;
		
		// Play all customer hands, generating dealer cards
		// at the end of every required hand
		while(counter <= this.amountOfHands)
		{
			// Reset hand
			this.simFuncts.clearBoard();
			this.simFuncts.dealAllCards();
			
			this.dealerStartingAmount = this.simFuncts.getDealer().getTotalAmount();
			this.customerStartingAmount = this.simFuncts.getCustomer().getTotalAmount();
			
			System.out.println("Starting hand: " + counter + ", cards are: " + dealerStartingAmount + " // " + customerStartingAmount); // TODO DELETE
			
			Boolean carryOn = true;
			double prediction = this.getPrediction();
			
			// Play all hands and decide if customer hits card
			while(carryOn)
			{
				System.out.println("	CarryOn entered: "); // TODO DELETE
				if(prediction >= 0.5)
				{
					System.out.println("		Prediction right: " + prediction); // TODO DELETE
					this.simFuncts.drawExtraCustomerCards();
					
					if(this.simFuncts.getCustomer().checkBusted())
					{
						System.out.println("			Player busted: " + this.simFuncts.getCustomer().getTotalAmount());	
						// Player busted
						this.aiObject.train(0);
						carryOn = false;
						 
						continue;	
					}
					
					System.out.println("			Player NOT busted: " + this.simFuncts.getCustomer().getTotalAmount());	
					// Player hit and didn't bust
					this.aiObject.train(1);
					prediction = this.getPrediction();
				}
				System.out.println("		Prediction NOT right: " + prediction); // TODO DELETE
				break;
			}
			System.out.println("Finishing hand. Cards: " + this.simFuncts.getDealer().getTotalAmount() + " // " + this.simFuncts.getCustomer().getTotalAmount()); // TODO DELETE
			// If customer didn't bust but doesn't hit any more cards
			if(carryOn) { this.simFuncts.drawAllDealerCards(); }
			this.updateStats();
			++counter;
		}
	}
	
	private void updateStats()
	{
		// Save stats for populating the table on the interface
		Map<Integer, Boolean> tempMap = new HashMap<>();
		tempMap.put(this.customerStartingAmount, true);
		System.out.println("updating value: " + dealerStartingAmount + "of the map, adding: " +  tempMap.get(customerStartingAmount));
		this.stats.put(this.dealerStartingAmount, tempMap);
		
		// Save the final decision about whether the AI performed well on the hand
		Integer winOrLoseNumeric = 
				!this.simFuncts.getCustomer().checkBusted()
				&& this.simFuncts.getCustomer().getTotalAmount() > this.simFuncts.getDealer().getTotalAmount()  ? 0 : 1;
				
		Boolean winOrLose = winOrLoseNumeric == 1 ? true : false;
		
		
		this.aiObject.train(winOrLoseNumeric);
		
		++this.handsPlayed;
		
			
		if(winOrLose) { ++this.handsWon; }
		else { ++this.handsLost; }
		
		this.WLRatio = (double) (this.handsWon / this.handsPlayed * 100);
	}
	
	private double getPrediction()
	{
		return this.aiObject.prediction
				(this.simFuncts.getCustomer().getTotalAmount(),
				this.simFuncts.getDealer().getTotalAmount());
	}
	
	
}
