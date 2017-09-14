package dvdstore4.view;

import java.io.IOException;
import java.util.Optional;

import dvdstore4.Main;
import dvdstore4.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddCustomerController {

	//===============  Instance Variables  ===============
	@FXML
	private Button add;
	@FXML
	private Button cancel;
	@FXML
	private TextField first;
	@FXML
	private TextField last;
	
	private Main main;
	
	
	//================  Constructor  ==================
	public AddCustomerController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleAddClicked() {
		if (!first.getText().equals("") && !last.getText().equals("")) {
			main.getCustomerData().add(new Customer(first.getText(), last.getText()));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Customer Added!");
			alert.setHeaderText(null);
			alert.setContentText(first.getText() + " " + last.getText() + " has been added!");
			
			alert.showAndWait();
			try {
				main.showHomeScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Entry");
			alert.setHeaderText(null);
			alert.setContentText("You have not entered a valid customer name.");
			
			alert.showAndWait();
			
		}
		
	}
	
	@FXML
	private void handleCancelClicked() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Cancel");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to cancel?");

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
	
	public void setMain(Main main) {
		this.main = main;
	}
}
