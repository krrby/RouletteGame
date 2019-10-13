package model.wheel;

public class SlotImpl implements Slot {
	
	private int number;
	private SlotColor color;
	private int position;
	
	public SlotImpl(int number, SlotColor color, int position) {
		
		this.number = number;
		this.color = color;
		this.position = position;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + number;
		result = prime * result + position;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SlotImpl other = (SlotImpl) obj;
		if (color != other.color)
			return false;
		if (number != other.number)
			return false;
		if (position != other.position)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format("slotPos: %d\nSlotColor: %s\nSlotNumber: %d\n\n",
						this.position, this.color, this.number);
	}

	@Override
	public int getPosition() {
		
		return this.position;
	}

	@Override
	public SlotColor getColor() {
		
		return this.color;
	}

	@Override
	public int getNumber() {

		return this.number;
	}

}
