package multiChrono.tests.states;

import static org.junit.Assert.*;

import org.junit.*;

import multiChrono.states.*;
import multiChrono.states.stopwatch.*;
import multiChrono.states.timer.AbstractTimer;

public class StopwatchTests {

	private static Context context;
	private ClockState current, newState;

	@Before
	public void setup() {
        context = new Context(); // create the state machine context
        AbstractStopwatch.resetInitialValues();
        context.currentState = AbstractStopwatch.Instance();
	}
		
	@Test
	public void testInitialState() {
		//context.tick(); //no tick() needed for this test;
		/* When initialising the context (see setup() method above)
		 * its currentState will be inialised with the initial state
		 * of timer, i.e. the IdleTimer state.
		 */
		current = context.currentState;
		
	    assertEquals(Mode.stopwatch, current.getMode());
	    assertSame(ResetStopwatch.Instance(), current);
	    assertEquals("For the value of totalTime we ",0, AbstractStopwatch.getTotalTime());
	    assertEquals("For the value of lapTime we ",0, AbstractStopwatch.getLapTime());
	}

	@Test
	public void testInitialAbstractStopwatch() {
		// The initial state of composite state AbstractStopwatch should be ResetStopwatch
		assertSame(AbstractStopwatch.Instance(), ResetStopwatch.Instance());
	}
	
	@Test
	public void testHistoryState() {		
		current = AbstractStopwatch.Instance();
		// after processing the left() event, we should arrive in the initial state of AbstractStopwatch
		newState = current.left();
		assertEquals(AbstractTimer.Instance(), newState);
		/* after another occurrence of the left() event, we should return to the original state
		 * because we used history states		
		 */
		assertEquals(current, newState.left());
	}

}
