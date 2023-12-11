package com.skilldistillery.blackjack.entities;

public class Card {
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getValue() {
		return rank.getValue();
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	public int getValues() {
		switch (rank) {
		case ACE:
			return 11; 
		case KING:
		case QUEEN:
		case JACK:
			return 10;
		default:
			return rank.getValue(); 
		}
	}
}
