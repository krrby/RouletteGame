package client;

import model.GameEngine;
import model.GameEngineImpl;
import model.PlayerImpl;
import model.bet.BetType;
import model.wheel.Slot;
import model.wheel.SlotColor;
import model.wheel.SlotImpl;
import model.wheel.WheelImpl;
import validate.Validator;
import view.ConsoleLoggerCallback;

/**
 * A basic client that tests your model implementation.
 * <p>
 * Tests performed by this client are not exhaustive. As such you are encouraged to write your own
 * test client to test your model.
 * <p>
 * This client was used to produce the supplied output trace. You should compare the output of this
 * class using your model with the output trace. As such it's advisable to write your own test
 * client rather modifying this one.
 * <p>
 * This class also uses the Validator (from lib/validator.jar) to check adherence
 * to the specifications.
 * <p>
 * 
 * @author Ross Nye
 * 
 * @see model.GameEngine
 * @see validate.Validator
 *
 */
public class BasicTestClient
{
	
	public static void main(String[] args)
	{
		// calls validator to check your code meets specifications
		// set parameter to true for more verbose output
		Validator.validate(false);
		
		
		checkWheel();
		
		// Creates a game engine
		GameEngine engine = new GameEngineImpl();
		
		// add ConsoleLoggerCallback
		engine.registerCallback(new ConsoleLoggerCallback(engine));
		
		engine.addPlayer(new PlayerImpl("P1", "Player One", 1000));
		engine.addPlayer(new PlayerImpl("P2", "Player Two", 2000));
		engine.addPlayer(new PlayerImpl("X3", "Player Three", 3000));
		
		// removes player
		engine.removePlayer("X3");
		
		// place a Color Bet
		engine.placeBet("P1", 100, BetType.RED);
		
		// place a Number Bet
		engine.placeBet("P2", 100, 12);
		
		// testing bets are finalised correctly
		// (without having to do a full spin or randomised outcome)
		engine.finaliseSpin(new SlotImpl(6, SlotColor.RED, 12));
		engine.resetAllBets();
		
		
		
		// place a Color Bet
		engine.placeBet("P1", 100, BetType.BLACK);
		
		// place a Number Bet
		engine.placeBet("P2", 100, 22);
		
		// spin wheel using default values
		engine.spinWheel();
		engine.resetAllBets();
		
	}
	
	/**
	 * Tests generation of wheel and slots
	 */
	private static void checkWheel()
	{
		System.out.println("Testing wheel/slots:");
		for(Slot s : new WheelImpl().generateWheel())
			System.out.println(s);
		
		System.out.println();
	}
}
