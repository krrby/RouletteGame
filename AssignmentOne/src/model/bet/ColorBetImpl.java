package model.bet;

import model.wheel.Slot;

public class ColorBetImpl implements ColorBet  {

	private int amount = 0;
	private BetType betType;
	
	public ColorBetImpl(int amount, BetType betType) throws NullPointerException, IllegalArgumentException {
			this.amount = amount;
			this.betType = betType;
	}
	
	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public boolean isWinningBet(Slot slot) {
		if(this.getBetType().equals(slot.getColor())) {
			return true;
		}
		else {
			return false;
		}		
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorBetImpl other = (ColorBetImpl) obj;
		if (amount != other.amount)
			return false;
		if (betType != other.betType)
			return false;
		return true;
	}
	
	
	
}
