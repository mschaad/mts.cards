package mts.cards;

/**
 * Represents the standard thirteen (13) Ranks in a standard French-style deck of cards.
 * @author mschaad
 */
public enum Rank {
	Ace		(1, "Ace", "A"),
	Two		(2),
	Three	(3),
	Four	(4),
	Five	(5),
	Six		(6),
	Seven	(7),
	Eight	(8),
	Nine	(9),
	Ten		(10),
	Jack	(11, "Jack", "J"),
	Queen	(12, "Queen", "Q"),
	King	(13, "King", "K");
	
	private final int value;
	private final String name;
	private final String abbreviation;
	
	private Rank(int value) {
		this(value, Integer.toString(value), Integer.toString(value));
	}
	
	private Rank(int value, String name, String abbreviation) {
		this.value = value;
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	/**
	 * Returns the value of the rank:
	 * 	for Ace, Jack, Queen and King: 1, 11, 12 and 13, respectively;
	 *  for all other ranks, the number matching its name.
	 * @return The value of the rank.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the name of the rank.
	 *   for Ace, Jack, Queen and King, the rank's entire name;
	 *   for all other ranks, its arabic numeral.
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Returns the abbreviation of the Rank:
	 *   for Ace, Jack, Queen and King, the first letter of its name;
	 *   for all other ranks, its arabic numeral.
	 * @return the abbreviation of the rank.
	 */
	public String getAbbreviation() {
		return this.abbreviation;
	}
}
