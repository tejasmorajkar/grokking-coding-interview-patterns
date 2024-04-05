/**
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 */

package merge_intervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuload;

    public Job(int start, int end, int cpuload) {
        this.start = start;
        this.end = end;
        this.cpuload = cpuload;
    }
}

public class MaximumCPULoad {
    private static int findMaxCPULoad(List<Job> jobs) {
        jobs.sort(Comparator.comparing(job -> job.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), Comparator.comparing(job -> job.end));
        int maxCPULoad = 0, currCPULoad = 0;
        for (Job j: jobs) {
            while (!minHeap.isEmpty() && j.start >= minHeap.peek().end)
                currCPULoad -= minHeap.poll().cpuload;
            minHeap.offer(j);
            currCPULoad += j.cpuload;
            maxCPULoad = Math.max(maxCPULoad, currCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>(){{
            add(new Job(1,4,3));
            add(new Job(2,5,4));
            add(new Job(7,9,6));
        }};
        int result = findMaxCPULoad(jobs);
        System.out.println(result);

        jobs = new ArrayList<>(){{
            add(new Job(6,7,10));
            add(new Job(2,4,11));
            add(new Job(8,12,15));
        }};
        result = findMaxCPULoad(jobs);
        System.out.println(result);

        jobs = new ArrayList<>(){{
            add(new Job(1,4,2));
            add(new Job(2,4,1));
            add(new Job(3,6,5));
        }};
        result = findMaxCPULoad(jobs);
        System.out.println(result);
    }
}
