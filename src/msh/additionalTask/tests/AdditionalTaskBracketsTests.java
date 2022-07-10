package msh.additionalTask.tests;

import static org.junit.jupiter.api.Assertions.*;
import static msh.additionalTask.AdditionalTaskBrackets.*;
import org.junit.jupiter.api.Test;

class AdditionalTaskBracketsTests {

	@Test
	void hasValidBracketsTrue() {
		assertTrue(hasValidBrackets("aaaaaa (sdfsdfdsf[dfd(f)f] zcvzxcv {{[ghjk]}} asd )"));
	}
	@Test
	void hasValidBracketsFalse() {
		assertFalse(hasValidBrackets(")dfgswfgsf("));
		assertFalse(hasValidBrackets("[werwert(wertwrtw] wertrt)"));
	}
}
