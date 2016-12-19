package mts.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class DefaultDeckTests {

	private DefaultDeck deck; 
	@Before
	public void setUp() throws Exception {
		deck = new DefaultDeck(CardFactory.GetStandard52());
	}
		
	@Test
	public void Given_initialized_deck_When_getCount_called_Then_returns_52() {
		assertEquals(52, deck.getCount());
	}
	
	@Test
	public void Given_initialized_deck_When_dealOneCard_called_Then_count_is_decremented() {
		deck.dealOneCard();
		assertEquals(51, deck.getCount());
	}

	@Test
	public void Given_initialized_deck_When_dealOneCard_called_52_times_Then_deck_is_empty() {
		for(int i = 0; i < 52; i++) {
			deck.dealOneCard();
		}
		assertEquals(0, deck.getCount());
	}
	
	@Test(expected=IllegalStateException.class)
	public void Given_initialized_deck_When_dealOneCard_called_53_times_Then_throws_IllegalStateException() {
		DefaultDeck deck = new DefaultDeck(CardFactory.GetStandard52());
		for(int i = 0; i < 53; i++) {
			deck.dealOneCard();
		}
	}
	
	@Test
	public void Given_empty_deck_When_shuffle_called_Then_nothing_happens() {
		deck = new DefaultDeck();
		deck.shuffle();
		assertEquals(0, deck.getCount());
	}
	
	@Test
	public void Given_full_deck_When_shuffle_called_Then_deck_is_well_shuffled() {
		List<Card> standard52 = new ArrayList<Card>(CardFactory.GetStandard52());
	
		int[] histogram = new int[52];

		Random random = new Random();
		int iterationCount = 10000;
		for(int i = 0; i < iterationCount; i++) {
			
			deck = new DefaultDeck(standard52, random);
			deck.shuffle();
			
			ArrayList<Card> cards = toList(deck);
			
			int index = FindIndexOfAceOfSpades(cards);
			
			histogram[index] = histogram[index] + 1;
		}
		
		double expectedMean = iterationCount / (double)52; 
		double actualMean = Stats.getMean(histogram);
		
		assertEquals(expectedMean, actualMean, 0.1);
		
		double variance = Stats.getVariance(histogram);
		
		double averageVariance = variance / iterationCount;
		assertEquals(averageVariance, 0.0, 0.1);
	}
	
	private int FindIndexOfAceOfSpades(Iterable<Card> cards) {
		int i = 0;
		for(Card card : cards) {
			if (card.getRank() == Rank.Ace && card.getSuit() == Suit.Spades) {
				return i; 
			}
			i++;
		}
		throw new IllegalStateException("");
	}
	
	private ArrayList<Card> toList(Deck deck) {
		ArrayList<Card> cards = new ArrayList<>();
		while(deck.getCount() > 0) {
			cards.add(deck.dealOneCard());
		}
		return cards;
	}
	

}
