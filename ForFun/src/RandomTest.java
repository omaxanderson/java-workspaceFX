import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int temp = r.nextInt(10);
			System.out.println(temp);
		}
		
	}

}
