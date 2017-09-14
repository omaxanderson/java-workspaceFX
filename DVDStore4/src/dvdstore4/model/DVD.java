/** O Maxwell Anderson
 *  Dr. Prakash Duraisamy
 *  CSE 274 B
 *  DVD.java
 *  DVD class that contains all the methods and data for each DVD instance.
 */

package dvdstore4.model;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DVD {

	
	//================  Instance Variables  =======================
	private StringProperty title = new SimpleStringProperty();
	private StringProperty producer = new SimpleStringProperty();
	private StringProperty director = new SimpleStringProperty();
	private StringProperty productionCompany = new SimpleStringProperty();
	private IntegerProperty stock = new SimpleIntegerProperty();
	private ObservableList<String> stars = FXCollections.observableArrayList();
	
	//================  Constructors  =====================
	public DVD(String title) {
		setTitle(title);
		setProducer("");
		setDirector("");
		setProductionCompany("");
		setStock(0);
	}
	
	public DVD(String title, String producer, String director, String productionCompany, 
			int stock, ArrayList<String> stars) {
		setTitle(title);
		setProducer(producer);
		setDirector(director);
		setProductionCompany(productionCompany);
		setStock(stock);
		for (String s : stars) {
			this.stars.add(s);
		}
	}
	
	//================  Methods  ==================
	
	// Adds a star to the ObservableArrayList stars
	public void addStar(String s) {
		this.stars.add(s);
	}
	
	// Gets the first index of the stars ArrayList
	public String getMainStar() {
		return stars.get(0);
	}
	
	// Returns true if the movie is in stock
	// Else returns false
	public boolean isAvailable() {
		if (stock.get() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Returns the movie's title... Basically the same as getTitle()
	public String toString() {
		return getTitle();
	}
	
	
	
	//================  Getters and Setters  =====================
	
	public StringProperty getTitleProperty() 	{	return title;			}	
	public void setTitle(String title) 			{	this.title.set(title);	}
	public String getTitle() 					{return this.title.get();	}
	
	public StringProperty getProducerProperty() 	{	return producer;				}
	public void setProducer(String producer) 		{	this.producer.set(producer);	}
	public String getProducer() 					{	return this.producer.get();		}

	public StringProperty getDirectorProperty() 	{	return director;				}
	public void setDirector(String director) 		{	this.director.set(director);	}
	public String getDirector() 					{	return this.director.get();		}

	public StringProperty getProductionCompanyProperty() 		{	return productionCompany;						}
	public void setProductionCompany(String productionCompany) 	{	this.productionCompany.set(productionCompany);	}
	public String getProductionCompany() 						{	return this.productionCompany.get();			}
	

	public IntegerProperty getStockProperty() 	{	return stock;				}
	public void setStock(int stock) 			{	this.stock.set(stock);		}
	public int getStock() 						{	return this.stock.get();	}
	

	public ObservableList<String> getStars() 			{	return stars;		}
	public void setStars(ObservableList<String> stars) 	{	this.stars = stars;	}
	
}
