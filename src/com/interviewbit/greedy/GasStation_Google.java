package com.interviewbit.greedy;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GasStation_Google {

	public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
		int startingGasStation = -1;
		if (A == null || B == null || A.size()==0 || B.size()==0) {
			return startingGasStation;
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= B.get(i) && canCompleteCircuit(A, B, i)) {
				startingGasStation = i;
				break;
			}
		}

		return startingGasStation;
	}

	private boolean canCompleteCircuit(List<Integer> a, List<Integer> b, int i) {
		boolean canComplete = false;
		int size = a.size();
		int stopPt=i-1;
		stopPt= stopPt>=0 ? stopPt :size+i-1;
		if (size > 1) {
			int pendingFuel = 0;
			for (int j = 0; j < size; j++) {
				int pt = j + i;
				pt = pt <= size - 1 ? pt : pt - size;
				int currFuel = a.get(pt) + pendingFuel;
				int reqdFuel = b.get(pt);

				if (currFuel < reqdFuel) {
					return false;
				}
				pendingFuel = currFuel - reqdFuel;

				if (pt == stopPt) {
					canComplete = true;
					break;
				}
			}
		} else if (size == 1) {
			canComplete = a.get(0) >= b.get(0);
		}
		return canComplete;
	}

	@Test
	public void test4() {
		List<Integer> A = Arrays.asList(383, 521, 491, 907, 871, 705);
		List<Integer> B = Arrays.asList(96, 197, 592, 67, 77, 641);
		Assert.assertEquals(0, canCompleteCircuit(A, B));
	}

	
	
	@Test
	public void test() {
		List<Integer> A = Arrays.asList(1, 2);
		List<Integer> B = Arrays.asList(2, 1);
		Assert.assertEquals(1, canCompleteCircuit(A, B));
	}

	@Test
	public void test3() {
		List<Integer> A = Arrays.asList(1);
		List<Integer> B = Arrays.asList(2);
		Assert.assertEquals(-1, canCompleteCircuit(A, B));
	}

	@Test
	public void test1() {
		List<Integer> A = Arrays.asList(0);
		List<Integer> B = Arrays.asList(0);
		Assert.assertEquals(0, canCompleteCircuit(A, B));
	}

	@Test
	public void test2() {
		List<Integer> A = Arrays.asList(959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163,
				953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738,
				7, 209);
		List<Integer> B = Arrays.asList(862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797,
				512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517,
				237, 884);
		Assert.assertEquals(-1, canCompleteCircuit(A, B));
	}

}
