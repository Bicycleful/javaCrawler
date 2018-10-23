package DownloadWord;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveEveryRow {
    private String[] STR;
    private static String outputFile = "D:\\try.xls";

    public void Save(String url, ArrayList lis, int allRows, HSSFWorkbook workbook, HSSFSheet spreadsheet) throws IOException {
        for (int i = 0; i<lis.size(); i++) {
            Match obj = (Match) lis.get(i);
            HSSFRow row = spreadsheet.createRow((short) i + allRows);

            HSSFCell cell0 = row.createCell((short) 0);
            cell0.setCellValue(obj.getTime());

            HSSFCell cell1 = row.createCell((short) 1);
            cell1.setCellValue(obj.getNum().substring(0, 2));

            HSSFCell cell2 = row.createCell((short) 2);
            cell2.setCellValue(obj.getNum().substring(2, 5));

            HSSFCell cell3 = row.createCell((short) 3);
            cell3.setCellValue(obj.getMatch());

            STR = obj.getVs().split("[()]", 3);
            HSSFCell cell4 = row.createCell((short) 4);
            cell4.setCellValue(STR[0]);

            HSSFCell cell5 = row.createCell((short) 5);
            cell5.setCellValue(STR[1]);

            HSSFCell cell6 = row.createCell((short) 6);
            cell6.setCellValue(STR[2].substring(2, STR[2].length()));

            HSSFCell cell7 = row.createCell((short) 7);
            cell7.setCellValue(obj.getMidScore());

            HSSFCell cell8 = row.createCell((short) 8);
            cell8.setCellValue(obj.getFullScore());

            HSSFCell cell9 = row.createCell((short) 9);
            cell9.setCellValue(obj.getConditon());

        }
        FileOutputStream out = new FileOutputStream(outputFile);
        workbook.write(out);
        out.flush();
        out.close();
        System.out.println(url);
    }

}
