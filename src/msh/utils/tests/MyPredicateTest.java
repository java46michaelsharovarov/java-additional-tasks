package msh.utils.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import msh.utils.MyPredicate;

class MyPredicateTest {

	MyPredicate<Integer> MyEvenPredicate = e -> e % 2 == 0;
	MyPredicate<Integer> MyTruePredicate = e -> true;
	
	MyPredicate<Integer> p1 = MyEvenPredicate;
	MyPredicate<Integer> p2 = MyTruePredicate;
	
	@Test
	void negateTest() {
		assertTrue(p1.test(2));
		assertFalse(p1.test(3));
		
		MyPredicate<Integer> p2 = p1.negate(); // odd predicate
		assertFalse(p2.test(2));
		assertTrue(p2.test(3));
		
		MyPredicate<Integer> p3 = p2.negate(); // even predicate
		assertTrue(p3.test(2));
		assertFalse(p3.test(3));
	}
	
	@Test
	void addTest() {
		MyPredicate<Integer> p3 = p1.add(p2);
		assertTrue(p3.test(2));
		assertFalse(p3.test(3));
	}
	
	@Test
	void orTest() {
		MyPredicate<Integer> p3 = p1.or(p2);
		assertTrue(p3.test(2));
		assertTrue(p3.test(3));
	}
	
	@Test
	void isEqualTest() {
		Integer obj = 555;
		Integer obj1 = 555;
		Integer obj2 = 333;
		MyPredicate<Integer> p4 = MyPredicate.isEqual(obj);
		assertTrue(obj == obj1);
		assertTrue(p4.test(obj1));
		assertFalse(p4.test(obj2));
	}
	
	@Test
	void notTest() {
		MyPredicate<Integer> p4 = MyPredicate.not(p1);
		assertTrue(p4.test(3));
		assertFalse(p4.test(2));
	}

}

	


