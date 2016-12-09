package PageRank;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kenny on 09/12/2016.
 */
public class SearchEngine {

    private HashMap<String, WebPage> pages;

    // un MyDataStructure contenant l’ensemble des mots-cl´es figurant dans index small.txt (ou index.txt suivant les cas) ;

    private String pathInputFiles;

    private String pathOutputFiles;


    public SearchEngine(String pif, String pof) {
        this.pathInputFiles = pif;
        this.pathOutputFiles = pof;
    } // constructor


    public void readWebPages() {

    }

    public void readKeyWord() {

    }

    /*public void HashMap<String, WebPage> getSearchSubGraph(List<String> graph) {

    }

    public void computeRanks(List<WebPage>, List<String>) {

    }*/



}
