package multiChrono.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import multiChrono.states.Context;
import multiChrono.states.EventListener;


public class FxController extends AbstractGUI implements Initializable {

	Context observer;
	
	public FxController(EventListener o) {
		super(o);
		observer = (Context) o;
	}

	public Label getMyLabel1() {
		return myLabel1;
	}

	public Label getMyLabel2() {
		return myLabel2;
	}

	public Label getMyLabel3() {
		return myLabel3;
	}

	public Button getB1() {
		return b1;
	}

	public Button getB2() {
		return b2;
	}

	public Button getB3() {
		return b3;
	}


	@FXML
    private Label myLabel1;

    @FXML
    private Label myLabel2;

    @FXML
    private Label myLabel3;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		b1.addEventHandler(ActionEvent.ACTION, e -> observer.left());
		b2.addEventHandler(ActionEvent.ACTION, e -> observer.up());
		b3.addEventHandler(ActionEvent.ACTION, e -> observer.right());
		
	}

	@Override
	protected void initGUI() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void addEventListener() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void updateUI(Context c) {
		myLabel1.setText(c.getDisplayText());
		myLabel2.setText(c.getModeText());
		myLabel3.setText(c.getStateText());
        // update the button labels:
        b1.setText(c.getLeftText());
        b2.setText(c.getUpText());
        b3.setText(c.getRightText());
	}
}
