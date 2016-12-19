package mts.cards;

import static org.junit.Assert.*;
import java.util.Collection;
import org.junit.Test;

public class CardFactoryTests {

	@Test
	public void GetStandard52_returns_collection_with_52_cards() {
		Collection<Card> cards = CardFactory.GetStandard52();
		assertEquals(52, cards.size());
		
	}

}
