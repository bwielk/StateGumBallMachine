package gumball;

public class SoldOutState implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	public String acceptQuarter() {
		return "There are no gums to sell so we are not accepting your quarter";
	}

	public String ejectQuarter() {
		return "There are no gums to sell so we didn't accept your quarter";
	}

	public String turnCrank() {
		return "You turned but there are no gums to sell";
	}

	public String dispense() {
		return null;
	}
}