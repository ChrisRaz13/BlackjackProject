package com.skilldistillery.blackjack.entities;

public class Player {

	
	private Hand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public Hand getHand() {
		return hand;
	}
	public String toString() {
		return "Players hand: " + hand.getCards();
	}
}
