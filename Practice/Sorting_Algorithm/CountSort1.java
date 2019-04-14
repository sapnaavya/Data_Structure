import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numberCount[] = new int[100];
        //track the number count
        for(int i=0;i<n;i++)
        {
            int number = sc.nextInt();
            numberCount[number]+=1;
        }
        //print number count
        for(int i=0;i<numberCount.length;i++)
        {
            System.out.print(numberCount[i]+" ");
        }
       }

}
