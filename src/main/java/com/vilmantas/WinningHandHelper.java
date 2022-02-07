package com.vilmantas;

import com.vilmantas.enums.Rank;
import com.vilmantas.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class WinningHandHelper {

    // sorted by default and no duplicates
    private final EnumSet<Suit> suitsUniqueSorted = EnumSet.noneOf(Suit.class);
    private final EnumSet<Rank> ranksUniqueSorted = EnumSet.noneOf(Rank.class);

    // need duplicates
    private final List<Rank> ranks = new ArrayList<>();

    public WinningHandHelper(List<Card> list) {

        list.forEach(card -> {
            this.ranksUniqueSorted.add(card.getRank());
            this.suitsUniqueSorted.add(card.getSuit());
            this.ranks.add(card.getRank());
        });

        Collections.sort(ranks);
    }

    public boolean isRoyalFlush() {

        return ranksUniqueSorted.contains(Rank.ACE) && ranksUniqueSorted.contains(Rank.KING) && isFlush() && isStraight();
    }

    public boolean isStraightFlush() {

        return (!ranksUniqueSorted.contains(Rank.ACE) || !ranksUniqueSorted.contains(Rank.KING)) && isFlush() && isStraight();

    }

    public boolean isFourOfAKind() {

        return ranks.get(0) == ranks.get(3) || ranks.get(1) == ranks.get(4);
    }

    public boolean isFullHouse() {

        return (ranks.get(0) == ranks.get(2) && ranks.get(3) == ranks.get(4)) ||
                (ranks.get(0) == ranks.get(1) && ranks.get(2) == ranks.get(4));
    }

    public boolean isFlush() {

        return ranksUniqueSorted.size() == 5 && suitsUniqueSorted.size() == 1;

    }

    public boolean isStraight() {

        if (ranksUniqueSorted.size() != 5) {
            return false;
        }

        if (ranksUniqueSorted.contains(Rank.ACE) &&
                ranksUniqueSorted.contains(Rank.TWO) &&
                ranksUniqueSorted.contains(Rank.THREE) &&
                ranksUniqueSorted.contains(Rank.FOUR) &&
                ranksUniqueSorted.contains(Rank.FIVE)) {
            return true;
        }

        // Taking first card in the hand and to its value adding 1 - that means second
        // card value has to increase one. If not - that's not straight
        int nextCard = ranks.get(0).ordinal() + 1;
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i).ordinal() != nextCard) {
                return false;
            }
            nextCard++;
        }

        return true;
    }

    public boolean isThreeOfAKind() {

        return (isRanksSameAtIndex(0, 2) && isRanksNotSameAtIndex(3, 4)) ||
                (isRanksSameAtIndex(1, 3) && isRanksNotSameAtIndex(0, 4)) ||
                (isRanksSameAtIndex(2, 4) && isRanksNotSameAtIndex(0, 1));
    }

    public boolean isTwoPair() {

        if (ranksUniqueSorted.size() != 3) {
            return false;
        }

        return (isRanksSameAtIndex(0, 1) && isRanksSameAtIndex(2, 3)) ||
                (isRanksSameAtIndex(0, 1) && isRanksSameAtIndex(3, 4)) ||
                (isRanksSameAtIndex(1, 2) && isRanksSameAtIndex(3, 4));
    }

    public boolean isJacksOrBetter() {

        int jackCounter = 0;
        int queenCounter = 0;
        int kingCounter = 0;
        int aceCounter = 0;

        if (ranksUniqueSorted.size() != 4) {
            return false;
        }

        for (Rank rank : ranks) {
            if (rank == Rank.JACK) {
                jackCounter++;
            }
            if (rank == Rank.QUEEN) {
                queenCounter++;
            }
            if (rank == Rank.KING) {
                kingCounter++;
            }
            if (rank == Rank.ACE) {
                aceCounter++;
            }
        }

        return jackCounter == 2 || queenCounter == 2 || kingCounter == 2 || aceCounter == 2;
    }

    private boolean isRanksSameAtIndex(int sortedCardIndex1, int sortedCardIndex2) {
        return ranks.get(sortedCardIndex1) == ranks.get(sortedCardIndex2);
    }

    private boolean isRanksNotSameAtIndex(int sortedCardIndex1, int sortedCardIndex2) {
        return ranks.get(sortedCardIndex1) != ranks.get(sortedCardIndex2);
    }

}
