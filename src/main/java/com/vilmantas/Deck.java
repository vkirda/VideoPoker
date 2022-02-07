package com.vilmantas;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private Card card;
    private final List<Card> cards = new ArrayList<>();

    public Card getSingleCard() {
        return card;
    }

    public void setSingleCard(Rank c, Suit s) {

        this.card = Card.with(c, s);
    }

    public void setNewDeck() {
        for (Suit i : Suit.values()) {
            for (Rank j : Rank.values()) {
                setSingleCard(j, i);
                this.cards.add(getSingleCard());
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

}
