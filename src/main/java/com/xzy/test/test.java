package com.xzy.test;

import com.xzy.model.Record;
import com.xzy.util.Global;
import com.xzy.util.Time;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xzy on 2015-01-14 10:43 PM.
 */
public class test {

    public static void main(String[] args) {
        String fileName="/home/xzy/20150129152359_res_res_sicuan1234.xls";
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3;
        try{
            //t.xls为要读取的excel文件名
            book= Workbook.getWorkbook(new File(fileName));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0);
            int rows = sheet.getRows();
            int i=1;
            while(i<rows)
            {
                //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                System.out.println(cell1.getContents()+cell2.getContents()+cell3.getContents());
                String pro = Global.str2code.get(cell3.getContents());
                i++;
            }
            book.close();
        } catch(Exception e)  {
            e.printStackTrace();
        }
    }
}
