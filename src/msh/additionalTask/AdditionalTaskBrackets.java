package msh.additionalTask;

public class AdditionalTaskBrackets {
	public static boolean hasValidBrackets(String text) {
		char[] bracketsArray = new char [text.length()];
		int i = 0;
		for (char c : text.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				bracketsArray[++i] = c;
			} else if (c == ')') {
				if (bracketsArray[i] == '(') {
					i--;
				} else {
					return false;
				}
			} else if (c == ']' || c == '}') {
				if (bracketsArray[i] == c - 2) {
					i--;
				} else {
					return false;
				}
			}	
		}
		return i == 0 ? true : false;
	}
}
