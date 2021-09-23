package com.atexo.card.services;

import com.atexo.card.beans.Card;
import com.atexo.card.enums.CardType;
import com.atexo.card.enums.CardValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CardServiceImpl implements CardService {


	private static List randomCardsDrawn;

	@Override
	public List<String> getRandomCardsColors() {

		List<CardType> colors = Stream.of(CardType.values()).collect(Collectors.toList());
		Collections.shuffle(colors);
		colors.subList(0, colors.size());

		return colors.stream().map(value -> {
			return value.getCardType();
		}).collect(Collectors.toList());

	}

	@Override
	public List<String> getRandomCardsValues() {

		List<CardValue> values = Stream.of(CardValue.values()).collect(Collectors.toList());
		Collections.shuffle(values);
		values.subList(0, values.size());

		return values.stream().map(value -> {
			return value.getCardValue();
		}).collect(Collectors.toList());

	}

	@Override
	public List<Card> getRandomCardDraw() {
		List cards = getAllCardGameValues();
		Collections.shuffle(cards);
		randomCardsDrawn = cards.subList(0, 10);


		return randomCardsDrawn;
	}

	@Override
	public List<Card> sortDrownCardsByColors() {

		randomCardsDrawn.sort(Comparator.comparing(Card::getCardType));
		return randomCardsDrawn;
	}

	@Override
	public List<Card> sortDrownCardsByValues() {

		randomCardsDrawn.sort(Comparator.comparing(Card::getCardValue));
		return randomCardsDrawn;
	}

	private List<Card> getAllCardGameValues() {
		List cards = new ArrayList();
		Arrays.stream(CardValue.values()).forEach(cardValue -> {
			Arrays.stream(CardType.values()).forEach(cardType -> {
				Card card = new Card(cardValue, cardType);
				cards.add(card);
			});
		});
		return cards;
	}

	public static List getRandomCardsDrawn() {
		return randomCardsDrawn;
	}

}
