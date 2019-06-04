import java.util.Scanner;

public class LongestPallindromeSubstring {
    public static String longestPallindromeSubstring(String str) {
        if(str == null || str.isEmpty()) {
            return new String();
        }
        int length = str.length();
        int longestPalSubLength = 0;
        String subStr = new String();
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < length; i++) {         
            for(int j = i+1; j <= length; j++) {
                subStr = str.substring(i, j);
                if(isPal(subStr) && subStr.length() > longestPalSubLength ) {
                    longestPalSubLength = subStr.length();
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return str.substring(startIndex, endIndex);
    }

    //check if a string is pallindrome or not
    public static boolean isPal(String str) {
        if(str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for(int i=0; i<length/2; i++) {
            if(str.charAt(i) != str.charAt(length - i -1)){
                return false;
            }
        }
        return true;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String longestPalSubstring = longestPallindromeSubstring(str);
        System.out.println(longestPalSubstring);
    }
}