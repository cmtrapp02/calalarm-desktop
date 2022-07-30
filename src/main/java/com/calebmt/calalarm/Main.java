package com.calebmt.calalarm;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
//import javafx.scene.layout.*;
//import javafx.scene.control.ButtonBase;
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
    public void start(Stage primaryStage) {

        // Check if this is the first time 
        // In the future we will parse a .json file for this setting
        boolean firstTimeSignIn = true;

        if (firstTimeSignIn) {
            Stage signInStage = new Stage(StageStyle.DECORATED);
            SignInGUI signIn = new SignInGUI(signInStage);
            signIn.showScene();
        }
            


        // EVERYTHING BELLOW THIS LINE IS FOR THE MVP 

        primaryStage.initStyle(StageStyle.DECORATED);

        // Labels
        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        Label calendarURLLabel = new Label("Calendar URL: ");
        Label URLStatus = new Label("The text entered is: ");


        // Input fields
        TextField calendarInput = new TextField();
        calendarInput.setPrefColumnCount(30);
        TextField usernameInput = new TextField();
        usernameInput.setPrefColumnCount(30);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPrefColumnCount(30);

        // EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent e)
        //     {
                
        //     }
        // };

        calendarInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Action!");
            }
        });

        //calendarInput.setOnAction(event);

        StackPane rootPane = new StackPane();
        //rootPane.getColumnConstraints().add(new ColumnConstraints(200));
        // rootPane.getChildren().add(0, usernameInput);
        // rootPane.getChildren().add(1, passwordLabel);
        // rootPane.getChildren().add(2, calendarURLLabel);
        rootPane.getChildren().addAll(calendarInput, calendarURLLabel);
        
        Scene scene = new Scene(rootPane, 640, 480);
        primaryStage.setScene(scene);
        //primaryStage.show();
    }

    
}
