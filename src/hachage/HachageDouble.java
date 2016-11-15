package hachage;

import java.util.ArrayList;

/**
 * Created by jonathan on 15/11/16.
 */
public class HachageDouble extends Hachage<HashDonnee> {

    int a;

    ArrayList<HashDonnee> table = new ArrayList<HashDonnee>();

    public HachageDouble(int m, int a) {
        super(m);
        this.a = a;
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
