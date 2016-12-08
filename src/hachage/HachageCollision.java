package hachage;

import ABR.Donnee;

import java.util.*;

/**
 * Created by jonathan on 15/11/16.
 */
public class HachageCollision extends Hachage<HashDonnee> {

    int a;

    ArrayList<ArrayList<HashDonnee>> table;


    public HachageCollision(int m, int a) {
        super(m);
        this.a = a;

        this.table = new ArrayList<ArrayList<HashDonnee>>();


        for (int i = 0; i < m;++i) {
            table.add(new ArrayList<HashDonnee>());
        }


        //System.out.println("Table created");
    }

    @Override
    public void add(HashDonnee d) {

        int h = this.h(d);

        //System.out.println("Create new hashDonnee(" + d + ") at: " + h + " - Existe? " + this.recherche(d));

        if (!this.recherche(d)) {
            table.get(h).add(d);
        }

    }

    @Override
    public boolean recherche(HashDonnee d) {

        int h = this.h(d);

        //System.out.print(table.toString() + " -- " + d.getCle().toString());
        //System.out.println("? " + table.get(h).contains(d));

        /*for (HashDonnee item: table.get(h)) {

            if(item.getCle() == d.getCle()) {
                return true;
            }

        }*/

        if(table.get(h).contains(d)) {
            return true;
        }

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

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        StringBuffer str = new StringBuffer();

        // parcours de table
        for (ArrayList<HashDonnee> pos: table) {

            int nb = pos.size();

            if(count.get(nb) != null) {
                count.put(nb, count.get(nb) + 1);
            } else {
                count.put(nb, 1);

            }

        }


        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            //System.out.print(value + " entrée(s) contenant " + key + " élément(s)\n");
            str.append(value + " entrée(s) contenant " + key + " élément(s)\n");
        }


        return str.toString();
    }

}
