package com.dekyou.func.poi.higher07.self.copy.official;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月21日
 * 
 */
public class App {
	
	@Test
	public void test() throws Exception {
		InputStream inputStream = new FileInputStream("D://gaojing.docx");

		XWPFDocument xDocument = new XWPFDocument(inputStream);
		WriteDoc doc = new WriteDoc(xDocument, "D://gaojing1.docx", "${template}") ;
		
		doc.doMergeDoc();
	}
}

