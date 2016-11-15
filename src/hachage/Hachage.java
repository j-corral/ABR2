package hachage;

import ABR.Donnee;

/**
 * Created by jonathan on 15/11/16.
 */
public abstract class Hachage<T extends HashDonnee> {

    int m;

    public Hachage(int m) {

        this.m = m;
    } // Constructor


    public abstract void add(T d);

    public abstract boolean recherche(T d);

    public abstract int h(T d);

}
