package ABR;

import java.util.Arrays;

public class ABR<T extends Donnee>{

	T donnee;

	ABR pere;
	ABR filsGauche, filsDroit;

	static StringBuffer str = new StringBuffer();


	public ABR(T donnee) {
		//super();
		this.donnee = donnee;
	}


	@Override
	public String toString() {

		ABR r = this;

		if(str.length() >= str.capacity()) {
			str.ensureCapacity(str.length() * 2);
		}

		if(r.filsGauche != null) {
			str.append(r.filsGauche.toString());
		}

		// concatener string
		if(r != null) {
			str.append(r.donnee.getCle() + ", ");
		}

		if(r.filsDroit != null) {
			str.append(r.filsDroit.toString());
		}


		String full = str.toString();
		str.setLength(0);

		return full;
	}


	public void affiche(String val) {
		System.out.print(val + ", ");
	}


	public void infixe(ABR r) {

		if(r == null) {
			infixe(r.filsGauche);
			affiche(r.donnee.getCle());
			infixe(r.filsDroit);
		}

	}



	public void prefixe(ABR r) {

		if(r == null) {
			affiche(r.donnee.getCle());
			infixe(r.filsGauche);
			infixe(r.filsDroit);
		}

	}


	public void postfixe(ABR r) {

		if(r == null) {
			infixe(r.filsGauche);
			infixe(r.filsDroit);
			affiche(r.donnee.getCle());
		}

	}


	/**
	 * Insère une donnée dans l'arbre
	 * @param d
	 */
	public void insertionFeuille(Donnee d) {

		if(this.recherche(d) != null || d.getClass() != this.donnee.getClass()) {
			return;
		}

		if(d.compareTo(this.donnee) < 0) {
			if(this.filsGauche == null) {
				this.filsGauche = new ABR(d);
				this.filsGauche.pere = this;
			} else {
				this.filsGauche.insertionFeuille(d);
			}
		} else {
			if(this.filsDroit == null) {
				this.filsDroit = new ABR(d);
				this.filsDroit.pere = this;
			} else {
				this.filsDroit.insertionFeuille(d);
			}
		}

	}


	/**
	 * Recherche une donnée dans l'arbre
	 * @param key : ABR.Donnee
	 * @return
	 */
	public ABR recherche(Donnee key) {

		ABR x = this;

		while ( (x != null) && (key.getCle().compareTo(x.donnee.getCle()) != 0) ) {

			if(key.getCle().compareTo(x.donnee.getCle()) < 0) {
				x = x.filsGauche;
			} else {
				x = x.filsDroit;
			}

		}

		if(x == null) {
			return null;
		}

		return x;
	}


	/**
	 * Recherche par cle
	 * @param key : String
	 * @return
	 */
	public ABR recherche(String key) {

		ABR x = this;

		while ( (x != null) && (key.compareTo(x.donnee.getCle()) != 0) ) {

			if(key.compareTo(x.donnee.getCle()) < 0) {
				x = x.filsGauche;
			} else {
				x = x.filsDroit;
			}

		}


		if(x == null) {
			return null;
		}

		return x;
	}



	public ABR minimum() {

		ABR r = this;

		while (r.filsGauche != null) {
			r = r.filsGauche;
			//r.pere = this;
		}

		return r;
	}


	public ABR maximum() {

		ABR r = this;

		while (r.filsDroit != null) {
			r = r.filsDroit;
			//r.pere = this;
		}

		return r;
	}


	public ABR predecesseur () {

		ABR y = this;

		if(y == null) {
			System.out.println("pred: " + y.toString());
			return y.pere;
		}


		if (y.filsGauche  !=  null) {
			return y.filsGauche.maximum();
		}


		ABR x = y.pere;


		while (x  !=  null && y == x.filsGauche) {
			y = x;
			x = x.pere;
		}


		return x;
	}



	public ABR successeur () {

		ABR y = this;

		if(y == null) {
			System.out.println("succ: " + y.toString());
			return y.pere;
		}

		if (y.filsDroit  !=  null) {
			return  y.filsDroit.minimum();
		}


		ABR x = y.pere;


		while (x != null && y == x.filsDroit) {
			y = x;
			x = x.pere;
		}


		return x;
	}



	/**
	 * @return la hauteur de l'arbre
	 */
	/*public int hauteur() {

		ABR.ABR a = this;

		int hLeft = 1;

		int hRight = 1;


		if(a.filsGauche != null) {
			hLeft += a.filsGauche.hauteur();
		}

		if(a.filsDroit != null) {
			hRight += a.filsDroit.hauteur();
		}

		return Math.max(hLeft, hRight);
	}*/

