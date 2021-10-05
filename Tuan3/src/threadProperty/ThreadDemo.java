package threadProperty;

public class ThreadDemo {
	public static void main(String[] args) {
	Thread t = Thread.currentThread();
	t.setName("My Thread");
	System.out.println("Thread hien tai:"+t);
	try {
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
		}
		Thread.sleep(1000);
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}

}
