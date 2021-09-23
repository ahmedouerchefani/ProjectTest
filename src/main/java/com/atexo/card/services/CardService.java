package com.atexo.card.services;

import com.atexo.card.beans.Card;

import java.util.List;

public interface CardService {

	public List<String> getRandomCardsColors();

	public List<String> getRandomCardsValues();

	public List<Card> getRandomCardDraw();

	public List<Card> sortDrownCardsByColors();

	public List<Card> sortDrownCardsByValues();
}
