package mts.cards;

/**
 * Represents a card in a French-style deck.
 * 
 * <p>
 * A card has both Rank and Suit.  
 * </p>
 * 
 * <p>
 * This class is immutable.
 * </p>
 * 
 * @author mschaad
 *
 */
public class Card {
	
	private final Rank rank;
	private final Suit suit;
	
	private final String abbreviation;
	private final String fullName;
	
	/**
	 * Constructs a new card with the given rank and suit.
	 * 
	 * @param rank	the rank of the card.
	 * @param suit	the suit of the card.
	 */
	public Card(Rank rank, Suit suit) {
		if (rank == null) {
			throw new IllegalArgumentException("rank must not be null.");			
		}
		if (suit == null) {
			throw new IllegalArgumentException("suit must not be null.");
		}
		
		this.rank = rank;
		this.suit = suit;
		
		this.fullName = rank.toString() + " of " + suit.toString();
		this.abbreviation = rank.getAbbreviation() + suit.getSymbol();
	}
	
	/**
	 * Gets the rank of the card.
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Gets the suit of the card.
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		return suit;
	}
	
	/**
	 * Returns the full name of the card, with both rank and suit.
	 */
	@Override
	public String toString()
	{
		return this.fullName;
	}
	
	/**
	 * Returns an abbreviation of the card name, with both rank abbreviation and suit symbol.
	 * @return An abbreviation of the card, rank and suit.
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
}
