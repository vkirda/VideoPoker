package com.vilmantas;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WinningHandTests {

    @Test
    public void isFlush() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.EIGHT, Suit.SPADES));
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.KING, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isFlush());

    }

    @Test
    public void NotFlush() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.EIGHT, Suit.SPADES));
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isFlush());

    }

    @Test
    public void isLowAceStraight() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.TWO, Suit.SPADES));
        list.add(Card.with(Rank.THREE, Suit.SPADES));
        list.add(Card.with(Rank.FOUR, Suit.SPADES));
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isStraight());

    }

    @Test
    public void isHighAceStraight() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.TEN, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.QUEEN, Suit.SPADES));
        list.add(Card.with(Rank.KING, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isStraight());

    }

    @Test
    public void isStraight() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        list.add(Card.with(Rank.SIX, Suit.SPADES));
        list.add(Card.with(Rank.SEVEN, Suit.SPADES));
        list.add(Card.with(Rank.EIGHT, Suit.SPADES));
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isStraight());

    }

    @Test
    public void isNotStraight() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        list.add(Card.with(Rank.SIX, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.EIGHT, Suit.SPADES));
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isStraight());

    }

    @Test
    public void isRoyalFlus() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        list.add(Card.with(Rank.QUEEN, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.TEN, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isRoyalFlush());

    }

    @Test
    public void isNotRoyalFlus() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        list.add(Card.with(Rank.QUEEN, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.TEN, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isRoyalFlush());

    }

    @Test
    public void isStraightFlus() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        list.add(Card.with(Rank.QUEEN, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.TEN, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isStraightFlush());

    }

    @Test
    public void isNotStraightFlus() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        list.add(Card.with(Rank.QUEEN, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.TEN, Suit.CLUBS));
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isStraightFlush());

    }

    @Test
    public void isLowStraightFlus() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FOUR, Suit.CLUBS));
        list.add(Card.with(Rank.THREE, Suit.CLUBS));
        list.add(Card.with(Rank.TWO, Suit.CLUBS));
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isStraightFlush());

    }

    @Test
    public void isFourOfAKind() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.DIAMONDS));
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.HEARTS));
        list.add(Card.with(Rank.FIVE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isFourOfAKind());

    }

    @Test
    public void isNotFourOfAKind() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.DIAMONDS));
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isFourOfAKind());

    }

    @Test
    public void isFullHouse() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.DIAMONDS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isFullHouse());

    }

    @Test
    public void isNotFullHouse() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.DIAMONDS));
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isFullHouse());

    }

    @Test
    public void isThreeOfAKind1() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.TWO, Suit.CLUBS));
        list.add(Card.with(Rank.TWO, Suit.DIAMONDS));
        list.add(Card.with(Rank.TWO, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isThreeOfAKind());

    }

    @Test
    public void isThreeOfAKind2() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.DIAMONDS));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isThreeOfAKind());

    }

    @Test
    public void isThreeOfAKind3() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.DIAMONDS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isThreeOfAKind());

    }

    @Test
    public void isNotThreeOfAKind() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.DIAMONDS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isThreeOfAKind());

    }

    @Test
    public void isTwoCard1() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.TWO, Suit.CLUBS));
        list.add(Card.with(Rank.TWO, Suit.DIAMONDS));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.JACK, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isTwoPair());

    }

    @Test
    public void isTwoCard2() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.FIVE, Suit.DIAMONDS));
        list.add(Card.with(Rank.JACK, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isTwoPair());

    }

    @Test
    public void isTwoCard3() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.FIVE, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isTwoPair());

    }

    @Test
    public void isNotTwoCard() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.NINE, Suit.CLUBS));
        list.add(Card.with(Rank.NINE, Suit.DIAMONDS));
        list.add(Card.with(Rank.ACE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.ACE, Suit.DIAMONDS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isTwoPair());

    }

    @Test
    public void isCardOfJacks() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.JACK, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.KING, Suit.DIAMONDS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isJacksOrBetter());

    }

    @Test
    public void isCardOfQeens() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.JACK, Suit.CLUBS));
        list.add(Card.with(Rank.QUEEN, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.ACE, Suit.HEARTS));
        list.add(Card.with(Rank.QUEEN, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isJacksOrBetter());

    }

    @Test
    public void isCardOfKings() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.KING, Suit.CLUBS));
        list.add(Card.with(Rank.ACE, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.KING, Suit.HEARTS));
        list.add(Card.with(Rank.QUEEN, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isJacksOrBetter());

    }

    @Test
    public void isCardOfAces() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        list.add(Card.with(Rank.ACE, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.KING, Suit.HEARTS));
        list.add(Card.with(Rank.QUEEN, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertTrue(playersHand.isJacksOrBetter());

    }

    @Test
    public void isNotCardOfJacsOrBetter() {

        List<Card> list = new ArrayList<>();
        list.add(Card.with(Rank.ACE, Suit.CLUBS));
        list.add(Card.with(Rank.KING, Suit.DIAMONDS));
        list.add(Card.with(Rank.NINE, Suit.SPADES));
        list.add(Card.with(Rank.NINE, Suit.HEARTS));
        list.add(Card.with(Rank.QUEEN, Suit.HEARTS));
        WinningHandHelper playersHand = new WinningHandHelper(list);
        Assert.assertFalse(playersHand.isJacksOrBetter());

    }

}
