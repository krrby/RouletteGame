package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.bet.Bet;
import model.bet.BetType;
import model.bet.ColorBetImpl;
import model.bet.NumberBetImpl;
import model.wheel.Slot;
import view.GameCallback;

public class GameEngineImpl implements GameEngine {
	
	Collection<Player> playersList;
	Collection<GameCallback> gameCallBackList;
	
	public GameEngineImpl() {
		
		super();
		this.playersList = new ArrayList<Player>();
		this.gameCallBackList = new ArrayList<GameCallback>();
	}

	@Override
	public void registerCallback(GameCallback callback) {
		try {
				
				gameCallBackList.add(callback);
				
		}
		catch(NullPointerException exception) {
			System.out.println("You havent entered a callback!\n");
		}
		
	}

	@Override
	public void removeCallback(GameCallback callback) {
		gameCallBackList.remove(callback);
				
	}

	@Override
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {
		try {
			
			playersList.add(player);
			
			Iterator<GameCallback> it = gameCallBackList.iterator();
			
			while(it.hasNext()) {
		
				GameCallback value = it.next();
				value.addPlayer(player);
			}		
			
		} 
		catch(NullPointerException exception) {
			
			System.out.println("You haven't entered any details\n");
			
		}
		catch(IllegalArgumentException exception) {
			
			System.out.println("Invalid player arguement\n");
		}		
		
	}

	@Override
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException {
		
		try {		
				Iterator<Player> iter = playersList.iterator();
				Iterator<GameCallback> it = gameCallBackList.iterator();
				while(it.hasNext()) {
					
					Player value = iter.next();
					if(value.getId().equals(playerId)){
				
						iter.remove();
						
						while(it.hasNext()) {
							
							GameCallback values = it.next();
							values.removePlayer(value);
						}
					}
				}
		}
		catch (NullPointerException exception) {
			
			System.out.println("You haven't entered a player id\n");
		}
		catch (IllegalArgumentException exception) {
			
			System.out.println("that isn't an ID\n");
		}
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		Collection<Player> copiedPlayersList = new ArrayList<Player>(playersList);
		return copiedPlayersList;
	}

	@Override
	public void placeBet(String playerId, int betAmount, BetType betType)
			throws NullPointerException, IllegalArgumentException {		
		
		try {
			
				Iterator<Player> it = playersList.iterator();
							//Finding the playerID
				while(it.hasNext()) {
			
					Player value = it.next();
					if(value.getId().equals(playerId)){
												
						value.assignBet(new ColorBetImpl(betAmount, betType));					
					}
				}
			}
			catch (NullPointerException exception) {
				
				System.out.println("You have not entered a playerID");
			}
			catch (IllegalArgumentException exception) {
				
				System.out.println("That ID doesnt exist\n");
			}		
	}

	@Override
	public void placeBet(String playerId, int betAmount, int number)
			throws NullPointerException, IllegalArgumentException {
		
		try {
					
				Iterator<Player> it = playersList.iterator();		
				//Finding the playerID
				while(it.hasNext()) {
			
					Player value = it.next();
					if(value.getId().equals(playerId)){
				
						value.assignBet(new NumberBetImpl(betAmount, number));			
					}						
				}
			}
			catch (NullPointerException exception) {
			
				System.out.println("You have not entered a playerID");
			}
			catch (IllegalArgumentException exception) {
			
				System.out.println("That ID doesnt exist\n");
			}
	}

	@Override
	public void resetAllBets() {
				
		Iterator<Player> it = playersList.iterator();
		
		while(it.hasNext()) {
			
			Player value = it.next();
			value.resetBet();
		}

	}

	@Override
	public Slot selectStartingSlot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot spinWheel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot spinWheel(int initialDelay, int finalDelay, int delayIncrement) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finaliseSpin(Slot slot) {
		// TODO Auto-generated method stub		
	}


	

}
