import java.util.LinkedHashMap;

public class LongestSubstring{
  static void longestSbString(String inputString){
    char[] charArray = inputString.toCharArray();
    //Initialization
    String longestSubstring = null;
    int longestSubstringLength = 0;
    //Create a linked HashMap
    LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>(); 
    	for(int i =0; i<charArray.length; i++){
          
          char ch = charArray[i];
          if(!charPosMap.containsKey(ch)){
          	charPosMap.put(ch, i);
          }
          else{
          	i = charPosMap.get(ch);
          	charPosMap.clear();
          }
         //Update longest SubString and Substring length
             if(charPosMap.size() > longestSubstringLength){
             longestSubstringLength = charPosMap.size();
             longestSubstring = charPosMap.keySet().toString();
           }
        }
      System.out.println("Input String is " + inputString); 
      System.out.println("Longest Substring is " + longestSubstring);
      System.out.println("Longest Substring Length is " + longestSubstringLength);
   }
  public static void main(String args[]){
  	longestSbString("javaconceptoftheday");
  }
}
