package bai1;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileTWrite extends Thread{
	private static String file_path = null;
	synchronized public void run() {
		BufferedOutputStream bout= null;
		FileOutputStream fout = null;
		try {
			System.out.println("nhap vao duong dan file");
			Scanner sc = new Scanner(System.in);
			file_path= sc.nextLine();
			fout = new FileOutputStream(file_path);
			bout = new BufferedOutputStream(fout);
			for (int i=0; i<5; i++) 
	        {
	            Random rand = new Random();
				bout.write(rand.nextInt(100)+1);
				bout.flush();
	        }
            bout.close();
			fout.close();
			}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		}
		System.out.println("sucess!");
	}

}
//"D:\\word\\phat trien he thong tich hop\\FIle out\\1.txt"
//"D:\\word\\phat trien he thong tich hop\\FIle out\\2.txt"
//"D:\\word\\phat trien he thong tich hop\\FIle out\\3.txt"