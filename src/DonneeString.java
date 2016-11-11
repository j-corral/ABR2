/**
 * Created by jonathan on 20/10/16.
 */
public class DonneeString extends Donnee {

    private String valeur;


    public String getValeur() {
        return valeur;
    }

    public DonneeString(String donnee) {
        this.valeur = donnee;
        super.setCle(donnee);
    }


}
