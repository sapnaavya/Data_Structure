import java.util.*;
public class Solution {
       
          static void quickSort(int[] array, int left, int right) {
              if(right - left >= 2){
                  int pivot = partition(array, left, right);
                  quickSort(array, left, pivot);
                  quickSort(array, (pivot+1), right);
                  printArray(array, left, right);
              }
              
                    
       }  
    static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        ArrayList<Integer> smallerElem =  new ArrayList<Integer>();
        ArrayList<Integer> largerElem = new ArrayList<Integer>();
        for(int i=left+1; i<right; i++){
            if(arr[i]<pivot){
                smallerElem.add(arr[i]);
            }else{
                largerElem.add(arr[i]);
            }
        }
        for(int i=0; i<smallerElem.size(); i++){
            arr[left+i] = smallerElem.get(i);
        }
        arr[left + smallerElem.size()] = pivot;
        for(int i=0; i<largerElem.size();i++){
            arr[left + smallerElem.size() + i + 1 ] = largerElem.get(i);
        }
        return left+smallerElem.size();
    }
 
 static void printArray(int[] ar, int left, int right) {
         for(int i=left; i<right; i++){
             System.out.print(ar[i] + " ");
             }
             System.out.println(" ");

      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           quickSort(ar, 0, ar.length);
       }    
   }

