package dvdstore4.view;

import java.io.IOException;

import dvdstore4.Main;
import dvdstore4.model.Customer;
import dvdstore4.model.DVD;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewCustomerController {
	
	//=================  Instance Variables  ================
	@FXML
	private TableView<Customer> customerTable;
	@FXML
	private TableColumn<Customer, String> customerColumn;
	@FXML
	private TableView<DVD> dvdRentalTable;
	@FXML
	private Label currentRentalLabel;
	@FXML
	private TableColumn<DVD, String> rentalHistoryColumn;
	@FXML
	private Button back;
	@FXML
	private Button select;
	@FXML
	private Button checkIn;
	@FXML
	private Label accountNumber;
	private Main main;
	private Customer currentCustomer;
	@FXML
	private TextField filterField;
	
	//=====================  Constructor  =====================
	public ViewCustomerController() {
		
	}
	
	// Initializes the Customer Column and adds listeners to the table
	@FXML
	private void initialize() {
        customerColumn.setCellValueFactory(cellData -> cellData.getValue().getFullNameProperty());
        
        showCustomerDetails(null);
        
        customerTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showCustomerDetails(newValue));
        customerTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> setCurrentCustomer(newValue));
	}
	
	// Sets the current customer
	private void setCurrentCustomer(Customer newValue) {
		this.currentCustomer = newValue;
	}

	/**
	 * Called whenever a customer is selected in the table
	 * Displays the customer's rental history, account number, and current rental
	 * @param Customer c
	 */
	private void showCustomerDetails(Customer c) {
		if (c != null) {
			if (c.getCurrentRental() != null) {
				currentRentalLabel.setText(c.getCurrentRental().getTitle());
			} else {
				currentRentalLabel.setText("NO CURRENT RENTAL");
			}
			if (!c.getRented().isEmpty()) {
				dvdRentalTable.setItems(c.getRented());
				rentalHistoryColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
			} else {
				dvdRentalTable.setItems(null);
			}
			accountNumber.setText(c.getAccountNumber());
		} else {
			currentRentalLabel.setText("");
			dvdRentalTable.setItems(null);
			accountNumber.setText("");
		}
	}
	
	// Calls Main's showHomeScreen method
	@FXML
	private void handleBackClick() {
		try {
			main.showHomeScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Ensures that the user has selected a customer, then calls Main's showDisplayList method
	// If no Customer selected, popup with error message
	@FXML
	private void handleContinueClicked() {
		if (customerTable.getSelectionModel().getSelectedItem() != null) {
			try {
				main.showDisplayList(currentCustomer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("You must select a customer!");

			alert.showAndWait();
		}
	}
	
	// If the user has a movie checked out, this returns it to the store and sets the current
	// customer's current rental to null
	@FXML
	private void handleCheckInClicked() {
		if (currentCustomer != null) {
			if (currentCustomer.getCurrentRental() != null) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText(currentCustomer.getCurrentRental().toString() + " has been returned to the store!");
	
				alert.showAndWait();
				currentCustomer.checkIn(currentCustomer.getCurrentRental());
				showCustomerDetails(currentCustomer);
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert");
				alert.setHeaderText(null);
				alert.setContentText(currentCustomer.getFullName() + " does not have a movie rented right now!");
	
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No Customer Selected");
			alert.setHeaderText(null);
			alert.setContentText("You have not selected a customer!");

			alert.showAndWait();
		}
	}
	
	// Called by main to get a reference back to itself
	// Also populates the table with the customer list
	public void setMain(Main main) {
		this.main = main;
		
		FilteredList<Customer> filteredData = new FilteredList<>(main.getCustomerData(), p -> true);
        
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } 
                return false; // Does not match.
            });
        });
        
        SortedList<Customer> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(customerTable.comparatorProperty());

        customerTable.setItems(sortedData);
	}
	
	
}
