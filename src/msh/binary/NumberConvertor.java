package msh.binary;

public class NumberConvertor {
	  public static String toBinaryStr(int number) {
		long remains = 0;
		String resStr = new String();
		do{
			remains = number % 2;
			number /= 2;
			resStr = String.valueOf(remains) + resStr;
		}while(number != 0);
		return resStr;
	  }
}
