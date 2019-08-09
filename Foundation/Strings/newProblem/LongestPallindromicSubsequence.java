/*
 *
 * This code finds the longest pallindromic subsequence in this string
 *  Time complexity - O(n*n)
 *  Space complexity - O(n*n)
 *  Youtube link - https://youtu.be/_nCsPn7_OgI
 *  Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
*/

public class LongestPallindromicSubsequence {

    // function to count longest pallindromic subsequence using Dynamic Programming
    public int countLongestPalSubseq(char[] str) {
        int T[][] = new int[str.length][str.length];
        for(int i = 0; i < str.length; i++) {
            T[i][i] = 1;
        }

        int n = str.length;
        for(int l = 2; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]) {
                    T[i][j] = 2;
                } else if(str[i] == str[j]) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else {
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length - 1];
    }

    //function to calculate longest pallindromic subsequence using recursion
    public int countLongestSubSequence(char[] str, int start, int len) {
        if(len == 1) {
            return 1;
        }
        if(len == 0) {
            return 0;
        }
        if(str[start] == str[start + len -  1]) {
            return 2 + countLongestSubSequence(str, start + 1, len - 2);
        } else {
            return Math.max(countLongestSubSequence(str, start + 1, len - 1), countLongestSubSequence(str, start, len - 1));
        }
    }

    //main method 
    public static void main(String args[]) {
        LongestPallindromicSubsequence lps = new LongestPallindromicSubsequence();
        String str1 = "abbdcacb";
        int longestSubseqCount = lps.countLongestPalSubseq(str1.toCharArray());
        int longestSubseqCountRecur = lps.countLongestSubSequence(str1.toCharArray(), 0, str1.length());
        System.out.println(longestSubseqCountRecur);
        System.out.println(longestSubseqCount);
    }
}