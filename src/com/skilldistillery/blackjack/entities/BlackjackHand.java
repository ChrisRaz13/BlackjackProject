package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackHand extends Hand {

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		List<Card> cards = getCards();
		for (int i = 0; i < cards.size(); i++) {
			sb.append(cards.get(i));
			if (i < cards.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public int calculateScore() {
		int score = 0;

		for (Card card : getCards()) {
			if (card.getRank().equals(Rank.ACE)) {
				score += 11;
			} else if (card.getRank().equals(Rank.KING) || card.getRank().equals(Rank.QUEEN)
					|| card.getRank().equals(Rank.JACK)) {
				score += 10;
			} else {
				score += card.getValue();
			}
		}

		return score;
	}
}