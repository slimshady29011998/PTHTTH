package TCPSocket;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class TCPEchoServer {
	public final static int serverport = 7;
	public static void main(String[] args) {
		try {
			ServerSocket ss= new ServerSocket(serverport);
			System.out.println("server da duoc tao");
			while(true) {
				try {
					Socket s = ss.accept();
					OutputStream os = s.getOutputStream();
					InputStream is = s.getInputStream();
					int ch=0;
					while(true) {
						ch=is.read();
						if(ch==1) break;
						System.out.println((char)ch);
						os.write(ch);
					}
					s.close();
				}catch(IOException ie1) {
					System.out.println("Connection Error:"+ie1);
				}
			}
		}catch(IOException ie) {
			System.out.println("Server Createion Error: "+ie);
		}
	}

}
