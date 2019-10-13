package model;

import model.bet.Bet;
import model.wheel.Slot;

public class PlayerImpl implements Player {
	
	private String playerID;
	private String name;
	private int points;
	private Bet bet;

	public PlayerImpl(String playerID, String name, int points) throws NullPointerException, IllegalArgumentException {
		
		this.playerID = playerID;
		this.name = name;
		this.points = points;
		this.bet = bet.NO_BET;
	}
	
	

	@Override
	public String toString() {
		
		return String.format("PlayerID: %s\n Players Name: %s\nPoints: %d\n", 
						this.playerID, this.name, this.points);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerImpl other = (PlayerImpl) obj;
		if (playerID == null) {
			if (other.playerID != null)
				return false;
		} else if (!playerID.equals(other.playerID))
			return false;
		return true;
	}

	@Override
	public String getId() {
		
		return this.playerID;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public int getPoints() {
	
		return this.points;
	}

	@Override
	public int getTotalPoints() {
		
		if(this.bet != null) {
			return this.bet.getAmount() + this.points;
		}
		return this.points;
	}

	@Override
	public void assignBet(Bet bet) {
				
		if (bet.getAmount() > getPoints()) {
			System.out.println("You cannot add bets greater than points");
		}
		else{
		
			//changed players points to bet
			this.points = bet.getAmount() - getPoints();
			//added the bet to the player
			this.bet = bet;
		}		
	}

	@Override
	public Bet getBet() {

		return this.bet;
	}

	@Override
	public void finaliseBet(Slot slot) {
		// TODO Auto-generated method stub
		//slot
		//bet
		//bet.getBetType()
		//bet.getBetType().iswinningtypSlot() < if true by supplying true, adjust points
		
	}

	@Override
	public void resetBet() {
		
		this.bet = bet.NO_BET;
		
	}


}
