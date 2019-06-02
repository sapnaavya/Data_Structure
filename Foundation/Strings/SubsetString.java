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
        for(int i=0; i<str1.length() && i<str2.length(); i++) {
            for(int j=0; j<str1.length(); j++) {
                if(str1.charAt(j) == str2.charAt(k)) {
                    k++;
                    if(k != str2.length()) {
                        continue;
                    } else {
                        return true;
                    }
                } else if(k != 0) {
                    k = 0;
                }
            }
        }  
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