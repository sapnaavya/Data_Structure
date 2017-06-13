import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numberCount[] = new int[100];
        //track the number count
        for(int i=0;i<n;i++)
        {
            int number = sc.nextInt();
            numberCount[number]+=1;
        }
       
        for(int i=0;i<100; i++){
            if(numberCount[i] != 0){
                {
                    for(int j=0; j<numberCount[i]; j++){
                        System.out.print(i+ " ");
                    }
                }
            }
        }
       }
    }
