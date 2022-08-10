package msh.additionalTask6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredIterator<T> implements Iterator<T> {
	private Predicate<T> predicate;
	private Iterator<T> it;
	private T current;
	
	public FilteredIterator(Iterator<T> srcIterator, Predicate<T> filter) {	
		this.it = srcIterator;   
		this.predicate = filter;
		try {
			current = getNext();
		} catch (NoSuchElementException e) {
			current = null;
		}		
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		T next = current;
		try {
			current = getNext();
		} catch (NoSuchElementException e) {
			current = null;
		}
		return next;
	}

	private T getNext() {
		T current = it.next();
		while(it.hasNext()) {
			if(predicate.test(current)) {
				return current;
			} else {
				current = it.next();
			}			
		}
		return predicate.test(current) ? current : null;
	}
}
