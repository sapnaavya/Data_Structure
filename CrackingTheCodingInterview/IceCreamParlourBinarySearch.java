import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashMap;

public class Solution{
    public static void main(String arga[]){
         Scanner sc = new Scanner(System.in);
              int T = sc.nextInt();
              for (int k = 0; k < T; k++) {
                     int M = sc.nextInt();
                     int N = sc.nextInt();

                     int[] Cost = new int[N];
                     // get the cost
                     for (int index = 0; index < N; index++)
                           Cost[index] = sc.nextInt();

                     for (int i = 0; i < N; i++) {
                           for (int j = i; j < N; j++) {
                                  if (i == j)
                                         continue;
                                  else {
                                         if (Cost[i] + Cost[j] > M)
                                                continue;
                                         else if (Cost[i] + Cost[j] == M) {
                                         System.out.println((i+1) + " " + (j+1));
                                         }
                                  }
                           }

                     }

              }
              sc.close();
    }
    
}
