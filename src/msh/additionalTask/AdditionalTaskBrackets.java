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
		return i == 0;
	}
	
/*******************hasValidBrackets with indexOf**********************************/
//	public static boolean hasValidBrackets(String text) {
//		char[] bracketsArray = new char [text.length()];
//		int i = 0;
//		String openBrackets = "([{";
//		String closeBrackets = ")]}";
//		for (char c : text.toCharArray()) {
//			if (openBrackets.indexOf(c) >= 0) {
//				bracketsArray[++i] = c;
//			} else if (closeBrackets.indexOf(c) >= 0) {
//				if (openBrackets.indexOf(bracketsArray[i]) == closeBrackets.indexOf(c)) {
//					i--;
//				} else {
//					return false;
//				}
//			}	
//		}
//		return i == 0;
//	}
}
                                                            