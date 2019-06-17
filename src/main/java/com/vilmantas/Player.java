package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

//import org.javatuples.Card;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Player {

	private List<Card<Rank, Suit>> playersCards = new ArrayList<Card<Rank, Suit>>();
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

		if (playersBank - betAmount > 0) {
			this.wager = betAmount;
			this.playersBank = playersBank - wager;
		} else {
			System.out.println("\nYou cannot bet that much! Your balance is: " + playersBank + ", try again.");
			takeMoney();
			System.exit(0);
		}

	}

	public int getWager() {
		return wager;
	}

	public void setPlayerCards(List<Card<Rank, Suit>> slotMachineCards) {

		this.playersCards.addAll(slotMachineCards);

	}

	public void setPlayerCards(Card<Rank, Suit> slotMachineCards) {

		this.playersCards.add(slotMachineCards);

	}

	public List<Card<Rank, Suit>> getPlayerCards() {

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
