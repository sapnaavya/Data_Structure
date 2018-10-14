public class CheckPermuation {	

	public static boolean permutation(String s, String t) {

		if (s.length() != t.length()) {

			return false;

		}

		int[] letters = new int[128]; 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++; 
          System.out.println(letters[c]);

		}

		for (int i = 0; i < t.length(); i++) {
          System.out.println(t.charAt(i));
          	letters[t.charAt(i)]-- ;
		    if (letters[t.charAt(i)] < 0) {
		    	return false;
		    }
		}
      
		return true;
	}

	public static void main(String[] args) {
		String[][] pairs = {{"hello", "llaoh"}, {"test", "test1"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
        	System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}