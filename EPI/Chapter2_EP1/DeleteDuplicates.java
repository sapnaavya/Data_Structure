import java.util.*;

public class DeleteDuplicates {
    public static int deleteDupElementsOptimized(List<Integer> list1) {
        System.out.print("Calling Optimized method...");
        if(list1.isEmpty()) {
           return 0;
        }
        
        int moveIndex = 1;
        for(int i=1; i<list1.size(); i++) {
            if(!list1.get(moveIndex - 1).equals(list1.get(i))) {
                list1.set(moveIndex++, list1.get(i));
            }
        }
        return moveIndex;
    }

    public static List<Integer> deleteDupsBruteForce(List<Integer> list1) {
        System.out.print("Calling Bruteforce method...");
        if(list1.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> uniqueList = new ArrayList<Integer>();
        for(int i=0; i<list1.size(); i++) {
            if(!uniqueList.contains(list1.get(i))) {
                uniqueList.add(list1.get(i));
            }
        }
        return uniqueList;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the list");
        int size = sc.nextInt();
        List<Integer> list1 = new ArrayList<>();
        System.out.print("Enter the elements of the list");
        for(int i=0; i<size; i++) {
            list1.add(sc.nextInt());
        }
        
        System.out.println("Press 'B' for Bruteforce and 'O' for Optimized method call");
        String option = sc.next();
        if(option.equalsIgnoreCase("B")) {
            list1 = deleteDupsBruteForce(list1);
            System.out.print("Elements of the list, after removing the duplicates");
            for(int i=0; i<list1.size(); i++) {
                System.out.print(list1.get(i));
            }
        }
        else if(option.equalsIgnoreCase("O")) {
            int moveIndex = deleteDupElementsOptimized(list1);
            for(int i=0; i<moveIndex; i++) {
                System.out.print(list1.get(i));
            } 
        }
        else{
            System.out.println("no option selected...");
        }

        sc.close();
    }
}