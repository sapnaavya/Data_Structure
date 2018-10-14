public class Solution{
    public static boolean isUniqueChar(String str){
        if(str.length() > 128 ){
            return false;
        }
        
        boolean[] bool = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(bool[val]){
                return false;
            }
          bool[val] = true;
        }
        return true;
    }
      
    public static void main(String args[]){
        String[] words = {"apple", "kito","potatos"};
        for(String word:words){
            System.out.println(word + "" + isUniqueChar(word));
        } 
    }
}