package mts.cards;

import static org.junit.Assert.*;
import org.junit.Test;

public class RankTests {
	
	@Test
	public void Ace_has_correct_properties_defined() {
		Rank ace = Rank.Ace;
		assertEquals("Ace", ace.toString());
		assertEquals("A", ace.getAbbreviation());
		assertEquals(1, ace.getValue());
	}

	@Test
	public void Two_has_correct_properties_defined() {
		Rank two = Rank.Two;
		assertEquals("2", two.toString());
		assertEquals("2", two.getAbbreviation());
		assertEquals(2, two.getValue());
	}
}
