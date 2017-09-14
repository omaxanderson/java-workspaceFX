package application.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController implements Initializable {
	
	@FXML
	private Button button;
	
	public void buttonClicked(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;
		
        //get reference to the button's stage         
        stage=(Stage) button.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	     
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
