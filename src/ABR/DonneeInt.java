package ABR;

public class DonneeInt extends Donnee {

	private Integer valeur;

	public Integer getValeur() {
		return valeur;
	}
	
	public DonneeInt(Integer donnee) {
		this.valeur = donnee;
		super.setCle(Integer.toString(donnee));
	}
	
	
	
	

}
