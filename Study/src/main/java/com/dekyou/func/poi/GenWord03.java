package com.dekyou.func.poi;

import java.io.ByteArrayInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import org.apache.poi.poifs.filesystem.DirectoryEntry;  
import org.apache.poi.poifs.filesystem.POIFSFileSystem; 

/**
 * @author GaoJing
 * @date 2018年4月13日
 * 
 */
public class GenWord03 {

    public static void main(String[] args) throws IOException {  
        String path = "D:/";
        String filename = "/123321.doc";
        String content="cccccccccccccccccc";
        byte[] b = content.getBytes("UTF-8");
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry dirEntry = poifs.getRoot();
        dirEntry.createDocument("WordDocument", bais);
        FileOutputStream out = new FileOutputStream(path + filename);
        poifs.writeFilesystem(out);
        out.flush();
        out.close();
        bais.close();
    }  
}

