package msh.additionalTasksTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import msh.additionalTask6.FilteredIterator;
import msh.additionalTask6.IntRangeIterator;

class FilteredIteratorTests {

//	@Test
//	void emptyFilteredIteratorTest() {
//		Integer [] expected = new Integer[0];
//		assertArrayEquals(expected , getResult(new IntRangeIterator(0, 0), new AllTruePredicate()));
//	}
//	
//	@Test
//	void oneUnfilteredFilteredIteratorTest() {
//		Integer [] expected = new Integer[0];
//		assertArrayEquals(expected , getResult(new IntRangeIterator(1, 2), new EvenPredicate()));
//	}
//	
//	@Test
//	void allFilteredIteratorTest() {
//		Integer [] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		assertArrayEquals(expected , getResult(new IntRangeIterator(0, 10), new AllTruePredicate()));
//	}
	
	@Test
	void firstAndLastFilteredIteratorTest() {
		Integer [] expected = {0, 2, 4, 6, 8, 10};
		assertArrayEquals(expected , getResult(new IntRangeIterator(0, 11), new EvenPredicate()));
	}
	
//	@Test
//	void firstAndNotLastFilteredIteratorTest() {
//		Integer [] expected = {0, 2, 4, 6, 8};
//		assertArrayEquals(expected , getResult(new IntRangeIterator(0, 10), new EvenPredicate()));
//	}
//	
//	@Test
//	void notFirstAndLastFilteredIteratorTest() {
//		Integer [] expected = {2, 4, 6, 8, 10};
//		assertArrayEquals(expected , getResult(new IntRangeIterator(1, 11), new EvenPredicate()));
//	}
//	
//	@Test
//	void notFirstAndNotLastFilteredIteratorTest() {
//		Integer [] expected = {2, 4, 6, 8};
//		assertArrayEquals(expected , getResult(new IntRangeIterator(1, 10), new EvenPredicate()));
//	}
	
//	@Test
//	void nullSupportFilteredIteratorTest() {
//		int [] expected = new int[0];
//		assertArrayEquals(expected , getResult(new IntRangeIterator(1, 2), new AllTruePredicate()));
//	}

	private Integer[] getResult(Iterator<Integer> srcIterator, Predicate<Integer> predicate) {
		FilteredIterator<Integer> fltIter = new FilteredIterator<>(srcIterator, predicate);
		if (!fltIter.hasNext()) {
			return new Integer[0];
		}
		ArrayList<Integer> arRes = new ArrayList<>();
		while(fltIter.hasNext()) {
			arRes.add(fltIter.next());
		}
		return arRes.toArray(new Integer[0]);
	}	

}
