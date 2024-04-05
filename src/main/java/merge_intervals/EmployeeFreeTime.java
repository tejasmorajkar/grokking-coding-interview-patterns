package merge_intervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class EmployeeInterval {
    Interval interval;
    int intervalIndex;
    int employeeIndex;

    public EmployeeInterval(Interval interval, int intervalIndex, int employeeIndex) {
        this.interval = interval;
        this.intervalIndex = intervalIndex;
        this.employeeIndex = employeeIndex;
    }
}
public class EmployeeFreeTime {
    private static List<Interval> findEmployeeFreeTime(List<List<Interval>> intervals) {
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                intervals.size(),
                Comparator.comparingInt(a -> a.interval.start));
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) return result;
        for (int idx = 0; idx < intervals.size(); idx++)
            minHeap.offer(new EmployeeInterval(intervals.get(idx).get(0), 0, idx));
        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval top = minHeap.poll();
            if (previousInterval.end < top.interval.start) {
                result.add(new Interval(previousInterval.end, top.interval.start));
                previousInterval = top.interval;
            } else {
                if (previousInterval.end < top.interval.end) {
                    previousInterval = top.interval;
                }
            }
            if (top.intervalIndex + 1 < intervals.get(top.employeeIndex).size())
                minHeap.offer(
                        new EmployeeInterval(
                                intervals.get(top.employeeIndex).get(top.intervalIndex + 1),
                                top.intervalIndex + 1,
                                top.employeeIndex));
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        intervals.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> freeTime = findEmployeeFreeTime(intervals);
        System.out.println(freeTime);

        intervals = new ArrayList<>();
        intervals.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        intervals.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        intervals.add(new ArrayList<>(Arrays.asList(new Interval(6, 8))));
        freeTime = findEmployeeFreeTime(intervals);
        System.out.println(freeTime);
    }
}
