
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirstThread ft = new FirstThread();
ft.start();
SecondThread st = new SecondThread();
st.start();
	}

}
