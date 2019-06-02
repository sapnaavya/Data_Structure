import java.util.Scanner;

public class ReverseStringCheck {

    //function to check if one string is rotation of another
    public static boolean isreverseString(String str1, String str2) {

        //if both are null, return true
        if(str1 == null && str2 == null) {
            return true;
        }

        //if strings length are not equal then return false as they can not be rotation
        if(str1.length() != str2.length()) {
            return false;
        }

        //if only one of the string is null then return false;
        if(str1 == null || str2 == null) {
            return false;
        }

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        final int length = charArr1.length;

        //Traverse arrays and compare first element of one array and last element of another arrays
        for(int i=0; i<charArr1.length; i++){
            if(charArr1[i] != charArr2[length - i -1]) {
                return false;
            }
        }
        return true;
    }
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings to check if one is rotaion of another ");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean isReverse = isreverseString(str1, str2);
        System.out.println(isReverse);
        sc.close();
    }
}