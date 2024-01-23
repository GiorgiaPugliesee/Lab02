package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dizionario {
	
	private Map<String, Parola> wordsMap;
	
	public Dizionario() {
		this.wordsMap = new HashMap<String, Parola>();
	}
	
	public void add(String key, String value) {
		Parola parola = this.wordsMap.get(key);
		
		if (parola == null) {
			
			this.wordsMap.put(key, new Parola(key));
			
			this.wordsMap.get(key).add(value);
			
		} else {
		
			parola.add(value);
			
		}
		
	}
	
	public List<String> search(String parolaAliena) {
		
		Parola parola = this.wordsMap.get(parolaAliena);
		
		if(parola == null) {
			return null;
		} else {
			return parola.getTraduzioni();
		}
	}

}
