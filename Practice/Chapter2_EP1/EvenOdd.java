import java.util.*;
public class EvenOdd {
    public static List<Integer> evenOddArranges(List<Integer> A) {
        int nEven = 0;
        int nOdd = A.size() - 1;
        while(nEven < nOdd) {
            if(A.get(nEven) % 2 == 0){
                nEven++;
            }
            else{
                Collections.swap(A, nEven, nOdd--);     
            }
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
        list= evenOddArranges(list);
        for(int i=0; i< list.size(); i++) {
            System.out.print(list.get(i));
        }
        sc.close();
    }
}