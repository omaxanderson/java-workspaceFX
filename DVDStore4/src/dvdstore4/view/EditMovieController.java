/** O Maxwell Anderson
 *  Dr. Prakash Duraisamy
 *  CSE 274 B
 *  EditMovieController.java
 *  Controller class for the Edit Movie screen.
 */

package dvdstore4.view;

import java.io.IOException;
import java.util.Optional;

import dvdstore4.Main;
import dvdstore4.model.DVD;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class EditMovieController {
	
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
	private Button save;
	private Main main;
	private DVD currentMovie;
	
	//===================  Constructor  ====================
	public EditMovieController() {
		
	}
	
	
	
	@FXML
	private void initialize() {
		
	}
	
	
	// Saves entered information
	@FXML 
	private void handleSaveClicked() {
		currentMovie.setTitle(title.getText());
		currentMovie.setDirector(director.getText());
		currentMovie.setProducer(producer.getText());
		currentMovie.setProductionCompany(productionCompany.getText());
		currentMovie.getStars().clear();
		currentMovie.getStars().add(stars1.getText());
		currentMovie.getStars().add(stars2.getText());
		currentMovie.getStars().add(stars3.getText());
		currentMovie.setStock(Integer.parseInt(stock.getText()));
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Information for " + currentMovie.getTitle() + " has been saved!");

		alert.showAndWait();
		
		try {
			main.showDisplayMovieListAlternate();
		} catch (IOException e) {
			e.printStackTrace();
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
				main.showDisplayMovieListAlternate();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			alert.close();
		}
	}
	
	// Sets current movie to be edited
	public void setCurrentMovie(DVD d) {
		this.currentMovie = d;
		
		title.setText(currentMovie.getTitle());
		director.setText(currentMovie.getDirector());
		producer.setText(currentMovie.getProducer());
		productionCompany.setText(currentMovie.getProductionCompany());
		stars1.setText(currentMovie.getStars().get(0));
		if (currentMovie.getStars().size() == 2) {
			stars2.setText(currentMovie.getStars().get(1));
		} else if (currentMovie.getStars().size() == 3) {
			stars2.setText(currentMovie.getStars().get(1));
			stars3.setText(currentMovie.getStars().get(2));
		}
		stock.setText(Integer.toString(currentMovie.getStock()));
	}
	
	// Called by main to give a reference back to itself
	public void setMain(Main main) {
		this.main = main;
	}
}