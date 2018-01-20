package gumball;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gumball.GumballMachine;

public class GumballMachineTest{
	
	private GumballMachine machine1;
	private GumballMachine machine2;
	private GumballMachine machine3;
	private GumballMachine machine4;
	private GumballMachine machine5;
	
	@Before
	public void before(){
		machine1 = new GumballMachine(10);
		machine2 = new GumballMachine(0); 
		machine3 = new GumballMachine(4);
		machine4 = new GumballMachine(5);
		machine5 = new GumballMachine(20);
	}
	
	@Test
	public void machinesUpdateItsStateDependingOnNumberOfGums(){
		State state = machine1.getState();
		assertEquals(NoQuarterState.class, state.getClass());
		State state1 = machine2.getState();
		assertEquals(SoldOutState.class, state1.getClass());
		State state2 = machine3.getState();
		assertEquals(NoQuarterState.class, state2.getClass());
		State state3 = machine4.getState();
		assertEquals(NoQuarterState.class, state3.getClass());
		State state4 = machine5.getState();
		assertEquals(NoQuarterState.class, state4.getClass());
	}
	
	//NoQuartersState
	@Test
	public void machinesAcceptQuartersInNoQuarterState(){
		machine1.acceptQuarter();
		State state = machine1.getState();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals(HasQuarterState.class, state.getClass());
		machine3.acceptQuarter();
		State state1 = machine3.getState();
		assertEquals(0.25, machine3.getTotal(), 0.1);
		assertEquals(HasQuarterState.class, state1.getClass());
	}
	
	@Test
	public void machinesCannotEjectQuarterIfNoQuarterState(){
		assertEquals(false, machine1.ejectQuarter());
		assertEquals(false, machine3.ejectQuarter());
		assertEquals(false, machine4.ejectQuarter());
		assertEquals(false, machine5.ejectQuarter());
	}
	
	@Test
	public void machinesCannotGetAGumIfNoQuarterState(){
		assertEquals("Error. Check if you have inserted a quarter or you have already turned the crank", machine1.turnCrank());
		assertEquals(10, machine1.getCount());
		assertEquals("Error. Check if you have inserted a quarter or you have already turned the crank", machine3.turnCrank());
		assertEquals(4, machine3.getCount());
		assertEquals("Error. Check if you have inserted a quarter or you have already turned the crank", machine4.turnCrank());
		assertEquals(5, machine4.getCount());
		assertEquals("Error. Check if you have inserted a quarter or you have already turned the crank", machine5.turnCrank());
		assertEquals(20, machine5.getCount());
	}
	
	//HasQuarterState
	@Test
	public void machineDoesntAcceptAnotherQuarterIfHasQuarterState(){
		machine1.acceptQuarter();
		machine3.acceptQuarter();
		machine4.acceptQuarter();
		machine5.acceptQuarter();
		assertEquals("You cannot insert another quarter", machine1.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine3.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine4.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine5.acceptQuarter());
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals(0.25, machine3.getTotal(), 0.1);
		assertEquals(0.25, machine4.getTotal(), 0.1);
		assertEquals(0.25, machine5.getTotal(), 0.1);
	}
	
	//SoldOutState
	@Test
	public void machineDoesntAcceptQuartersIfAllGumsAreSoldOut(){
		assertEquals("There are no gums to sell so we are not accepting your quarter", machine2.acceptQuarter());
		assertEquals(0.0, machine2.getTotal(), 0.1);
		State state = machine2.getState();
		assertEquals(SoldOutState.class, state.getClass());
	}
	
	@Test
	public void machineDoesntReturnAnyMoneyIfSoldOut(){
		assertEquals(false, machine2.ejectQuarter());
		assertEquals(0.0, machine2.getTotal(), 0.1);
	}
	
	@Test
	public void machineDoesntDispenseAnyMoneyIfGumsAreSoldOut(){
		assertEquals("Error. Check if you have inserted a quarter or you have already turned the crank", machine2.turnCrank());
	}

	/*
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
	}*/
}
