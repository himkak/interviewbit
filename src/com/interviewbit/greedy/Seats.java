package com.interviewbit.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class Seats {

	public int seats(String A) {
		List<Integer> vacantSeats = new ArrayList<>();
		List<Integer> occupiedSeats = new ArrayList<>();
		A = A.replaceAll(" ", "");
		char[] chArr = A.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] == 'x') {
				occupiedSeats.add(i);
			} else {
				vacantSeats.add(i);
			}
		}
		if (occupiedSeats.size() == 0 || vacantSeats.size() == 0) {
			return 0;
		}

		// identify static first element index
		int minMoves = Integer.MAX_VALUE;
		int occupiedSeat = occupiedSeats.get(occupiedSeats.size() / 2);
		int tmpMoves = getNoOfMovesForConstantSeat(occupiedSeat, occupiedSeats);
		minMoves = tmpMoves < minMoves ? tmpMoves : minMoves;

		return minMoves % 10000003;
	}

	private int getNoOfMovesForConstantSeat(int occupiedSeat, List<Integer> occupiedSeats) {
		Set<Integer> newOccupiedPos = new TreeSet<>(occupiedSeats);
		int moves = 0;
		for (Integer currSeat : occupiedSeats) {
			if (currSeat != occupiedSeat && !isConnected(currSeat, occupiedSeat, newOccupiedPos)) {
				// is onRIght
				if (currSeat > occupiedSeat) {
					// find avbl seat to right of occupiedSeat
					int avblSeat = occupiedSeat;
					while (newOccupiedPos.contains(avblSeat)) {
						avblSeat++;
					}
					moves = moves + currSeat - avblSeat;
					newOccupiedPos.remove(currSeat);
					newOccupiedPos.add(avblSeat);
				} else {
					// is on left
					int avblSeat = occupiedSeat;
					while (newOccupiedPos.contains(avblSeat)) {
						avblSeat--;
					}
					moves = moves + avblSeat - currSeat;
					newOccupiedPos.remove(currSeat);
					newOccupiedPos.add(avblSeat);
				}
			}
		}
		return moves;

	}

	private boolean isConnected(Integer currSeat, int occupiedSeat, Set<Integer> newOccupiedPos) {
		while (newOccupiedPos.contains(occupiedSeat)) {
			if (currSeat < occupiedSeat)
				occupiedSeat--;
			else
				occupiedSeat++;
			if (currSeat == occupiedSeat) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void test() {
		Assert.assertEquals(5, seats(". . . . x . . x x . . . x . ."));

	}

	@Test
	public void test1() {
		Assert.assertEquals(0, seats(".xxx"));

	}

}
