package com.calebmt.calalarm;

import javafx.stage.Stage;

import java.util.concurrent.Flow;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



// The purpose of this class is to handle signing in into calendar accounts.
// Most of the backend details are handled by Calendar.java, this class just calls
// some functions from it. 
// The primary purpose of this class is handling the sign in GUI, which is seperate from the main system tray application.

class SignInGUI {
    
    // Declare labels, text input boxes and the program stage

    // Program stage
    private Stage signInStage;

    // root
    private FlowPane root;

    // scene
    private Scene scene;

    // Labels
    private Label usernameLabel;
    private Label passwordLabel;
    private Label calendarLabel;

    // Text input boxes
    // Instantiate and set the widith of the labels
    private TextField usernameInput;
    private PasswordField passwordInput;
    private TextField calendarInput;

    private Calendar calendar;

    public SignInGUI(Stage stage) {
        
        // Initialze the stage, labels an input text fields.
        this.signInStage = stage;
        this.signInStage.initStyle(StageStyle.DECORATED);

        this.usernameLabel = new Label("Username: ");
        this.passwordLabel = new Label("Password: ");
        this.calendarLabel = new Label("Calendar URL: ");

        this.usernameInput = new TextField();
        this.passwordInput = new PasswordField();
        this.calendarInput = new TextField();

        // Configure the width of the text fields
        usernameInput.setPrefColumnCount(30);
        passwordInput.setPrefColumnCount(30);
        calendarInput.setPrefColumnCount(40);

        this.root = new FlowPane(Orientation.VERTICAL);

        this.scene = new Scene(this.root, 640, 640);

        this.addNodesToRoot();
        this.handleEvents();

        this.calendar = new Calendar();
    }

    private void addNodesToRoot() {
        
        this.root.getChildren().add(this.usernameLabel);
        this.root.getChildren().add(this.usernameInput);
        this.root.getChildren().add(this.passwordLabel);
        this.root.getChildren().add(this.passwordInput);
        this.root.getChildren().add(this.calendarLabel);
        this.root.getChildren().add(this.calendarInput);
        this.root.setMinHeight(100);
        this.root.setMinWidth(20);
        
    }

    private void errorOutLabel(Label label){
        // Change the text to red to and add label error
        String errorColor = "red";
        label.setStyle("-fx-text-fill: " + errorColor + ";"); 
        System.out.println("Error out text!");
    }

    private void reverseErroredOutLabel(Label label) {
        // Change the text back to the original color.
        String normalColor = "black";
        label.setStyle("-fx-text-fill: " + normalColor + ";");
    }

    private boolean isTextPopulated(String text) {
        if (text.isEmpty()) {
            return false;
        }

        return true;
    }

    private void onEnterPressed() {
        
        // pass the credentials over to the calendar
        String user = this.usernameInput.getText();
        String pass = this.passwordInput.getText();
        String url = this.calendarInput.getText();
        if (isTextPopulated(user) && isTextPopulated(pass) && isTextPopulated(url)) {
            this.calendar.handleCalendarSignIn(user, pass, url);
        }
        if (!isTextPopulated(user)) {
            errorOutLabel(this.usernameLabel);
        }
        else {
            reverseErroredOutLabel(this.usernameLabel);
        }
        if (!isTextPopulated(pass)) {
            errorOutLabel(this.passwordLabel);
        }
        else {
            reverseErroredOutLabel(this.passwordLabel);
        }
        if (!isTextPopulated(url)) {
            errorOutLabel(this.calendarLabel);
        } 
        else {
            reverseErroredOutLabel(this.calendarLabel);
        }
    }

    public void showScene() {

        this.signInStage.setScene(this.scene);
        this.signInStage.show();

    }

    private void handleEvents() {
        
        // On calendar input event
        this.calendarInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                onEnterPressed();
            }
        });
    }

}