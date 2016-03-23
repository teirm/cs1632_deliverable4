/* Author: Cyrus Ramavarapu
Date: 18 MARCH 2016
Purpose: Check Properties of Arrays
Invariants: 
	Length
	Element Type
	Class Type
*/

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.mockito.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayPropertyTest {

	ArrayList<int[]> array_set;
	Random prng;

	public boolean generate_set(int cardinality) {

		int i;
		int j;
		int length;
		int modulus;

		length = 0;
		modulus = 100000;

		for (i = 0; i < cardinality; i++) {
			length = Math.abs(prng.nextInt()%modulus);
			int[] a = new int[length];
			
			for (j = 0; j < a.length; j++) {
				a[j] = prng.nextInt();
			}	
			
			array_set.add(a);	
		}
	
		return true;	
	}	

	public void print_set() {
		for (int[] element: array_set) {
			System.out.printf("%s\n", Arrays.toString(element));
		}
	}

	@Before
	public void setup() throws Exception {
		
		int cardinality;
		long time;

		cardinality = 1000;
		time = System.currentTimeMillis();
		prng = new Random(time);
		array_set = new ArrayList<int[]>();
		generate_set(cardinality);	
	}


	@After
	public void teardown() throws Exception {
		
		array_set = null;
	}

	/* Check that class type is invariant upon 
	   sorting an array */

	@Test
	public void checkClassType() {

		for (int[] element: array_set) {
			Arrays.sort(element);
			assertTrue(element instanceof int[]);
		}
	}
	
	/* Check that length is invariant upon
	   sorting an array */
	@Test
	public void checkLength() {
		
		int initial_length = 0;
		int final_length = 0;

		for (int[] element: array_set) {
			initial_length = element.length;
			Arrays.sort(element);
			final_length = element.length;
			assertEquals(initial_length, final_length);
		}
	}


	/* A test to check that Arrays.sort() sorts arrays
	   into ascending order */
	@Test
	public void checkSorted() {
		
		int i;

		int initial_length = 0;
		int final_length = 0;

		for (int[] element: array_set) {
			Arrays.sort(element);
			
			for (i = 0; i < element.length-1; i++) {
				assertTrue(element[i] <= element[i+1]);	
			}	
		}
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("ArrayPropertyTest");
	}

}
