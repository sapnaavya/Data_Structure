/**
 This code checks whether one string is rotation of another string using below  two approach:
 first approach : append two stringBuilder object
    1. First check if both strings are null -> return true
    2. If any of the string is null -> return false;
    3. If length of both the strings is not similar -> return false;
    4. Take one stringbuilder object and append str2 itself with it and check if str1 contains in the appended string
        for example, abcd and dabc are rotation as dabcdabc contains str1 i.e abcd so -> return true
        Lets take another example, abcd and dbca are not rotation as dbcadbca does not contain str1 i.e abcd -> return false;

 Second Approach: 
    1. Take the first element from input string and find its index in rotate string
    2. Subtract that index from length to get finalposition index (from this index substring match with rotate string) in input string
    3. Check if index is greater than -1
    4. Check below two condition:
        a. compare rotate's first character and character in input's finaposition index
        b. and compare substring from rotate(0, index) and input(finalpos) substring
        if a and b are true -> return true
        else return false;
*/


import java.util.Scanner;
public class RotationString {

    public static boolean isRotate(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return true;
        }
        if(str1 == null || str2 == null) {
            return false;
        }
        if(str1.length() != str2.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder(str2);
        sb = sb.append(sb);
        if(sb.toString().contains(str1)) {
            return true;
        }
        return false;
    }

    public static boolean isRotateBruteforce(String input, String rotate) {
        if(input == null && rotate == null) {
            return true;
        }
        if(input == null || rotate == null) {
            return false;
        }
        if(input.length() != rotate.length()) {
            return false;
        }

        int index = rotate.indexOf(input.charAt(0));
        int finalPos = input.length() - index;
        if(finalPos > -1) {
            if(input.equalsIgnoreCase(rotate)) {
                System.out.println("both the strings are equal");
                return true;
            }

            return rotate.charAt(0) == input.charAt(finalPos) 
                && rotate.substring(0, index).equals(input.substring(finalPos));
        }

        return false;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean isRotate = isRotate(str1, str2);
        System.out.println(isRotate);

        boolean isRotateBrute = isRotateBruteforce(str1, str2);
        System.out.println(isRotateBrute);
        sc.close();
    }

}