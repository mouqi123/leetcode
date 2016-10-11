import java.util.*;
public class InsertInterval57 {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> results = new ArrayList<>();

		for (Interval interval : intervals) {
			if (newInterval == null || interval.end < newInterval.start)
				results.add(interval);
			else if (interval.start > newInterval.end) {
				results.add(newInterval);
				results.add(interval);
				newInterval = null;
			}else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		if (newInterval != null)
			results.add(newInterval);
		return results;
	}
}
