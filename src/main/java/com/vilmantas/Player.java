package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Player {

	private List<Pair<Rank, Suit>> playersCards = new ArrayList<Pair<Rank, Suit>>();
	private int playersBank = 0;
	private int wager = 0;

	public void addmoney(int amount) {
		playersBank = playersBank + amount;
	}

	public int checkBalance() {
		return playersBank;
	}

	public void takeMoney() {
		playersBank = 0;
	}

	public void setWager(int betAmount) {
		this.wager = betAmount;
		this.playersBank = playersBank - wager;
	}

	public int getWager() {
		return wager;
	}

	public void setPlayerCards(List<Pair<Rank, Suit>> slotMachineCards) {

		this.playersCards.addAll(slotMachineCards);

	}

	public void setPlayerCards(Pair<Rank, Suit> slotMachineCards) {

		this.playersCards.add(slotMachineCards);

	}

	public List<Pair<Rank, Suit>> getPlayerCards() {

		return playersCards;
	}

	public void discard1(int cardNumber) {

		this.playersCards.remove(cardNumber - 1);

	}

	public void discardAllCards() {

		this.playersCards.removeAll(playersCards);

	}

	public void winOrLose(int payout) {
		if (payout == getWager()) {
			payout = 0;
		}
		this.playersBank = playersBank + payout;
	}

}
