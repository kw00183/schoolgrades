package edu.westga.cs.schoolgrades;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the SchoolGrades project
 * 
 * @author Kim Weible
 * @version cs6241
 */
public class Main extends Application {
	
	private static final String GUI_RESOURCE = "edu/westga/cs/schoolgrades/views/MainGui.fxml";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL resource = classLoader.getResource(Main.GUI_RESOURCE);
		FXMLLoader loader = new FXMLLoader(resource);
        
        primaryStage.setTitle("Grades Worksheet");
		primaryStage.setResizable(true);
        
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grades Worksheet");
        primaryStage.show();
    }

	/**
	 * Start point for the application
	* 
	* @param args not used
	*/
	public static void main(String[] args) {
		launch(args);
	}
}