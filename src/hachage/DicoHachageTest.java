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
    public void testChargementArticle() throws IOException {

        DicoHachage dico = new DicoHachage(30000, 3);

        dico.chargerMots("francais", 0);
        System.out.println(dico.getListsSize() + "\n");

        assertEquals(true, dico.recherche(new HashDonneeString("quintessence")));
        assertEquals(false, dico.recherche(new HashDonneeString("trumper")));

        dico.lireFichier("ArticleLeMonde");
        dico.comparerMots();


    }


}
