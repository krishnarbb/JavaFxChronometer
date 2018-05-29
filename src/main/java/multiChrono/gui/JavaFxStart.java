package multiChrono.gui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
///import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import multiChrono.states.Context;

public class JavaFxStart extends Application {

	private Parent root;
	private Context observer;
	private FxController controller;
	
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	@Override
    public void init() throws Exception {
		this.observer = new Context();
		
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chrono.fxml"));
        fxmlLoader.setControllerFactory(c -> 
        		{ this.controller = new FxController(observer); 
        		  return controller; 
        });
        root = fxmlLoader.load();
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.updateUI(observer);
		observer.tick();
		startScheduledExecutorService();
	}
	
	@Override
	public void stop() {
		scheduler.shutdown();
	}
	

    // infinite loop that asks the current state to do whatever it needs to do
    // and that updates the graphical user interface accordingly
	private void startScheduledExecutorService() {
        scheduler.scheduleAtFixedRate(
        		new Runnable(){
                    @Override
                    public void run() {
                            Platform.runLater(new Runnable(){
                                @Override
                                public void run() {
                            		controller.updateUI(observer);
                            		observer.tick();
                                }
                            });
                }
        },1,1, TimeUnit.SECONDS);      
        
        
    }
}
