/** O Maxwell Anderson
 *  Dr. Prakash Duraisamy
 *  CSE 274 B
 *  DisplayListController.java
 *  Controller for the movie rent screen.
 */

package dvdstore4.view;

import java.io.IOException;
import java.util.Optional;

import dvdstore4.Main;
import dvdstore4.model.Customer;
import dvdstore4.model.DVD;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class DisplayListController {

	//==================  Instance Variables  ====================
	@FXML
	private Button rentButton;
	@FXML
	private Button backButton;
	@FXML 
	private TableColumn<DVD, String> movieColumn;
	@FXML
	private TableView<DVD> movieTable;
	@FXML
	private Label titleLabel;
	@FXML
	private Label producerLabel;
	@FXML
	private Label directorLabel;
	@FXML
	private Label productionCompanyLabel;
	@FXML
	private Label starsLabel;
	@FXML
	private Label stockLabel;
	private Main main;
	private Customer currentCustomer;	
	@FXML
	private TextField filterField;
	
	//==================  Constructor  ==================
	public DisplayListController() {
		
	}
	
	
	/**
	 * Initializes the movie table and adds a listener to 
	 * detect when a movie is selected
	 */
    @FXML
	private void initialize() {
		
        movieColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());

        showDVDDetails(null);
        
        movieTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showDVDDetails(newValue));
	}
	
	/**
	 * Called when a movie is selected and sets the 
	 * movie details to selected movie
	 *  
	 * @param DVD d
	 */
	private void showDVDDetails(DVD d) {
		if (d != null) {
			titleLabel.setText(d.getTitle());
			producerLabel.setText(d.getProducer());
			directorLabel.setText(d.getDirector());
			productionCompanyLabel.setText(d.getProductionCompany());
			starsLabel.setText(d.getMainStar());
			if (d.getStock() == 0) {
				stockLabel.setText(Integer.toString(d.getStock()) + " (NOT IN STOCK)");
				stockLabel.setTextFill(Color.web("#FF0000"));
			} else {
				stockLabel.setText(Integer.toString(d.getStock()));
				stockLabel.setTextFill(Color.web("#000000"));

			}
		} else {
			titleLabel.setText("");
			producerLabel.setText("");
			directorLabel.setText("");
			productionCompanyLabel.setText("");
			starsLabel.setText("");
			stockLabel.setText("");
		}
	}
	
	/**
	 * Called when rent button is clicked
	 */
	@FXML
	private void handleRentClick() {
		
		// Check if the user has selected a customer
		if (movieTable.getSelectionModel().getSelectedItem() != null) {
			//Check to make sure the movie is in stock
			if (movieTable.getSelectionModel().getSelectedItem().getStock() == 0) {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setTitle("Error");
				alert2.setHeaderText(null);
				alert2.setContentText("There are no copies of " + 
						movieTable.getSelectionModel().getSelectedItem().getTitle() + " left in stock!");
		
				alert2.showAndWait();
			} else {
				// If the user already has a movie rented, they must check in that movie
				// in order to rent the new movie
				if (currentCustomer.getCurrentRental() != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirm Check-Out");
					alert.setHeaderText(currentCustomer.getFullName() + " already has " + 
							currentCustomer.getCurrentRental() + " checked out.");
					alert.setContentText("Are you sure you want to return this movie and check out " + 
							movieTable.getSelectionModel().getSelectedItem().getTitle() + "?");
		
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						
						// Checks in their previous movie and checks out the new movie
						currentCustomer.checkIn(currentCustomer.getCurrentRental());
						currentCustomer.checkOut(movieTable.getSelectionModel().getSelectedItem());
						
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("Rental Complete");
						alert1.setHeaderText(null);
						alert1.setContentText("Movie has been rented!");
				
						alert1.showAndWait();
						
						try {
							main.showHomeScreen();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						alert.close();
					}
				} else {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirm Check-Out");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to check out " + 
							movieTable.getSelectionModel().getSelectedItem().getTitle() + "?");
		
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						
						currentCustomer.checkOut(movieTable.getSelectionModel().getSelectedItem());
						
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("Rental Complete");
						alert1.setHeaderText(null);
						alert1.setContentText("Movie has been rented!");
				
						alert1.showAndWait();
						
						try {
							main.showHomeScreen();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						alert.close();
					}
			
				}
			}
			
		} else {
			// If no movie was selected when rent button is clicked, display error message 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("You must select a movie to rent!");
	
			alert.showAndWait();
		}
		
		
	}
	
	// Brings the user back to the Customer List
	@FXML
	private void handleBackClick() {
		try {
			main.showCustomerList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Sets the current customer to the Customer c that was passed.
	public void setCurrentCustomer(Customer c) {
		currentCustomer = c;
	}
	
	// Called from the main method to give a reference back to itself. 
	// Also populates the movie table with the Main class's DVD list
	public void setMain(Main main) {
		this.main = main;
		
		// Wrap the ObservableList in a FilteredList and SortedList so that we can use
		// the search bar to filter the table
		FilteredList<DVD> filteredData = new FilteredList<>(main.getDVDListData(), p -> true);
        
		// Adds the listener to the text field
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(dvd -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (dvd.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } 
                return false; // Does not match.
            });
        });
        
        SortedList<DVD> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(movieTable.comparatorProperty());

        movieTable.setItems(sortedData);
	}
	
}
