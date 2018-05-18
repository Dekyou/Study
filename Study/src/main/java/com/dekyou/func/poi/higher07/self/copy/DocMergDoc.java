package com.dekyou.func.poi.higher07.self.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xwpf.converter.core.styles.XWPFStylesDocument;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.BodyType;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

/**
 * @author GaoJing
 * @date 2018年4月21日
 * 
 */
public class DocMergDoc {

	@Test
	public void test() throws Exception {
//		this.merge("D://test.docx", "");
//		this.write("D://test.docx");
		this.copy("D://document.docx", "D://test_20180422copy.docx");
	}

	
	
	
	
	public void copy(String orginalFilePath, String newFilePath) throws Exception {
		InputStream inputStream = new FileInputStream(orginalFilePath);
		@SuppressWarnings("resource")
		XWPFDocument xDocument = new XWPFDocument(inputStream);
		CTDocument1 ctDocument  = xDocument.getDocument();
		
//			InputStream inputStream1 = new FileInputStream("D://test.docx");
//			@SuppressWarnings("resource")
//			XWPFDocument xDocument1 = new XWPFDocument(inputStream1);
//			CTDocument1 ctDocument1  = xDocument1.getDocument();
//		
//			Node node = new DocumentImpl();
//			node.setNodeValue("gaojing");
//		
//		ctDocument.newDomNode().getFirstChild().appendChild(node);
		
		FileOutputStream out = new FileOutputStream(newFilePath);  
//		ctDocument.save(out);
		xDocument.write(out);
	}
	
	public void write(String filePath) throws Exception {
		
		InputStream inputStream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		XWPFDocument xDocument = new XWPFDocument(inputStream);
		
		List<IBodyElement> bodyElements = xDocument.getBodyElements();
		
		for (int i = 0; i < bodyElements.size(); i++) {

			IBodyElement bodyElement = bodyElements.get(i);
			switch (bodyElement.getElementType()) {
			case PARAGRAPH:
				XWPFParagraph paragraph = (XWPFParagraph) bodyElement;
//				visitParagraph(paragraph, i);
				break;
			case TABLE:
//				visitTable((XWPFTable) bodyElement, i);
				writeTable((XWPFTable) bodyElement);
				break;
			default:
				throw new Exception("未知word文档类型");
			}
		}
		
//		List<XWPFTable> tableList = xDocument.getTables();
//		for (XWPFTable table : tableList) {
//			String tableText = table.getText();
//			System.out.println(tableText);
//		}
//		
//		
//		List<XWPFParagraph> paragraphList = xDocument.getParagraphs();
//		for (XWPFParagraph pg : paragraphList) {
//			List<XWPFRun> runList = pg.getRuns();
//			for (XWPFRun run : runList) {
//				String runText = run.text();
//				System.out.println(runText);
//			}
//		}
		 File file = new File(filePath);
	    FileOutputStream out = new FileOutputStream(file);  
		xDocument.write(out);
	}

	private void writeTable(XWPFTable table) {
//		String tableText = table.getText();
//		System.out.println(tableText);
//		if (tableText != null && tableText.equals("${Test}")) {
//			
//		}
		
		List<XWPFTableRow> tableList = table.getRows();
		for (XWPFTableRow row : tableList) {
			List<XWPFTableCell> cellList = row.getTableCells();
			for (XWPFTableCell cell : cellList) {
				String cellText = cell.getText();
				if (cellText != null && cellText.equals("${test}")) {
					cell.removeParagraph(0);
					XWPFParagraph pa = cell.addParagraph();
					XWPFRun run = pa.createRun();
					run.setText("这是一个 测试的例子");
					
				}
			}
		}
		
	}


	@SuppressWarnings("resource")
	public void merge(String filePath1, String filePath2) throws Exception {
		InputStream inputStream1 = new FileInputStream(filePath1);
		XWPFDocument xDocument1 = new XWPFDocument(inputStream1);

		// InputStream inputStream2 = new FileInputStream(filePath2);
		// XWPFDocument xDocument2 = new XWPFDocument(inputStream2);

		List<IBodyElement> bodyElements = xDocument1.getBodyElements();

		for (int i = 0; i < bodyElements.size(); i++) {

			IBodyElement bodyElement = bodyElements.get(i);
			switch (bodyElement.getElementType()) {
			case PARAGRAPH:
				XWPFParagraph paragraph = (XWPFParagraph) bodyElement;
				visitParagraph(paragraph, i);
				break;
			case TABLE:
				visitTable((XWPFTable) bodyElement, i);
				break;
			default:
				throw new Exception("未知word文档类型");
			}
		}

	}

	/**
	 * 遍历段落
	 * 
	 * @param paragraph
	 * @param i
	 * @throws IOException
	 * @throws XmlException
	 */
	public void visitParagraph(XWPFParagraph paragraph, int index) throws XmlException, IOException {
		List<XWPFRun> runs = paragraph.getRuns();
		if (runs.isEmpty()) {
			if (isAddNewLine(paragraph, index)) {
				visitEmptyRun();
			}

		} else {
			visitRuns(paragraph);
		}

	}

	public void visitEmptyRun() {

	}

	public void visitRuns(XWPFParagraph paragraph) {
		CTP ctp = paragraph.getCTP();
		XmlCursor c = ctp.newCursor();
		c.selectPath("child::*");
		while (c.toNextSelection()) {
			XmlObject o = c.getObject();
			System.out.println(o);
		}

	}

	/**
	 * 遍历表格
	 * 
	 * @param bodyElement
	 * @param i
	 */
	public void visitTable(XWPFTable bodyElement, int i) {

	}

	/**
	 * Returns true if the given paragraph which is empty (none <w:r> run) must
	 * generate new line and false otherwise.
	 * 
	 * @param paragraph
	 * @param index
	 * @return
	 * @throws IOException
	 * @throws XmlException
	 */
	private boolean isAddNewLine(XWPFParagraph paragraph, int index) throws XmlException, IOException {
		// a new line must be generated if :
		// - there is next paragraph/table
		// - if the body is a cell (with none vMerge) and contains just this paragraph
		IBody body = paragraph.getBody();
		List<IBodyElement> bodyElements = body.getBodyElements();
		if (body.getPartType() == BodyType.TABLECELL && bodyElements.size() == 1) {
			XWPFTableCell cell = (XWPFTableCell) body;
			XWPFStylesDocument stylesDocument = new XWPFStylesDocument(paragraph.getDocument());
			STMerge.Enum vMerge = stylesDocument.getTableCellVMerge(cell);
			if (vMerge != null && vMerge.equals(STMerge.CONTINUE)) {
				// here a new line must not be generated because the body is a cell (with none
				// vMerge) and contains just
				// this paragraph
				return false;
			}
			// Loop for each cell of the row : if all cells are empty, new line must be
			// generated otherwise none empty
			// line must be generated.
			XWPFTableRow row = cell.getTableRow();
			List<XWPFTableCell> cells = row.getTableCells();
			for (XWPFTableCell c : cells) {
				if (c.getBodyElements().size() != 1) {
					return false;
				}
				IBodyElement element = c.getBodyElements().get(0);
				if (element.getElementType() != BodyElementType.PARAGRAPH) {
					return false;
				}
				return ((XWPFParagraph) element).getRuns().size() == 0;
			}
			return true;

		}
		// here a new line must be generated if there is next paragraph/table
		return bodyElements.size() > index + 1;
	}

}
