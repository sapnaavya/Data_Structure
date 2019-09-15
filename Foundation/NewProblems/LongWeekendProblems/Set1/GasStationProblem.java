/**
 * This code finds first circular tour that visits all petrol pumps
 * Reference: https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * example: {4, 6}, {6, 5}, {7, 3} and {4, 5}
 *          {4, 6}, {6, 3}, {7, 11} and {4, 5}
*/

class PetrolPump {
    int petrol;
    int distance;
    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class GasStationProblem {

    // This function returns the starting point, if there is possible solution,
    // otherwise returns -1
    public static int printTour(PetrolPump[] arr, int n) {
        int start = 0;
        int end = 1;
        int current_Petrol = arr[start].petrol - arr[start].distance;
        
        while(end != start || current_Petrol < 0) {
            // If current amount of petrol in truck becomes less than 0, then 
            // remove the starting petrol pump from tour 
            while(current_Petrol < 0 && start != end) {

                // remove starting point and change start
                current_Petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no 
                // possible solution 
                if(start == 0) 
                    return -1; 
            }
            // add a petrol pump to the current tour
            current_Petrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n; // do not forget mod n to avoid index out of bound exception
        }
        return start;
    }

    // main method
    public static void main(String args[]) {
        PetrolPump[] arr = {new PetrolPump(4, 6), 
                            new PetrolPump(6, 5), 
                            new PetrolPump(7, 3),
                            new PetrolPump(4, 5)}; 

        int start = printTour(arr, arr.length); 
        System.out.println(start == -1 ? "No Solution" : "Start = " + start); 
    }
}