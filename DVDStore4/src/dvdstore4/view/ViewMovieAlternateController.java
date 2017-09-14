/** O Maxwell Anderson
 *  Dr. Prakash Duraisamy
 *  CSE 274 B
 *  ViewMovieAlternate.java
 *  This class is the controller for the movie display screen.
 */

package dvdstore4.view;

import java.io.IOException;

import dvdstore4.Main;
import dvdstore4.model.DVD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ViewMovieAlternateController {

	//==================  Instance Variables  ===================
	@FXML
	private Button backButton;
	@FXML
	private Button editButton;
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
	private Label stars1Label;
	@FXML
	private Label stars2Label;
	@FXML
	private Label stars3Label;
	@FXML
	private Label stockLabel;
	@FXML
	private ObservableList<DVD> masterData = FXCollections.observableArrayList();
	@FXML
	private TextField filterField;
	private Main main;
	
	//======================  Constructor  ======================
	public ViewMovieAlternateController() {
		
	}
	
	// Initializes the movie column and adds a listener
	@FXML
	private void initialize() {
		
        movieColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());

        showDVDDetails(null);
        
        movieTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showDVDDetails(newValue));
	}
	
	// Displays the DVD details whenever a movie is selected
	private void showDVDDetails(DVD d) {
		if (d != null) {
			titleLabel.setText(d.getTitle());
			producerLabel.setText(d.getProducer());
			directorLabel.setText(d.getDirector());
			productionCompanyLabel.setText(d.getProductionCompany());
			if (d.getStars().size() == 0) {
				stars1Label.setText("");
				stars2Label.setText("");
				stars3Label.setText("");
			} else if (d.getStars().size() == 1) {
				stars1Label.setText(d.getMainStar());
				stars2Label.setText("");
				stars3Label.setText("");
			} else if (d.getStars().size() == 2) {
				stars1Label.setText(d.getMainStar());
				stars2Label.setText(d.getStars().get(1));
				stars3Label.setText("");
			} else if (d.getStars().size() == 3) {
				stars1Label.setText(d.getMainStar());
				stars2Label.setText(d.getStars().get(1));
				stars3Label.setText(d.getStars().get(2));
			}
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
			stars1Label.setText("");
			stars2Label.setText("");
			stars3Label.setText("");
			stockLabel.setText("");
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
	
	// Calls Main's showEditMovie method
	@FXML
	private void handleEditClicked() {
		try {
			//System.out.println(movieTable.getSelectionModel().getSelectedItem().getTitle());
			main.showEditMovie(movieTable.getSelectionModel().getSelectedItem());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Called by Main to get a reference back to itself
	// Also populates the table with the Movie List
	public void setMain(Main main) {
		this.main = main;
		
		FilteredList<DVD> filteredData = new FilteredList<>(main.getDVDListData(), p -> true);
        
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
