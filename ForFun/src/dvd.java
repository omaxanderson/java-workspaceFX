import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class dvd {
	private StringProperty title = new SimpleStringProperty(); //, production;
	
	/*
	public dvd(String title, String production) {
		this.title = title;
		this.production = production;
	}
	
	*/
	
	public dvd(String title) {
		setTitle(title);	
	}
	
	public String toString() {
		return title.get();  // + " : " + production;
	}
	
	
	
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public String getTitle() {
		return this.title.get();
	}
	
	public StringProperty getTitleProperty() {
		return this.title;
	}
	
}
