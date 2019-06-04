import java.util.Scanner;

public class ReverseWordsInString {


    //Reverse words in a string using extra space
    public  static String reverseWords(String str) {
        if(str == null || str.length() == 0) {
            return null;
        }

        //Split words by space
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; --i) {
            sb.append(arr[i]).append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1); 
    }

    //Reverse words in a string without using extra space
    public void reverseWordsInplace(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }

        //char[] s = str.toCharArray();
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);        
                i=j+1;
            }
        }
        reverse(s, i, s.length-1);
        reverse(s, 0, s.length-1);
    }

    public void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    //main method
    public static void main(String args[]) {
        ReverseWordsInString obj = new ReverseWordsInString();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String reverseStr = reverseWords(str);
        System.out.println(reverseStr);
        char[] s = str.toCharArray();
        obj.reverseWordsInplace(s);
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        sc.close();
    }
}