package gumball;

public class GumballMachine {
	
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State soldOutState;
	private State winnerState;
	
	private State state = soldOutState;
	private int count = 0;
	private double total = 0.0;
	private String result;
	
	public GumballMachine(int count){
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.soldOutState = new SoldOutState(this);
		this.winnerState = new WinnerState(this);
		this.count = count;
		if(count > 0){
			state = noQuarterState;
		}
		this.result = new String();
	}
	
	//GETTERS
	
	public double getTotal() {
		return total;
	}
	
	public int getCount() {
		return count;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}
	
	public State getWinnerState(){
		return winnerState;
	}

	//SETTERS

	public void setState(State state){
		this.state = state;
	}
	
	public void setTotal(double value) {
		this.total = value;
	}

	// ACTIONS
	
	public String acceptQuarter() {
		state.acceptQuarter();
	}

	public String ejectQuarter(){
		state.ejectQuarter();
	}

	public String turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void releaseGum(){
		if(count != 0){
			count -= 1;
		}
	}
}