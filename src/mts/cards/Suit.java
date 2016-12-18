package mts.cards;

/**
 * Represents the four Suits in a standard French-style deck of cards.
 * 
 * @author mschaad
 *
 */
public enum Suit {
	/**
	 * The suit of Clubs.
	 */
	Clubs ("Clubs", "\u2663"),
	
	/**
	 * The suit of Diamonds.
	 */
	Diamonds ("Diamonds", "\u2666"),
	
	/**
	 * The suit of Hearts.
	 */
	Hearts ("Hearts", "\u2665"),
	
	/**
	 * The suit of Spades.
	 */
	Spades ("Spades", "\u2660");
	
	private final String name;
	private final String symbol;
	
	private Suit(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	/**
	 * Returns the name of the suit.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Returns the Unicode symbol of the suit.
	 * @return the Unicode symbol of the suit.
	 */
	public String getSymbol() {
		return symbol;
	}
}
