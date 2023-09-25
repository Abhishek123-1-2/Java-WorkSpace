class FirstThread extends Thread {
	public void run() {
		
     for(int i=0;i<100;i++) {
	System.out.println("Hello..");	
	}
}
class SecondThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Hi...");
		}
	}
}

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirstThread ft = new FirstThread();
ft.start();

	}

}
}
