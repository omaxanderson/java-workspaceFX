/** O Maxwell Anderson
 *  Dr. Prakash Duraisamy
 *  CSE 274 B
 *  Main.java
 *  Main class that contains the methods to display each different scene. 
 *  Also contains the complete list of DVD's that the store has and all
 *  of the customers.
 */



package dvdstore4;

import java.io.IOException;
import java.util.ArrayList;

import dvdstore4.model.Customer;
import dvdstore4.model.DVD;
import dvdstore4.view.AddCustomerController;
import dvdstore4.view.AddMovieController;
import dvdstore4.view.DisplayListController;
import dvdstore4.view.EditMovieController;
import dvdstore4.view.MainController;
import dvdstore4.view.ViewCustomerController;
import dvdstore4.view.ViewMovieAlternateController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * TODO: 
 * DONE -- Fix customer rented list display - not showing anything right now
 * DONE -- Check in movie button in ViewCustomerController functionality
 * DONE -- DisplayListController dialog flow stuff
 * DONE -- Search Bar
 * DONE -- Edit movie function
 * DONE -- Display all the stars
 * DONe -- Fix nullPointerException on checkin Button - view Customer page
 * DONE -- Add new Customer option
 * 
 * @author Max
 *
 */
public class Main extends Application {

	//===================  Instance Variables  ====================
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<DVD> dvdList = FXCollections.observableArrayList();
	private ObservableList<Customer> customerList = FXCollections.observableArrayList();
	//private Customer currentCustomer;
	
	//===================  Constructor  ==========================
	//  This is where all the customer and dvd information is hard coded into
	//  the program. Ideally, future versions will be able to maintain an actual
	//  database so that this doesn't need to be hard coded 
	public Main() {
		ArrayList<String> avengersStars = new ArrayList<String>();
		avengersStars.add("Robert Downey Jr.");
		avengersStars.add("Chris Evans");
		
		ArrayList<String> holidayStars = new ArrayList<String>();
		holidayStars.add("Kate Winslet");
		holidayStars.add("Cameron Diaz");
		
		ArrayList<String> deadpoolStars = new ArrayList<String>();
		deadpoolStars.add("Ryan Renolds");
		
		ArrayList<String> djangoStars = new ArrayList<String>();
		djangoStars.add("Jamie Foxx");
		
		ArrayList<String> wolfStars = new ArrayList<String>();
		wolfStars.add("Leonardo Di Caprio");
		
		ArrayList<String> harryStars = new ArrayList<String>();
		harryStars.add("Emma Watson");
		harryStars.add("Rupert Grint");
		harryStars.add("Daniel Radcliff");
		
		ArrayList<String> shawshankStars = new ArrayList<String>();
		shawshankStars.add("Morgan Freeman");
		shawshankStars.add("Tim Robbins");
		shawshankStars.add("Bob Gunton");
		
		ArrayList<String> lotrStars = new ArrayList<String>();
		lotrStars.add("Daniel Radcliff");
		lotrStars.add("Sean Astin");
		lotrStars.add("Ian McKellan");
		
		
		dvdList.add(new DVD("The Avengers", "Kevin Feige", "Joss Whedon", "Marvel", 3, avengersStars));
		dvdList.add(new DVD("The Holiday", "Bruce A. Block" , "Nancy Meyers", "Universal Studios", 1, holidayStars));
		dvdList.add(new DVD("Deadpool", "Simon Kimburg", "Tim Miller", "20th Century Fox", 4, deadpoolStars));
		dvdList.add(new DVD("Django Unchained", "Reginald Hudlin", "Quentin Tarantino", "Columbia Pictures", 7, djangoStars));
		dvdList.add(new DVD("The Wolf of Wall Street", "Riza Aziz", "Martin Scorsese", "Paramount Pictures", 0, wolfStars));
		dvdList.add(new DVD("Harry Potter and the Deathly Hallows Pt. 1", "JK Rowling", "David Yates", "HeyDey Films", 10, harryStars));
		dvdList.add(new DVD("The Shawshank Redemption", "Liz Glotzer", "Frank Darabont", "Castle Rock Entertainment", 3, shawshankStars));
		dvdList.add(new DVD("The Lord of The Rings: Return of the King", "Peter Jackson", "Peter Jackson", "New Line Cinema", 1, lotrStars));
		
		Customer max = new Customer("Max", "Anderson");
		max.setCurrentRental(dvdList.get(3));
		max.addRented(dvdList.get(3));
		max.addRented(dvdList.get(1));
		max.addRented(dvdList.get(4));
		Customer dave = new Customer("Dave", "Bodger");
		dave.setCurrentRental(null);
		Customer erik = new Customer("Erik", "Peterson");
		erik.setCurrentRental(dvdList.get(1));
		erik.addRented(dvdList.get(1));
		erik.addRented(dvdList.get(5));
		Customer jared = new Customer("Jared", "Willard");
		jared.setCurrentRental(dvdList.get(4));
		jared.addRented(dvdList.get(4));
		jared.addRented(dvdList.get(6));
		Customer ali = new Customer("Ali", "Belzer");
		ali.setCurrentRental(dvdList.get(7));
		ali.addRented(dvdList.get(7));
		ali.addRented(dvdList.get(0));
		ali.addRented(dvdList.get(2));
		ali.addRented(dvdList.get(4));
		ali.addRented(dvdList.get(6));
		Customer jon = new Customer("Jon", "Opdahl");
		jon.setCurrentRental(dvdList.get(0));
		jon.addRented(dvdList.get(0));
		jon.addRented(dvdList.get(3));
		Customer syd = new Customer("Sydney", "Enzler");
		syd.setCurrentRental(dvdList.get(3));
		syd.addRented(dvdList.get(3));
		syd.addRented(dvdList.get(1));
		customerList.add(max);
		customerList.add(dave);
		customerList.add(erik);
		customerList.add(jared);
		customerList.add(ali);
		customerList.add(jon);
		customerList.add(syd);
	}
	
	
	//===================  Start method  ======================
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Max's DVD Store");
		
