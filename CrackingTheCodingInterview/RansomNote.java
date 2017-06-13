import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap =  new HashMap<String, Integer>();
    Map<String, Integer> noteMap =  new HashMap<String, Integer>();
    
    public Solution(String magazine, String note) {
        fillMap(magazineMap, magazine);
        fillMap(noteMap, note);
    }
    public void fillMap(Map<String, Integer> map, String value ){
        if(value == null) return;
        String[] words = value.split("\\s+");
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }else{
                Integer current = map.get(word);
                if(current == null) current = 0;
                map.put(word, current+1);
            }
            
        }
        
    }
    
    public boolean solve() {
            for(String key : noteMap.keySet()){
            if(!magazineMap.containsKey(key)) return false;
        
            Integer magazineCount = magazineMap.get(key);
            Integer noteCount = noteMap.get(key);
       
            if (magazineCount < noteCount) return false;

        }               return true;
        
    }
        
        
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

