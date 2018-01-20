package gumball;

public interface State {
	
	String acceptQuarter();
	String ejectQuarter();
	String turnCrank();
	String dispense();
}
