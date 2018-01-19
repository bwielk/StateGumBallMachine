package gumball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GumballMachineTest{
	
	private GumballMachine machine1;
	private GumballMachine machine2;
	
	@Before
	public void before(){
		machine1 = new GumballMachine(1);
		machine2 = new GumballMachine(0); 
	}
	
	@Test
	public void machinesUpdateItsStateDependingOnNumberOfGums() {
		assertEquals(1, machine1.getState());
		assertEquals(0, machine2.getState());
	}

}
