package com.dekyou.func.poi.higher07.self.copy.official;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlCursor;
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
	
	
	@Test
	public void test2() throws Exception{
		InputStream inputStream = new FileInputStream("D://gaojing.docx");
		@SuppressWarnings("resource")
		XWPFDocument xDocument = new XWPFDocument(inputStream);
		
		InputStream inputStream_copy = new FileInputStream("D://copy.docx");
		XWPFDocument xDocument_copy = new XWPFDocument(inputStream_copy);
		
		xDocument.createParagraph();
		XmlCursor tblCursor = xDocument.getDocument().getBody().newCursor();
		xDocument.insertNewParagraph(tblCursor);//在表格位置插入一个新段落, 文档顶部重新变成了两个空段落  
		xDocument.setParagraph(xDocument_copy.getParagraphs().get(0), 3);//将第1个段落设置成和第1个一样的段落  
       
		//		xDocument.createParagraph();
//		xDocument.setParagraph(paragraph, pos);
//		XmlCursor cursor = null;
//		xDocument.insertNewParagraph(cursor);
		
//		@SuppressWarnings("resource")
//		XWPFDocumentMerge dm = new XWPFDocumentMerge(xDocument);

		//		dm.copyParagraph(xDocument.getParagraphs().get(0));
//		List<XWPFParagraph> XWPFParagraphList = xDocument_copy.getParagraphs();
//		int i = 0;
//		for (XWPFParagraph pa : XWPFParagraphList) {
//			dm.copyParagraph(pa);
//			dm.createParagraph();
//			dm.setParagraph(pa, 1);
//		}
//		dm.onDocumentGet(xDocument);
		
		
//		XmlCursor cursor = dm.getDocument().getBody().newCursor();
//		dm.insertNewParagraph(cursor);
//		

		FileOutputStream out = new FileOutputStream("D://gaojing2018-05-02.docx");  
		xDocument.write(out);
	}

	@Test
	public void test3() throws Exception{
		InputStream inputStream = new FileInputStream("D://gaojing.docx");
		XWPFDocument xDocument = new XWPFDocument(inputStream);
		
		@SuppressWarnings("resource")
		XWPFDocumentMerge merge = new XWPFDocumentMerge(xDocument);
		
		
		InputStream inputStream_copy = new FileInputStream("D://document.docx");
		XWPFDocument xDocument_copy = new XWPFDocument(inputStream_copy);
		
		merge.copyDocument(xDocument_copy);
		
		
		FileOutputStream out = new FileOutputStream("D://gaojing2018-05-02.docx");  
		xDocument.write(out);
	}
}

