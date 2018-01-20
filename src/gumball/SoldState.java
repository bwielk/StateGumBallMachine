package gumball;

public class SoldState implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		return "The transaction is being processed";
	}

	public boolean ejectQuarter() {
		System.out.println("Sorry, too late. You have already turned the crank ");
		return false;
	}

	public boolean turnCrank() {
		return false;
	}

	public String dispense() {
		gumballMachine.releaseGum();
		if(gumballMachine.getCount() > 0){
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}else{
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
		return null;
	}
}