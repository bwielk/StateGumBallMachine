package gumball;

public class GumballMachine {

	private final static int SOLD_OUT = 0;
	private final static int NO_QUARTER = 1;
	private final static int HAS_QUARTER = 2;
	private final static int SOLD = 3;
	
	private int state = SOLD_OUT;
	private int count = 0;
	private double total = 0.0;
	
	public GumballMachine(int count){
		this.count = count;
		if(count > 0){
			state = NO_QUARTER;
		}
	}
	
	public int getState(){
		return state;
	}
	
	public String acceptQuarter() {
		String result = new String();
		switch(state){
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
	
		return result;
	}

	public double getTotal() {
		return total;
	}

	public String ejectQuarter(){
		String result = new String();
		switch(state){
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
		}
		return result;
	}

	public String turnCrank() {
		String result = new String();
		switch(state){
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
		return result;
	}

	public String dispense() {
		String result = new String();
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
	}

	public int getCount() {
		return count;
	}
}
