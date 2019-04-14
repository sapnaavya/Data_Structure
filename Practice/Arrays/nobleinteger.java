// Find the number of integer greater than or equal to a value

import java.lang.Math; // headers MUST be above the first class
import java.util.*;
// one class needs to have a main() method
public class NobleInteger{
    public static void main (String args[]){
       // int[] arr = {1,2,1,3};
       int[] arr = {10,20,3,40,2};
        int res = findNoble(arr);
        if(res != -1){
            System.out.println("the noble integer " + res);
        }
        else{
            System.out.println("no noble integer found");
        }
    }

    public static int findNoble(int arr[]){
        Arrays.sort(arr);
        int n = arr.length;
         for (int i = 0; i <= n-1; i++){
            if(arr[i] == arr[i+1]){
                continue;
            }
            if(arr[i] == n-i-1){
                return arr[i];
            }
        }

        if(arr[n-1] == 0){
            return arr[n-1];
        }
      return n-1;
    }
  
}
