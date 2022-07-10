package msh.arrays;

public class AdditionalTasks {
	public static int maxSubsequenceLength(int[] ar) {
		int prevCount = 0;
		if (ar.length > 0) {
			int currCount = 1;
			for (int i = 1; i < ar.length; i++) {
				if (ar[i - 1] == ar[i]) {
					currCount = currCount + 1;
				} else {
					if(currCount > prevCount) {
						prevCount = currCount;
						currCount = 1;
					}
				}
			} 
			if(currCount > prevCount) {
				prevCount = currCount;
			}
		}
		return prevCount;
	}
}
