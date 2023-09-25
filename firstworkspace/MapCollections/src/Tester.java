import java.util.*;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map<Integer,String> m1 = new LinkedHashMap<>();
m1.put(345,"Raja");
m1.put(314, "Abhishek");
m1.put(421,"Radhika");
m1.put(300,"Rukmani");
System.out.println(m1);
Set<Integer> k =m1.keySet();
System.out.println(k);
for(Integer keys:k) {
	System.out.println(m1.get(keys));
}
}
}
