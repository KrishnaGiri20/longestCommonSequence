public class Main{
	public static void main(String[] args){
		LongestCommonSequence lcs = new LongestCommonSequence();
		String input1 = "abcdgh";
		String input2 = "abedfhe";
		System.out.println("recursive aproach solution"+lcs.recursiveLCS(input1, input2, input1.length(), input2.length()));

		int m = input1.length();
		int n = input2.length();
		// LongestCommonSequence lcsMemoize = new LongestCommonSequence(m+1, n+1);

		System.out.println("memoization approach solution" + lcs.memoizeLCS(input1, input2, m,n));
		System.out.println("Top Down approach solution" + lcs.topDownLCS(input1, input2, m,n));

		
	}
}
