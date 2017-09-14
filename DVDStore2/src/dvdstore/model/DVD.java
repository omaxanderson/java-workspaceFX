package dvdstore.model;

import java.util.ArrayList;

import dvdstore.MainClass;
import dvdstore.view.MainScreenController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DVD {
	
	//==============	Variables	======================
	private StringProperty title = new SimpleStringProperty();
	private StringProperty producer = new SimpleStringProperty();
	private StringProperty director = new SimpleStringProperty();
	private StringProperty productionCompany = new SimpleStringProperty();
	private ArrayList<String> stars = new ArrayList<String>();
	private IntegerProperty count = new SimpleIntegerProperty();
	
	//==============	Constructors	==================
	
	public DVD(String title) {
		setTitle(title);
		setProducer("");
		setDirector("");
		setProductionCompany("");
		setCount(0);
		//MainClass.addMovie(this);
		MainScreenController.addMovie(this);
	}
	
	public DVD(String title, String productionCompany) {
		setTitle(title);
		setProductionCompany(productionCompany);
		setProducer("");
		setDirector("");
		setCount(0);
		//MainClass.addMovie(this);
		MainScreenController.addMovie(this);
	}
	
	
	
	
	//==============	Methods 	======================
	public void addStar(String title) {
		stars.add(title);
	}
	
	public String toString() {
		String temp = "";
		/**********************
		 * for (String s : stars) {
	
			temp = temp + "\n" + s;
		}
		***************************/
		return getTitle() + " : " + //getProducer() + "\n" + getDirector() + "\n" + 
				getProductionCompany(); // + "\n" + temp;
	}
	
	public boolean rent() {
		if (count.equals(0)) {
			return false;
		} else {
			count.setValue(count.getValue() - 1);;
			return true;
		}
	}
	
	public boolean checkIn() {
		count.setValue(count.getValue() - 1);;
		return true;
	}
	
	public boolean isAvailable() {
		if (count.getValue() > 0) {
			return true;
		} else {
			return false;
		}
	}

	

	
	//============		Getters and Setters		=================
	
	public String getTitle() {
		return title.get();
	}
	
	public StringProperty getTitleProperty() {
		return title;
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getProducer() {
		return producer.get();
	}
	
	public StringProperty getProducerProperty() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer.set(producer);
	}

	public String getDirector() {
		return director.get();
	}
	
	public StringProperty getDirectorProperty() {
		return director;
	}

	public void setDirector(String director) {
		this.director.set(director);
	}

	public String getProductionCompany() {
		return productionCompany.get();
	}
	
	public StringProperty getProductionCompanyProperty() {
		return productionCompany;
	}

	public void setProductionCompany(String productionCompany) {
		this.productionCompany.set(productionCompany);
	}

	public ArrayList<String> getStars() {
		return stars;
	}

	public void setStars(ArrayList<String> stars) {
		this.stars = stars;
	}

	public int getCount() {
		return count.get();
	}
	
	public IntegerProperty getCountProperty() {
		return count;
	}

	public void setCount(int count) {
		this.count.set(count);
	}
	
	
	
}
