import java.util.*;
public class PlusOne {
    public static List<Integer> plusOneAdd(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for(int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i,0);
            A.set(i-1, A.get(i-1) + 1);
        }
        if(A.get(0) == 10) {
            A.set(0, 1);
            A.add(0);
        }
        return A;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter size of the list");
        int size = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<size; i++) {
            list.add(sc.nextInt());
        }
        list = plusOneAdd(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        sc.close();
    }
}