import java.io.*;

class Solution{
 static void printPascal(int n){
  for(int line=0; line<n; line++){
    for(int i=0; i<=line; i++){
      System.out.print(binomialCoefficient(line, i)+ " ");
      System.out.println();
    }
  }
 }

 static int binomialCoefficient(int n, int k){
  int res = 1;

  if(k > n-k){
    k = n-k;
  }
  for(int i=0; i<k; i++){
    res *= (n-i);
    res /= (i+1);
  }
  return res;
 }
  public static void main(String args[]){
      int n = 7;
      printPascal(7);
  }
}
