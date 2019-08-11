/**
 This code reverse a string in place.
 In Java, Strings are immutable.. thus, it is not possible to reverse the same string. 
 But, we can use StringBuilder or StringBuffer. So, essentially, we convert string to stringBuilder
 so that we can change the content of the string without creating new String Objects.
 So, it goes replaces first and endpart until it reaches the midpoint
 */
import java.util.Scanner;

public class ReverseString {

    public static void reverseStr(String str) {
        if(str == null) {
            return ;
        }
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        for(int i = 0; i < charArr.length/2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[len -i -1];
            charArr[len -i -1] = temp;
        }

        System.out.println(charArr);
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for(int i=0; i<length/2; i++) {
            char curr = sb.charAt(i);
            char end = sb.charAt(length - i - 1);
            sb.setCharAt(i, end);
            sb.setCharAt(length - i - 1, curr);
        }
        System.out.println(sb.toString());
        reverseStr(str);
        sc.close();
    }
}