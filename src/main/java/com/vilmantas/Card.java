package com.vilmantas;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card with(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return "[" + rank + " of " + suit + "]";
    }
}
