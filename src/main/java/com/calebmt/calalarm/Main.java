package com.calebmt.calalarm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.ButtonBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * Hello world!
 *
 */
public class Main extends Application {
    
    public static void main( String[] args ) {
        System.out.println("Main!");
        launch();
    }   
    
    @Override
    public void start(Stage stage) {

        stage.initStyle(StageStyle.UNDECORATED);

        // Labels
        Label calendarURLLabel = new Label("Calendar URL: ");
        Label URLStatus = new Label("The text entered is: ");

        // Input fields
        TextField calendarInput = new TextField();
        calendarInput.setPrefColumnCount(30);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("Action!");
            }
        };

        calendarInput.setOnAction(event);

        GridPane rootPane = new GridPane();
        //rootPane.getColumnConstraints().add(new ColumnConstraints(200));
        rootPane.addRow(0, calendarURLLabel, calendarInput);
        
        Scene scene = new Scene(rootPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
}
