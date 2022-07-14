package com.calebmt.calalarm;

import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;



// The purpose of this class is to handle signing in into calendar accounts.
// Most of the backend details are handled by Calendar.java, this class just calls
// some functions from it. 
// The primary purpose of this class is handling the sign in GUI, which is seperate from the main system tray application.

class SignInGUI {
    
    // Declare labels, text input boxes and the program stage

    // Program stage
    private Stage signInStage;
    // Labels
    private Label usernameLabel;
    private Label passwordLabel;
    private Label calendarLabel;

    // Text input boxes
    // Instantiate and set the widith of the labels
    private TextField usernameInput;
    private TextField passwordInput;
    private TextField calendarInput;

    public SignInGUI(Stage stage) {
        
        // Initialze the stage, labels an input text fields.
        this.signInStage = stage;

        this.usernameLabel = new Label("Username: ");
        this.passwordLabel = new Label("Password: ");
        this.calendarLabel = new Label("Calendar URL: ");

        this.usernameInput = new TextField();
        this.passwordInput = new TextField();
        this.calendarInput = new TextField();

    }


}