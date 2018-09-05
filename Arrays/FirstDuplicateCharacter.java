import java.util.Map;
import java.util.HashMap;
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] intArray = {5, 4, 6, 8, 9};
		Map<Integer, Integer> freqCountMap = new HashMap<Integer, Integer>();
		for(int a : intArray) {
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