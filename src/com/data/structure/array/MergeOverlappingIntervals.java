package com.data.structure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.patterns.graph.Interval;

public class MergeOverlappingIntervals {

	//	Given a collection of intervals, merge all overlapping intervals.
	//
	//	For example:
	//
	//	Given [1,3],[2,6],[8,10],[15,18],
	//
	//	return [1,6],[8,10],[15,18].
	//
	//	Make sure the returned intervals are sorted.
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if(intervals.size()<2){
			return intervals;
		}
		Collections.sort(intervals,new Comparator<Interval>(){ 
			public int compare(Interval i1,Interval i2) 
			{ 
				return i1.start-i2.start; 
			} 
		}); 

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		ArrayList<Interval> list = new ArrayList<Interval>();

		for(int i=1; i<intervals.size(); i++){
			int newStart = intervals.get(i).start; 
			int newEnd = intervals.get(i).end;
			if(end >= newStart){
				end = Math.max(end, newEnd);
			}else{
				Interval interval = new Interval(start, end);
				list.add(interval);
				start = newStart;
				end = newEnd;
			}
		}

		Interval interval = new Interval(start, end);
		list.add(interval);

		return list;
	}

	public static void main(String[] args) {
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(2,6);
		Interval interval3 = new Interval(8,10);
		Interval interval4 = new Interval(15,18);
		
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(interval1);
		list.add(interval2);
		list.add(interval3);
		list.add(interval4);
		
		ArrayList<Interval> result = new MergeOverlappingIntervals().merge(list);
		
		for(Interval interval : result) {
			System.out.println(interval.start + "  " +interval.end);
		}
	}

}
