package com.atexo.card.enums;

public enum CardValue {

	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	DAME("Dame"),
	VALET("Valet"),
	ROI("Roi"),
	AS("As");

	private String value;

	public String getCardValue() {
		return this.value;
	}

	private CardValue(String val) {
		this.value = val;
	}
}
