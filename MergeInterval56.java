import java.util.*;
class Interval {
	int start;
	int end;
	Interval() {
		start = 0; end = 0;
	}
	Interval(int s, int e) {
		start = s; end = e;
	}
}

public class MergeInterval56 {
	public static  List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2) return intervals;
		Collections.sort(intervals, (a, b)-> Integer.compare(a.start, b.start) );
		ArrayList<Interval> results = new ArrayList<>();

		//用两个计数器来记录连续的空间
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals){
			if (interval.start <= end)
				end = Math.max(end, interval.end);
			//当空间不再连续时，将前面连续的区间加入到结果集，并更新两个计数器
			else {
				results.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		results.add(new Interval(start, end));
		return results;
	}
}
