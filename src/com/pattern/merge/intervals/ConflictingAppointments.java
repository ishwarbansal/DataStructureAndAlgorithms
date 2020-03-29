package com.pattern.merge.intervals;

public class ConflictingAppointments {
	
	public static boolean canAttendAllAppointments(Interval[] intervals) {
		Interval interval = intervals[0];
		int end = interval.end;
		
		for(int i=1; i<intervals.length; i++) {
			if(intervals[i].start <= end) {
				return false;
			}
			end = intervals[i].end;
		}
	    return true;
	  }

	  public static void main(String[] args) {
	    Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
	    boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals1 = { new Interval(2, 4), new Interval(6, 7), new Interval(8, 12) };
	    result = ConflictingAppointments.canAttendAllAppointments(intervals1);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals2 = {new Interval(2, 3), new Interval(3, 6), new Interval(4, 5) };
	    result = ConflictingAppointments.canAttendAllAppointments(intervals2);
	    System.out.println("Can attend all appointments: " + result);
	  }


}
