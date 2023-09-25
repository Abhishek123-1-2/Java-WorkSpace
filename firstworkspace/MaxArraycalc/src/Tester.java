
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[] = {1,2,3,4,5,6,7,8,9,100,2,600,6,4,0};
int min = a[0];
for(int i=0;i<a.length;i++) {
	if(a[i]<min) {
		min=a[i];
		i++;
	}
	
}
System.out.println(min);
	}

}
