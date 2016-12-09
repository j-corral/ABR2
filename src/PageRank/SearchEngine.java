package PageRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
