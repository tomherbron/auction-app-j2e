package fr.eni.projetjee.TrocEncheres.bo;

import java.util.Objects;

public class Retrait {
	//Création des attributs
	private String rue;
	private String codePostal;
	private String ville;
	
	//Constructeur vide
	public Retrait() {
	}
	//Constructeur plein
	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	//Création des getters et setters
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	//Méthode toString
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	//Méthode equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retrait other = (Retrait) obj;
		return Objects.equals(codePostal, other.codePostal) && Objects.equals(rue, other.rue)
				&& Objects.equals(ville, other.ville);
	}
	
	
	
	
}
