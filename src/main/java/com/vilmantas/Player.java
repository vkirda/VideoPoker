package com.vilmantas;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Card> playersCards = new ArrayList<>();
    private int playersBank = 0;
    private int wager = 0;

    public void addMoney(int amount) {

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

    public void setPlayerCards(List<Card> slotMachineCards) {

        this.playersCards.addAll(slotMachineCards);
    }

    public void setPlayerCards(Card slotMachineCards) {

        this.playersCards.add(slotMachineCards);
    }

    public List<Card> getPlayerCards() {

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
