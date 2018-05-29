package multiChrono.tests.gui;

import multiChrono.gui.*;
import multiChrono.states.Context;
import multiChrono.states.timer.AbstractTimer;

import org.junit.Before;

public abstract class TestGUIAbstract {

	protected Context c;
	protected SwingGUI g;

    @Before
    public void setup() {
    	c = new Context();
    	g = new SwingGUI(c);
    	//before each test, reset the timer values to avoid interference between tests:
    	AbstractTimer.resetInitialValues();
    }

}
