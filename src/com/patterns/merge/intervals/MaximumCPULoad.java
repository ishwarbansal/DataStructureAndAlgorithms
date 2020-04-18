package com.patterns.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPULoad {

	public static int findMaxCPULoadDoc(List<Job> jobs) {
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
//		PriorityQueue<Job> jobList = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end, b.end));
		Job previousJob = null;
		int maxCpuLoad = Integer.MIN_VALUE;
		int tmpCpuLoad = 0;
		for(Job job : jobs) {
			if(previousJob!=null && previousJob.end>job.start) {
				tmpCpuLoad = tmpCpuLoad + job.cpuLoad;
			}else {
				tmpCpuLoad = job.cpuLoad;
			}
//			jobList.poll();
//			jobList.offer(job);
			previousJob = job;
			maxCpuLoad = Math.max(maxCpuLoad, tmpCpuLoad);
		}
		return maxCpuLoad;
	}
	public static int findMaxCPULoad(List<Job> jobs) {
		Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
		Iterator<Job> iterator = jobs.iterator();
		Job job = iterator.next();
		int end = job.end;
		int cpuLoad = job.cpuLoad;
		int maxCpuLoad = -1;
		while(iterator.hasNext()) {
			Job job2 = iterator.next();
			maxCpuLoad = Math.max(maxCpuLoad, cpuLoad);
			if(job2.start<=end) {
				cpuLoad+=job2.cpuLoad;
			}else {
				cpuLoad = job2.cpuLoad;
				end = job2.end;
			}
		}
		return  Math.max(maxCpuLoad, cpuLoad);
	}

	public static void main(String[] args) {
		List<Job> input = new ArrayList<Job>();
		input = (Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6), new Job(8, 9, 8)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoadDoc(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoadDoc(input));

		input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
		System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoadDoc(input));
	}


}
