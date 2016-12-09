package PageRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 09/12/2016.
 */
public class WebPage {

    private String url;

    private double rank;

    private List<WebPage> listReferTo;
    private List<WebPage> listReachFrom;


    public WebPage(String url) {
        this.url = url;
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
