/**
 * This code calculates longest common subsequence using two ways:
 * 1. Recursion
 * 2. BottomUp Approach
 * Please note that memoization approach is not implemented yet
 */
import java.util.Scanner;

public class LongestCommonSubsequence {

    //Recursive method to calculate the length of longest common subsequence
    public static int longestCommonSubsqRec(String str1, String str2, int i, int j) {
        if(i == 0 || j == 0) {
            return 0;
        }

        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return  1 + longestCommonSubsqRec(str1, str2, i - 1, j - 1);
        } else {
            return Math.max(longestCommonSubsqRec(str1, str2, i - 1, j), longestCommonSubsqRec(str1, str2, i, j - 1));
        }
    }

    //Pi Table approach to solve longest common subsequence
    public static int longestCommonSubPi(String str1, String str2, int m, int n) {
        int piTable [][] = new int[m + 1] [n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    piTable[i][j] = 0;
                } else if(str1.charAt(i - 1)  == str2.charAt(j - 1)) {
                    piTable[i][j] = piTable[i - 1][j - 1] + 1;
                } else {
                    piTable[i][j] = Math.max(piTable[i][j - 1], piTable[i - 1][j]);
                }
            }
        }
        return piTable[m][n];
    }
     
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        //calculate longest common subsequence using recursion
        int i = str1.length();
        int j = str2.length();

        int lengthLongestCommonRec = longestCommonSubsqRec(str1, str2, i, j);
        System.out.println(lengthLongestCommonRec);

        //calculate Longest common subsequence using bottom up approach
        int longestComSubseqPi = longestCommonSubPi(str1, str2, i, j);
        System.out.println(longestComSubseqPi);

        sc.close();
    }
    
}