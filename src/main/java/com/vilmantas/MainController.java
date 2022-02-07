package com.vilmantas;

import java.util.Scanner;

public class MainController {

    static Player player = new Player();
    static SlotMachine slot = new SlotMachine();

    public static void main(String[] args) {

        System.out.flush();
        Scanner scan = new Scanner(System.in);

        System.out.println("Wellcome to Virtual Poker game! \n");
        System.out.print("Please enter amount of your Buy-in: ");

        while (!scan.hasNextInt()) {
            System.out.println("Pleas enter number! ");
            System.out.print("Please enter amount of your Buy-in: ");
            scan.nextLine();
        }

        player.addMoney(scan.nextInt());

        System.out.println("\nYour balance is: " + player.checkBalance());

        meniu();

        scan.close();

    }

    private static void meniu() {

        Scanner scan = new Scanner(System.in);
        String options = null;

        System.out.println("\nYour options is:\n");
        System.out.println("1. Play");
        System.out.println("2. Quit\n");
        System.out.print("Type them here: ");

        do {
            options = scan.next();
            if (!options.equalsIgnoreCase("play") && !options.equalsIgnoreCase("quit")) {
                System.out.println("Wrong keyword, try again...");
                System.out.print("\nType here: ");
            }
        } while (!options.equalsIgnoreCase("play") && !options.equalsIgnoreCase("quit"));

        if (options.equalsIgnoreCase("play")) {

            subMeniuPlay();
        } else if (options.equalsIgnoreCase("quit")) {
            exit();
        }

//		scan.close();
    }

    private static void subMeniuPlay() {

        System.out.print("\nPleas enter amount you want to bet: ");

        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Pleas enter number! ");
            System.out.print("\nPleas enter amount you want to bet: ");
            scan.nextLine();
        }

        int betAmount = scan.nextInt();

        player.setWager(betAmount);
        System.out.println("\nYour bet is: " + player.getWager() + " EUR");
        slot.shuffle();
        player.setPlayerCards(slot.get5Cards());

        System.out.println("\nYour cards:");

        for (int i = 0; i < player.getPlayerCards().size(); i++) {

            System.out.println(player.getPlayerCards().get(i));

        }

        slot.discard5Cards();

        System.out.println("\nYour options:");
        System.out.println("\n1. Change 1 card  - type: 1");
        System.out.println("2. Change 2 cards - type: 2");
        System.out.println("3. Finish hand - type: finish");
        System.out.print("\nType here: ");

        String subMeniuOptions = null;
        do {
            subMeniuOptions = scan.next();
            if (!subMeniuOptions.equalsIgnoreCase("1") &&
                    !subMeniuOptions.equalsIgnoreCase("2") &&
                    !subMeniuOptions.equalsIgnoreCase("finish")) {
                System.out.println("Wrong keyword, try again...");
                System.out.print("\nType here: ");
            }
        } while (!subMeniuOptions.equalsIgnoreCase("1") &&
                !subMeniuOptions.equalsIgnoreCase("2")  &&
                !subMeniuOptions.equalsIgnoreCase("finish"));

        if (subMeniuOptions.equalsIgnoreCase("1")) {
            subMeniuChange1();
        } else if (subMeniuOptions.equalsIgnoreCase("2")) {
            subMeniuChange2();
        } else if (subMeniuOptions.equalsIgnoreCase("finish")) {
            subMeniuFinish();
        }

//		scan.close();

    }

    private static void subMeniuFinish() {

        // verify wining hand and pay or take(no card changing)
        int multiplier = slot.determineWinner(player.getPlayerCards());
        player.winOrLose(multiplier * player.getWager() + player.getWager());
        System.out.println("\nYour balance is: " + player.checkBalance());
        player.discardAllCards();
        slot.resetDeck();
        meniu();

    }

    private static void subMeniuChange2() {

        discarding1Card();
        discarding1Card();
        player.setPlayerCards(slot.get1Card());
        slot.discard1Card();
        player.setPlayerCards(slot.get1Card());

        System.out.println("\nCards after change:");
        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            System.out.println(player.getPlayerCards().get(i));
        }

        slot.discard1Card();

        int multiplier = slot.determineWinner(player.getPlayerCards());
        player.winOrLose(multiplier * player.getWager() + player.getWager());
        System.out.println("\nYour balance is: " + player.checkBalance());
        player.discardAllCards();
        slot.resetDeck();

        meniu();

    }

    private static void subMeniuChange1() {

        discarding1Card();

        player.setPlayerCards(slot.get1Card());

        System.out.println("\nCards after change:");
        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            System.out.println(player.getPlayerCards().get(i));
        }

        slot.discard1Card();

        int multiplier = slot.determineWinner(player.getPlayerCards());
        player.winOrLose(multiplier * player.getWager() + player.getWager());
        System.out.println("\nYour balance is: " + player.checkBalance());
        player.discardAllCards();
        slot.resetDeck();

        meniu();

    }

    private static void discarding1Card() {

        Scanner scan = new Scanner(System.in);

        System.out.print("\nPleas enter number of the card you want to discard: ");

        String cardNumber = null;
        do {
            cardNumber = scan.next();
            if (!cardNumber.equalsIgnoreCase("1") &&
                    !cardNumber.equalsIgnoreCase("2") &&
                    !cardNumber.equalsIgnoreCase("3") &&
                    !cardNumber.equalsIgnoreCase("4") &&
                    !cardNumber.equalsIgnoreCase("5")
            ) {
                System.out.println("Wrong number, try again...");
            }
        } while (!cardNumber.equalsIgnoreCase("1") &&
                !cardNumber.equalsIgnoreCase("2") &&
                !cardNumber.equalsIgnoreCase("3") &&
                !cardNumber.equalsIgnoreCase("4") &&
                !cardNumber.equalsIgnoreCase("5"));

        player.discard1(Integer.parseInt(cardNumber));

        System.out.println("\nRemaining cards:");
        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            System.out.println(player.getPlayerCards().get(i));
        }

//		scan.close();
    }

    private static void exit() {

        System.out.println("\nThank you for the game!");
        System.out.println("\nYou leave with " + player.checkBalance() + " EUR");
        player.takeMoney();
        System.exit(0);

    }

}
