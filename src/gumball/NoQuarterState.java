package gumball;

public class NoQuarterState implements State {
	
	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		gumballMachine.setTotal(gumballMachine.getTotal() + 0.25);
		gumballMachine.setState(gumballMachine.getHasQuarterState());
		return "Quarter insterted";
	}

	public boolean ejectQuarter() {
		System.out.println("There is no coin to return. Insert a quarter");
		return false;
	}

	public boolean turnCrank() {
		return false;
	}

	public String dispense() {
		return "Insert a quarter";
	}
}