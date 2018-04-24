package com.dekyou.func.poi.write;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月17日
 * 
 */
public class DocWrite {
	
	private static final String CHAR_SET = "GB2312";
	
	@Test
	public void test() throws Exception{
		this.createDoc("D://DOC//11.doc");
	}
	/**
	 * 写word文档
	 * @throws Exception 
	 */
	public void createDoc(String filePath) throws Exception {
		
        String content="测试的内容呢";
        byte[] b = content.getBytes(CHAR_SET);
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        @SuppressWarnings("resource")
		POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry dirEntry = poifs.getRoot();
        dirEntry.createDocument("WordDocument", bais);
        FileOutputStream out = new FileOutputStream(filePath);
        poifs.writeFilesystem(out);
        out.flush();
        out.close();
        bais.close();
        
        this.writeDoc(filePath);
	}
	
	
	public void writeDoc(String filePath) throws Exception {
		
		InputStream istream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		HWPFDocument document = new HWPFDocument(istream);
		
		
		
	}
}

