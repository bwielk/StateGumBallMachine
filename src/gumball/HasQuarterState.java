package gumball;

import java.util.Random;

public class HasQuarterState implements State {
	
	private Random randomWinner = new Random(System.currentTimeMillis());
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		gumballMachine.setTotal(gumballMachine.getTotal() + 0.25);
		return "You cannot insert another quarter";
	}

	public String ejectQuarter() {
		gumballMachine.setTotal(gumballMachine.getTotal() - 0.25);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
		return "Quarter returned";
	}

	public String turnCrank() {
		int winner = randomWinner.nextInt(10);
		if(winner == 0 && gumballMachine.getCount() > 1){
			gumballMachine.setState(gumballMachine.getWinnerState());
		}else{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
		return "You have turned the crank";
	}

	public String dispense() {
		return "Turn the crank";
	}
}