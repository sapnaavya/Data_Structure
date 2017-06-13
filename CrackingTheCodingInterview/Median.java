import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size =  sc.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int median;
       // System.out.println("hello");
        
        if(array.length%2 == 0){
            median = (array[array.length/2] + array[(array.length/2) + 1])/2;
        }
        else{
            median = array[array.length/2];
            }
                    System.out.println(median);
    }
}

