package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Assert;
import org.junit.Test;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

public class WinningHandTests {

	@Test
	public void isFlush() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.EIGHT, Suit.SPADES));
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.KING, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isFlush());

	}

	@Test
	public void NotFlush() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.EIGHT, Suit.SPADES));
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isFlush());

	}

	@Test
	public void isLowAceStraight() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.TWO, Suit.SPADES));
		list.add(Pair.with(Rank.THREE, Suit.SPADES));
		list.add(Pair.with(Rank.FOUR, Suit.SPADES));
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isStraight());

	}

	@Test
	public void isHighAceStraight() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.TEN, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.QUEEN, Suit.SPADES));
		list.add(Pair.with(Rank.KING, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isStraight());

	}

	@Test
	public void isStraight() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		list.add(Pair.with(Rank.SIX, Suit.SPADES));
		list.add(Pair.with(Rank.SEVEN, Suit.SPADES));
		list.add(Pair.with(Rank.EIGHT, Suit.SPADES));
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isStraight());

	}

	@Test
	public void isNotStraight() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		list.add(Pair.with(Rank.SIX, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.EIGHT, Suit.SPADES));
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isStraight());

	}

	@Test
	public void isRoyalFlus() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		list.add(Pair.with(Rank.QUEEN, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.TEN, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isRoyalFlush());

	}

	@Test
	public void isNotRoyalFlus() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		list.add(Pair.with(Rank.QUEEN, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.TEN, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isRoyalFlush());

	}

	@Test
	public void isStraightFlus() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		list.add(Pair.with(Rank.QUEEN, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.TEN, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isStraightFlush());

	}

	@Test
	public void isNotStraightFlus() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		list.add(Pair.with(Rank.QUEEN, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.TEN, Suit.CLUBS));
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isStraightFlush());

	}

	@Test
	public void isLowStraightFlus() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FOUR, Suit.CLUBS));
		list.add(Pair.with(Rank.THREE, Suit.CLUBS));
		list.add(Pair.with(Rank.TWO, Suit.CLUBS));
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isStraightFlush());

	}

	@Test
	public void isFourOfAKind() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.HEARTS));
		list.add(Pair.with(Rank.FIVE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isFourOfAKind());

	}

	@Test
	public void isNotFourOfAKind() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isFourOfAKind());

	}

	@Test
	public void isFullHouse() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isFullHouse());

	}

	@Test
	public void isNotFullHouse() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isFullHouse());

	}

	@Test
	public void isThreeOfAKind1() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.TWO, Suit.CLUBS));
		list.add(Pair.with(Rank.TWO, Suit.DIAMONDS));
		list.add(Pair.with(Rank.TWO, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isThreeOfAKind());

	}

	@Test
	public void isThreeOfAKind2() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.DIAMONDS));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isThreeOfAKind());

	}

	@Test
	public void isThreeOfAKind3() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isThreeOfAKind());

	}

	@Test
	public void isNotThreeOfAKind() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isThreeOfAKind());

	}

	@Test
	public void isTwoPair1() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.TWO, Suit.CLUBS));
		list.add(Pair.with(Rank.TWO, Suit.DIAMONDS));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.JACK, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isTwoPair());

	}

	@Test
	public void isTwoPair2() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.FIVE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.JACK, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isTwoPair());

	}

	@Test
	public void isTwoPair3() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.FIVE, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isTwoPair());

	}

	@Test
	public void isNotTwoPair() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.NINE, Suit.CLUBS));
		list.add(Pair.with(Rank.NINE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.ACE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.ACE, Suit.DIAMONDS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isTwoPair());

	}

	@Test
	public void isPairOfJacks() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.JACK, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.KING, Suit.DIAMONDS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isJacksOrBetter());

	}

	@Test
	public void isPairOfQeens() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.JACK, Suit.CLUBS));
		list.add(Pair.with(Rank.QUEEN, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.ACE, Suit.HEARTS));
		list.add(Pair.with(Rank.QUEEN, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isJacksOrBetter());

	}

	@Test
	public void isPairOfKings() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.KING, Suit.CLUBS));
		list.add(Pair.with(Rank.ACE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.KING, Suit.HEARTS));
		list.add(Pair.with(Rank.QUEEN, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isJacksOrBetter());

	}

	@Test
	public void isPairOfAces() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		list.add(Pair.with(Rank.ACE, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.KING, Suit.HEARTS));
		list.add(Pair.with(Rank.QUEEN, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertTrue(playersHand.isJacksOrBetter());

	}

	@Test
	public void isNotPairOfJacsOrBetter() {

		List<Pair<Rank, Suit>> list = new ArrayList<Pair<Rank, Suit>>();
		list.add(Pair.with(Rank.ACE, Suit.CLUBS));
		list.add(Pair.with(Rank.KING, Suit.DIAMONDS));
		list.add(Pair.with(Rank.NINE, Suit.SPADES));
		list.add(Pair.with(Rank.NINE, Suit.HEARTS));
		list.add(Pair.with(Rank.QUEEN, Suit.HEARTS));
		WinningHandHelper playersHand = new WinningHandHelper(list);
		Assert.assertFalse(playersHand.isJacksOrBetter());

	}

}
