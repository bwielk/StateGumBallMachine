package gumball;

public class GumballMachine {
	
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State soldOutState;
	
	private State state = soldOutState;
	private int count = 0;
	private double total = 0.0;
	private String result;
	
	public GumballMachine(int count){
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.soldOutState = new SoldOutState(this);
		this.count = count;
		if(count > 0){
			state = noQuarterState;
		}
		this.result = new String();
	}

	public double getTotal() {
		return total;
	}
	
	public int getState(){
		return state;
	}
	
	public String acceptQuarter() {
		state.acceptQuarter();
		/*switch(state){
		case SOLD_OUT: 
			result = "There are no gums to sell";
			break;
		case NO_QUARTER:
			state = HAS_QUARTER;
			total += 0.25;
			break;
		case HAS_QUARTER:
			result = "You cannot insert another quarter";
			break;
		case SOLD:
			result = "The transaction is being processed";
		}
		return result;*/
	}

	public String ejectQuarter(){
		state.ejectQuarter();
		/*switch(state){
		case NO_QUARTER:
			result = "There is no coin to return";
			break;
		case HAS_QUARTER:
			state = NO_QUARTER;
			total -= 0.25;
			break;	
		case SOLD_OUT:
			result = "There are no gums to sell";
			break;
		case SOLD:
			result = "Sorry, too late. You have already turned the crank ";
		}
		return result;*/
	}

	public String turnCrank() {
		state.turnCrank();
		state.dispense();
		/*switch(state){
		case NO_QUARTER:
			result = "Insert a quarter to turn";
			break;
		case HAS_QUARTER:
			result = "Turned";
			state = SOLD;
			break;
		case SOLD:
			result = "Insert a quarter to get another gum";
			break;
		case SOLD_OUT:
			result = "You turned but there are no gums";
			break;
		}
		return result;*/
	}

	/*public String dispense() {
		
		switch(state){
		case SOLD:
			count -= 1;
			if(count == 0){
				state = SOLD_OUT;
			}else{
				state = NO_QUARTER;
			}
		case SOLD_OUT:
			result = "No gums to dispense";
			break;
		case HAS_QUARTER:
			result = "Turn the crank";
			break;
		case NO_QUARTER:
			result = "Insert a quarter";
			break;
		}
		return result;
	}*/
	public void setState(State state){
		this.state = state;
	}
	
	public int getCount() {
		return count;
	}
	
	public void releaseGum(){
		if(count != 0){
			count -= 1;
		}
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
}