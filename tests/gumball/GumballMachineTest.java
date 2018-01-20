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
	
	private void acceptQuarter(){
		machine1.acceptQuarter();
		machine3.acceptQuarter();
		machine4.acceptQuarter();
		machine5.acceptQuarter();
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
		acceptQuarter();
		assertEquals("You cannot insert another quarter", machine1.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine3.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine4.acceptQuarter());
		assertEquals("You cannot insert another quarter", machine5.acceptQuarter());
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals(0.25, machine3.getTotal(), 0.1);
		assertEquals(0.25, machine4.getTotal(), 0.1);
		assertEquals(0.25, machine5.getTotal(), 0.1);
	}
	
	@Test
	public void machineCanEjectQuarterIfRequested(){
		acceptQuarter();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals(0.25, machine3.getTotal(), 0.1);
		assertEquals(0.25, machine4.getTotal(), 0.1);
		assertEquals(0.25, machine5.getTotal(), 0.1);
		assertEquals(true, machine1.ejectQuarter());
		assertEquals(true, machine3.ejectQuarter());
		assertEquals(true, machine4.ejectQuarter());
		assertEquals(true, machine5.ejectQuarter());
		assertEquals(0.0, machine1.getTotal(), 0.1);
		assertEquals(0.0, machine3.getTotal(), 0.1);
		assertEquals(0.0, machine4.getTotal(), 0.1);
		assertEquals(0.0, machine5.getTotal(), 0.1);
	}
	
	@Test
	public void machineDispensesAGumballIfHasQuarter(){
		acceptQuarter();
		machine1.turnCrank();
		machine3.turnCrank();
		machine4.turnCrank();
		machine5.turnCrank();
		assertEquals(0.25, machine1.getTotal(), 0.1);
		assertEquals(0.25, machine3.getTotal(), 0.1);
		assertEquals(0.25, machine4.getTotal(), 0.1);
		assertEquals(0.25, machine5.getTotal(), 0.1);
		assertEquals(9, machine1.getCount());
		assertEquals(3, machine3.getCount());
		assertEquals(4, machine4.getCount());
		assertEquals(19, machine5.getCount());
	}
	
	//SoldState - Processing the transaction
	
	@Test
	public void machineDoesntAcceptQuartersIfSoldStatus(){
		acceptQuarter();
		machine1.setState(machine1.getSoldState());
		machine3.setState(machine3.getSoldState());
		machine4.setState(machine4.getSoldState());
		machine5.setState(machine5.getSoldState());
		assertEquals("The transaction is being processed", machine1.acceptQuarter());
		assertEquals("The transaction is being processed", machine3.acceptQuarter());
		assertEquals("The transaction is being processed", machine4.acceptQuarter());
		assertEquals("The transaction is being processed", machine5.acceptQuarter());
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
}
