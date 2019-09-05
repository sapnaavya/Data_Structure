/**
 * Problem Statement: You are given a string S, and you have to find all the amazing substrings of S.
   Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 * This code prints substring that starts with vowel
 */
public class AmazingSubstring {

    // function to count amazing substring
    public static int countAmazingString(String a) {
        int ans = 0;
        char[] ch = a.toCharArray();
        for(int i = 0; i<a.length(); i++)
        {
            if(ch[i]=='A' || ch[i]=='E' || ch[i]=='I' || ch[i]=='O' || ch[i]=='U' || ch[i]=='u' || ch[i]=='o' || ch[i]=='i' || ch[i]=='e' || ch[i]=='a'  )
            ans=ans+((a.length())-i);   
            // if(ans>10003)
            // ans=ans%10003;
        }
        return ans;
    }

    // main method
    public static void main(String args[]) {
        String str = "AIEC";
        int count = countAmazingString(str);
        System.out.println(count);
    }
}