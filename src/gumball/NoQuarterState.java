package gumball;

public class NoQuarterState implements State {
	
	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		gumballMachine.setState(gumballMachine.getHasQuarterState());
		return "Quarter insterted";
	}

	public String ejectQuarter() {
		return "There is no coin to return. Insert a quarter";
	}

	public String turnCrank() {
		return "Insert a quarter to turn";
	}

	public String dispense() {
		return "Insert a quarter";
	}
}