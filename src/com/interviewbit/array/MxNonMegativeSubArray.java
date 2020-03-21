package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MxNonMegativeSubArray {

	public List<Integer> maxset(List<Integer> A) {
		ArrayList<Integer> maxResultArray = new ArrayList<>();
		ArrayList<Integer> currResultArray = new ArrayList<>();
		long max = Integer.MIN_VALUE;
		long currSum = 0;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) >= 0) {
				currSum = currSum + A.get(i);
				currResultArray.add(A.get(i));
			}
			if ((A.get(i) < 0 || i + 1 == A.size()) && currSum >= 0) {
				if (currSum > max) {
					max = currSum;
					maxResultArray = currResultArray;
					currSum = 0;
					currResultArray = new ArrayList<>();
				} else if (currSum == max) {
					if (currResultArray.size() > maxResultArray.size()) {
						max = currSum;
						maxResultArray = currResultArray;
						currSum = 0;
						currResultArray = new ArrayList<>();
					} else if (currResultArray.size() == maxResultArray.size()) {
						if ((currResultArray.size() > 0 && maxResultArray.size() > 0)
								&& currResultArray.get(0) > maxResultArray.get(0)) {
							max = currSum;
							maxResultArray = currResultArray;
							currSum = 0;
							currResultArray = new ArrayList<>();
						}
					}
				}else {
					currSum = 0;
					currResultArray = new ArrayList<>();
				}
			}
		}
		return maxResultArray;
	}

	@Test
	void test() {

		Assert.assertEquals(Arrays.asList(41594, 16395, 19113, 71006 ),
				maxset(Arrays.asList(24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501,
						83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113,
						71006, -97942, 42082, -30767, 85695, -73671)));

		Assert.assertEquals(Arrays.asList(1967513926, 1540383426),
				maxset(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368)));

		Assert.assertEquals(new ArrayList<>(), maxset(Arrays.asList(-1, -1, -1)));
		Assert.assertEquals(Arrays.asList(0, 0), maxset(Arrays.asList(0, 0, -1, 0)));

		Assert.assertEquals(Arrays.asList(1, 2, 5), maxset(Arrays.asList(1, 2, 5, -7, 2, 3)));
		Assert.assertEquals(Arrays.asList(2, 3, 4), maxset(Arrays.asList(1, 2, 5, -7, 2, 3, 4)));

		Assert.assertEquals(Arrays.asList(2, 3, 2, 1), maxset(Arrays.asList(1, 2, 5, -7, 2, 3, 2, 1)));
		Assert.assertEquals(Arrays.asList(2, 3, 4), maxset(Arrays.asList(1, 2, 5, -7, 2, 3, 4)));
	}

}
