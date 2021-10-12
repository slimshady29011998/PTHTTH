package bai_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class TCPEchoClient{
	public final static String serverIP="127.0.0.2";
	public final static int serverPort = 7;
	public static void main(String[] args) throws IOException

	{
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis=null;
		try {
			s=new Socket(serverIP,serverPort);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			Scanner input = new Scanner(System.in);
			String S = null;
			while(true)
			{
				System.out.print("\nNhap du lieu: ");
				S =input.nextLine();
				dos.writeUTF(S);  
				String str=dis.readUTF();
				System.out.print("ket qua tu Server : "+str);
			}
		}

		catch(Exception e) {
			System.out.print("Ngat ket noi");
			dis.close();
			dos.close();
			s.close();
			e.printStackTrace();
		}
	}
}