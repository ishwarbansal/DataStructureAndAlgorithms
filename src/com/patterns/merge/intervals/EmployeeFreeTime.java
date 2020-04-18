package com.patterns.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmployeeFreeTime {

	public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<Interval>();
		
		List<Interval> list = new ArrayList<Interval>();
		Iterator<List<Interval>> iterator = schedule.iterator();
		while(iterator.hasNext()) {
			for(Interval interval : iterator.next()) {
				list.add(interval);
			}
		}
		
		Collections.sort(list, (a,b) -> Integer.compare(a.start, b.start));
		
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).start > list.get(i-1).end) {
				result.add(new Interval(list.get(i-1).end, list.get(i).start));
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		List<List<Interval>> input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
		List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		System.out.println();

		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
		result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		System.out.println();

		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
		result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
	}


}
