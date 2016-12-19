package mts.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The default implementation of Deck.
 * 
 * <p>
 * 
 * </p>
 * @author mschaad
 *
 */
public class DefaultDeck 
	implements Deck {

	private Deque<Card> cards;
	private final Random rng;
	
	/**
	 * Constructs a new, empty DefaultDeck object with a 
	 * new instance of the Random class supplied as the 
	 * random number generator used for shuffling.
	 */
	public DefaultDeck() {
		this(new Random());
	}

	/**
	 * Constructs a new DefaultDeck object populated with 
	 * the cards from @cards and a new instance of the 
	 * Random class supplied as the random number generator used
	 * for shuffling.
	 *  
	 * @param cards	The card collection used to initialize the deck.
	 */
	public DefaultDeck(Collection<Card> cards) {
		this(cards, new Random());
	}
		
	/**
	 * Constructs a new DefaultDeck object populated with 
	 * the cards from @cards and the given instance of the 
	 * Random class supplied as the random number generator 
	 * used for shuffling.
	 *  
	 * @param cards	The card collection used to initialize the deck.
	 */
	public DefaultDeck(Random rng) {
		this(new ArrayList<Card>(), rng);
	}
	
	/**
	 * Constructs a new DefaultDeck object populated with 
	 * the cards from @cards and the given instance of the 
	 * Random class supplied as the random number generator 
	 * used for shuffling.
	 *  
	 * @param cards	The card collection used to initialize the deck.
	 */
	public DefaultDeck(Collection<Card> cards, Random rng) {
		if (cards == null) {
			throw new IllegalArgumentException("cards cannot be null.");
		}
		if (rng == null) {
			throw new IllegalArgumentException("rng cannot be null.");
		}
		
		this.cards = new LinkedList<Card>(cards);
		this.rng = rng;
	}
	
	/**
	 * Returns the count of cards remaining in the deck.
	 * 
	 * @return	the count of cards remaining in the deck.
	 */
	@Override
	public int getCount() {
		return cards.size();
	}
	

	/**
	 * Removes one card from the top of the deck, if possible,
	 * or throws if the deck is empty.
	 * 
	 * @return							a Card from the top of the deck
	 * @throws IllegalStateException	If the deck is empty.
	 */
	@Override
	public Card dealOneCard() throws IllegalStateException {
		if (getCount() == 0) {
			throw new IllegalStateException("dealOneCard() cannot be called when the deck is empty.");
		}
		
		Card card = cards.removeFirst();
		return card;
	}
	
	/**
	 * Shuffles the cards in the deck in a pseudo random order,
	 * using the Random object supplied in the constructor.
	 */
	@Override
	public void shuffle() {
		
		Comparator<CardWeight> byWeight = (e1, e2) -> Integer.compare(e1.weight, e2.weight);
		
		LinkedList<Card> shuffledCards = 
				this.cards
				.stream()
				.map(c -> new CardWeight(c, rng.nextInt()))
				.sorted(byWeight)
				.map(m -> m.card)
				.collect(Collectors.toCollection(LinkedList::new))
				;
		
		this.cards = shuffledCards;
	}
	
	/**
	 * Logically, the tuple type (Card x Weight).
	 * @author mschaad
	 */
	private class CardWeight
	{
		public CardWeight(Card card, int weight) {
			this.card = card;
			this.weight = weight;
		}
		public Card card;
		public int weight;
	}
	
}
