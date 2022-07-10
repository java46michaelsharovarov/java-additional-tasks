package msh.arrays.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import msh.arrays.AdditionalTasks;
import msh.binary.NumberConvertor;

class AdditionalTasksTests {

	@Test
	void maxSubsequenceLength1() {
		int ar1[] = {};		
		assertEquals(0, AdditionalTasks.maxSubsequenceLength(ar1));
	}
	@Test
	void maxSubsequenceLength2() {
		int ar2[] = {1, 2, 3, 4, 5, 6, 7};
		assertEquals(1, AdditionalTasks.maxSubsequenceLength(ar2));
	}
	@Test
	void maxSubsequenceLength3() {
		int ar3[] = {1,3,3,2,8,8,8,5,6,6};
		assertEquals(3, AdditionalTasks.maxSubsequenceLength(ar3));
	}
	@Test
	void toBinaryStr() {
		int number = 2147483647;
		assertEquals(Integer.toBinaryString(number), NumberConvertor.toBinaryStr(number));
	}
}
