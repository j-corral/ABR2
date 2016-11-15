package hachage;


/**
 * Created by jonathan on 20/10/16.
 */
public class HashDonneeString extends HashDonnee {

    private String valeur;


    public String getValeur() {
        return valeur;
    }

    public HashDonneeString(String donnee) {
        this.valeur = donnee;
        super.setCle(donnee);
    }


}
