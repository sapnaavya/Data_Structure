public class FindLongestCommonPrefix {

    // brute force approach to find longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String currentWord = strs[i];
            int j = 0; 

            while(j < currentWord.length() && j < lcp.length() 
                        && currentWord.charAt(j) == lcp.charAt(j)) { 
                j++;
            }

            if(j == 0) {
                return "";
            }

            lcp = currentWord.substring(0,j);
        }
        return lcp;
    }


    public static String longestCommonPrefixSubString(String[] A) {
        StringBuilder sb = new StringBuilder();
        int n = Integer.MAX_VALUE;
        for (String s : A) {
            n = Math.min(s.length(), n);
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            char c =  A[0].charAt(i);
            for (String s : A) {
                if (s.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
             
            if (!flag) break;
            sb.append(c);
        }
        return sb.toString();
    }

    // main method
    public static void main(String args[]) {
        String[] arr = {"cable", "cat", "camera"};
        String str = longestCommonPrefix(arr);
        String str1 = longestCommonPrefixSubString(arr);
        System.out.println(str);
        System.out.print(str1);
    }
}