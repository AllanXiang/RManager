package com.xzy.service.impl;

import com.xzy.dao.BatchMapper;
import com.xzy.dao.RecordMapper;
import com.xzy.model.Batch;
import com.xzy.model.FileState;
import com.xzy.model.Record;
import com.xzy.service.FileService;
import com.xzy.util.Global;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xzy on 2015-01-21 9:29 AM.
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    private static Logger logger = Logger.getLogger(FileServiceImpl.class);

    @Resource
    private RecordMapper recordMapper;
    @Resource
    private BatchMapper batchMapper;

    public int insertBatch(String fileName, int batchId){
        int i=1,count=0;
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3;
        try{
            //t.xls为要读取的excel文件名
            book= Workbook.getWorkbook(new File(fileName));
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0);
            int rows = sheet.getRows();
            while(i<rows) {
                //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
//                cell2=sheet.getCell(1,i);
//                cell3=sheet.getCell(2,i);
                i++;
//                String pro = Global.str2code.get(cell3.getContents());
                String tmp = cell1.getContents();
                if(tmp!=null  && tmp.length()>=15) {
                    String code = tmp.substring(0, 15);
                    String pro = code.substring(0,2)+"0000";
                    Record r = new Record();
                    r.setRecordInputProvince(pro);
                    r.setRecordBatchId(batchId);
                    r.setRecordStatus(-1);
//                    r.setRecordInputCorpname(cell1.getContents());
                    r.setRecordInputCode(code);
                    this.recordMapper.insertSelective(r);
                    count+=1;
                }
            }
            book.close();
        } catch(Exception e)  {
            logger.error(e);
        }
        return count;
    }

    private final String uploadPath = "/home/crawler/file/"; // 用于存放上传文件的目录
    public void init(){
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private String getFileName() {
        //根据时间产生文件名
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    @Override
    public FileState upload(HttpServletRequest request) {
        init();
        FileState res = new FileState();
        String filename = "";
        res.setStatus(0);
        Batch batch = new Batch();
        try {
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                    request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if(multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                //获取multiRequest 中所有的文件名
                Iterator iter=multiRequest.getFileNames();
                while(iter.hasNext()){
                    //一次遍历所有文件
                    MultipartFile file=multiRequest.getFile(iter.next().toString());
                    filename = file.getOriginalFilename();
                    String fileType = filename.substring(filename.indexOf("."));//获得文件后缀名
                    if( fileType.equals(".xls") || fileType.equals(".xlsx") ) {
                        res.setFilename(filename);
                        batch.setBatchFilename(filename);
                        filename = getFileName() + "_" + filename;//随机产生一个文件名防止文件名重复
                    }else {
                        res.setStatus(-1);
                        return res;
                    }
                    if(file!=null){
                        file.transferTo(new File(uploadPath+filename));
                    }
                }
                batch.setBatchStime(new Date());
                batch.setBatchStatus(-1);
                batch.setBatchDir(filename);
                this.batchMapper.insertSelective(batch);
                Integer batchId = batch.getBatchId();
                if(batchId != null){
                    int num = insertBatch(uploadPath+filename, batchId);
                    if(num>0) {
                        res.setStatus(1);
                        batch.setBatchNum(num);
                        this.batchMapper.updateByPrimaryKeySelective(batch);
                    }else{
                        this.batchMapper.deleteByPrimaryKey(batchId);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return res;
    }

    @Override
    public void download(int id, HttpServletResponse response){
        List<Record> records = this.recordMapper.getListResByBatchId(id);
        Batch batch = this.batchMapper.selectByPrimaryKey(id);

        //标题行
//        String title[]={"商户全称","营业执照号码","省份", "商户全称", "法人姓名", "营业执照号码", "商户状态"};
        String title[]={"营业执照号码","查询状态","商户全称", "注册号", "注册日期", "法人姓名", "商户状态",
        "注册资金", "经营范围", "开业日期", "经营开始日期", "经营截至日期", "企业类型", "工商登记机关", "注册地址"};
        //操作执行
        try {
            OutputStream os = response.getOutputStream();
            response.reset();// 清空输出流
            String filename = "res_"+batch.getBatchFilename();
            response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.setContentType("application/msexcel");// 定义输出类型

            WritableWorkbook book= Workbook.createWorkbook(os);
            //生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet=book.createSheet("Sheet1",0);
            //写入内容
            for(int i=0;i<15;i++)    //title
                sheet.addCell(new Label(i,0,title[i]));
            for(int i=0;i<records.size();i++){    //context
                Record r = records.get(i);
//                sheet.addCell(new Label(0,i+1, r.getRecordInputCorpname()));
//                sheet.addCell(new Label(1,i+1, r.getRecordInputCode()));
//                sheet.addCell(new Label(2,i+1, Global.provincelist.get(r.getRecordInputProvince())));
//                sheet.addCell(new Label(3,i+1, r.getRecordOutputCorpname()));
//                sheet.addCell(new Label(4,i+1, r.getRecordOutputName()));
//                sheet.addCell(new Label(5,i+1, r.getRecordOutputCode()));
//                sheet.addCell(new Label(6,i+1, r.getRecordOutputStatus()));
                sheet.addCell(new Label(0,i+1, r.getRecordInputCode()));
                int status = r.getRecordStatus();
                if(status==1){
                    sheet.addCell(new Label(1,i+1, "查得"));
                }else if(status==2){
                    sheet.addCell(new Label(1,i+1, "未查得"));
                }else{
                    sheet.addCell(new Label(1,i+1, "查询失败"));
                }
                sheet.addCell(new Label(2,i+1, r.getRecordOutputCorpname()));
                sheet.addCell(new Label(3,i+1, r.getRecordOutputCode()));
                sheet.addCell(new Label(4, i + 1, r.getRecordOutputRegisterdate()));
                sheet.addCell(new Label(5, i + 1, r.getRecordOutputName()));
                sheet.addCell(new Label(6,i+1, r.getRecordOutputStatus()));
                sheet.addCell(new Label(7,i+1, r.getRecordOutputRegisterfund()));
                sheet.addCell(new Label(8,i+1, r.getRecordOutputRange()));
                sheet.addCell(new Label(9,i+1, r.getRecordOutputOpendate()));
                sheet.addCell(new Label(10,i+1, r.getRecordOutputManageopendate()));
                sheet.addCell(new Label(11,i+1, r.getRecordOutputManageenddate()));
                sheet.addCell(new Label(12,i+1, r.getRecordOutputCompanytype()));
                sheet.addCell(new Label(13,i+1, r.getRecordOutputRegisterorgan()));
                sheet.addCell(new Label(14,i+1, r.getRecordOutputRegisteraddress()));
            }
            //写入数据
            book.write();
            //关闭文件
            book.close();
//            logger.info("download ok");
        }
        catch(Exception e) {
            logger.error( "download err Output is  closed ");
        }
    }
}
