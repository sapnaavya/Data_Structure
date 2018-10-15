public class Solution
{
    public  static boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
          System.out.println(map[s.charAt(i)]);
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
    }
  
  public static void main(String[] args)
  {
    String test = "aaabbb";
    System.out.print(canPermutePalindrome(test));
  }
}