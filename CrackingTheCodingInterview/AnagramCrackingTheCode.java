import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int[] ac = new int[26];
        int[] bc = new int[26];
        for(int i=0; i<a.length; i++){
            ac[a[i] -'a']++;
        }
        for(int i=0; i<b.length; i++){
            bc[b[i] - 'a']++;
        }
        int ans = 0;
        for(int i=0; i<ac.length; i++){
            ans += Math.abs(ac[i] - bc[i]);
        }
        
      return ans;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
