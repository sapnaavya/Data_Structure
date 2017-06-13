import java.util.*;
public class Solution {
       
          static void partition(int[] ar, int left, int right) {
              int pivot = ar[left];
              ArrayList <Integer> smallerElement = new ArrayList<>(ar.length);
              ArrayList <Integer> largerElement =  new ArrayList<>(ar.length);
              for(int i = left+1; i<right; i++ ){
                  if(ar[i] < pivot){
                      smallerElement.add(ar[i]);
                  }else{
                      largerElement.add(ar[i]);
                  }
                }
              for(int i=0; i<smallerElement.size();i++){
                  ar[left+i] = smallerElement.get(i);
              }
              ar[left+smallerElement.size()] = pivot;
              for(int i=0; i<largerElement.size(); i++){
                  ar[left+smallerElement.size() + 1+ i] = largerElement.get(i);
              }     
       }   
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar, 0, ar.length);
           printArray(ar);
       }    
   }

