package multiChrono.gui;

import javax.swing.*;

import java.awt.*;

import multiChrono.states.Context;
import multiChrono.states.EventListener;

public class SwingGUI extends AbstractGUI {
    
    public JButton b1, b2, b3;
    public JLabel myText1, myText2, myText3;
        
    public SwingGUI(EventListener o) { super(o); }
    
    protected void initGUI() {
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        myText1 = new JLabel();
        myText2 = new JLabel();
        myText3 = new JLabel();

        JFrame myFrame = new JFrame("Chronometer");
        Container myContent = myFrame.getContentPane();
        // grid layout with 2 rows and 3 columns
        myContent.setLayout(new GridLayout(2,3,1,1));
        // filling first row of grid (3 columns) with text information
        myContent.add(myText1,0);
        myContent.add(myText2,1);
        myContent.add(myText3,2);
        // filling second row of grid (3 columns) with buttons
        myContent.add(b1);
        myContent.add(b2);
        myContent.add(b3);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    protected void addEventListener() {
    	// new, more compact way of adding action listeners (since Java8, using lambda expressions)
    	b1.addActionListener(e -> observer.left());
        b2.addActionListener(e -> observer.up());
        b3.addActionListener(e -> observer.right());
        // old-style, verbose way of adding action listeners (Java 7 and before)
        //    b1.addActionListener(new ActionListener() { 
        //       public void actionPerformed(ActionEvent e) { observer.left(); }
        //       });
		//    b2.addActionListener(new ActionListener() {
		//       public void actionPerformed(ActionEvent e) { observer.up(); }
		//       });
		//    b3.addActionListener(new ActionListener() {
		//       public void actionPerformed(ActionEvent e) { observer.right(); }
		//       });
   }
    
    public void updateUI(Context c) {
        myText1.setText(c.getDisplayText());
        myText2.setText(c.getModeText());
        myText3.setText(c.getStateText());
        // update the button labels:
        b1.setText(c.getLeftText());
        b2.setText(c.getUpText());
        b3.setText(c.getRightText());
    }
       
}
