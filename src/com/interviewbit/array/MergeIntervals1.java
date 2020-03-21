package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeIntervals1 {

	public static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		public Interval() {

		}

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		boolean isMergedInLastIteration = false;
		boolean isMerged = false;
		if (intervals == null || intervals.size() == 0) {
			return new ArrayList<Interval>(Arrays.asList(newInterval));
		}

		for (int i = 0; i < intervals.size(); i++) {

			if (areIntervalsOverlapping(intervals.get(i), newInterval)) {
				if (!isMergedInLastIteration) {
					Interval mergedInterval = merge(intervals.get(i), newInterval);
					intervals.set(i, mergedInterval);
					isMergedInLastIteration = true;
					isMerged = true;
				} else {
					Interval mergedInterval = merge(intervals.get(i - 1), intervals.get(i));
					intervals.set(i, mergedInterval);
					intervals.remove(i - 1);
					i--;
				}
			} else if(i>0 && isAfter(intervals.get(i-1), newInterval) && isBefore(intervals.get(i), newInterval)) {
				isMergedInLastIteration = false;
				intervals.add(i,newInterval);
			}else {
				isMergedInLastIteration = false;
			}

		}

		if (!isMerged) {
			if (newInterval.end < intervals.get(0).start) {
				intervals.add(0, newInterval);
			} else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
				intervals.add(newInterval);
			}
		}
		return intervals;
	}

	private boolean isBefore(Interval interval, Interval newInterval) {
		return newInterval.end<interval.start;
	}

	private boolean isAfter(Interval interval, Interval newInterval) {
		return interval.end<newInterval.start;
	}

	private Interval merge(Interval interval, Interval newInterval) {
		Interval mergeInterval = new Interval();
		mergeInterval.start = Integer.min(interval.start, newInterval.start);
		mergeInterval.end = Integer.max(interval.end, newInterval.end);
		return mergeInterval;
	}

	private boolean areIntervalsOverlapping(Interval interval, Interval newInterval) {
		return isInBetween(interval.start, interval.end, newInterval.start)
				|| isInBetween(interval.start, interval.end, newInterval.end)
				|| (newInterval.start < interval.start && newInterval.end > interval.end);
	}

	private boolean isInBetween(int start, int end, int num) {
		return num >= start && num <= end;
	}

	
	@Test
	public void test5() {

		Interval[] expected = { new Interval(1, 2), new Interval(3,6), new Interval(8,10) };

		Assert.assertArrayEquals(expected,
				insert(new ArrayList(Arrays.asList(new Interval(1, 2), new Interval(8,10))), new Interval(3,6))
						.toArray());
	}
	
	@Test
	public void test() {

		Interval[] expected = { new Interval(1, 5), new Interval(6, 9) };

		Assert.assertArrayEquals(expected,
				insert(new ArrayList(Arrays.asList(new Interval(1, 3), new Interval(6, 9))), new Interval(2, 5))
						.toArray());
	}

	@Test
	public void test1() {

		Interval[] expected = { new Interval(1, 2), new Interval(3, 6), new Interval(8, 10) };
		Assert.assertArrayEquals(expected,
				insert(new ArrayList(Arrays.asList(new Interval(1, 2), new Interval(3, 6))), new Interval(8, 10))
						.toArray());

	}

	@Test
	public void test2() {
		Interval[] expected = { new Interval(1, 11) };
		Assert.assertArrayEquals(expected,
				insert(new ArrayList(Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11))),
						new Interval(2, 11)).toArray());

	}

	@Test
	public void test3() {

		Interval[] expected = { new Interval(6037774, 6198243), new Interval(6726550, 7004541),
				new Interval(8842554, 10866536), new Interval(11027721, 11341296), new Interval(11972532, 14746848),
				new Interval(16374805, 16706396), new Interval(17557262, 20518214), new Interval(22139780, 22379559),
				new Interval(27212352, 28404611), new Interval(28921768, 29621583), new Interval(29823256, 32060921),
				new Interval(33950165, 64859907), new Interval(65277782, 65296274), new Interval(67497842, 68386607),
				new Interval(70414085, 73339545), new Interval(73896106, 75605861), new Interval(79672668, 84539434),
				new Interval(84821550, 86558001), new Interval(91116470, 92198054), new Interval(96147808, 98979097)

		};

		Assert.assertArrayEquals(expected, insert(new ArrayList(Arrays.asList(new Interval(6037774, 6198243),
				new Interval(6726550, 7004541), new Interval(8842554, 10866536), new Interval(11027721, 11341296),
				new Interval(11972532, 14746848), new Interval(16374805, 16706396), new Interval(17557262, 20518214),
				new Interval(22139780, 22379559), new Interval(27212352, 28404611), new Interval(28921768, 29621583),
				new Interval(29823256, 32060921), new Interval(33950165, 36418956), new Interval(37225039, 37785557),
				new Interval(40087908, 41184444), new Interval(41922814, 45297414), new Interval(48142402, 48244133),
				new Interval(48622983, 50443163), new Interval(50898369, 55612831), new Interval(57030757, 58120901),
				new Interval(59772759, 59943999), new Interval(61141939, 64859907), new Interval(65277782, 65296274),
				new Interval(67497842, 68386607), new Interval(70414085, 73339545), new Interval(73896106, 75605861),
				new Interval(79672668, 84539434), new Interval(84821550, 86558001), new Interval(91116470, 92198054),
				new Interval(96147808, 98979097))), new Interval(36210193, 61984219)).toArray());

	}

}
