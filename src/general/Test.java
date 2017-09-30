package general;

public class Test {

	int x = 3;
	public static void main(String[] args) {
		Test nan = new Test();
		nan.add(20);
		System.out.println(nan.add(20));
	}
	
	
	int add (int z) {
		z = z+z;
		return z;
	}
	
	
}
