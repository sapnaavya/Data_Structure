/*
    This function returns the length of longest common substring in two ways:
    1. Using recursive
    2. Using iterative manner
*/
import java.util.Scanner;

public class LongestCommonSubstring {

    // Recursive function to get length of longest common substring 
    public static int longestCommonSubstring(String str1, String str2, int i, int j, int count) {
        if(i == 0 || j == 0) {
            return count;
        }
        
        if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
            count = longestCommonSubstring(str1, str2, i-1, j-1, count+1);
        } else {
            count = Math.max(count, Math.max(longestCommonSubstring(str1, str2, i-1, j, 0), longestCommonSubstring(str1, str2, i, j-1, 0)));
        }

        return count;
    }

    // Iterative function to calculate longest common substring
    public static int longestCommonSubstringIter(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) {
            return 0;
        }
        if(str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int m = str1.length();
        int n = str2.length();
        int[][] lcsArr = new int[m + 1][n + 1];
        int result = 0;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0){
                    lcsArr[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcsArr[i][j] = lcsArr[i-1][j-1] + 1;
                    result = Math.max(result, lcsArr[i][j]);
                } else {
                    lcsArr[i][j] = 0;
                }
            }
        }

        return result;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int count = 0;
        int len = longestCommonSubstring(str1, str2, len1, len2, count);
        System.out.println("length of longest common substring: " + len);
        System.out.print("\n");
        int commonSubstrlen = longestCommonSubstringIter(str1, str2);
        System.out.println("length of longest common substring(Iterative): " + commonSubstrlen);
        sc.close();
    }
}