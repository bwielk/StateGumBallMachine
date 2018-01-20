package gumball;

public class SoldOutState implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	public String acceptQuarter() {
		return "There are no gums to sell so we are not accepting your quarter";
	}

	public boolean ejectQuarter() {
		System.out.println("There are no gums to sell so we didn't accept your quarter");
		return false;
	}

	public boolean turnCrank() {
		return false;
	}

	public String dispense() {
		return "No gums to dispense";
	}
}