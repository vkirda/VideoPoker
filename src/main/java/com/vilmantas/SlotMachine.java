package com.vilmantas;

import java.util.Collections;
import java.util.List;

import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class SlotMachine {

	Deck deck = new Deck();
	private List<Pair<Rank, Suit>> machinesDeck;

	public SlotMachine() {

	}

	public void shuffle() {
		deck.setNewDeck();
		machinesDeck = deck.getDeck();
		Collections.shuffle(machinesDeck);
	}

	public List<Pair<Rank, Suit>> get5Cards() {
		return machinesDeck.subList(0, 5);
	}

	public void discard5Cards() {
		for (int j = 0; j < 5; j++) {
			machinesDeck.remove(0);
		}
	}

	public void discard1Card() {
		machinesDeck.remove(0);
	}

	public Pair<Rank, Suit> get1Card() {
		return machinesDeck.get(0);
	}

	public int determineWinner(List<Pair<Rank, Suit>> list) {

		WinningHandHelper playersHand = new WinningHandHelper(list);

		if (playersHand.isRoyalFlush()) {
			System.out.println("\nYou have Royal Flush!");
			return 800;
		} else if (playersHand.isStraightFlush()) {
			System.out.println("\nYou have Straight Flush!");
			return 50;
		} else if (playersHand.isFourOfAKind()) {
			System.out.println("\nYou have Four of a Kind!");
			return 25;
		} else if (playersHand.isFullHouse()) {
			System.out.println("\nYou have Full House!");
			return 9;
		} else if (playersHand.isFlush()) {
			System.out.println("\nYou have Flush!");
			return 6;
		} else if (playersHand.isStraight()) {
			System.out.println("\nYou have Stright!");
			return 4;
		} else if (playersHand.isThreeOfAKind()) {
			System.out.println("\nYou have Three of a Kind!");
			return 3;
		} else if (playersHand.isTwoPair()) {
			System.out.println("\nYou have Two Pair!");
			return 2;
		} else if (playersHand.isJacksOrBetter()) {
			System.out.println("\nYou have Jacks or Better!");
			return 1;
		} else {
			System.out.println("\nSorry, you have nothing...");
			return 0;
		}

	}

	public void resetDeck() {
		machinesDeck.removeAll(machinesDeck);
	}

}
