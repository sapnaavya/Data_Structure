/*
    This code checks whether a string is a subset of another string or not
*/
import java.util.Scanner;
public class SubsetString {

    public boolean isSubset(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return true;
        }
        if(str2 == null) {
            return true;
        }
        if(str1 == null) {
            return false;
        }

        int k = 0;
        int i = 0;
        while(i < str1.length()) {
            if(str1.charAt(i) == str2.charAt(k)) {
                k++;
                i++;
                if(k == str2.length()) {
                    return true;
                }
            } 
            else if(k != 0) {
                k = 0;
            } else {
                i++;
            }
        }  
        //means you have reached the end of string and still could not find the substring
        return false;
    }
    
    //main method
    public static void main(String args[]) {
        SubsetString  obj = new SubsetString();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean isSubset = obj.isSubset(str1, str2);
        System.out.println(isSubset);
        sc.close();
    }
}