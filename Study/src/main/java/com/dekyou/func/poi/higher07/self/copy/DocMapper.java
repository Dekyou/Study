package com.dekyou.func.poi.higher07.self.copy;

import java.util.List;

import org.apache.poi.xwpf.converter.core.IURIResolver;
import org.apache.poi.xwpf.converter.core.ListItemContext;
import org.apache.poi.xwpf.converter.core.XWPFDocumentVisitor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.converter.xhtml.internal.XHTMLMasterPage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STRelFromH.Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.xml.sax.ContentHandler;

/**
 * @author GaoJing
 * @date 2018年4月21日
 * 
 */
public class DocMapper extends XWPFDocumentVisitor<Object, XHTMLOptions, XHTMLMasterPage>{

    private final ContentHandler contentHandler;
    private final IURIResolver resolver;
    private boolean pageDiv;
	
	public DocMapper(XWPFDocument document, ContentHandler contentHandler, XHTMLOptions options ) throws Exception {
        super( document, options != null ? options : XHTMLOptions.getDefault() );
        this.contentHandler = contentHandler;
        this.resolver = getOptions().getURIResolver();
        this.pageDiv = false;
	}

	@Override
	public XHTMLMasterPage createMasterPage(CTSectPr sectPr) {
		
		return null;
	}

	@Override
	public void setActiveMasterPage(XHTMLMasterPage currentMasterPage) {
		
		
	}

	@Override
	protected Object startVisitDocument() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void endVisitDocument() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object startVisitParagraph(XWPFParagraph paragraph, ListItemContext itemContext, Object parentContainer)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void endVisitParagraph(XWPFParagraph paragraph, Object parentContainer, Object paragraphContainer)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitEmptyRun(Object paragraphContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitText(CTText ctText, boolean pageNumber, Object paragraphContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitTab(CTPTab o, Object paragraphContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitTabs(CTTabs tabs, Object paragraphContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitBookmark(CTBookmark bookmark, XWPFParagraph paragraph, Object paragraphContainer)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addNewLine(CTBr br, Object paragraphContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pageBreak() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object startVisitTable(XWPFTable table, float[] colWidths, Object tableContainer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void endVisitTable(XWPFTable table, Object parentContainer, Object tableContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object startVisitTableCell(XWPFTableCell cell, Object tableContainer, boolean firstRow, boolean lastRow,
			boolean firstCol, boolean lastCol, List<XWPFTableCell> vMergeCells) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void endVisitTableCell(XWPFTableCell cell, Object tableContainer, Object tableCellContainer)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitHeader(XWPFHeader header, CTHdrFtrRef headerRef, CTSectPr sectPr, XHTMLMasterPage masterPage)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitFooter(XWPFFooter footer, CTHdrFtrRef footerRef, CTSectPr sectPr, XHTMLMasterPage masterPage)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void visitPicture(CTPicture picture, Float offsetX, Enum relativeFromH, Float offsetY,
			org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STRelFromV.Enum relativeFromV,
			org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STWrapText.Enum wrapText,
			Object parentContainer) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

