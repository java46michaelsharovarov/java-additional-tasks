package msh.additionalTask;

public class AdditionalTaskBrackets {
	public static boolean hasValidBrackets(String text) {
	     char str[] = text.toCharArray();
	     boolean res = true;
	     char closeSymb = 0;
	     for(int i = 0; i < str.length; i++) {
	    	 if(str[i] == '(' || str[i] == '[' || str[i] == '{') {
	    		 res = hasCloseBracket(str, str[i], i, closeSymb);
	    		 if(!res) {
	    			 return res;
	    		 }
	    	 }
	     }
		return res;
	}

	private static boolean hasCloseBracket(char[] str, char symb, int index, char prevCloseSymb) {
		char closeSymb;
		boolean res = false;
		closeSymb = symb == '(' ? ')' : symb == '[' ? ']' : '}';
		for(int i = index + 1; i < str.length; i++) {
			if(str[i] == closeSymb) {
				return true;
			} else if(str[i] == '(' || str[i] == '[' || str[i] == '{') {
				res = hasCloseBracket(str, str[i], i, closeSymb);
	    		 if(!res) {
	    			 return res;
	    		 }
			} else if (str[i] == prevCloseSymb) {
				return res;
			}
		}
		return res;
	}
}
