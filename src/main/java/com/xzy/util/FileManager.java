package com.xzy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class FileManager { 
    public String read(String fileName, String encoding) { 
        StringBuffer fileContent = new StringBuffer(); 
        try { 
            FileInputStream fis = new FileInputStream(fileName); 
            InputStreamReader isr = new InputStreamReader(fis, encoding); 
            BufferedReader br = new BufferedReader(isr); 
            String line = null; 
            while ((line = br.readLine()) != null) { 
                fileContent.append(line); 
                fileContent.append(System.getProperty("line.separator")); 
            } 
            br.close(); 
            isr.close(); 
            fis.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return fileContent.toString(); 
    } 

    public static final void write(String fileContent, String fileName, String encoding) {
        try { 
        	File file=new File(fileName);
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	//追加文件，属性设为true
            FileOutputStream fos = new FileOutputStream(fileName, true); 
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding); 
            osw.write(fileContent); 
            osw.flush(); 
            osw.close(); 
            fos.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 