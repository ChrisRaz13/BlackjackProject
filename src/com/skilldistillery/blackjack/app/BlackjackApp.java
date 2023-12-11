package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		Player p = new Player();
		Dealer d = new Dealer();
		Deck deck = new Deck();
		dealCards(p, d, deck);

		System.out.println("Welcome to Blackjack");
		System.out.println("The hands: ");
		System.out.println(p);
		System.out.println(d);
		System.out.println("Player's Score: " + p.getHand().calculateScore());

		Scanner sc = new Scanner(System.in);
		playerTurn(sc, p, deck);

		dealerTurn(d, deck);

		determineWinner(p, d);
	}

	private void dealCards(Player player, Dealer dealer, Deck deck) {
		player.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		player.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
	}

	private void playerTurn(Scanner scanner, Player p, Deck deck) {
		while (true) {
			System.out.println("Do you want to Hit (H) or Stand (S)?");
			String choice = scanner.next();

			if ("H".equalsIgnoreCase(choice)) {
				Card newCard = deck.dealCard();
				p.getHand().addCard(newCard);
				System.out.println("Player draws: " + newCard);
				System.out.println("Player's Hand: " + p.getHand());
				System.out.println("Player's Score: " + p.getHand().calculateScore());

				if (p.getHand().calculateScore() > 21) {
					System.out.println("Bust! Player's score is over 21.");
					break;
				}
			} else if ("S".equalsIgnoreCase(choice)) {
				System.out.println("Player chooses to Stand.");
				break;
			} else {
				System.out.println("Invalid choice. Please enter 'H' or 'S'.");
			}
		}
	}

	private void dealerTurn(Dealer d, Deck deck) {
		System.out.println("Dealer's turn:");

		System.out.println("Dealer's Hand: " + d.getHand());

		// Dealer must Hit until the score is at least 17
		while (d.getHand().calculateScore() < 18) {
			Card newCard = deck.dealCard();
			d.getHand().addCard(newCard);
			System.out.println("Dealer draws: " + newCard);
			System.out.println("Dealer's Hand: " + d.getHand());
		}

		if (d.getHand().calculateScore() > 21) {
			System.out.println("Bust! Dealer's score is over 21.");
		} else {
			System.out.println("Dealer chooses to Stand.");
		}
	}

	private void determineWinner(Player p, Dealer d) {
		System.out.println("\nResults:");

		int playerScore = p.getHand().calculateScore();
		int dealerScore = d.getHand().calculateScore();

		System.out.println("Player's Hand: " + p.getHand() + " (Score: " + playerScore + ")");
		System.out.println("Dealer's Hand: " + d.getHand() + " (Score: " + dealerScore + ")");

		if (playerScore > 21) {
			System.out.println("Player busts. Dealer wins!");
		} else if (dealerScore > 21) {
			System.out.println("Dealer busts. Player wins!");
		} else if (playerScore > dealerScore) {
			System.out.println("Player wins!");
		} else if (playerScore < dealerScore) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("It's a tie!");
		}

	}
}