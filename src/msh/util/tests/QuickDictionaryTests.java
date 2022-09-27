package msh.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static msh.util.QuickDictionaryArray.*;
//import static msh.util.QuickDictionaryTreeSet.*;

class QuickDictionaryTests {

	@Test
	void putTest() {
		assertEquals("A-А", put("A", "А"));
		assertEquals("HELL-Ад", put("Hell", "Ад"));
		assertEquals("HELLO-Здравствуйте", put("Hello", "Здравствуйте"));
		assertEquals("HELP-Помощь", put("Help", "Помощь"));
	}
	
	@Test
	void getTest() {
		assertThrows(IllegalArgumentException.class, () -> get("aaaaaaaaaaaaaaaaaaaaa"));
		assertThrows(IllegalArgumentException.class, () -> get("Hel2o"));
		assertEquals("А", get("A"));
		assertEquals("Ад", get("Hell"));
		assertEquals("Здравствуйте", get("Hello"));
		assertEquals("Помощь", get("Help"));
	}

}
