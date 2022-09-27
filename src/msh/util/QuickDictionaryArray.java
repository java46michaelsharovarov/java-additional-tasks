package msh.util;

public class QuickDictionaryArray {
	
	private static final int numOfChars = 26;
	private static Object[] dictionary = new Object[numOfChars];
	
	public static String put(String key, String value) {
		chekIllegalArgument(key);
		char[] charsOfKey = key.toUpperCase().toCharArray();	
		addValueByKey(dictionary, charsOfKey, value, 0);	
		return key.toUpperCase().concat("-").concat(value); 	
    }

	private static void addValueByKey(Object[] ar, char[] chars, Object value, int i) {
		if(i == chars.length) {
			ar[ar.length - 1] = value;
			return; 			
		}
		int charValue = chars[i] - 'A';
		if(ar[charValue] == null) {
			ar[charValue] = new Object[numOfChars + 1];
		}	
		addValueByKey((Object[]) ar[charValue], chars, value, ++i);		
	}

	public static String get(String key) {  
		chekIllegalArgument(key);
		char[] chars = key.toUpperCase().toCharArray();
    	return getValueByKey(dictionary, chars, 0);
    }

    private static String getValueByKey(Object[] ar, char[] chars, int i) {
    	if(i == chars.length) {
			return (String) ar[ar.length - 1];			
		}
		return getValueByKey((Object[]) ar[chars[i] - 'A'], chars, ++i);
	}

	private static void chekIllegalArgument(String key) {
		if(!key.matches("[A-Za-z]{1,20}")) {
			throw new IllegalArgumentException();
		}
	}
}
