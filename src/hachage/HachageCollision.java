package hachage;

import ABR.Donnee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 15/11/16.
 */
public class HachageCollision extends Hachage<HashDonnee> {

    int a;

    ArrayList<HashDonnee> t = new ArrayList<HashDonnee>();

    public HachageCollision(int m, int a) {
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

        int x = 0;

        for (int i = 0; i < d.getCle().length(); ++i) {

            Character ch = new Character(d.getCle().charAt(i));

            x += ch.hashCode() * Math.pow(this.a, i);

        }



        return x % this.m;
    }


    public String getListsSize() {

        String str = this.m + " entrée(s) contenant 0 élément(s)\n";

        return str;
    }
}
