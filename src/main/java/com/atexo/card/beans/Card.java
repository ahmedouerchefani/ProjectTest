package com.atexo.card.beans;

import com.atexo.card.enums.CardType;
import com.atexo.card.enums.CardValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {

	private CardValue cardValue;
	private CardType cardType;

}
