/**
 This class print the count of vowels, consonents, numbers and special characters in a  string

 */
import java.util.Scanner;

//Count class to hold count object

class Count {
    int vowels;
    int consonents;
    int specialChar;
    int numbers;

    //Default constructor
    Count() {
        vowels = 0;
        consonents = 0;
        specialChar = 0;
        numbers = 0;
    }

    //Parameterized constructor
    Count(int v, int c, int spChar, int num) {
        vowels = v;
        consonents = c;
        specialChar = spChar;
        numbers = num;
    }
}

public class CountVowelsConsonents {

    //Function to count occurances of vowels, consonents and numbers and special characters
    public static Count countVowConsonents(String str, Count count) {
        if(str == null) {
            return new Count(0, 0, 0, 0);
        }

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                // To handle upper case letters 
                ch = Character.toLowerCase(ch);

                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count.vowels++;
                } else {
                    count.consonents++;
                }
            } else if(ch >= '0' && ch <= '9') {
                count.numbers++;
            } else {
                count.specialChar++;
            }
        }
        return count;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Count count = new Count();
        System.out.println("Enter the String");
        String str = sc.nextLine();
        Count countOccur = countVowConsonents(str, count);
        System.out.println("Vowels " + countOccur.vowels +  " "+
            "Consonents " + countOccur.consonents  + " "+ "specialChar " + countOccur.specialChar  + " "
                + "numbers " + countOccur.numbers);
        sc.close();
    }
}