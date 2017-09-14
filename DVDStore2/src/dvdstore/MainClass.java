package dvdstore;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dvdstore.model.DVD;
import dvdstore.model.MovieList;
import dvdstore.view.DisplayMovieController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class MainClass extends Application {
	//public MovieList movieList = new MovieList();
	private Stage primaryStage;
	private BorderPane rootLayout;
	//private static ObservableList<DVD> movieList = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Max's Movies");
		
		/*
		try {
			importDVDList();
		} catch (FileNotFoundException e) {  	e.printStackTrace();	}
		*/
		//new DVD("The Avengers", "Marvel").setCount(38);
		//new DVD("Home Alone", "FOX").setDirector("Max Anderson");
		//new DVD("The Hateful 8", "Quentin Tarantino").setCount(4);
		
		/*
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/MovieListDisplay.fxml"));
		DisplayMovieController controller = loader.getController();
		controller.setMainClass(this);
		*/
		initRootLayout();
		//showMovieListDisplay();
		showMainScreen();
		
		
		
		/**********************************
		 ********	Listener Test  ********

		DVD d = new DVD("The Avengers");
		d.getNameProperty().addListener( new ChangeListener<Object>() {
			@Override public void changed(ObservableValue o,Object oldVal, 
	                 Object newVal){
	             System.out.println("DVD name has changed again!");
	        }
		});
		
		d.setName("The Avengers 2");
		
		 **********************************/
	}
	
	/**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    
	/*
	public ObservableList<DVD> getDVDData() {
        return movieList;
    }
    
    public static void addMovie(DVD movie) {
    	movieList.add(movie);
    }
    
    */
	
    
    /********************************************************
    ************* Imports Massive Movie .txt file  **********
	public void importDVDList() throws FileNotFoundException{
		File in = new File("DVD_csv.txt");
		//ArrayList<DVD> list = new ArrayList<DVD>();
		
		BufferedReader br = null;
	      try {
	         br = new BufferedReader(new FileReader(in));
	         String a;
	         while((a = br.readLine()) != null) {
	             
	        	 String[] temp = a.replaceAll("\"", "").split(",");
	        	 movieList.add(new DVD(temp[0], temp[1]));            
	         }
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         if (br != null) {
	            try {
	               br.close();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      }
		
	      /**************************************
	       ******Prints out the movielist*******
	       
	      int count = 0;
	      for (DVD d : movieList) {
	    	  System.out.println(count + " " + d.toString());
	    	  count++;
	      }
	      
	      **************************************
	}

	****************************************/
	
	
	public void initRootLayout() {
		try {
			//Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//Show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e ) {
			e.printStackTrace();
		}
	}
	
	//Shows main screen inside the root layout
	public void showMainScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("view/MainScreen.fxml"));
			AnchorPane mainScreen = (AnchorPane) loader.load();
			
			rootLayout.setCenter(mainScreen);
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void showMovieListDisplay() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("view/MovieListDisplay.fxml"));
			AnchorPane movieListDisplay = (AnchorPane) loader.load();
			
			rootLayout.setCenter(movieListDisplay);
			
			DisplayMovieController controller = loader.getController();
			//controller.setMainClass(this);
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
