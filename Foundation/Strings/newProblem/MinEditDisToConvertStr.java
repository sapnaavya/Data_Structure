/**
 * This code calculates the minimum edit required to convert one string to another and 
 *  prints the changes required to convert string to another string
 *  References: 
 *      1. https://www.geeksforgeeks.org/print-all-possible-ways-to-convert-one-string-into-another-string-edit-distance/
 *      2. https://www.youtube.com/watch?time_continue=1466&v=b6AGUjqIPsA 
 */

import java.util.Scanner;

public class MinEditDisToConvertStr {
    static int dp[][];

    // Calculate DP Matrix to count minimum edit distance to convert one string to another
    public static void calculateDPMatrix(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        // intialize matirx with +1 to conside null also
        int[][] DP = new int[len1 + 1][len2 + 1];

        // initilize by the maximum edits possible 
        for (int i = 0; i <= len1; i++) 
            DP[i][0] = i; 
        for (int j = 0; j <= len2; j++) 
            DP[0][j] = j; 

        for(int i = 1; i <= len1 ; i++) {
            for(int j = 1; j <= len2; j++) {  
                if(str1.charAt(i-1) == str2.charAt(j-1)) { //Simply copy from diagonal
                    DP[i][j] = DP[i - 1][j - 1];
                } else {
                    DP[i][j] = min(DP[i][j - 1], DP[i - 1][j - 1], DP[i - 1][j]) + 1;
                }
            }
        }
        // initialize to global array
        dp = DP;
    }

    // Function to find the minimum of three 
	static int min(int a, int b, int c) 
	{ 
		int z = Math.min(a, b); 
		return Math.min(z, c); 
    }
    
    // function to print changes requred to convert str1 to str2 based on DP Matrix
    public static void printChanges(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();

        //check till the end
        while(i != 0 || j != 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            } //replace
            else if(dp[i][j] == dp[i - 1][j - 1] + 1) {
                System.out.println("Replace " +  s1.charAt(i - 1) + " with " +s2.charAt(j - 1));
                i--;
                j--;
            }  //remove
            else if (dp[i][j] == dp[i - 1][j] + 1) {
                System.out.println("Remove " + s1.charAt(i - 1));
                i--;
            } //add 
            else if(dp[i][j] == dp[i][j-1] + 1) {
                System.out.println("Add " + s2.charAt(j - 1));
                j--;
            }
        }
    }

    // main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string that needs to be change");
        String str1 = sc.nextLine();
        System.out.println("Enter string to compare with string");
        String str2 = sc.nextLine();
        calculateDPMatrix(str1, str2);
        System.out.println("Minimum changes required: " + dp[str1.length()][str2.length()]);
        printChanges(str1, str2);
        sc.close();
    }
}