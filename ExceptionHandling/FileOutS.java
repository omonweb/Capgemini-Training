package acception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class FileOutS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("demo.txt");
		FileOutputStream fos = new FileOutputStream(f);
		String s = "Java is beautiful";
		
		fos.write(s.getBytes());
		FileInputStream fis = new FileInputStream(f);
		while(fis.read() != -1) System.out.print((char) fis.read());
	}

}
