package zk.gradle.model;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import java.util.ArrayList;

public class Budget {
	private String intitule;
	private String description;
	private float valeur ;

	public Budget(String intitule, String description, float valeur) {
		this.intitule = intitule;
		this.description = description;
		this.valeur = valeur;
	}

	public String getIntitule() {
		return intitule;
	}

	public String getDescription() {
		return description;
	}

	public float getValeur() {
		return valeur;
	}

}
