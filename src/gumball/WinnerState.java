package gumball;

public class WinnerState implements State {
	
	private GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}

	public String acceptQuarter() {
		return "The transaction is being processed";
	}

	public String ejectQuarter() {
		return "Sorry, too late. You have already turned the crank ";
	}

	public String turnCrank() {
		return "Insert a quarter to get another gum";
	}

	public String dispense() {
		gumballMachine.releaseGum();
		if(gumballMachine.getCount() == 0){
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}else{
			gumballMachine.releaseGum();
			if(gumballMachine.getCount() > 0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			}else{
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
		return null;
	}
}