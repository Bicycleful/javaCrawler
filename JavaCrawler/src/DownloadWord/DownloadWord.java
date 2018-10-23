package DownloadWord;

import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DownloadWord {
    private int rows;
    private int page;
    public List getTexts(String u){
        List list = new ArrayList();
        try {
            Document document = Jsoup.connect(u).get();
            Elements a = document.select(".m-tab").select("tr");
            rows = a.size()-2;
             for(int i = 0;i < rows;i++) {
                 Elements b= a.get(i).select("td");

                 Match e = new Match();
                 e.setTime( b.get(0).text());
                 e.setNum(b.get(1).text());
                 e.setMatch(b.get(2).text());
                 e.setVs(b.get(3).text());
                 e.setMidScore(b.get(4).text());
                 e.setFullScore(b.get(5).text());
                 e.setConditon(b.get(6).text());

                 list.add(e);

             }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int getM_page(String u) throws IOException {
        Document document = Jsoup.connect(u).get();
        Elements a = document.select(".m-page").select("li");
        page = a.size()-3;
        return page;
    }


}