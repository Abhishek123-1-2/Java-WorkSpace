//Exception-It is a runtime anamoly
public class Tester {
		public static void fn1() throws InterruptedException {
			fn2();
		}
	
		public static void fn2() throws InterruptedException {
			Thread.sleep(100);
			System.out.println("fn2..");
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	fn1();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
