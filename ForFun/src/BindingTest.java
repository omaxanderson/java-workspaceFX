import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingTest {

	public static void main(String[] args) {
		
		IntegerProperty int1 = new SimpleIntegerProperty(5);
		IntegerProperty int2 = new SimpleIntegerProperty(10);
		
		NumberBinding sum = int1.add(int2);
		System.out.println(sum.getValue());
		int1.setValue(10);
		System.out.println(sum.getValue());
		
		
		
	}

}
