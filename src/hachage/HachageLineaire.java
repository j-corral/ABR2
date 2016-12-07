package hachage;

import java.util.ArrayList;

/**
 * Created by kenny on 07/12/16.
 */
public class HachageLineaire extends Hachage<HashDonnee> {


    ArrayList<ArrayList<HashDonnee>> table;

    public HachageLineaire(int m) {
        super(m);

        this.table = new ArrayList<ArrayList<HashDonnee>>();


        for (int i = 0; i < m;++i) {
            table.add(new ArrayList<HashDonnee>());
        }
    }

    @Override
    public void add(HashDonnee d) {

        int h = this.h(d);

        if (!this.recherche(d)) {
            table.get(h).add(d);
        }
    }

    @Override
    public boolean recherche(HashDonnee d) {

        int h = this.h(d);

        for (HashDonnee item: table.get(h)) {

            if(item.getCle() == d.getCle()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int h(HashDonnee d) {

        return Math.abs(d.hashCode()) % this.m;
    }


    public String toString() {


        for (Object data: table) {
            System.out.println(data);
        }

        return "";
    }
}
