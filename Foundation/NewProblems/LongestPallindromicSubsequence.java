/*
 *
 * This code finds the longest pallindromic subsequence in this string
 *  Time complexity - O(n*n)
 *  Space complexity - O(n*n)
 *  Youtube link - https://youtu.be/_nCsPn7_OgI
 *  Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
 *  if the given sequence is "BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. 
 *  “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
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
        // Base Case 1: If there is only 1 character 
        if(start == len) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same  
        if (str[start] == str[len] && start + 1 == len) { 
            return 2; 
        } 

        if(str[start] == str[len]) {
            return 2 + countLongestSubSequence(str, start + 1, len - 1);
        } else {
            return Math.max(countLongestSubSequence(str, start + 1, len), countLongestSubSequence(str, start, len - 1));
        }
    }

    //main method 
    public static void main(String args[]) { 
        LongestPallindromicSubsequence lps = new LongestPallindromicSubsequence();
        String str1 = "sapn";
        int longestSubseqCount = lps.countLongestPalSubseq(str1.toCharArray());
        int n = str1.length() - 1;
        int longestSubseqCountRecur = lps.countLongestSubSequence(str1.toCharArray(), 0, n);
        System.out.println(longestSubseqCountRecur);
        System.out.println(longestSubseqCount);
    }
} 