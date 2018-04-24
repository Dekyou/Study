package com.dekyou.func.poi;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月12日
 * 
 */
public class App {

	
	@Test
	public void test() throws IOException {
//		 this.createWordDoc("D://ceshi.docx");
		byte[] a = this.readDataDocx("D://document.doc");
//		System.out.println(a);
//		this.createWordDoc("D://Test.doc", a);
		
	}

	// 读取数据 docx
	public byte[] readDataDocx(String filePath) {
		byte[] mainStream = null;
		InputStream istream = null;
		try {
			istream = new FileInputStream(filePath);
			@SuppressWarnings("resource")
			HWPFDocument document = new HWPFDocument(istream);
			
			
			
			PicturesTable picTable = document.getPicturesTable();
			
			// getLastParagraph()返回包含页眉或页脚的文本的段落
			// getText()返回文档所有文本
			mainStream = document.getMainStream();
			
			Range range = document.getRange();
			
			int numSections = range.numSections();
			
			System.out.println("word文档章节一共有："+ numSections);
			for (int i = 0; i < numSections; i++) {
				
				Section section = range.getSection(i);
				int numParagraph = section.numParagraphs();
				
				System.out.println("word文档第" + (i+1) + "章节，" + "一共有" +numParagraph + "段落");
				
				for (int j = 0; j < numParagraph; j ++) {
					Paragraph paragraph = section.getParagraph(j);
					
//					String text = paragraph.text();
//					System.out.println(text);
					int numCharacterRun = paragraph.numCharacterRuns();
					
					System.out.println("相同属性的文本一共有：" + numCharacterRun);
					
					for (int a = 0; a < numCharacterRun; a++) {
						CharacterRun cr = paragraph.getCharacterRun(a);
						
						if (picTable.hasPicture(cr)) {
		                    Picture pic = picTable.extractPicture(cr, false);  
		                    String afileName= pic.suggestFullFileName();  
		                    OutputStream out=new FileOutputStream(new File("D:\\docPic\\"+ UUID.randomUUID()+afileName));  
		                    pic.writeImageContent(out);  
						}
						
						
					}
				}
			}
			
			
			
//			String a = new String(mainStream,"GB2312");
//			System.out.println(a);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (istream != null) {

			}
		}
		return mainStream;
	}
	
	
	
	public void createWordDoc(String filePath, byte[] content) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        @SuppressWarnings("resource")
		POIFSFileSystem poifs = new POIFSFileSystem();
        DirectoryEntry dirEntry = poifs.getRoot();
        dirEntry.createDocument("WordDocument", bais);
        FileOutputStream out = new FileOutputStream(filePath);
        poifs.writeFilesystem(out);
        out.flush();
        out.close();
        bais.close();
		
	}
	/**
	 * 关闭输入流
	 * 
	 * @param is
	 */
	private void closeStream(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭输出流
	 * 
	 * @param os
	 */
	private void closeStream(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	   }
}
