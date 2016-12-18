package mts.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTests {

	@Test
	public void When_ctor_called_with_good_args_Then_properties_are_set_correctly() {
		Card card = new Card(Rank.Ace, Suit.Clubs);
		assertEquals(Rank.Ace, card.getRank());
		assertEquals(Suit.Clubs, card.getSuit());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void When_ctor_called_with_null_Rank_Then_throws_IllegalArgumentException() {
		Card card = new Card(null, Suit.Clubs);
		assertEquals("Ace", card.getRank().toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void When_ctor_called_with_null_Suit_Then_throws_IllegalArgumentException() {
		Card card = new Card(Rank.Ace, null);
	}
	
	@Test
	public void Given_new_card_When_getAbbreviation_called_Then_returns_abbreviation_of_Rank_and_Suit() {
		Card card = new Card(Rank.Ace, Suit.Clubs);
		assertEquals("A\u2663", card.getAbbreviation());
	}
	
	@Test
	public void Given_new_card_When_toString_called_Then_returns_full_name_of_card() {
		Card card = new Card(Rank.Ace, Suit.Clubs);
		assertEquals("Ace of Clubs", card.toString());
	}
}
