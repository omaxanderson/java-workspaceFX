import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDVDImport {

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("dvd_csv.txt");
		
		ArrayList<dvd> list = new ArrayList<dvd>();
		
		BufferedReader br = null;
	      try {
	         br = new BufferedReader(new FileReader(in));
	         String a;
	         while((a = br.readLine()) != null) {
	             
	        	 String[] temp = a.replaceAll("\"", "").split(",");
	        	 list.add(new dvd(temp[0], temp[1]));            
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
		int count = 0;
	      for (dvd d : list) {
	    	  System.out.println(count + " " + d.toString());
	    	  count++;
	      }
		
		
		
		
		/*
		
		Scanner k = new Scanner(in);
		
		
		int count = 0;
		while (k.hasNext()) {
			//String[] temp;
			//temp = k.nextLine().replaceAll("\"", "").split(",");
			//list.add(new dvd(temp[0], temp[1]));
			System.out.println(count + "\t" + k.nextLine());
			count++;
		}
		/*
		int i = 0;
		for(dvd d : list) {
			System.out.println(i + " " + d.toString());
			i++;
		}  */
		
	
	}

	
	
}
