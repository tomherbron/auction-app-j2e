package fr.eni.projetjee.TrocEncheres.bo;
import java.time.LocalDate;
import java.util.Objects;

public class Enchere {
	
	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	
	public Enchere() {
		super();
	}

	public Enchere(LocalDate dateEnchere, Integer montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateEnchere, montantEnchere, noEnchere);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchere other = (Enchere) obj;
		return Objects.equals(dateEnchere, other.dateEnchere) && Objects.equals(montantEnchere, other.montantEnchere)
				&& Objects.equals(noEnchere, other.noEnchere);
	}
}
