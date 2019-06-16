package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Deck {

	private Pair<Rank, Suit> card;
	private List<Pair<Rank, Suit>> deck = new ArrayList<>();

	public Deck() {
	}

	public Pair<Rank, Suit> getSingleCard() {
		return card;
	}

	public void setSingleCard(Rank c, Suit s) {

		this.card = Pair.with(c, s);

	}

	public void setNewDeck() {
		for (Suit i : Suit.values()) {
			for (Rank j : Rank.values()) {
				setSingleCard(j, i);
				this.deck.add(getSingleCard());
			}
		}
	}

	public List<Pair<Rank, Suit>> getDeck() {
		return deck;
	}

}
