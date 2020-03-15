using System;
using System.Collections.Generic;

namespace Foundation {
    public class Job {
        private int profit, deadline, taskID;
        public Job(int taskID, int deadline, int profit) {
            this.taskID = taskID;
            this.deadline =  deadline;
            this.profit = profit;
        }

        public int getDeadline() {
            return deadline;
        }
        public int getTaskID() {
            return taskID;
        }
        public int getProfit() {
            return profit;
        }
    }

    public class JobSequencing {
        public int getTotalProfit(List<Job> jobs, int T) {

            //array to store used and unused slot
            int[] slot = new int[T];
            Fill(slot, -1);

            // stores maximum profit that can be earned by scheduling jobs
            int profit = 0;

            //consider each job in decreasing order
            foreach(Job job in jobs) {
                // search for next free job and map the task to the slot
                for(int j = job.getDeadline() - 1; j >= 0; j--) {
                    if(j < T && slot[j] == -1) {
                        profit += job.getProfit();
                        slot[j] = job.getTaskID();
                        break;
                    }
                }
            }

            // print the scheduling jobs
            System.Console.WriteLine("Scheduled jobs are:");
            for(int i = 0; i < T; i++) {
                if(slot[i] != -1) {
                    System.Console.Write(slot[i] + " ");
                }
            }

            // return maximum profit
            return profit;
        }

        public static void Fill(int[] array, int value)
        {
            if (array == null)
            {
                throw new ArgumentNullException("array");
            }
            int start = 0;
            int end = array.Length;

            for (int i = start; i < end; i++)
            {
                array[i] = value;
            }
        }
    }
}