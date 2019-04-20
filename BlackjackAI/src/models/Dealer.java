package models;

public class Dealer extends Player{
	/*
	 * This method checks the dealer has less than 16 in order to
	 * get a new card or not
	 */
	public Boolean checkNewCard()
	{
		if(getTotalAmount() < 17)
		{
			return true;
		}
		return false;
	}

}
