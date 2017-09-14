package dvdstore.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dvdstore.MainClass;
import dvdstore.model.DVD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController implements Initializable{

	@FXML
	private Button viewMovies;
	@FXML
	private Button viewCustomers;
	@FXML
	private Button returnDVD;
	@FXML
	private Button checkOutDVD;
	private MainClass mainClass;

	private static ObservableList<DVD> movieList = FXCollections.observableArrayList();

	
	public void viewMoviesButton(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("MovieListDisplay.fxml"));
		
		new DVD("The Avengers", "Marvel").setCount(38);
		new DVD("Home Alone", "FOX").setDirector("Max Anderson");
		new DVD("The Hateful 8", "Quentin Tarantino").setCount(4);
		
        //get reference to the button's stage         
        stage=(Stage) viewMovies.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("MovieListDisplay.fxml"));
		
        DisplayMovieController controller = loader.getController();
		controller.setMainClass(this);
		
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public static void addMovie(DVD d) {
		movieList.add(d);
	}
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public ObservableList<DVD> getDVDData() {
        return movieList;
    }
	
	
	/*
	 @FXML
	 private void handleButtonAction(ActionEvent event) throws IOException{
	     Stage stage; 
	     Parent root;
	     if(event.getSource()==){
	        //get reference to the button's stage         
	        stage=(Stage) btn1.getScene().getWindow();
	        //load up OTHER FXML document
	  root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
	      }
	     else{
	       stage=(Stage) btn2.getScene().getWindow();
	  root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
	      }
	     //create a new scene with root and set the stage
	      Scene scene = new Scene(root);
	      stage.setScene(scene);
	      stage.show();
	    }
	 
	 */
	
}
