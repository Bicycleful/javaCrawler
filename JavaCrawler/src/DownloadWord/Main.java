package DownloadWord;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int allRows = 0;
        SaveEveryRow save = new SaveEveryRow();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("try");
        DownloadWord down = new DownloadWord();

        try {
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-22");
            Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-23");
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);

            while (dd.getTime().before(d2)) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = sdf.format(dd.getTime());

                String url = "http://info.sporttery.cn/football/match_result.php?page=1&search_league=0&start_date=" + str + "&end_date=" + str
                        + "&dan=";
                if (down.getM_page(url) <= 0) {
                    List lis = down.getTexts(url);
                    save.Save(url, (ArrayList) lis,allRows,workbook,spreadsheet);

                    allRows = allRows + lis.size();
                    dd.add(Calendar.DAY_OF_YEAR, 1);
                }
                else{
                    for(int j=1;j<=down.getM_page(url);j++){
                        String u = "http://info.sporttery.cn/football/match_result.php?page="+j+"&search_league=0&start_date=" + str + "&end_date=" + str
                                + "&dan=";
                        List lis = down.getTexts(u);
                        save.Save(u, (ArrayList) lis,allRows,workbook,spreadsheet);
                        allRows = allRows + lis.size();

                    }
                    dd.add(Calendar.DAY_OF_YEAR, 1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("成功爬取到本机！");


    }
}