	/**
	 * @return la hauteur de l'arbre
	 */
	public int hauteur() {

		ABR a = this;

		if (a == null) {
			return 1;
		}
		else {

			int hG = 1;
			int hD = 1;

			if(a.filsGauche != null) {
				hG += a.filsGauche.hauteur();
			}

			if(a.filsDroit != null) {
				hD += a.filsDroit.hauteur();
			}

			return (Math.max(hG, hD));
		}
	}


	public void suppression(String cle) {

		ABR x = this.recherche(cle);

		if(x == null) {
			System.out.println(cle + ": not found !");
			return;
		} else {
			System.out.println("Removing " + cle);
		}


		if(x.filsGauche == null) {

			this.deplacer(x, x.filsDroit);

		} else {

			if(x.filsDroit == null) {

				this.deplacer(x, x.filsGauche);

			} else {

				ABR y = x.filsDroit.minimum();

				if (y.pere != x) {

					this.deplacer(y, y.filsDroit);

					y.filsDroit = x.filsDroit;
					y.filsDroit.pere = y;

				}

				this.deplacer(x, y);

				y.filsGauche = x.filsGauche;
				y.filsDroit.pere = y;

			}

		}

	}


	public void deplacer(ABR u, ABR<T> v) {

		if (u.pere == null) {

			this.pere = v.pere;
			this.filsGauche = v.filsGauche;
			this.filsDroit = v.filsDroit;
			this.donnee = v.donnee;

		} else {

			if (u == u.pere.filsGauche) {

				u.pere.filsGauche = v;
			} else {

				u.pere.filsDroit = v;
			}

		}

		if(v != null) {

			v.pere = u.pere;
		}


	}


	public boolean equivalent(ABR x) {

		ABR r = this;

		if(r.toString().equals(x.toString())) {
			return true;
		}

		return false;
	}


	public boolean contenuDans(ABR x) {

		ABR r = this;

		String pattern = ", ";

		String[] kr = r.toString().split(pattern);

		//System.out.println(Arrays.toString(kr));

		String[] kx = x.toString().split(pattern);

		//System.out.println(Arrays.toString(kx));


		for (String key: kr) {

			if(!Arrays.asList(kx).contains(key)) {
				return false;
			}

		}

		return true;
	}



	public void fusion(ABR<T> x) {

		ABR<T> r = this;


		if(x != null) {

			r.insertionFeuille(x.donnee);

			if(x.filsGauche != null) {
				r.insertionFeuille(x.filsGauche.donnee);
				this.fusion(x.filsGauche);
			}

			if(x.filsDroit != null) {
				r.insertionFeuille(x.filsDroit.donnee);
				this.fusion(x.filsDroit);
			}

		}





	}


	public void rotationDroite() {

		this.pere = this.filsGauche;
		this.filsGauche.filsDroit = this;
		this.filsGauche = null;

	}


	public void rotationGauche() {

		this.pere = this.filsDroit;
		this.filsDroit.filsGauche = this;
		this.filsDroit = null;

	}


	public void rotationGaucheDroite() {
		this.filsGauche.rotationGauche();
		this.rotationDroite();
	}


	public void rotationDroiteGauche() {
		this.filsDroit.rotationDroite();
		this.rotationGauche();
	}


	public int desequilibre() {

		// TODO: 12/11/16 - Fix function and test

		int hG = 1;

		if(this.filsGauche != null) {
			hG += this.filsGauche.hauteur();
		}


		int hD = 1;

		if(this.filsDroit != null) {
			hD += this.filsDroit.hauteur();
		}


		int desequilibre = hG - hD;

		return desequilibre;
	}


	public void reequilibrage() {

		ABR r = this;

		if(r == null) {
			return;
		}


		// TODO: 12/11/16 - Write algo and test
		/*if(r.desequilibre() == 2 && r.filsGauche != null && r.filsGauche.desequilibre() == 1) {
			r.rotationDroite();
		} else if(r.desequilibre() == 2 && r.filsDroit != null && r.filsDroit.desequilibre() == -1){
			r.rotationGauche();
		} else if(r.desequilibre() == 2 && r.filsGauche != null && r.filsGauche.desequilibre() == -1){
			r.rotationGaucheDroite();
		} else if(r.desequilibre() == -2 && r.filsDroit != null && r.filsDroit.desequilibre() == 1){
			r.rotationDroiteGauche();
		}*/


	}


	public void insertionFeuilleEquilibre(Donnee d) {

		// TODO: 12/11/16 - Write algo and test
		/*this.insertionFeuille(d);

		if(Math.abs(this.desequilibre()) > 1) {
			System.out.println("Equilibrage après insertion...");
			this.reequilibrage();
		}*/

	}


}
