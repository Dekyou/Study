package com.dekyou.func.poi.higher07;

import static org.apache.poi.xwpf.converter.core.utils.DxaUtil.emu2points;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;

/**
 * @author GaoJing
 * @date 2018年4月17日 07+版本word文档
 */
public class ReadDoc {

	@Test
	public void test() throws Exception {
//		this.readDoc("D://test.docx");
		this.testHtml("D://test.docx");
	}

	

	public void readDoc(String filePath) throws Exception {
		InputStream istream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument(istream);
		
//		FileOutputStream ab = new FileOutputStream("D://WordXML2006.xml");
//		ab.write(document.getDocument().toString().getBytes());
//		ab.close();
		List<XWPFParagraph> paragraphList = document.getParagraphs();
		System.out.println("此文档一共有：" + paragraphList.size() + "段落");
		for (XWPFParagraph para : paragraphList) {
			List<XWPFRun> runList = para.getRuns();

			for (XWPFRun run : runList) {
//				String runText = run.text();
//				System.out.println(runText);
				List<XWPFPicture> pictureList1 = run.getEmbeddedPictures();
				FileOutputStream fos = null;
				for (XWPFPicture pic : pictureList1) {
					
					CTPicture ctp = pic.getCTPicture();

					CTPositiveSize2D ext = ctp.getSpPr().getXfrm().getExt();
					 float width = emu2points( ext.getCx() );
					float height = emu2points(ext.getCy());
					XWPFPictureData picData = pic.getPictureData();
					System.out.println("宽度："+width+ "高度：" + height);
					System.out.println(picData.getPictureType() + File.separator + picData.suggestFileExtension()
							+ File.separator + picData.getFileName());
					byte[] bytev = picData.getData();
					fos = new FileOutputStream("D://docPic//" + picData.getFileName());
					fos.write(bytev);
				}
			}

		}

	}
	
	
	
	public void testHtml(String filePath) throws Exception {
		
		InputStream istream = new FileInputStream(filePath);
		XWPFDocument document = new XWPFDocument(istream);
		File imageFolderFile = new File("D://docPic");
        XHTMLOptions options = XHTMLOptions.create().URIResolver(  
                new FileURIResolver(imageFolderFile));
        options.setExtractor(new FileImageExtractor(imageFolderFile));  
        //options.setIgnoreStylesIfUnused(false);
        //options.setFragment(true);
        // 3) Convert XWPFDocument to XHTML
        OutputStream out = new FileOutputStream(new File("D:\\DOC\\test.html"));
        XHTMLConverter.getInstance().convert(document, out, options);
	}
}
