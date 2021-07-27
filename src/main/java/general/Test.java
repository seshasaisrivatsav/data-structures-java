package general;

public class Test {

	int x = 3;
	public static void main(String[] args) {
		Test nan = new Test();
		nan.add(20);
		//System.out.println(nan.add(20));
		
		String s = "12312312.csv";
		
		System.out.println(s.replaceAll(".csv", ""));
	}
	
	
	int add (int z) {
		z = z+z;
		return z;
	}
	
	
}
