package PageRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 09/12/2016.
 */
public class WebPage {

    private String url;

    private double rank;

    private List<WebPage> listInputPages;
    private List<WebPage> listOutPages;


    public WebPage(String url) {
        this.url = url;
        this.listInputPages = new ArrayList<WebPage>();
        this.listOutPages = new ArrayList<WebPage>();
    } // constructor



    public ArrayList getInputArc() {
        ArrayList arrayList = new ArrayList();

        return arrayList;
    }

    public ArrayList getOutputArc() {
        ArrayList arrayList = new ArrayList();

        return arrayList;
    }
}
