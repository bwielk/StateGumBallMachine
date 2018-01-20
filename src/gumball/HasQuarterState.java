package gumball;

public class HasQuarterState implements State {
	
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		return "You cannot insert another quarter";
	}

	public String ejectQuarter() {
		gumballMachine.setState(gumballMachine.getNoQuarterState());
		return "Quarter returned";
	}

	public String turnCrank() {
		gumballMachine.setState(gumballMachine.getSoldState());
		return "You have turned the crank";
	}

	public String dispense() {
		return "Turn the crank";
	}
}