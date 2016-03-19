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

	public ArrayPropertyTest(long seed) {
		array_set = new ArrayList<int[]>();	
		prng = new Random(seed);
	}

	public boolean generate_set(int cardinality) {

		int i;
		int j;
		int length;
		int modulus;

		length = 0;
		modulus = 1000;

		for (i = 0; i < cardinality; i++) {
			length = Math.abs(prng.nextInt()%modulus);
			System.out.printf("%d\n", length);
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

}
