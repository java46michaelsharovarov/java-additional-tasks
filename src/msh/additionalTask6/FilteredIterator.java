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
		this.current = it.next();
	}

	@Override
	public boolean hasNext() {
		return this.current != null;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		T next = this.current;
		this.current = getNext(it.next());
		return next;
	}

	private T getNext(T current) {
		while(it.hasNext()) {
			if(predicate.test(current)) {
				return current;
			} else {
				current = it.next();
			}			
		}
		return null;
	}
}
