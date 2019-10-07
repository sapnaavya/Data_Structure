
/*
 * This code counts the distinct occurances of a subsequence
 * Reference: https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
 * Example:
 *  Input  : S = banana, T = ban
    Output : 3
    T appears in S as below three subsequences.
    [ban], [ba  n], [b   an]

*/

public class CountDistinctSubseq {

    // recursive function to count distinct occurances of a subsequence
    public static int countDisSubseq(String superStr, int i, String subStr, int j) {
        // base case 1
        if ((i == 0 && j == 0) || j == 0) 
        return 1; 
  

        // base case 2
        if(i == 0) {
            return 0;
        }

        if(superStr.charAt(i - 1) != subStr.charAt(j - 1)) {
            return countDisSubseq(superStr, i - 1, subStr, j);
        } else {
            return (countDisSubseq(superStr, i - 1, subStr, j - 1) + countDisSubseq(superStr, i - 1, subStr, j));
        }
    }

    // function to count distint occurances of subsequence
    public static int findSubsequenceCount(String superStr, String subStr) {
        int m = subStr.length();
        int n = superStr.length();
        if(m > n) {
            return 0;
        }
        
        int[][] mat = new int[m + 1][n + 1];

        // Initializing first column with 
		// all 0s. An empty string can't have 
		// another string as subsequence 
        for(int i = 1; i <= m; i++) {
            mat[i][0] = 0;
        }

        // Initializing first row with all 1s. 
		// An empty string is subsequence of all. 
        for(int j = 0; j <= n; j++) {
            mat[0][j] = 1;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(subStr.charAt(i - 1) != superStr.charAt(j - 1)) {
                    mat[i][j] = mat[i][j - 1];
                } else {
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
                }
            }
        }

        return mat[m][n];
    }

    // main method 
    public static void main(String args[]) {
        String T = "bag"; 
		String S = "babag"; 
        System.out.println(findSubsequenceCount(S, T)); 
        int i = S.length();
        int j = T.length();
        System.out.println(countDisSubseq(S, i, T, j));
    }
}