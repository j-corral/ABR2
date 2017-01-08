package PageRank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kenny on 09/12/2016.
 */
public class SearchEngine {

    private HashMap<String, WebPage> pages;

    private MyDataStructure keywords;

    private String pathInputFiles;

    private String pathOutputFiles;


    public SearchEngine() {} // default constructor

    public SearchEngine(String pif, String pof) {
        this.pathInputFiles = pif;
        this.pathOutputFiles = pof;
    } // constructor


    public void readWebPages() {

    }

    public void readKeyWords() {

    }

    public HashMap<String, WebPage> getWebpages() {

        HashMap<String, WebPage> map = new HashMap<String, WebPage>();

        Tools tools= new Tools();
        ArrayList<String> lines = tools.lireFichier("new");



        for (String line: lines) {

            // suppression des préfixes http://, https:// et ./
            line = line.replaceAll("https://", "");
            line = line.replaceAll("http://", "");
            line = line.replaceAll("./", "");

            // suppression de from( et )
            String fromStartPattern = "\\(from\\ (.*)\\)";
            line = line.replaceAll(fromStartPattern, "$1");


            String[] columns;
            columns = line.split("\t");


            String link1 = "";
            String link2 = "";
            String from = "";

            if(columns.length > 7) {
                link1 = columns[7];
            }


            if(columns.length > 8) {
                link2 = columns[8];
            }

            if(columns.length > 9) {
                from = columns[9];
            }



            System.out.println(link1);
            System.out.println(link2);
            System.out.println(from);
            System.out.println();




            


        }




        return map;
    }

    // TODO !
    /*
    public List<WebPage> getSearchSubGraph(List<String> graph) {
        List<WebPage> list = new ArrayList<String>();

        return list;
    }

    public void computeRanks(List<WebPage>, List<String>) {

    }
    */



}
