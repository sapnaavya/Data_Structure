/*
 *
 * This code removes the subset from the string and returns the left out string
 * Example, Superstring: sapnagandhi 
 *          subset string: gandhi
 *          output: sapna
*/

import java.util.Scanner;

class Index {
    int startIndex;
    int endIndex;
    Index() {}
    Index(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

public class SubtractString {

    public static Index subsetString(String superStr, String subStr, Index index) {

        if(subStr.length() == 0 || subStr.length() == 0) {
            return null;
        }
        if(subStr.length() > superStr.length()) {
            return new Index(-1, -1);
        }

        int i = 0;
        int k = 0;
        int s = 0;
        while(i < superStr.length()) {
            if(superStr.charAt(i) == subStr.charAt(k)) {    
                index.startIndex = s;
                index.endIndex = i;
                i++;
                k++;
                if(k != subStr.length()) {
                    continue;
                } else { 
                    return index;
                }
            } else if(k != 0) {
                k = 0;
                s = i;
            } 
            else {
                i++;
                s = i;
            }
        }
        return new Index(-1, -1);
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter SuperString");
        String superStr = sc.nextLine();
        System.out.println("enter substring");
        String subStr = sc.nextLine();
        Index index = new Index();
        index = subsetString(superStr, subStr, index);
        
        //Create new StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(superStr.substring(0, index.startIndex)).append(superStr.substring(index.endIndex + 1, superStr.length()));
        System.out.println("Subtraction of the string:" + sb.toString());
        sc.close();
    }
}