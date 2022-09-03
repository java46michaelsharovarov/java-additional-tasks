package msh.utils;

public interface MyPredicate<T> {		
	
	boolean test(T t);
	
	default MyPredicate<T> negate(){
		return t -> ! test(t);
	}
	
	default MyPredicate<T> add(MyPredicate<T> p){		
		return t -> test(t) && p.test(t);
	}

	default MyPredicate<T> or(MyPredicate<T> p) {
		return t -> test(t) || p.test(t);
	}

	static MyPredicate<Integer> isEqual(Integer obj) {
		return t -> obj.equals(t);
	}

	static MyPredicate<Integer> not(MyPredicate<Integer> p) {
		return t -> ! p.test(t);
	}
}
