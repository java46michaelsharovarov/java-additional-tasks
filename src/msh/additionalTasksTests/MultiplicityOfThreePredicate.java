package msh.additionalTasksTests;

import java.util.function.Predicate;

public class MultiplicityOfThreePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return i % 3 == 0;
	}

}