/**
 * This code calculates the length of longest common substring in java.
 */
import java.util.Scanner;

public class LongestCommonSubsequenceMemo {

    //Calculate length of longest common subsequence using memoization
    public static int longestCommonSubsequence(String str1, String str2, int i, int j, int [][] memo) {
        if(i == 0 || j == 0) {
            return 0;
        }
        if(memo[i - 1][j - 1] > 0) {
            return memo[i - 1][j - 1];
        }
        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            memo[i - 1][j - 1] = 1 + longestCommonSubsequence(str1, str2, i - 1, j - 1, memo);             
        } else {
            memo[i - 1][j - 1] = Math.max(longestCommonSubsequence(str1, str2, i - 1, j, memo), longestCommonSubsequence(str1, str2, i, j - 1, memo));
        }
        return memo[i - 1][j - 1];
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int i = str1.length();
        int j = str2.length();
        int[][] memo = new int[i][j];
        int longestCommomSubseqMemo = longestCommonSubsequence(str1, str2, str1.length(), str2.length(), memo);
        System.out.println(longestCommomSubseqMemo);
        sc.close();
    }
    
}