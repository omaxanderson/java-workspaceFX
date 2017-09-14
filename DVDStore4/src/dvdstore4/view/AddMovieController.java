package dvdstore4.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.paint.Color;

import dvdstore4.Main;
import dvdstore4.model.DVD;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddMovieController {
	
	//===================  Instance Variables  ==================
	@FXML
	private TextField title;
	@FXML
	private TextField director;
	@FXML
	private TextField producer;
	@FXML
	private TextField productionCompany;
	@FXML
	private TextField stock;
	@FXML
	private TextField stars1;
	@FXML
	private TextField stars2;
	@FXML
	private TextField stars3;
	@FXML
	private Button back;
	@FXML
	private Button add;
	private Main main;
	@FXML
	private Label stockLabel;
	@FXML
	private Label titleLabel;
	
	//===================  Constructor  ====================
	public AddMovieController() {
		
	}
	
	
	
	@FXML
	private void initialize() {
		
	}
	
	// Adds a new movie to Main's movieList 
	@FXML
	private void handleAddClicked() {
		if (title.getText().equals("")) {
			
			titleLabel.setTextFill(Color.web("#FF0000"));
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Entry");
			alert.setHeaderText(null);
			alert.setContentText("You must enter a title.");
			
			alert.showAndWait();
		} else if(stock.getText().equals("")) {
			stockLabel.setTextFill(Color.web("#FF0000"));
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Entry");
			alert.setHeaderText(null);
			alert.setContentText("You must enter the number of copies in the store.");
			
			alert.showAndWait();
			
		} else {	
			ArrayList<String> stars = new ArrayList<String>();
			stars.add(stars1.getText());
			stars.add(stars2.getText());
			stars.add(stars3.getText());
			DVD temp = new DVD(title.getText(), producer.getText(), director.getText(), productionCompany.getText(),
					Integer.parseInt(stock.getText()), stars);
			main.getDVDListData().add(temp);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Movie successfully added!");
	
			alert.showAndWait();
			
			try {
				main.showHomeScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	// Goes back to the Home Screen
	@FXML
	private void handleBackClicked() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Cancel");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to cancel? Unsaved data will be lost.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			
			try {
				main.showHomeScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			alert.close();
		}
	}
	
	// Called by main to give a reference back to itself
	public void setMain(Main main) {
		this.main = main;
	}
}
