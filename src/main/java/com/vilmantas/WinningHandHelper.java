package com.vilmantas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

//import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class WinningHandHelper {

	// sorted by default and no duplicates
	private EnumSet<Suit> suitSet = EnumSet.noneOf(Suit.class);
	private EnumSet<Rank> rankSet = EnumSet.noneOf(Rank.class);

	// sorted by default and no duplicates, has method get not like EnumSet
	private List<Suit> suitListFromSet = new ArrayList<Suit>();
	private List<Rank> rankListFromSet = new ArrayList<Rank>();

	// just regular list, need duplicates and sorted
	private List<Rank> rankList = new ArrayList<Rank>();

	public WinningHandHelper(List<Card<Rank, Suit>> list) {

		for (int i = 0; i < list.size(); i++) {
			this.rankSet.add(list.get(i).getValue0());
			this.suitSet.add(list.get(i).getValue1());
			this.rankList.add(list.get(i).getValue0());
		}
		this.rankListFromSet.addAll(rankSet);
		this.suitListFromSet.addAll(suitSet);

		// sorting list
		Collections.sort(rankList);
	}

	public EnumSet<Suit> getSuitSet() {
		return suitSet;
	}

	public EnumSet<Rank> getRankSet() {
		return rankSet;
	}

	public boolean isRoyalFlush() {

		if (rankSet.contains(Rank.ACE) && rankSet.contains(Rank.KING)) {
			if (isFlush() && isStraight()) {
				return true;
			}
		}

		return false;
	}

	public boolean isStraightFlush() {

		// if hand has ace and king - its not straight flush
		if (rankSet.contains(Rank.ACE) && rankSet.contains(Rank.KING)) {
			return false;
		}

		if (isFlush() && isStraight()) {
			return true;
		}

		return false;
	}

	public boolean isFourOfAKind() {

		// list is already sorted by the constructor
		if (rankList.get(0) == rankList.get(3) || rankList.get(1) == rankList.get(4)) {
			return true;
		}

		return false;
	}

	public boolean isFullHouse() {

		// list is already sorted by the constructor
		if ((rankList.get(0) == rankList.get(2) && (rankList.get(3) == rankList.get(4)))
				|| (rankList.get(0) == rankList.get(1) && (rankList.get(2) == rankList.get(4)))) {
			return true;
		}
		return false;
	}

	public boolean isFlush() {

		// if there is no duplicates in rank set - then proceed
		if (rankSet.size() == 5) {
			// there is 5 duplicates in suit set - then set only show 1 element
			if (suitSet.size() == 1) {
				return true;
			}
		}

		return false;
	}

	public boolean isStraight() {

		if (rankSet.size() == 5) {

			if (rankSet.contains(Rank.ACE) && rankSet.contains(Rank.TWO) && rankSet.contains(Rank.THREE)
					&& rankSet.contains(Rank.FOUR) && rankSet.contains(Rank.FIVE)) {
				return true;
			}

			// Taking first card in the hand and to its value adding 1 - that means second
			// card value has to increase one. If not - thats not straight
			int nextCard = rankListFromSet.get(0).ordinal() + 1;
			for (int i = 1; i < rankListFromSet.size(); i++) {
				if (rankListFromSet.get(i).ordinal() != nextCard) {
					return false;
				}
				nextCard++;
			}
			return true;

		}
		return false;
	}

	public boolean isThreeOfAKind() {

		if ((rankList.get(0) == rankList.get(2) && (rankList.get(3) != rankList.get(4)))
				|| (rankList.get(1) == rankList.get(3) && (rankList.get(0) != rankList.get(4)))
				|| (rankList.get(2) == rankList.get(4) && (rankList.get(0) != rankList.get(1)))) {
			return true;
		}
		return false;
	}

	public boolean isTwoPair() {
		if (rankSet.size() == 3) {
			if ((rankList.get(0) == rankList.get(1) && (rankList.get(2) == rankList.get(3)))
					|| (rankList.get(0) == rankList.get(1) && (rankList.get(3) == rankList.get(4)))
					|| (rankList.get(1) == rankList.get(2) && (rankList.get(3) == rankList.get(4)))) {
				return true;
			}
		}
		return false;
	}

	public boolean isJacksOrBetter() {
		int jackCounter = 0;
		int queenCounter = 0;
		int kingCounter = 0;
		int aceCounter = 0;
		if (rankSet.size() == 4) {
			for (int i = 0; i < rankList.size(); i++) {
				if (rankList.get(i) == Rank.JACK) {
					jackCounter++;
				}
				if (rankList.get(i) == Rank.QUEEN) {
					queenCounter++;
				}
				if (rankList.get(i) == Rank.KING) {
					kingCounter++;
				}
				if (rankList.get(i) == Rank.ACE) {
					aceCounter++;
				}
			}

			if (jackCounter == 2 || queenCounter == 2 || kingCounter == 2 || aceCounter == 2) {
				return true;
			}
		}

		return false;
	}

}
