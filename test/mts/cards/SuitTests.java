package mts.cards;

import static org.junit.Assert.*;
import org.junit.Test;

public class SuitTests {
	
	@Test
	public void Given_suit_When_toString_called_Then_returns_name() {
		Suit suit = Suit.Clubs;
		assertEquals("Clubs", suit.toString());
		assertEquals("\u2663", suit.getSymbol());
	}

	@Test
	public void Given_suit_When_toString_called_Then_returns_symbol() {
		Suit suit = Suit.Clubs;
		assertEquals("Clubs", suit.toString());
		assertEquals("\u2663", suit.getSymbol());
	}
}
