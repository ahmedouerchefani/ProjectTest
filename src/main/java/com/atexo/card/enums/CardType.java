package com.atexo.card.enums;

public enum CardType {
	CARREAUX("Carreaux"), COEUR("Coeur"), PIQUE("Pique"), TREFLE("Trefle");

	private String value;

	private CardType(String value) {
		this.value = value;

	}

	public String getCardType() {
		return this.value;
	}
}
