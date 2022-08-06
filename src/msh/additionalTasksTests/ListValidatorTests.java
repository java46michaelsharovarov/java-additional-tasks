package msh.additionalTasksTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import msh.additionalTasks.ListValidator;
import msh.additionalTasks.Node;

class ListValidatorTests {

	Node n0 = new Node(0, null);
	Node n1 = new Node(1, null);
	Node n2 = new Node(2, null);
	Node n3 = new Node(3, null);
	Node n4 = new Node(4, null);
	Node n5 = new Node(5, null);
	Node n6 = new Node(6, null);
	Node n7 = new Node(7, null);
	Node n8 = new Node(8, null);
	Node n9 = new Node(9, null);
	
	
	@Test
	void isCircularTrueTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n3;
		assertTrue(ListValidator.isCircular(n0));	
	}
	
	@Test
	void isCircularFalseTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		assertFalse(ListValidator.isCircular(n0));	
	}
	
	@Test
	void indexOfCircularTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n3;		
		assertEquals(3, ListValidator.indexOfCircular(n0));	
	}
	
	@Test
	void indexOfCircularNotTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		assertEquals(-1, ListValidator.indexOfCircular(n0));	
	}
	
	@Test
	void indexOfCircularO_NTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n3;		
		assertEquals(3, ListValidator.indexOfCircularO_N(n0));	
	}
	
	@Test
	void indexOfCircularO_NNotTest() {
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;		
		assertEquals(-1, ListValidator.indexOfCircularO_N(n0));	
	}
}
