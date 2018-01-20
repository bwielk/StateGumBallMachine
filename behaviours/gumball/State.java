package gumball;

public interface State {
	String acceptQuarter();
	boolean ejectQuarter();
	boolean turnCrank();
	String dispense();
}
