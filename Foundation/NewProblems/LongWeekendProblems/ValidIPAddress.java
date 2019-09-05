import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address
   combinations.
   A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers
    from 0-255. The numbers cannot be 0 prefixed unless they are 0.   
 * 
 */
public class ValidIPAddress {

    // Array list that returns the list of valid IP address
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();  
        if (s.length() < 4 || s.length() > 12) return res;  
        dfs(s, "" , res, 0);  
        return res;  
    }

    public static void dfs(String s, String tmp, ArrayList<String> res, int count){ 
        if (count == 3 && isValid(s)) {  
            res.add(tmp + s);  
            return;  
        } 

        for(int i = 1; i < 4 && i < s.length(); i++){  
            String substr = s.substring(0,i);  
            if (isValid(substr)){  
                dfs(s.substring(i), tmp + substr + '.', res, count + 1);  
            }  
        }  
    } 

    public static boolean isValid(String s){  
        if (s.charAt(0) == '0') return s.equals("0");  
        int num = Integer.parseInt(s);  
        return num <= 255 && num > 0;  
    }    

    // main method
    public static void main(String args[]) {
        String str = "25525511255";
        ArrayList<String> list = restoreIpAddresses(str);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}