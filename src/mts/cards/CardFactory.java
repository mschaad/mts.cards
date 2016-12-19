package mts.cards;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Constructs a Collection<Card>.
 * @author mschaad
 *
 */
public class CardFactory {
	/**
	 * Constructs the 52 cards of a standard French-style deck: four suits of 13 cards each.
	 * @return
	 */
	public static Collection<Card> GetStandard52() {
		ArrayList<Card> cards = new ArrayList<>(52);
		
		for(Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
		return cards;
	}
}
