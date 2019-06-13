/**
 * This code prints the fabonacci sum for a number using recursion and memoization techniques
 * Please remember that fibonacci series start from 0.
*/

import java.util.Scanner;
public class FibonacciSeries {
    //print fibonacci series using recursion
    public static int fibonacciSeries(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1 ;
        }
        int result = fibonacciSeries(n - 1) + fibonacciSeries(n - 2);
        return result;
    }
    //print fibonacci series using memoization
    public static int fibonacciMemoization(int n, int[] memo) { 
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        } else if(memo[n] > 0) {
            return memo[n];
        }
        memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
        return memo[n];
    }
    //print fibonacci series using bottomup approach
    public static int fibonacciBottomUp(int num) {
        if(num <=  0) {
            return 0;
        }
        if(num == 1) {
            return 1;
        }
        int[] bottomUp = new int[num + 1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;
        for(int i = 3; i <= num; i++) {
            bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
            
        }
        return bottomUp[num];
    }
     
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //Recursion
        int num = sc.nextInt();
        int result = fibonacciSeries(num);
        System.out.println(result);
        //Memoization
        int[] memo = new int[num + 1];
        int result1 = fibonacciMemoization(num, memo);
        System.out.println(result1); 
        //BottomUp
        int result2 = fibonacciBottomUp(num);
        System.out.println(result2);
        sc.close();
    }
}