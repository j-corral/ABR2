package hachage;

/**
 * Created by kenny on 15/11/16.
 */
public abstract class HashDonnee implements Comparable<HashDonnee>{

	
	protected String cle;
	
	
	public String getCle() {
		return cle;
	}


	public void setCle(String cle) {
		this.cle = (cle);
	}

	
	
	public int compareTo(HashDonnee comp) {

		return this.getCle().compareTo(comp.getCle());

	}
	

	@Override
	public String toString() {
		return "Hash.Donnee [cle=" + cle + "]";
	}


	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof HashDonnee)) {
			return false;
		}

		HashDonnee other = (HashDonnee) obj;

		return cle == other.cle;
	}
	
	
	
	
}
