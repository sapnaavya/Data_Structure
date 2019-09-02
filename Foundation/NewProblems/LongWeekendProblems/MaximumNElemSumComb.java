/**
 * For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 ,
    2+3=5 , 2+4=6 and maximum 2 elements are 6, 5
    Example:
    N = 4
    a[]={1,4,2,3}
    b[]={2,5,1,6}
    Maximum 4 elements of combinations sum are
    10 (4+6),
    9 (3+6),
    9 (4+5),
    8 (2+6)
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumNElemSumComb {
    
    // function that return n max sum elements 
    public static List<Integer> maxSumNElem(int [] a, int [] b) {
        int n = a.length;
        int sum;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : a) {
            for(int j: b) {
                sum = i + j;
                if(pq.size() < n) {
                    pq.add(sum);
                } else if(sum > pq.peek()) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }

        List<Integer> res = new ArrayList<>(pq);
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }

    // main method
    public static void main(String args[]) {
        int a[] = {1,4,2,3};
        int b[] = {2,5,1,6};
        List<Integer> list = maxSumNElem(a, b);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}