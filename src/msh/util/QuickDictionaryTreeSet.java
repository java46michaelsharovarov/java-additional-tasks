package msh.util;

import java.util.SortedSet;
import java.util.TreeSet;

public class QuickDictionaryTreeSet {	
	
	private static TreeSet<String> myDict = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); 
	
	public static String put(String key, String value) {
		chekIllegalArgument(key);
		String couple = key.toUpperCase().concat("-").concat(value);
		myDict.add(couple);
		return couple;
    }

	public static String get(String key) {  
		chekIllegalArgument(key);
		SortedSet<String> set = myDict.subSet(key, getLimiterForSubSet(key));
    	String str = set.first();
    	String[] res = str.split("-");
    	return res[1];
    }

	private static String getLimiterForSubSet(String key) {
		char lastChar  = (char) (key.charAt(key.length() - 1) + 1);
		return key.substring(0, key.length() - 1) + lastChar;
	}

    private static void chekIllegalArgument(String key) {
		if(!key.matches("[A-Za-z]{1,20}")) {
			throw new IllegalArgumentException();
		}
	}
}
