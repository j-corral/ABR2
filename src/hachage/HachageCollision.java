package hachage;

import ABR.Donnee;

/**
 * Created by jonathan on 15/11/16.
 */
public class HachageCollision extends Hachage<Donnee> {

    int a;

    public HachageCollision(int m, int a) {
        super(m);
        this.a = a;
    }

    @Override
    public void add(Donnee d) {

    }

    @Override
    public boolean recherche(Donnee d) {
        return false;
    }

    @Override
    public int h(Donnee d) {
        return 0;
    }


    public String getListSize() {

        return "";
    }
}
