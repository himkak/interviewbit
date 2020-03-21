package com.interviewbit.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class LargestNumber {

	public String largestNumber(final List<Integer> B) {

		List<Integer> A = new ArrayList<>(B);
		Collections.sort(A, (a, b) -> {
			String left = a + "" + b;
			String right = b + "" + a;
			return right.compareTo(left);
		});

		StringBuilder result = new StringBuilder();
		for (Integer i : A) {
			result = result.append(i);
		}
		if (result.toString().matches("^0+$")) {
			result = new StringBuilder("0");
		}
		return result.toString();
	}

	private boolean isRightHigher(Integer integer, Integer integer2) {

		String left = integer + "" + integer2;
		String right = integer2 + "" + integer;
		if (Long.parseLong(right) > Long.parseLong(left)) {
			return true;
		}
		return false;

	}

	@Test
	public void test() {

		Assert.assertTrue(isRightHigher(980, 98));

		Assert.assertEquals(
				"99799599398980975969969943923911910884880866838814785722694692689684674664657623599563515496494470444438437426400399379377369365363359358341329324302302250231230204176168161152143126124121113106",
				largestNumber(Arrays.asList(980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923, 969, 880, 997,
						664, 152, 329, 975, 377, 995, 943, 369, 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113,
						302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684, 365, 470, 176, 910,
						204, 324, 657, 161, 884, 623, 814, 231, 694, 399, 126, 426)));

		Assert.assertFalse(isRightHigher(2, 206));

		Assert.assertEquals(
				"999929689669599469289119078875861850849848358308298148078077917837827617577477457196906696665563061060660459592584575568566557552552550540540523505494477456456440438430427419408404403400398393383351348347332328319311303292282692622522522452372262262216213206180174164161143139137115114111",
				largestNumber(Arrays.asList(180, 226, 946, 505, 719, 245, 928, 427, 550, 164, 610, 252, 604, 875, 269,
						419, 850, 213, 139, 761, 216, 303, 849, 319, 440, 66, 552, 143, 174, 456, 347, 400, 669, 332,
						861, 252, 237, 540, 540, 690, 966, 992, 351, 655, 494, 814, 2, 403, 114, 557, 783, 430, 745,
						782, 911, 292, 328, 206, 456, 59, 393, 161, 226, 835, 747, 408, 115, 829, 791, 552, 84, 592,
						757, 907, 584, 523, 959, 348, 99, 575, 477, 566, 383, 968, 438, 807, 606, 8, 807, 111, 398, 28,
						830, 311, 404, 262, 630, 137, 568)));

		Assert.assertFalse(isRightHigher(4, 412));

		Assert.assertEquals("9648527226766636354854724412368319",
				largestNumber(Arrays.asList(472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412)));
		Assert.assertEquals("9534330", largestNumber(Arrays.asList(3, 30, 34, 5, 9)));
	}

}
