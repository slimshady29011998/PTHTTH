package bai1;

public class Run extends Thread{
	public static void main(String[] args) {
	FileTWrite f1 = new FileTWrite();
	FileTWrite f2 = new FileTWrite();
	FileTWrite f3 = new FileTWrite();
	f1.start();
	f2.start();
	f3.start();
}
}
