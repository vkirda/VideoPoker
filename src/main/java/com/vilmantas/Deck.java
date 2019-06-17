package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

//import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Deck {

	private Card<Rank, Suit> card;
	private List<Card<Rank, Suit>> deck = new ArrayList<>();

	public Deck() {
	}

	public Card<Rank, Suit> getSingleCard() {
		return card;
	}

	public void setSingleCard(Rank c, Suit s) {

		this.card = Card.with(c, s);

	}

	public void setNewDeck() {
		for (Suit i : Suit.values()) {
			for (Rank j : Rank.values()) {
				setSingleCard(j, i);
				this.deck.add(getSingleCard());
			}
		}
	}

	public List<Card<Rank, Suit>> getDeck() {
		return deck;
	}

}