		initRootLayout();
		showHomeScreen();
	}
	
	//===========  Gets the full DVD list  ==============
	public ObservableList<DVD> getDVDListData() {
		return dvdList;
	}
	
	//===========  Gets the full Customer list
	public ObservableList<Customer> getCustomerData() {
		return customerList;
	}
	
	
	//=================  Initializes the frame  ======================
	public void initRootLayout() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	//=================  Displays Home Screen  ===================
	public void showHomeScreen() throws IOException {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/HomeScreen.fxml"));
			
			AnchorPane homeScreen = (AnchorPane) loader.load();
			
			Scene scene = new Scene(homeScreen);
			primaryStage.setScene(scene);
			
			MainController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	//===============  Display Add Movie Screen  ==============
	public void showAddMovie() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/AddMovieScreen.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
	
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
	
			
			AddMovieController controller = loader.getController();
			controller.setMain(this);
		
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	//===============  Displays Movie List  ===================
	public void showDisplayList(Customer c) throws IOException {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DisplayList.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);

			
			DisplayListController controller = loader.getController();
			controller.setMain(this);
			controller.setCurrentCustomer(c);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	//===================  Displays Customer List  =======================
	public void showCustomerList() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SelectCustomer.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);

			
			ViewCustomerController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	//=================  Displays Movie List  =====================
	public void showDisplayMovieListAlternate() throws IOException {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/ViewMoviesAlternate.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);

			ViewMovieAlternateController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	// Displays the Edit Movie Screen
	public void showEditMovie(DVD d) throws IOException {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/EditMovie.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);

			EditMovieController controller = loader.getController();
			controller.setMain(this);
			controller.setCurrentMovie(d);
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	// Displays the Add Customer Screen
	public void showAddCustomer() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/AddCustomer.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
	
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
	
			
			AddCustomerController controller = loader.getController();
			controller.setMain(this);
		
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
