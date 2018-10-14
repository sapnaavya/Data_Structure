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
        for(int i = 0; i < arr.length; i++){
          int counter = 0;
            for (int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    counter++;
                }
            }
          
          if(arr[i] == counter){
            return arr[i];
          }
        }
        return -1;
    }
  
}
