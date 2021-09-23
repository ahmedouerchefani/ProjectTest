package com.atexo.card.controllers;


import com.atexo.card.beans.Card;
import com.atexo.card.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	@Autowired
	private CardService cardService;


	@GetMapping("/")
	public String getAllCards(Model model) {

		model.addAttribute("message", welcomeMessage);
		return "welcome";
	}

	@GetMapping("/find-random-colors")
	public String getRandomColors(Model model) {

		List<String> colors = cardService.getRandomCardsColors();
		colors.replaceAll(String::toUpperCase);
		model.addAttribute("colors", colors);
		return "randomColors";
	}

	@GetMapping("/find-random-values")
	public String getRandomValues(Model model) {

		List<String> values = cardService.getRandomCardsValues();
		values.replaceAll(String::toUpperCase);
		model.addAttribute("values", values);
		return "randomValues";
	}

	@GetMapping("/find-random-draw")
	public String getRandomCardsDraw(Model model) {

		List<Card> cards = cardService.getRandomCardDraw();
		cards.stream().map(card -> {
			card.getCardValue().getCardValue().toUpperCase();
			card.getCardType().getCardType().toUpperCase();
			return card;
		});
		model.addAttribute("cards", cards);
		return "cardsDraw";
	}

	@GetMapping("/sort-color-draw")
	public String getSortedCardsDrawByColors(Model model) {

		List<Card> cards = cardService.sortDrownCardsByColors();
		cards.stream().map(card -> {
			card.getCardValue().getCardValue().toUpperCase();
			card.getCardType().getCardType().toUpperCase();
			return card;
		});
		model.addAttribute("cards", cards);
		return "cardsDraw";
	}

	@GetMapping("/sort-value-draw")
	public String getSortedCardsDrawByValues(Model model) {

		List<Card> cards = cardService.sortDrownCardsByValues();
		cards.stream().map(card -> {
			card.getCardValue().getCardValue().toUpperCase();
			card.getCardType().getCardType().toUpperCase();
			return card;
		});
		model.addAttribute("cards", cards);
		return "cardsDraw";
	}


}
