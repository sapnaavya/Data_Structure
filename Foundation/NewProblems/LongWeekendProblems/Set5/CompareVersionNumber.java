/**
 * This code compares version number
 * Problem statment: Compare two version numbers version1 and version2.
    1.	If version1 > version2 return 1,
    2.	If version1 < version2 return -1,
    3.	otherwise return 0.

    Reference: https://github.com/varunu28/InterviewBit-Java-Solutions/blob/master/Strings/Compare%20Version%20Numbers.java

    Example: 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
             1.30 < 1.351
             1.30 < 1.32   
             10.15 < 12.10

    Java – String compareTo() Method example. The method compareTo() is used for comparing two strings lexicographically.
*/

public class CompareVersionNumber {

    // function to check version number
    public static int compareVersion(String str1, String str2) {

        String[] arrA = str1.split("\\.");
        String[] arrB = str2.split("\\.");

        int length = Math.max(arrA.length, arrB.length);
        for (int i = 0; i < length; i++) {
            if (i < arrA.length && i < arrB.length) {     // do not forget this. very important
                if (arrA[i].length() > arrB[i].length()) return 1;
                else if (arrA[i].length() < arrB[i].length()) return -1;
            }

            Long n1 = i < arrA.length ? Long.parseLong(arrA[i]) : 0;
            Long n2 = i < arrB.length ? Long.parseLong(arrB[i]) : 0;

            int comp = n1.compareTo(n2);
            if (comp != 0) return comp;
        }
        return 0;
    }

    // main method
    public static void main(String args[]) {
        String str2 = "0.1.2.52";
        String str1 = "0.1.2.1";
        int result = compareVersion(str1, str2);
        System.out.println(result);
    }
}