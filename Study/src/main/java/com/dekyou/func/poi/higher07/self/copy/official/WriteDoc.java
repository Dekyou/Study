package com.dekyou.func.poi.higher07.self.copy.official;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * @author GaoJing
 * @date 2018年4月21日
 * 
 */
public class WriteDoc {
	
	private XWPFDocument orginalDocument;
	
	private XWPFDocument copyDocument;
	
	private String newFilePath;
	
	private String template;

	public WriteDoc(XWPFDocument orginalDocument, String newFilePath, String template){
		if (orginalDocument != null) {
			this.orginalDocument = orginalDocument;
		}
		this.newFilePath = newFilePath;
		this.template = template;
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void doMergeDoc() throws Exception {
		if (!newFilePath.endsWith(".docx")) {
			throw new Exception("文件名称不正确");
		}
		this.mergeDoc();
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	private void mergeDoc() throws Exception {
		XWPFRun run = this.getInsertPosition();
		run.setText("这是一个简单的测试，2018年4月21日做的一个例子1");
		this.writeNewFile();
	}
	
	private XWPFRun getInsertPosition() throws Exception {
		
		List<IBodyElement> bodyElements = orginalDocument.getBodyElements();
		
		for (int i = 0; i < bodyElements.size(); i++) {
			IBodyElement bodyElement = bodyElements.get(i);
			
			String templateText = null;
			switch (bodyElement.getElementType()) {
			case PARAGRAPH:
				XWPFParagraph paragraph = (XWPFParagraph) bodyElement;
				List<XWPFRun> paragraphRunList = paragraph.getRuns();
				
				for (int ir = 0; ir < paragraphRunList.size(); ir ++) {
					templateText = paragraphRunList.get(ir).text();
					
					if (templateText != null && templateText.equals(template)) {
						paragraph.removeRun(ir);
						return paragraph.insertNewRun(ir);
					}
				}
				break;
			case TABLE:
				XWPFTable table = (XWPFTable)bodyElement;
				List<XWPFTableRow> tableRowList = table.getRows();
				for (XWPFTableRow row : tableRowList) {
					List<XWPFTableCell> tableCellList = row.getTableCells();
					for (XWPFTableCell tableCell : tableCellList) {
						templateText = tableCell.getText();
						
						if (templateText != null && templateText.equals(template)) {
							tableCell.removeParagraph(0);
							return tableCell.addParagraph().createRun();
						}
					}
				}
				break;
			default:
				throw new Exception("未知word文档类型");
			}
		}
		return null;
	}
	
	/**
	 * docx文件输出
	 * @throws IOException
	 */
	private void writeNewFile() throws IOException{
		 FileOutputStream out = new FileOutputStream(newFilePath);  
		 orginalDocument.write(out);
		 this.close();
	}
	
	
	/**
	 * 关闭文档
	 * @throws IOException
	 */
	private void close() throws IOException {
		if (orginalDocument != null) {
			 orginalDocument.close();
		}
		if (copyDocument != null) {
			 copyDocument.close();
		}
		
	}
	
	
}

