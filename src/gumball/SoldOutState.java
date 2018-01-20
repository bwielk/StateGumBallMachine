package gumball;

public class SoldOutState implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	@Override
	public String acceptQuarter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejectQuarter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String turnCrank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dispense() {
		// TODO Auto-generated method stub
		return null;
	}

}
