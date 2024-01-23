package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Parola {
	
	private String alienWord;
	private List<String> traduzioni;
	
	public Parola(String alienWord) {
		this.alienWord = alienWord;
		this.traduzioni = new ArrayList<String>();
	}
	
	public void add(String traduzione) {
		this.traduzioni.add(traduzione);
	}

	public List<String> getTraduzioni() {
		return traduzioni;
	}
	
	

}
