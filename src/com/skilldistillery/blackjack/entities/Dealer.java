package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;
	
	
	public String toString() {
		return "Dealers hand: " + getHand().getCards();
	}
}
