package blackjack;

import blackjack.Card;
import blackjack.Deck;

public class DealersRules {
	
	public int dealersRule(Card dealersCard1, Card dealersCard2, Deck currDeck) {
		int total = 0;
		Card hitCard;
		
		//to handle if the dealer has hit or if it is the first time calling this function
		if (dealersCard2 == null) {
			total = total + dealersCard1.getValue();
		}
		else
		{
			total = dealersCard1.getValue() + dealersCard2.getValue();
		}
		
		
		if (total < 17) {
			// TODO Function to add images 
			hitCard = currDeck.drawCard();
			// Recursion until number is between 17 and 21
			dealersRule(hitCard,null,currDeck);
		}
		 else if (total > 21) {
			//in the function that calls dealersRule if it returns 0 then the dealer has bust
			return 0;
		}
		else {
			return total;
		}
	}

}
