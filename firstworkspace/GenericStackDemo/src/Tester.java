class Stack<G>{
	private int size;
	private int top;
	private G arr[];
	
	public Stack()
{size=5;
		top=-1;
		arr=(G[])new Object[size];
		}
	public Stack(int s) {
		size=s;
		top=-1;
		arr=(G[])new Object[size];
	}
	public void push(G val) throws Exception {
		
		if(!isFull()) {
			arr[++top] = val;
		}else {
			throw new Exception("Overflow..!");
		}
	}
	public G pop() throws Exception {
		if(!isEmpty()) {
			return arr[top--];
		}else {
			throw new Exception("Underflow..!");
		}
	}
	public boolean isFull() {
		return top==size-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public void display1() {
		for(int i=0;i<=top;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void display2() {
		for(int i=0;i<=top;i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
	
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
Stack <Integer>s1 = new Stack<>(10);
s1.push(12);
s1.push(24);
s1.push(36);
s1.push(123);
s1.push(23);
s1.push(63);
s1.display1();
		}catch(Exception e) {
			System.out.println(e);
		}
	
	try {
		Stack <String>s2 = new Stack<>();
		s2.push("Infy");
		s2.push("Mindcraft");
		s2.push("CapeGemini");
		s2.push("TCS");
		s2.display2();
	}catch(Exception e) {
		System.out.println(e);
	}

	}
}
