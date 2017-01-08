package PageRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jonathan on 14/12/16.
 */
public class Tools {


    private ArrayList<String> fileLines;


    public ArrayList<String> lireFichier(String nom) {


        String path = nom + ".txt";
//        String encoding = "iso-8859-1";
        String encoding = "UTF-8";

        FileInputStream inputStream = null;
        Scanner sc = null;

        int cpt = 0;
        String line = null;


        try {


            File file = new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));

            int nombre = this.getNombreLignes(path);


            System.out.println(path + " - Load: " + nombre + " lines");


            fileLines = new ArrayList<String>();


            while( (line = br.readLine())!= null && cpt <= nombre ) {


                //System.out.println(line);

                fileLines.add(line);

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


        return fileLines;
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
