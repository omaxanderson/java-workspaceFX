package dvdstore.view;

import java.io.IOException;

import dvdstore.MainClass;
import dvdstore.model.DVD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class DisplayMovieController {
	@FXML
	private TableView<DVD> movieTable;
	@FXML
    private TableColumn<DVD, String> titleColumn;
    @FXML
    private TableColumn<DVD, String> productionCompanyColumn;
    @FXML
    private TableColumn<DVD, String> directorColumn;
    @FXML
    private TableColumn<DVD, String> producerColumn;
    @FXML
    private TableColumn<DVD, String> starsColumn;
    @FXML
    private TableColumn<DVD, Integer> stockColumn;
    
    @FXML
	private Button back;
	@FXML
	private Button rent;
    
    private MainClass mainClass;
    private MainScreenController msc;
    
    public DisplayMovieController() {
    	
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
        productionCompanyColumn.setCellValueFactory(cellData -> cellData.getValue().getProductionCompanyProperty());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().getCountProperty().asObject());
        //movieTable.setItems(mainClass.getDVDData());
    }
    
    public void backPressed(ActionEvent e) throws IOException {
    	Stage stage;
    	Parent root;
    	
    	stage = (Stage) back.getScene().getWindow();
    	root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    }
    
    public void setMainClass(MainScreenController msc) {
        //this.mainClass = mainClass;
    	this.msc = msc;

        // Add observable list data to the table
        //movieTable.setItems(mainClass.getDVDData());
        movieTable.setItems(msc.getDVDData());
    }
}
