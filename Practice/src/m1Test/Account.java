package m1Test;
import java.io.*;


// call the non static readLine method of buffer
//how to work with abstract classes - by creating a child class
//implementing runtime class
//exception handling!


public class Account {

	public static void main(String[] args) throws IOException {

		// Reader read = new Reader();cannot instantiate the type reader because this is an abstract class
		
		//ArrayList<Integer> list = new ArrayList<>();
		
		InputStream input1 = System.in;
		
		InputStreamReader input = new InputStreamReader(input1);
		
		BufferedReader reader = new BufferedReader(input);
		try {
		FileReader fr = new FileReader("Manas");
		}
		catch(Exception e) {System.out.println("File found");}
		reader.readLine();

		
		

	}

}
