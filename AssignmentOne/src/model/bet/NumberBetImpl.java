package model.bet;

import model.wheel.Slot;

public class NumberBetImpl implements NumberBet {
	
	private int amount;
	private int number;
	private BetType betType;
	
	public NumberBetImpl(int amount, int number) throws IllegalArgumentException {
		
		this.amount = amount;
		this.number = number;
		this.betType = BetType.NUMBER;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}
	
	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public boolean isWinningBet(Slot slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getOutcome(Slot slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Bet o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
