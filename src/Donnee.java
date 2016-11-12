
public abstract class Donnee implements Comparable<Donnee>{

	
	protected String cle;
	
	
	public String getCle() {
		return cle;
	}


	public void setCle(String cle) {
		this.cle = (cle);
	}

	
	
	public int compareTo(Donnee comp) {

		return this.getCle().toLowerCase().compareTo(comp.getCle().toLowerCase());

	}
	

	@Override
	public String toString() {
		return "Donnee [cle=" + cle + "]";
	}
	
	
	
	
	
	
	
}
