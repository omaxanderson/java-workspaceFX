package dvdstore4.model;

import java.util.Random;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

	//================  Instance Variables  ==================
	private StringProperty fn = new SimpleStringProperty();
	private StringProperty ln = new SimpleStringProperty();
	private StringProperty fullName = new SimpleStringProperty();
	private StringProperty accountNumber = new SimpleStringProperty();
	private ObservableList<DVD> rented = FXCollections.observableArrayList();
	private DVD currentRental;
	
	//================  Constructors  ===================
	public Customer(String fn, String ln) {
		setFn(fn);
		setLn(ln);
		setFullName(fn + " " + ln);
		setAccountNumber(generateAccountNumber());
		setCurrentRental(null);
	}
	
	//================  Methods  ======================
	
	/**
	 * Generates a random 10 digit number
	 * 
	 * @return 	void
	 */
	public String generateAccountNumber() {
		String num = "";
		Random r = new Random();
		for (int i = 0; i < 9; i++) {
			num += r.nextInt(10);
		}
		return num;
	}
  
	/** 
	 * Sets the current rental to null and adds one to the returned movie's stock
	 * 
	 * @param DVD d 
	 */
	public void checkIn(DVD d) {
		currentRental = null;
		d.setStock(d.getStock() + 1);
	}
	
	/**
	 * Sets customers current rental to the passed DVD and subtracts 1 from
	 * that DVD's stock
	 * 
	 * @param DVD d
	 */
	public void checkOut(DVD d) {
		currentRental = d;
		rented.add(d);
		d.setStock(d.getStock() - 1);
	}
	
	/**
	 * Adds a DVD to the customers list of rented movies
	 * @param DVD d
	 */
	public void addRented(DVD d) {
		rented.add(d);
	}
	
	//================  Getters and Setters  ==================
	public void setCurrentRental(DVD d) 	{ 	this.currentRental = d; 	}
	public DVD getCurrentRental() 			{	return currentRental;		}
	
	public StringProperty getFullNameProperty() {	return fullName;							}
	public void setFullName(String fullName) 	{	this.fullName.set(getFn() + " " + getLn());	}
	public String getFullName() 				{	return fullName.get();						}
	
	public StringProperty getFnProperty() 	{	return fn;			}
	public String getFn() 					{	return fn.get();	}
	public void setFn(String fn) 			{	this.fn.set(fn);	}
	
	public StringProperty getLnProperty() 	{	return ln;			}
	public String getLn() 					{	return ln.get();	}
	public void setLn(String ln) 			{	this.ln.set(ln);	}
	
	public StringProperty getAccountNumberProperty() 	{	return accountNumber;		}
	public String getAccountNumber() 					{	return accountNumber.get();	}
	public void setAccountNumber(String s) 				{	this.accountNumber.set(s);	}
	
	public ObservableList<DVD> getRented() 	{	return rented;	}
	
	

}
