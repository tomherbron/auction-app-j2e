package fr.eni.projetjee.TrocEncheres.bo;

import java.time.LocalDate;
import java.util.Objects;

public class ArticleVendu {
	//Déclaration des attributs
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private Integer miseAPrix;
	private Integer prixDeVente;
	private Boolean etatVente;
	private Retrait retrait;

	//Constructeur vide
	public ArticleVendu() {
	}
	
	//Constructeur avec le noArticle
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, Integer miseAPrix, Integer prixDeVente, Boolean etatVente, Retrait retrait) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixDeVente = prixDeVente;
		this.etatVente = etatVente;
		this.retrait = retrait;
	}

	//Constructeur sans le noArticle
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			Integer miseAPrix, Integer prixDeVente, Boolean etatVente, Retrait retrait) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixDeVente = prixDeVente;
		this.etatVente = etatVente;
		this.retrait = retrait;
	}

	
	//Génération des getters et setters
	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixDeVente() {
		return prixDeVente;
	}

	public void setPrixDeVente(Integer prixDeVente) {
		this.prixDeVente = prixDeVente;
	}

	public Boolean getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(Boolean etatVente) {
		this.etatVente = etatVente;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	//Génération de la méthode toString

	@Override
	public int hashCode() {
		return Objects.hash(dateDebutEnchere, dateFinEnchere, description, etatVente, miseAPrix, noArticle, nomArticle,
				prixDeVente, retrait);
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", miseAPrix="
				+ miseAPrix + ", prixDeVente=" + prixDeVente + ", etatVente=" + etatVente + ", retrait=" + retrait
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleVendu other = (ArticleVendu) obj;
		return Objects.equals(dateDebutEnchere, other.dateDebutEnchere)
				&& Objects.equals(dateFinEnchere, other.dateFinEnchere)
				&& Objects.equals(description, other.description) && Objects.equals(etatVente, other.etatVente)
				&& Objects.equals(miseAPrix, other.miseAPrix) && Objects.equals(noArticle, other.noArticle)
				&& Objects.equals(nomArticle, other.nomArticle) && Objects.equals(prixDeVente, other.prixDeVente)
				&& Objects.equals(retrait, other.retrait);
	}

	//Génération de la méthode equals

	
	
	

}
