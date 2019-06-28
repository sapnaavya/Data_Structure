/**
 * This code prints the frequency of each character in string using character arrays and integer arrays
 * Make sure to convert string to lowercase before doing any operations
 * Make sure not to give any special characters or spaces in the optimized code as it can only store charcters
 * 
 * Assumption for optimized code: 
    * In the optimization code, space between the strings wont work as it only takes 26 characters
    * and we are mapping every charcter to 'a' using subraction. Since, space is separate ascci value it will try to subtract from 'a'
    * the value will be something like 32 - 97 = -65. So, it will show index out of bound exception as our array size if 26
    * So, make sure to not give spaces or any special characters or '\t' withing words or characters in optimize code 
    * as our array size is 26 only it can only store chacters not any special characters
 * */
import java.util.Scanner;

public class PrintFrequency {

    public static void printFrquency(char [] charArray) {
        if(charArray == null || charArray.length == 0) {
            return;
        }
        int[] arr = new int[128];
        for(int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            //convert to lowercase first before storing as upper case and lowercase both will have diffrent ASCII Value
            ch = Character.toLowerCase(ch);
            arr[ch]++;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    //print frequency using optimization
    /*
    Basically, here we are taking 128 size integer array to store 26 characters. Instead, take only 26 size array and 
    do the mapping of 'a' with every character by subtracting every character from 'a'. This way, you only need to take 
    26 size array
    */

    public static void countFrquencyOptimize(char[] charArray) {
        if(charArray == null || charArray.length == 0) {
            return;
        }
        int[] arr = new int[26];
        for(int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            //convert to lowercase first before storing as upper case and lowercase both will have diffrent ASCII Value
            ch = Character.toLowerCase(ch);
            arr[ch - 'a']++;
        } 
        System.out.println("frequency of each chacter:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        char[] charArray = str.toCharArray();
        printFrquency(charArray);
        System.out.println();
        countFrquencyOptimize(charArray);
        sc.close();
    }
}