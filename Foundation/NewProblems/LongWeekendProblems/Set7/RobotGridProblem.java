/**
 * Problem Statement: A robot is located at the top-left corner of a m x n grid
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
    How many possible unique paths are there?
 * Reference: https://all4win78.wordpress.com/2016/07/05/leetcode-62-unique-paths/ 
 *            https://yucoding.blogspot.com/2013/04/leetcode-question-116-unique-path-i.html
 */
public class RobotGridProblem {

    // dynamic programming: function to calculate unique paths in a grid
    public static int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                paths[i][j] = paths[i][j-1] + paths[i-1][j];
            }
        }
        return paths[m-1][n-1];
    }

    // other approach to calculate unique paths
    public static int uniquePathOtherway(int m, int n) {
        if(m == 1 || n == 1) return 1;
        return nck(m+n-2, m-1);
    }

    public static int nck(int n, int k) {
        if(k == 0 || k == n) return 1;
        if(k == 1 || k == n-1) return n;
        int j = 1;
        int x = n;
        int ans = 1;
        for(int i = 0; i < k; i++) {
            ans = (ans*x)/j;
            j++;
            x--;
        }

        return ans;
    }

    // main method
    public static void main(String args[]) {
        int uniquePath = uniquePaths(3,4);
        int uniqPath = uniquePathOtherway(7,3);

        System.out.println(uniquePath);
        System.out.println(uniqPath);
    }
}