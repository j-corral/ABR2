package hachage;

import java.util.ArrayList;

/**
 * Created by jonathan on 15/11/16.
 */
public class HachageLineaire extends Hachage<HashDonnee> {


    ArrayList<HashDonnee> table = new ArrayList<HashDonnee>();

    public HachageLineaire(int m) {
        super(m);
    }

    @Override
    public void add(HashDonnee d) {

    }

    @Override
    public boolean recherche(HashDonnee d) {
        return false;
    }

    @Override
    public int h(HashDonnee d) {
        return 0;
    }


    public String getListsSize() {


        for (Object data: table) {
            System.out.println(data);
        }

        return "";
    }
}
