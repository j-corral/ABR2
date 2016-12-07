package hachage;

import java.io.*;
import java.util.Scanner;


/**
 * Created by jonathan on 06/12/16.
 */
public class DicoHachage extends HachageCollision {

    public DicoHachage(int m, int a) {
        super(m,a);
    }


    public void chargerMots(String langue, int nombre) throws IOException {

        String path = langue + ".mots";
        String encoding = "iso-8859-1";

        FileInputStream inputStream = null;
        Scanner sc = null;

        int cpt = 0;
        String line = null;


        try {


            File file = new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));

            if(nombre <= 0 || nombre > this.getNombreLignes(path)) {
                nombre = 1000;
            }


            while( (line = br.readLine())!= null && cpt <= nombre ) {

                //System.out.println(line);

                // Insert DATA
                this.add(new HashDonneeString(line));

                ++cpt;
            }

        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }


    private int getNombreLignes(String path) {

        int nombreLignes = 0;

        try {

            LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(path)));
            lnr.skip(Long.MAX_VALUE);

            nombreLignes = lnr.getLineNumber() + 1;

            lnr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nombreLignes;
    }



}
