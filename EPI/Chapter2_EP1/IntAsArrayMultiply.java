import java.util.*;

public class IntAsArrayMultiply {

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for(int i = num1.size()-1; i>=0; --i) {
            for(int j = num2.size()-1; j>=0; --j) {
                result.set(i+j+1, result.get(i+j+1) + num1.get(i) * num2.get(j));
                result.set(i+j, result.get(i+j) + result.get(i+j+1) / 10);
                result.set(i+j+1, result.get(i+j+1) % 10);
            }
        }

        int firstNotZero = 0;
        while(firstNotZero < result.size() && result.get(firstNotZero) == 0) {
            firstNotZero++;
        }
        result = result.subList(firstNotZero, result.size());
        if(result.isEmpty()) {
            System.out.print("list is empty");
            //return List.of(0);
            //return null;
            List<Integer> emptyList = new ArrayList<Integer>(Collections.nCopies(result.size(), 0));
            return emptyList;
        }
        result.set(0, result.get(0) * sign);
        return result;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        List<Integer> list1 =  new ArrayList<Integer>(); 
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        System.out.println("Enter the size of the list1");
        int sizeA = sc.nextInt();
        System.out.println("Enter the size of the list2");
        int sizeB = sc.nextInt();
        for (int i = 0; i<sizeA; i++) {
            list1.add(sc.nextInt());
        }
        for(int i = 0; i<sizeB; i++) {
            list2.add(sc.nextInt());
        }

        try{
            result = multiply(list1, list2);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Size of resulted list" + result.size());
        System.out.println("Element of resulted list:");
        if(!result.isEmpty())
            for(int i=0; i<result.size(); i++) {
                System.out.print(result.get(i));
            }
        else{
            System.out.println("Resulted list is empty");
        }
        sc.close();
    }
}