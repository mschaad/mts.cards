package mts.cards;

/**
 * A standard, French-style deck of cards.
 * 
 * <p>
 * Shuffling algorithm (and entropy collection method) are implementation dependent.
 * </p>
 * 
 * @author mschaad
 * @version		0.1
 * @since		0.1
 *
 */
public interface Deck {
	/**
	 * Shuffles the cards in the deck in a pseudo-random order.
	 * 
	 * <p>
	 * This operation succeeds even if the deck is empty.
	 * </p>
	 */
	void shuffle();
	
	/**
	 * Removes one card from the top of the deck, if possible,
	 * or throws if the deck is empty.
	 * 
	 * @return							a Card from the top of the deck
	 * @throws IllegalStateException	If the deck is empty.
	 */
	Card dealOneCard() throws IllegalStateException;
	
	/**
	 * Returns the count of cards remaining in the deck.
	 * 
	 * @return	the count of cards remaining in the deck.
	 */
	int getCount();
}
