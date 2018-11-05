
import entity.Interval;

import java.util.*;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals1 = new ArrayList<Interval>() {{
            add(new Interval(1, 4));
            add(new Interval(2, 3));
        }};
        List<Interval> intervals2 = new ArrayList<Interval>() {{
            add(new Interval(1, 3));
            add(new Interval(2, 6));
            add(new Interval(8, 10));
            add(new Interval(5, 7));
        }};

        intervals1 = merge(intervals1);
        System.out.println(intervals1);
    }

    public static List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0, j = 1; j < intervals.size(); ) {

            Interval intervalI = intervals.get(i);
            Interval intervalJ = intervals.get(j);

            if (intervalI.end >= intervalJ.start){
                intervalJ.start = intervalI.start;
                intervalJ.end = Math.max(intervalI.end,intervalJ.end);
                intervals.remove(i);
            }else {
                i++;
                j++;
            }
        }

        return intervals;
    }
}
