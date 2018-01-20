package gumball;

import java.util.Random; 

public class HasQuarterState implements State {
	
	private Random randomWinner = new Random(System.currentTimeMillis());
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		return "You cannot insert another quarter";
	}

	public boolean ejectQuarter() {
		gumballMachine.setTotal(gumballMachine.getTotal() - 0.25);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
		System.out.println("Quarter returned");
		return true;
	}

	public boolean turnCrank() {
		int winner = randomWinner.nextInt(10);
		if(winner == 0 && gumballMachine.getCount() > 1){
			gumballMachine.setState(gumballMachine.getWinnerState());
		}else{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
		return true;
	}

	public String dispense() {
		return "Turn the crank";
	}
}