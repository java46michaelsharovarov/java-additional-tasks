package msh.additionalTasksTests;

import java.util.function.Predicate;

public class AllTruePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer i) {
		return true;
	}

}