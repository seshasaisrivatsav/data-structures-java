package test_pkg_2;

import test_pkg_1.Class_1;

public class Class_2 {

	public static void main(String[] args) {
		Class_2 c2 = new Class_2();
		c2.test_class_1();
	}
	
	void test_class_1() {
		Class_1 c1 = new Class_1();
		int x = c1.class_1_method_1();
		System.out.println(x);
		
	}

}
