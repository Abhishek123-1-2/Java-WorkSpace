class FirstThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Hi..");
			try {
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}
	}
}
class SecondThread extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Hello...");
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				
			}
		}
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirstThread ft= new FirstThread();
ft.start();
SecondThread st = new SecondThread();
st.start();
	}

}
