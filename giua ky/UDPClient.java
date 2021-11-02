package De1;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	private static final int PORT = 7777;
	private static final String server = "127.0.0.1";
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress serverAddress = InetAddress.getByName(server);
			Scanner sc = new Scanner(System.in);

			String fileName = "";
			do {
				System.out.println("Nhap ten file: ");
				fileName = sc.nextLine();
			} while (checkFile(fileName));

			int choice;
			do {
				//gui yeu cau den server
				byte[] outputByteFile = fileName.getBytes();
				DatagramPacket outputPackFile = new DatagramPacket(outputByteFile, outputByteFile.length, serverAddress, PORT);
				socket.send(outputPackFile);

				// menu phia client
				System.out.println("\n------MENU------");
				System.out.println("1. In hoa tu trong file");
				System.out.println("2. Thoat");

				System.out.print("\nNhap lua chon: ");
				choice = sc.nextInt();
				String ch = String.valueOf(choice);

				if (choice == 1) {
					System.out.print("\nNhap tu can in hoa: ");
					sc = new Scanner(System.in);
					String letter = sc.nextLine();
					String request = String.valueOf(choice) + " " + letter;
					//gui lua chon cong viec va ky tu can in hoa den server
					byte[] outputByteRq = request.getBytes();
					DatagramPacket outputPackRq = new DatagramPacket(outputByteRq, outputByteRq.length, serverAddress, PORT);
					socket.send(outputPackRq);
				} else if (choice == 2) {
					// lua chon bang 2 thi ket thuc client
					byte[] outputByteCh = ch.getBytes();
					DatagramPacket outputPackCh = new DatagramPacket(outputByteCh, outputByteCh.length, serverAddress, PORT);
					socket.send(outputPackCh);
				} 
				//09_LuongHoangLong_16015921
				// nhan noi dung file tu server
				byte[] inputByteFile = new byte[60000];
				DatagramPacket inputPackFile = new DatagramPacket(inputByteFile, inputByteFile.length);
				socket.receive(inputPackFile);
				String inputStrFile = new String(inputPackFile.getData(), 0, inputPackFile.getLength());
				System.out.println("\nKet qua: \n" + inputStrFile);
			} while (choice != 2);
		} catch (IOException ex) {
			System.out.println("Loi Client: " + ex.toString());
		}
	}
	//ham kiem tra su ton tai cua file va thuoc tinh cua file
	private static boolean checkFile(String fileName) {
		boolean error = false;
		File file = new File(fileName);
		int maxLength = 64 * 1024;
		int fileLength = (int)file.length();

		if (fileLength > maxLength) {
			System.out.println("File qua lon");
			error = true;
		}
		if (!file.exists()) {
			System.out.println("File khong ton tai");
			error = true;
		}
		return error;
	} 
}
