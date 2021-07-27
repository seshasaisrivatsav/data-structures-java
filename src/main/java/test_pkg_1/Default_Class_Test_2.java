package test_pkg_1;

public class Default_Class_Test_2 {

	// default access for class only happens in same package!
	
	// Protected and Private are not availablt at class level
	
	int returnValues() {
		Default_Class_Test d = new Default_Class_Test();
		return d.returnVal();
	}
}
