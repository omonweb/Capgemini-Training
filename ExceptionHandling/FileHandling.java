package acception;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandling {

	public static void main(String[] args) throws Exception {
		File f = new File("demo1.txt");
		try {
			System.out.println(f.createNewFile());
			
		} catch(Exception e) {
			
		}
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(f);
			String s = "Java";
			fw.write(s);
			System.out.println(10/0);
			
		}
		
		catch(Exception e) {}
		
		try {
				fw.close();
			} 
		
		catch(Exception e) {
			
			}
		
		FileReader fr = new FileReader(f);
		int temp = fr.read();
		while(temp != -1) {
			System.out.print((char) temp);
			temp = fr.read();
		}
	}	

}
