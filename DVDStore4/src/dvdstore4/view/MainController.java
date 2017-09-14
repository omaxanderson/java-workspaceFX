package dvdstore4.view;

import java.io.IOException;

import dvdstore4.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainController {

	//===============  Instance Variables  =================
	@FXML
	private Button addMovieButton;
	@FXML
	private Button viewCustomersButton;
	@FXML
	private Button viewMoviesAltButton;
	@FXML
	private Button addCustomerButton;
	
	Main main;
	
	
	//===============  Constructor  =====================
	public MainController() {
		
	}
	
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleAddCustomerClicked() {
		main.showAddCustomer();
	}
	
	// Calls Main's showAddMovie method that displays the Add Movie Screen
	@FXML
	private void handleAddMovieClicked() {
			main.showAddMovie();	
	}
	
	// Calls Main's showDisplayMovieListAlternate method that displays the movie list
	@FXML
	private void handleViewMoviesClicked() {
		try {
			main.showDisplayMovieListAlternate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Calls Main's showCustomerList method and displays the customer list
	@FXML
	private void handleViewCustomerClick() {
		try {
			main.showCustomerList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Called by Main to give a reference back to itself
	public void setMain(Main main) {
		this.main = main;
	}
}
