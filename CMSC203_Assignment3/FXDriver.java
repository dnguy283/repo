/*
 Class: CMSC-203-23011
 Program: Assignment #3
 Instructor: Huseyin Aygun
 Summary of Description: (Create three methods to encrypt and decrypt text.) 
 Due Date: 10/12/2026 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Daniel Nguyen
 */
package BobsCircus;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXDriver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 600, 350));
		stage.setTitle("Cybersecurity Encryption and Decryption");
		stage.show();
	}
}
