package com.dekyou.func.poi.higher07.self.copy.official;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author GaoJing
 * @date 2018年4月22日
 * 
 */
public class XWPFDocumentMerge extends XWPFDocument {
	
	
	public XWPFDocumentMerge(InputStream inputStream, String newFilePath) throws IOException {
		XWPFDocument document = new XWPFDocument(inputStream);
		document.getPackage();
        onDocumentCreate();
	}
	
	
}

