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
		result = state.acceptQuarter();
		return result;
	}

	public boolean ejectQuarter(){
		return state.ejectQuarter();
	}

	public String turnCrank() {
		if(state.turnCrank()){
			result = state.dispense();
		}else{
			result = "Error. Check if you have inserted a quarter or you have already turned the crank";
		}
		return result;
	}
	
	public void releaseGum(){
		if(count != 0){
			count -= 1;
		}
	}
	
	public void refillGumballs(int amount){
		if(state == soldOutState){
			count = amount;
			state = noQuarterState;
		}
	}
}