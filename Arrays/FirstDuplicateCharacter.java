import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
class FirstDuplicateCharacter
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enther the length of the array");
		int length = sc.nextInt();
		int [] myArray = new int[length];
		System.out.println("Enther the elements of the array");
		for(int i=0; i<length; i++){
			myArray[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(myArray));
		Map<Integer, Integer> freqCountMap = new HashMap<Integer, Integer>();
		for(int a : myArray) {
			Integer k = freqCountMap.get(a);
			if(k != null) {
				System.out.println("First duplicate occurrence is for " + a);
				break;
			}
			else {
				freqCountMap.put(a, 1);
			}
		}
	}
}