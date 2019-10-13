package model.wheel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class WheelImpl implements Wheel {
	
	Collection<Slot> wheelList = new ArrayList<Slot>();	
	
	public WheelImpl()
	{
		super();
	}	

	@Override
	public Slot moveToPosition(int position) throws IllegalArgumentException {
		
		try {
				Iterator<Slot> iterator = wheelList.iterator();				
				while(iterator.hasNext()) {
					
					Slot value = iterator.next();
					if(value.getPosition() == position){
							return value;		
				    }
				}				
		}
		catch(IllegalArgumentException exception) {
			
			System.out.println("Error: that is not a position");
		}
		return null;
	}

	@Override
	public Slot nextSlot() {
		
		Iterator<Slot> iterator = wheelList.iterator();
		return iterator.next();
	}

	@Override
	public Collection<Slot> generateWheel() {
		
		SlotColor color;
		int greenZero = 19;
		
		wheelList.add(new SlotImpl(SLOT_NUMBERS[0], SlotColor.GREEN00, 0));
		for(int i = 1; i < NUMBER_OF_SLOTS; i++) {
			
			if(i % 2 == 0) {
				
				color = SlotColor.BLACK;
			}
			else {
				
				color = SlotColor.RED;
			}
			//If I get to the 19th position, it needs to be greenzero.
			if(i == greenZero) {
				
				wheelList.add(new SlotImpl(SLOT_NUMBERS[i], SlotColor.GREEN0, i));
			}
			else {
				
				wheelList.add(new SlotImpl(SLOT_NUMBERS[i], color, i));
			}
		}
		return wheelList;
	}

	@Override
	public int generateRandomPosition() {
		
		return new Random().nextInt((LARGEST_SLOT_NUMBER + 1));
	}
}
