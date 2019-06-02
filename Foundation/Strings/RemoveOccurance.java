import java.util.Scanner;

public class RemoveOccurance {

    //This function remove occurance of a specific character from a string
    public String removeOccur(String str, char ch){
        if(str == null || ch == '\u0000') {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] != ch) {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
    //main method
    public static void main(String args[]) {
        RemoveOccurance obj = new RemoveOccurance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to remove a specific character");
        String str = sc.nextLine();
        System.out.println("Enter a character to remove from string");
        char ch = sc.next().charAt(0); 
        String removeString = obj.removeOccur(str, ch);
        System.out.println(removeString);
        sc.close();
    }
}