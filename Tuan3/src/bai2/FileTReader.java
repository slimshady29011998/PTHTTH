package bai2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTReader {
	void read(String name) {
		try {
			File myObj = new File(name);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println("du lieu trong file la:"+data);
			}
			myReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("chuong trinh co loi");
			e.printStackTrace();
		}
	}
}
