/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 */

package merge_intervals;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + this.start + ", " + this.end + "]";
    }
}
public class MinimumMeetingRooms {
    private static int findMinimumMeetingRooms(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(a -> a.start));
        System.out.println(meetings);
        PriorityQueue<Meeting> pq = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));
        int minRoom = 0;
        for (Meeting m: meetings) {
            while (!pq.isEmpty() && m.start >= pq.peek().end)
                pq.poll();
            pq.offer(m);
            minRoom = Math.max(minRoom, pq.size());
        }
        return minRoom;
    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>(){{
            add(new Meeting(4, 5));
            add(new Meeting(2, 3));
            add(new Meeting(2, 4));
            add(new Meeting(3, 5));
        }};
        int result = findMinimumMeetingRooms(meetings);
        System.out.println(result);
        meetings = new ArrayList<>(){{
            add(new Meeting(1, 4));
            add(new Meeting(2, 5));
            add(new Meeting(7, 9));
        }};
        result = findMinimumMeetingRooms(meetings);
        System.out.println(result);
        meetings = new ArrayList<>(){{
            add(new Meeting(6,7));
            add(new Meeting(2, 4));
            add(new Meeting(8, 12));
        }};
        result = findMinimumMeetingRooms(meetings);
        System.out.println(result);
    }
}
