import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PropertyTest {
	
	public static void main(String[] args) {
		
		dvd d = new dvd("The Avengers");
		d.getTitleProperty().addListener( new ChangeListener() {
			@Override public void changed(ObservableValue o,Object oldVal, 
	                 Object newVal){
	             System.out.println("DVD name has changed!");
	        }
		});
		
		d.setTitle("Home Alone");
	}
}
