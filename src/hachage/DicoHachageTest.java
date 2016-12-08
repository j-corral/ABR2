package hachage;


/**
 * Created by jonathan on 06/12/16.
 */

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DicoHachageTest {

    @Test
    public void testChargemenArticle() throws IOException {

        DicoHachage dico = new DicoHachage(1000000, 3);

        dico.chargerMots("francais", 0);

        dico.lireFichier("ArticleLeMonde");

        //System.out.print(dico.getListsSize());

        dico.comparerMots();

        //System.out.println("poubelle ? " + dico.recherche(new HashDonneeString("poubelle")));

        //System.out.println(dico.toString());



    }



    /*@Test
    public void recherche() throws IOException {

        Dico dico = new Dico(new DonneeString(""));

        dico.chargerMots("francais", 10);

        Dico test = new Dico(new DonneeString("abaissant"));

        assertEquals(null, dico.recherche("gitan"));
        assertEquals(test.toString(), dico.recherche("abaissant").toString());

    }*/


}
