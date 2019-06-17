package com.vilmantas;

//import org.javatuples.Pair;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class Card<Rank, Suit> {
	
	private Rank rank;
	private Suit suit;
	
	
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public static <Rank, Suit> Card<Rank, Suit> with(Rank rank, Suit suit) {
		 return new Card<Rank, Suit>(rank,suit);
	}
	
	public Rank getValue0() {
		return this.rank;
	}
	
	public Suit getValue1() {
		return this.suit;
	}
	
	@Override
	public String toString() {
	  return "["+ rank +" of "+ suit +"]";
	}

}
