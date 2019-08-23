/**
 * This code solves the job sequencing problem 
 * Reference: https://www.techiedelight.com/job-sequencing-problem-deadlines/
 */
import java.util.*;

class Job {
    private int taskID, deadLine, profit;
    public Job(int taskID, int deadLine, int profit) {
        this.taskID = taskID;
        this.deadLine = deadLine;
        this.profit = profit;
    }

    public int getDeadline() {
		return deadLine;
	}

	public int getProfit() {
		return profit;
	}

	public int getTaskID() {
		return taskID;
	}

}

public class JobSequencingProblem {
    
    // scheduler function to maximize profit
    public static int scheduleJobs(List<Job> jobs, int T) {

        // arrays to store used and unused slot
        int[] slot = new int[T];
        Arrays.fill(slot, -1);

        // stores maximum profit that can be earned by scheduling jobs
        int profit = 0;

        // consider each job in decreasing order of profit
        for(Job job: jobs){
            // search for next free job and map the task to the slot
            for(int j = job.getDeadline() - 1; j >= 0; j--) {
                if(j < T && slot[j] == -1) {
                    slot[j] = job.getTaskID();
                    profit += job.getProfit();
                    break;
                }
            }
        }

        // print the scheduling jobs
       System.out.println("Scheduling jobs are:");
       for(int i = 0; i < T; i++) {
           if(slot[i] != -1) {
            System.out.println(slot[i]);
           }
        }

        // return maximum profit
        return profit;
    }

    //main method
    public static void main(String args[]) {
    // List of given jobs. Each job has an identifier, a deadline and
	// profit associated with it
		List<Job> jobs = Arrays.asList(
				new Job(1, 9, 15), new Job(2, 2, 2),
				new Job(3, 5, 18), new Job(4, 7, 1),
				new Job(5, 4, 25), new Job(6, 2, 20),
				new Job(7, 5, 8), new Job(8, 7, 10),
				new Job(9, 4, 12), new Job(10, 3, 5)
        );

    // stores maximum deadline that can be associated with a job
		final int T = 15;
    
    // arrange the jobs in decreasing order of their profits
        Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());
    
    // schedule jobs and calculate maximum profit
		System.out.println("\nTotal Profit is: " + scheduleJobs(jobs, T));
    }
}