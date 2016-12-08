package hachage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kenny on 07/12/16.
 */
public class HachageLineaire extends Hachage<HashDonnee> {

    ArrayList<HashDonnee> table;

    public HachageLineaire(int m) {
        super(m);

        this.table = new ArrayList<HashDonnee>();

        for (int i = 0; i < m;++i) {
            table.add(new HashDonneeString(""));
        }
    }

    @Override
    public void add(HashDonnee d) {

        System.out.println("#ADD : " + d.getCle());

        // calcul du h
        int h = this.findSlot(this.h(d));

        if(h >= 0) {
            // ajout de d at table[h] = d;
            this.table.set(h, d);
        }
    }


    /**
     * Vérifie si le tableau est plein
     *
     * @return boolean
     */
    private boolean isFull() {

        for (HashDonnee item: table) {

            if(item.getCle().length() == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Cherche un emplacement libre
     * @param h
     * @return int
     */
    private int findSlot(int h) {

        // Si l'emplacement est disponible
        if(this.table.get(h).getCle().length() == 0) {
            return h;
        }

        // Si le tableau est plein
        if(this.isFull()) {
            return -1;
        }

        int next = h + 1;
        //System.out.println("First next=" + next + " - m=" + m);

        while (next != h ) {
            // si next > taille de table -> reset next
            if (next >= m) {
                //System.out.println(next + " - End of table...Continue from begining");
                next = 0;
            }
            //System.out.println(next);
            //System.out.println("test : table["+next+"]==" + this.table.get(next).getCle());

            if (this.table.get(next).getCle().length() == 0) {
                h = next;
                break;
            }
            //System.out.println(next +"- Not found !  - table["+next+"]==" + d.getCle());
            next++;
        }
        return h;
    }


    @Override
    public boolean recherche(HashDonnee d) {
        //System.out.println("Search d=" + d.getCle());
        int h = this.h(d);

        for (HashDonnee item: table) {

            //System.out.println("item=" + item);

            if(item.getCle() == d.getCle()) {
                //System.out.println("item insterted");
                return true;
            }
        }

        //System.out.println("item not insterted");
        return false;
    }

    @Override
    public int h(HashDonnee d) {

        return Math.abs(d.getCle().hashCode()) % this.m;
    }


    public String toString() {

        StringBuffer result = new StringBuffer("");

        for (HashDonnee item: table) {

            if(item.getCle() != "") {
                result.append(table.indexOf(item) + " : " + item.getCle() + "\n");
            }
        }

        return result.toString();
    }

}
