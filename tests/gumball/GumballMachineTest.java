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
		GumballMachine machine3 = new GumballMachine(3);
		machine3.acceptQuarter();
		machine3.turnCrank();
		assertEquals("The transaction is being processed", machine3.acceptQuarter());
	}
	
	@Test
	public void machineCanEjectAQuarter(){
		machine1.acceptQuarter();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		machine1.ejectQuarter();
		assertEquals(0.0, machine1.getTotal(), 0.1);
		assertEquals("There are no gums to sell", machine2.ejectQuarter());
		GumballMachine machine3 = new GumballMachine(3);
		machine3.acceptQuarter();
		machine3.turnCrank();
		machine3.dispense();
		assertEquals("There is no coin to return", machine3.ejectQuarter());
	}
	
	@Test
	public void crankCanBeTurned(){
		assertEquals("Insert a quarter to turn", machine1.turnCrank());
		machine1.acceptQuarter();
		assertEquals("Turned", machine1.turnCrank());
		assertEquals("You turned but there are no gums", machine2.turnCrank());
	
	}
	
	@Test
	public void machineCanDispenseGums(){
		assertEquals("No gums to dispense", machine2.dispense());
		machine1.acceptQuarter();
		machine1.turnCrank();
		machine1.dispense();
		assertEquals(0, machine1.getCount());
		assertEquals(0.25, machine1.getTotal(), 0.1);
		GumballMachine machine3 = new GumballMachine(3);
		machine3.acceptQuarter();
		assertEquals("Turn the crank", machine3.dispense());
		GumballMachine machine4 = new GumballMachine(3);
		assertEquals("Insert a quarter", machine4.dispense());
	}
}
