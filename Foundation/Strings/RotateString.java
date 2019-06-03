/**
 This code performs below three operations:
 
 1. Left Rotate a String
 2. Right rotate a string
 3. Print all rotations of a string

 Please remember that we can rotate a string upto n-1 times as in n rotation string would be same.
*/
import java.util.Scanner;
import java.util.ArrayList;

public class RotateString {

    //function to left rotate a code
    public static String leftRotate(String str, int k) {
        if(str == null) {
            return null;
        }

        int length = str.length();
        if(!validateK(k, length)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(length - k)).append(str.substring(0, length - k));
        return sb.toString();
    }

    //function to check if entered k is valid or not. It has to be less than string length
    public static boolean validateK(int k, int length) {
        if(k >= length) {
            System.out.println("K is invalid..");
            return false;
        }
        return true;
    }

    //function to right rotate a string
    public static String rightRotate(String str, int k) {
        if(str == null) {
            return null;
        }

        int length = str.length();
        if(!validateK(k, length)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(k, length)).append(str.substring(0, k));
        return sb.toString();
    }

    //function to print all left rotation of a string
    public static ArrayList<String> getAllLeftRotations(String str) {
        if(str == null) {
            return null;
        }

        ArrayList<String> list = new ArrayList<String>();
        int length = str.length();
        StringBuilder sb = new StringBuilder();

        for(int k = 1; k<length; k++) {
            sb.append(str.substring(length - k)).append(str.substring(0, length - k));
            list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = 4;

        //print left rotation of a string
        System.out.println("Enter String to left Rotate");
        String str = sc.nextLine();
        str = leftRotate(str, k);
        System.out.println(str);

        //print right rotation of a string
        System.out.println("Enter String to right Rotate");
        String str2 = sc.nextLine();
        str2 = rightRotate(str2, k);
        System.out.println(str2);

        //print all left rotations of a string
        System.out.println("Enter String to print all left rotations");
        String str3 = sc.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        list = getAllLeftRotations(str3);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }
}