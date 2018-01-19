package gumball;

public class GumballMachine {

	private final static int SOLD_OUT = 0;
	private final static int NO_QUARTER = 1;
	private final static int HAS_QUARTER = 2;
	private final static int SOLD = 3;
	
	private int state = SOLD_OUT;
	private int count = 0;
	
	public GumballMachine(int count){
		this.count = count;
		if(count > 0){
			state = NO_QUARTER;
		}
	}
	
	public int getState(){
		return state;
	}
}
