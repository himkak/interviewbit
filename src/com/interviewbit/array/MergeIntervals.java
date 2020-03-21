package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeIntervals {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		intervals.add(0, newInterval);
		Interval[] intervalsArr =  intervals.toArray(new Interval[0]);

		List<Interval> newIntervals = new ArrayList<>();
		for (int i = 0; i < intervalsArr.length-1; i++) {

			int compRes = compare(intervalsArr[i], intervalsArr[i+1]);

			if (compRes == 0) {
				Interval mergedInterval=overLapAndMerge(intervalsArr[i], newInterval);
				intervalsArr[i]=mergedInterval;
			}

//			Interval nextFromList = intervalsArr[i];
//			Interval nextToMergeInterval = null;
//			if (null != newInterval) {
//				nextToMergeInterval = newInterval;
//			} else if (i + 1 < intervals.size()) {
//				nextToMergeInterval = intervals.get(i + 1);
//			}
//			if (null != nextToMergeInterval) {
//				Interval updatedInterval = overLapAndMerge(nextFromList, nextToMergeInterval);
//				if (null != updatedInterval) {
//					// it.remove();
//					newIntervals.add(updatedInterval);
//					newInterval = null;
//				}
//			} else {
//				newIntervals.add(nextFromList);
//			}
		}

		return newIntervals;

	}

	private int compare(Interval interval, Interval newInterval) {

		if (newInterval.start > interval.start && newInterval.start < interval.end && newInterval.end > interval.start
				&& newInterval.end < interval.end) {
			//new interval lies inside interval
			return 0;
		} else if (newInterval.start > interval.end) {
			//new interval  is after interval 
			return 1;
		} else if (interval.start > newInterval.end) {
			//interval is after new interval
			return -1;
		} else if (newInterval.start < interval.start && newInterval.end > interval.end) {
			//inetrval lies inside new interval
			return 0;
		}else if(interval.start<newInterval.start && interval.end>newInterval.start && newInterval.end>interval.end) {
			//overlap
			return 0;
		}else if(interval.start>newInterval.start && interval.start<newInterval.end && interval.end> newInterval.end) {
			return 0;
		}
		return 1;

	}

	private Interval overLapAndMerge(Interval interval, Interval newInterval) {
		if (newInterval.start > interval.start && newInterval.start < interval.end && newInterval.end > interval.end) {
			return new Interval(interval.start, newInterval.end);
		} else if (newInterval.start < interval.start && newInterval.end > interval.end)
			return new Interval(newInterval.start, interval.end);
		return null;
	}

	@Test
	public void test() {
		Assert.assertTrue(insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5))
				.contains(new Interval(1, 5)));
		Assert.assertTrue(insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5))
				.contains(new Interval(6, 9)));

	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		private MergeIntervals getEnclosingInstance() {
			return MergeIntervals.this;
		}

	}

}
