// Job Scheduling Problem
// Given a set of jobs where each job i has a deadline di and profit pi, the task is to maximize profit and find the maximum number of jobs that can be done.

package Assignment3;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class jobScheduling {

    public static int maxProfit;
    public static int jobsDone;

    // This function takes an array of jobs and returns the array of jobs in the
    // order they should be done
    public int[] jobSchedule(Job[] jobs) {

        // Step 1: Sort the jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline to create the schedule array
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Create the schedule array and initialize it with -1
        int[] schedule = new int[maxDeadline];
        for (int i = 0; i < maxDeadline; i++) {
            schedule[i] = -1;
        }

        // Step 4: Iterate through the jobs and assign them to the schedule array
        for (Job job : jobs) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (schedule[i] == -1) {
                    schedule[i] = job.id;
                    maxProfit += job.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        return schedule;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[4];

        jobs[0] = new Job(1, 4, 20);
        jobs[1] = new Job(2, 1, 10);
        jobs[2] = new Job(3, 2, 40);
        jobs[3] = new Job(4, 2, 30);

        jobScheduling js = new jobScheduling();
        int[] schedule = js.jobSchedule(jobs);

        System.out.println("Schedule: " + Arrays.toString(schedule));
        System.out.println("Max Profit: " + maxProfit);
        System.out.println("Jobs Done: " + jobsDone);
    }
}
