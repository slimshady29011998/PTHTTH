package viettus;

public class MultiImplement implements Runnable{
	public void run() {
		System.out.println("thread is running...");
	}
	public static void main(String[] args) {
		MultiImplement m1= new MultiImplement();
		Thread t1 = new Thread(m1);
		t1.start();
	}

}
