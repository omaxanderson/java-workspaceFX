package dvdstore.model;

import java.util.ArrayList;
import java.util.Random;

public class Customer {

	//================	Variables	=================
	private String fn, ln;
	private int accountNumber;
	ArrayList<DVD> rentedList = new ArrayList<DVD>();
	DVD currentMovie;
	
	
	//================		Constructors		====================
	
	
	
	//===============	Methods		=================

	public String getName() {
		return fn + " " + ln;
	}
	
	public String printRented() {
		String temp = "";
		for (DVD d : rentedList) {
			temp = temp + "\n" + d;
		}
		return temp;
	}
	
	public int generateAccNumber() {
		String num = "";
		Random r = new Random();
		for (int i = 0; i < 9; i++) {
			num += r.nextInt(10);
		}
		return Integer.parseInt(num);
	}
	
	public boolean rent(String name) {
		return true;
	}
	
	//==============		Getters and Setters		===================
	
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public ArrayList<DVD> getRentedList() {
		return rentedList;
	}
	public void setRentedList(ArrayList<DVD> rentedList) {
		this.rentedList = rentedList;
	}
	public DVD getCurrentMovie() {
		return currentMovie;
	}
	public void setCurrentMovie(DVD currentMovie) {
		this.currentMovie = currentMovie;
	}
	
}
