package msh.additionalTasks;

import java.util.ArrayList;

public class ListValidator {
	
	public static boolean isCircular (Node head) {
		ArrayList <Node> lockUpTable = new ArrayList<>();
		Node current = head;
		lockUpTable.add(current);
		while(current != null) {
			current = current.next;
			for(Node item: lockUpTable) {
				if(current == item) {
					return true;
				}
			}
			lockUpTable.add(current);
		}		
		return false;
    }
	
	public static int indexOfCircular (Node head) {
		ArrayList <Node> lockUpTable = new ArrayList<>();
		Node current = head;
		lockUpTable.add(current);
		while(current != null) {
			current = current.next;
			for(int i = 0; i < lockUpTable.size(); i++) {
				if(current == lockUpTable.get(i)) {
					return i;
				}
			}
			lockUpTable.add(current);
		}		
		return -1;
    }
	
	public static int indexOfCircularO_N (Node head) {
		int i = 0;
		Node current = head;
		Node tmp = null;
		Node itWas = new Node(888, null); //FIXME
		while(current != null) {
			if(current.next == itWas) {
				return current.value;
			}
			current.value = i++;
			tmp = current.next;
			current.next = itWas;
			current = tmp;			
		}
		return -1;
    }
}
