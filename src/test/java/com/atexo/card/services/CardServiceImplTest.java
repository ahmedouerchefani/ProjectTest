package com.atexo.card.services;

import com.atexo.card.enums.CardType;
import com.atexo.card.enums.CardValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceImplTest {

	@InjectMocks
	private CardServiceImpl cardService = new CardServiceImpl();



	@Test
	void getRandomCardsColors() {
		List colors = cardService.getRandomCardsColors();
		assertFalse(colors.isEmpty());
		assertTrue(colors.size() == CardType.values().length);
	}

	@Test
	void getRandomCardsValues() {
		List values = cardService.getRandomCardsValues();
		assertFalse(values.isEmpty());
		assertTrue(values.size() == CardValue.values().length);
	}

	@Test
	void getRandomCardDraw() {
		List cards = cardService.getRandomCardDraw();
		assertFalse(cards.isEmpty());
		assertTrue(cards.size() == 10);
		assertTrue(cards.size() == cardService.getRandomCardsDrawn().size());
	}

	@Test
	void sortDrownCardsByColors() {
		cardService.getRandomCardDraw();
		List cards = cardService.sortDrownCardsByColors();
		assertFalse(cards.isEmpty());
		assertTrue(cards.size() == cardService.getRandomCardsDrawn().size());
		assertTrue(cards.size() == 10);
	}

	@Test
	void sortDrownCardsByValues() {
		cardService.getRandomCardDraw();
		List cards = cardService.sortDrownCardsByValues();
		assertTrue(cards.size() == cardService.getRandomCardsDrawn().size());
		assertFalse(cards.isEmpty());
		assertTrue(cards.size() == 10);
	}
}
