


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Label label1;
	TextField textField1;
	//  declare two HBoxes
	HBox hBox1;
	HBox hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		label1 = new Label("Feedback:");
		textField1 = new TextField();
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		Insets insets = new Insets(15);
		HBox.setMargin(button1, insets);
		HBox.setMargin(button2, insets);
		HBox.setMargin(button3, insets);
		HBox.setMargin(button4, insets);
		HBox.setMargin(button5, insets);
		HBox.setMargin(label1, insets);
		HBox.setMargin(textField1, insets);
		
		//align
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBox2.getChildren().addAll(label1, textField1);
		//  add the buttons to the other HBox
		hBox1.getChildren().addAll(button1, button2, button3, button4, button5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBox1, hBox2);
		
		button1.setOnAction(new ButtonClickHandler());
		button2.setOnAction(new ButtonClickHandler());
		button3.setOnAction(new ButtonClickHandler());
		button4.setOnAction(new ButtonClickHandler());
		button5.setOnAction(new ButtonClickHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks\
	private class ButtonClickHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			if (event.getTarget() == button1)
			{
				textField1.setText(dataManager.getHello());
			}
			else if(event.getTarget() == button2)
			{
				textField1.setText(dataManager.getHowdy());
			}
			else if(event.getTarget() == button3)
			{
				textField1.setText(dataManager.getChinese());
			}
			else if(event.getTarget() == button4)
			{
				textField1.setText("");
			}
			else if(event.getTarget() == button5)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
