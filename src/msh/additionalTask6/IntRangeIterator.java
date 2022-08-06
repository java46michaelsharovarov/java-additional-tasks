package msh.additionalTask6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRangeIterator implements Iterator<Integer> {
	int max;
	int nextValue;
		
	public IntRangeIterator(int min, int max) {		
		super();
		if (max < min || max + 1 <= min) { // avoid invalid order and overflow
			throw new IllegalArgumentException();
		}
		this.nextValue = min;
		this.max = max;
	}

	@Override
	public boolean hasNext() {		
		return nextValue < max;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return nextValue++;
	}
}
