/**
 * This code finds whether s3 is an interleaved string for s1 and s2
 * Reference: https://www.techiedelight.com/check-string-interleaving-two-given-strings/
 */
public class InterleaveString {

    // function to check whether s3 is an interleave of s1 and s2
    public static boolean isInterleave(String s1, String s2, String s3) {
        // returns true if we have reached the end of all strings
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
           return true;
        }

       // returns false if we have reached the end of s3
       // but string x and y are not empty
        if(s3.length() == 0) {
           return false;
        }

        // if string s1 is not empty and first character of s1 matches with s3, recur for remaining string
        if(s1.length() != 0 && s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        }

        // if string s2 is not empty and first character of s2 matches with s3, recur for remaining strings
        if(s2.length() != 0 && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        
        return false;
    } 

    // main method
    public static void main(String args[]) {
        String s1 = "ABC";
        String s2 = "DEF";
        String s3 = "ADEBFC";
        boolean isInterleave = isInterleave(s1,s2,s3);
        System.out.println(isInterleave);
    }
}