package com.patterns.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() < 2)
			return intervals;

		// sort the intervals by start time
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		List<Interval> mergedIntervals = new LinkedList<Interval>();
		Iterator<Interval> intervalItr = intervals.iterator();
		Interval interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;

		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (newInterval.start <= end) { // overlapping intervals, adjust the start and end
				start = Math.min(newInterval.start, start);
				end = Math.max(newInterval.end, end);
			} else { // non-overlapping interval, add the previous interval and reset
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// add the last interval
		if (interval.start <= end) { // overlapping intervals, adjust the start and end
			start = Math.min(interval.start, start);
			end = Math.max(interval.end, end);
			mergedIntervals.add(new Interval(start, end));
		}else {
			mergedIntervals.add(new Interval(start, end));
			mergedIntervals.add(interval);
		}

		return mergedIntervals;
	}


	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
		
	}


}
