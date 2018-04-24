package com.dekyou.func.poi.higher07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;

/**
 * @author GaoJing
 * @date 2018年4月17日
 * 
 */
public class WriteDoc {

	@Test
	public void test() throws Exception {
		this.writeDoc("D://DOC//test.docx");
	}
	
	public void writeDoc(String filePath) throws IOException, Exception {
        String content = "要展示的内容";
        @SuppressWarnings("resource")
		XWPFDocument doc = new XWPFDocument();  
//        XHTMLConverter
        XWPFParagraph para= doc.createParagraph();  
        XWPFRun run = para.createRun();
        run.setText(content);
        
       
        InputStream pictureData = new FileInputStream("D:\\docPic\\image1.jpeg");
		int pictureType = Document.PICTURE_TYPE_JPEG;
		String filename = "";
		int width =  Units.toEMU(197.85);
		int height = Units.toEMU(85.6);
		
		run.addPicture(pictureData, pictureType, filename, width, height);
		
        File file = new File(filePath);
        FileOutputStream out = new FileOutputStream(file);  
        doc.write(out);
        out.close();
	}
	
	
}

