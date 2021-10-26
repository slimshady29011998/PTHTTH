package bai_09;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class TCPEchoClient {
	public final static String serverIP="127.0.0.2";
	public final static int serverPort = 8;
	public static void main(String[] args) throws InterruptedException, IOException{
		Socket s = null;
		try {
			s=new Socket(serverIP,serverPort);
			System.out.println("Client da duoc tao");
			InputStream is =s.getInputStream();
			OutputStream os = s.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			Scanner input = new Scanner(System.in);
			String menu= null;
			String S=null;
			menu=dis.readUTF();
			System.out.println(menu);
			while(true) {
				S = input.nextLine();
	            dos.writeUTF(S);
                String str = dis.readUTF();
                System.out.print("Ket qua tra ve tu SERVER : \n" + str);
			}
			
		}catch(IOException ie) {
			System.out.println("Error: can not create socket");
		}finally {
			if(s!=null) {
				s.close();
			}
		}
	}
}
