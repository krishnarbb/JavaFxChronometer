package multiChrono.gui;

import multiChrono.states.Context;
import multiChrono.states.EventListener;

public abstract class AbstractGUI {

    protected EventListener observer;
    
    public AbstractGUI(EventListener o) {
    	observer = o;
    	initGUI();
    	addEventListener();
    }
    
    protected abstract void initGUI();
    
    protected abstract void addEventListener();
    
    protected abstract void updateUI(Context c);
    
}
