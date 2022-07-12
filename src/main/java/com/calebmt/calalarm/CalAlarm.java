package com.calebmt.calalarm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


/**
 * Hello world!
 *
 */
public class CalAlarm extends Application {
    
    public static void main( String[] args ) {
        System.out.println("Main!");
        launch();
    }   
    
    @Override
    public void start(Stage stage) {

        Label calendarURLLabel = new Label("Calendar URL: ");
        TextField calendarInputField = new TextField();
        calendarInputField.setPrefColumnCount(30);
        
        GridPane rootPane = new GridPane();
        //rootPane.getColumnConstraints().add(new ColumnConstraints(200));
        rootPane.addRow(0, calendarURLLabel, calendarInputField);
        
        Scene scene = new Scene(rootPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
}
