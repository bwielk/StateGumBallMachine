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
	public void machinesUpdateItsStateDependingOnNumberOfGums(){
		assertEquals(1, machine1.getState());
		assertEquals(0, machine2.getState());
	}
	
	@Test
	public void machinesAcceptQuartesDependingOnState(){
		machine2.acceptQuarter();
		assertEquals("There are no gums to sell", machine2.acceptQuarter());
		assertEquals(0.00, machine2.getTotal(), 0.1);
		machine1.acceptQuarter();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals("You cannot insert another quarter", machine1.acceptQuarter());
	}
	
	@Test
	public void machineCanEjectAQuarter(){
		machine1.acceptQuarter();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		machine1.ejectQuarter();
		assertEquals(0.0, machine1.getTotal(), 0.1);
	}

}
