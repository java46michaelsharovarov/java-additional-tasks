package msh.additionalTasksTests;

import java.util.function.Predicate;

public class EvenPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return i % 2 == 0;
	}

}