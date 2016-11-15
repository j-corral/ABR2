package ABR; /**
 * Created by jonathan on 11/11/16.
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;


public class DicoTest {

    @Test
    public void testChargement() throws IOException {

        Dico dico = new Dico(new DonneeString("a"));

        dico.chargerMots("francais", 10);

        //System.out.println(dico.toString());

        assertEquals("a, abaissa, abaissable, abaissables, abaissai, abaissaient, abaissais, abaissait, abaissant, abaissâmes, à, ", dico.toString());


    }



    @Test
    public void recherche() throws IOException {

        Dico dico = new Dico(new DonneeString(""));

        dico.chargerMots("francais", 10);

        Dico test = new Dico(new DonneeString("abaissant"));

        assertEquals(null, dico.recherche("gitan"));
        assertEquals(test.toString(), dico.recherche("abaissant").toString());

    }


    @Test
    public void minMax() throws IOException {

        Dico dico = new Dico(new DonneeString("z"));

        dico.chargerMots("francais", 7565);

        assertEquals("a", dico.minimum().donnee.cle);
        assertEquals("âgé", dico.maximum().donnee.cle);

    }


    @Test
    public void hauteur() throws IOException {

        Dico dico = new Dico(new DonneeString("a"));

        dico.chargerMots("francais", 3);

        System.out.println(dico.toString());

        assertEquals(4, dico.hauteur());


        dico.chargerMots("francais", 9);

        System.out.println(dico.toString());

        assertEquals(10, dico.hauteur());
    }


    @Test
    public void suppression() throws IOException {

        Dico dico = new Dico(new DonneeString("a"));

        dico.chargerMots("francais", 10);

        dico.suppression("zero");

        assertEquals("a, abaissa, abaissable, abaissables, abaissai, abaissaient, abaissais, abaissait, abaissant, abaissâmes, à, ", dico.toString());


        dico.suppression("à");
        assertEquals("a, abaissa, abaissable, abaissables, abaissai, abaissaient, abaissais, abaissait, abaissant, abaissâmes, ", dico.toString());


        dico.suppression("abaissable");
        assertEquals("a, abaissa, abaissables, abaissai, abaissaient, abaissais, abaissait, abaissant, abaissâmes, ", dico.toString());

        dico.suppression("abaissâmes");
        dico.suppression("abaissant");
        dico.suppression("abaissait");
        dico.suppression("abaissais");
        dico.suppression("abaissaient");
        dico.suppression("abaissai");
        dico.suppression("abaissables");
        dico.suppression("abaissa");

        assertEquals("a, ", dico.toString());
    }


    @Test
    public void equivalent() throws IOException {

        Dico dico1 = new Dico(new DonneeString("a"));
        dico1.chargerMots("francais", 5);
        dico1.suppression("à");


        Dico dico2 = new Dico(new DonneeString("a"));
        dico2.insertionFeuille(new DonneeString("abaissai"));
        dico2.insertionFeuille(new DonneeString("abaissa"));
        dico2.insertionFeuille(new DonneeString("abaissable"));
        dico2.insertionFeuille(new DonneeString("abaissables"));

        assertTrue(dico1.equivalent(dico2));
    }



    @Test
    public void contenueDans() throws IOException {

        Dico dico1 = new Dico(new DonneeString("a"));
        dico1.chargerMots("francais", 5);
        dico1.suppression("à");


        Dico dico2 = new Dico(new DonneeString("a"));
        dico2.insertionFeuille(new DonneeString("abaissai"));
        dico2.insertionFeuille(new DonneeString("abaissa"));
        dico2.insertionFeuille(new DonneeString("abaissable"));
        dico2.insertionFeuille(new DonneeString("abaissables"));

        dico2.insertionFeuille(new DonneeString("zero"));
        dico2.insertionFeuille(new DonneeString("toto"));

        assertTrue(dico1.contenuDans(dico2));
    }


    @Test
    public void fusion() throws IOException {

        Dico dico1 = new Dico(new DonneeString("a"));
        dico1.chargerMots("francais", 5);
        dico1.suppression("à");

        Dico dico2 = new Dico(new DonneeString("a"));
        dico2.chargerMots("anglais", 5);
        dico2.suppression("abaft");

        dico1.fusion(dico2);

        assertEquals("a, abaissa, abaissable, abaissables, abaissai, abbreviation, abdicate, Abelard, abider, Abidjan, ", dico1.toString());
    }


}
