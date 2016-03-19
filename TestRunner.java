/* Author: Cyrus Ramavarapu
Date: 18 March 2016
Purpose: A driver for ArrayPropertyTest */

public class TestRunner {

	public static void main (String[] args) {

		int cardinality;	
		long time;

		cardinality = 100;
		time = System.currentTimeMillis();
		ArrayPropertyTest test_set = new ArrayPropertyTest(time);
		
		test_set.generate_set(cardinality);

		test_set.print_set();	
	}
}